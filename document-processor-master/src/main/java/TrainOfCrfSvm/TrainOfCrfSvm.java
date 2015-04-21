package TrainOfCrfSvm;

import java.io.IOException;
import java.util.ArrayList;

import org.shirdrn.document.processor.AbstractDocumentProcessorDriver;
import org.shirdrn.document.processor.Sorting;
import org.shirdrn.document.processor.TrainDocumentProcessorDriver;

import resource.FilePath;
import svm.classification.svm_train;
import svm.datawash.AllTermsReplaceByShuYu;
import svm.datawash.LabeledAbstractDataWash2;
import svm.datawash.SVMLabelWithCRFed;
import tools.all.ExcelRead;
import tools.all.ExcelWrite;
import tools.all.FileInputAndOutput;
import crf.datawash.CrfDataWash;
import crf.term.recognition.CrfCmdControl;

public class TrainOfCrfSvm {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		String TrianDataPath=FilePath.TrianDataPath;
		int StartRow=1;
		int EndRow=1107;
		//CRF训练
		ArrayList<String> AbstractCRFString = new ArrayList<String>();
		//从训练数据EXCEL文件夹中将数据提取出来并放入TXT文件中
		ExcelRead ER=new ExcelRead();	
		AbstractCRFString=ER.ExcelReadingGetColumn(TrianDataPath, StartRow,EndRow, 1);
		FileInputAndOutput.writetxtFile2(AbstractCRFString,FilePath.ManualLabeledabstract);//写入文件中
		//将用####()####标注好的摘要语料转换成用BIO标注的文本	
		CrfDataWash CDW=new CrfDataWash();
		CDW.CrfDW(FilePath.ManualLabeledabstract, FilePath.CrfAbstractToTrain);// 读取的文件路径和写入的文件路径
		//将用BIO标注的文本进行训练，产生模型文件CrfModel
		CrfCmdControl CCC=new CrfCmdControl();
		CCC.CrfControl("crf_learn CrfTemplate CrfAbstractToTrain.txt CrfModel");
		
	    //SVM训练
		//把训练EXCEL中标注了术语的摘要全部用术语两字代替
		AllTermsReplaceByShuYu ATR=new AllTermsReplaceByShuYu();
		ExcelWrite EW=new ExcelWrite();
		EW.ExcelWritingOfColumn(TrianDataPath, StartRow,EndRow, 2, ATR.ATRBSY(AbstractCRFString));
		//将用术语两字替换后的摘要和标注了类型的摘要相结合
		SVMLabelWithCRFed SWC=new SVMLabelWithCRFed();
		SWC.SWC(TrianDataPath,StartRow,EndRow,0,2,3);
		//将结合完的摘要数据分类，然后按照类别每个句子放入一个文档，再放入训练数据文件夹下
		LabeledAbstractDataWash2 LADW=new LabeledAbstractDataWash2();
		LADW.LADW(TrianDataPath,StartRow,EndRow,3);		
		//将文档使用TF-IDF的方式转换成SVM所需要的数据
		AbstractDocumentProcessorDriver.start(TrainDocumentProcessorDriver.class);
		//将产生的文档按序号进行排序
		Sorting.sort(FilePath.Train, FilePath.SortedTrain);//参数为待排序的文件和排完生成的文件
		//将已经处理好的数据放入SVM中进行训练，产生MODEL文件，在程序的根目录下
		String[] trainArgs = {FilePath.SortedTrain};//directory of training file
		svm_train.main(trainArgs);//model文件的生成路径在SVM_TRAIN中修改
			
	}

}
