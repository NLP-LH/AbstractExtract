package TrainOfCrfSvm;

import java.io.IOException;

import org.shirdrn.document.processor.AbstractDocumentProcessorDriver;
import org.shirdrn.document.processor.Sorting;
import org.shirdrn.document.processor.TrainDocumentProcessorDriver;

import svm.classification.svm_train;
import crf.datawash.CrfDataWash;
import crf.term.recognition.CrfCmdControl;

public class TrainOfCrfSvm {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		//CRF训练
		//将用####()####标注好的摘要语料转换成用BIO标注的文本
		CrfDataWash CDW=new CrfDataWash();
		CDW.CrfDW("D:\\file\\Crf\\ManualLabeledabstract.txt", "D:\\file\\Crf\\CrfAbstractToTrain.txt");// 读取的文件路径和写入的文件路径
		//将用BIO标注的文本进行训练，产生模型文件CrfModel
		CrfCmdControl CCC=new CrfCmdControl();
		CCC.CrfControl("crf_learn CrfTemplate CrfAbstractToTrain.txt CrfModel");
		
	     //SVM训练
		//将文档使用TF-IDF的方式转换成SVM所需要的数据
		AbstractDocumentProcessorDriver.start(TrainDocumentProcessorDriver.class);
		//将产生的文档按序号进行排序
		Sorting.sort("D:/file/SVMFile/Train.txt", "D:/file/SVMFile/SortedTrain.txt");//参数为待排序的文件和排完生成的文件
		//将已经处理好的数据放入SVM中进行训练，产生MODEL文件，在程序的根目录下
		String[] trainArgs = {"D:/file/SVMFile/SortedTrain.txt",};//directory of training file
		String modelFile = svm_train.main(trainArgs);//model文件的生成路径在SVM_TRAIN中修改
		
	
	}

}
