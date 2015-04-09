package main.abstractextract;

import java.io.IOException;
import java.util.ArrayList;

import main.abstractextract.sentenceextract.EffectExtract;
import main.abstractextract.sentenceextract.TypeExtract;

import crf.datawash.CrfDataWash;
import crf.datawash.CrfTestedDataBack;
import crf.term.recognition.CrfCmdControl;
import svm.ClassificationTree;
import svm.datawash.AllTermsReplaceByShuYu;
import svm.datawash.SVMedAbstractBack;
import tools.all.ExcelRead;
import tools.all.ExcelWrite;
import tools.all.FileInputAndOutput;

public class AbstractExtract {

	
	public static void main(String[] args) throws IOException {
		String DataToExtractFilePath="D:/file/DataToExtract/FullData.xls";
		int StartRow=1;
		int EndRow=1107;
		ArrayList<String> AbstractString = new ArrayList<String>();				
		ExcelRead ER=new ExcelRead();	
		ExcelWrite EW=new ExcelWrite();	
		//读取文档中的摘要	
		AbstractString=ER.ExcelReadingGetColumn(DataToExtractFilePath, StartRow,EndRow, 8);		
	    //将读取的摘要转换成CRF要求的格式，并写入CRF文件夹的TXT文件中
		CrfDataWash CDW=new CrfDataWash();
		FileInputAndOutput.writetxtFile(CDW.CrfDWOfList(AbstractString),"D:/file/Crf/CrfDataToTest.txt");//写入文件中
		
    	//用CRF进行训练
		CrfCmdControl CCC=new CrfCmdControl();
		CCC.CrfControl("crf_test -m CrfModel CrfDataToTest.txt >> result");
		//等三秒，否则CRF还没写到结果文件中，转换就已经开始了
		try {//
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		//再将训练完的数据转换成用####()####标注的文本
		CrfTestedDataBack CTDB=new CrfTestedDataBack();
		CTDB.CrfTDB("D:/file/Crf/result","D:/file/Crf/resultAfterCTDB");
		//将转换完的文本放入EXCEL表格中，
		ArrayList<String> AbstractCTBD = new ArrayList<String>();
		AbstractCTBD=FileInputAndOutput.readTxtFile2("D:/file/Crf/resultAfterCTDB");
		EW.ExcelWritingOfColumn(DataToExtractFilePath, StartRow,EndRow, 10, AbstractCTBD);
		//将标出来的术语转换成术语两字
		AllTermsReplaceByShuYu ATR=new AllTermsReplaceByShuYu();
		EW.ExcelWritingOfColumn(DataToExtractFilePath, StartRow,EndRow, 11, ATR.ATRBSY(AbstractCTBD));
				
		//将转换完的文本进行分类，分类标记好之后再存入文本
		ArrayList<String> AbstractString2 = new ArrayList<String>();
		ArrayList<String> AbstractString3 = new ArrayList<String>();
		AbstractString2=ER.ExcelReadingGetColumn(DataToExtractFilePath, StartRow,EndRow, 11);
		ClassificationTree CT=new ClassificationTree();
		for(int i =0;i<AbstractString2.size();i++)
		{
			AbstractString3.add(CT.Classification(AbstractString2.get(i)));			
		}
		EW.ExcelWritingOfColumn(DataToExtractFilePath, StartRow,EndRow, 12, AbstractString3);
		//将分类结合的结果中术语再替换成原有的字符串。
		SVMedAbstractBack SVMAA=new SVMedAbstractBack();
		EW.ExcelWritingOfColumn(DataToExtractFilePath, StartRow,EndRow, 13,SVMAA.SVMAB(AbstractString, AbstractString3));
		//对类型进行提取
		ArrayList<String> Abs13 = new ArrayList<String>();
		Abs13=ER.ExcelReadingGetColumn(DataToExtractFilePath, StartRow,EndRow, 13);
		TypeExtract TE=new TypeExtract();
		EW.ExcelWritingOfColumn(DataToExtractFilePath, StartRow,EndRow, 14,TE.distinguish(Abs13));						
		//对功效进行提取		（还要再修改，可以按标点符号进行分句再抽取）
		EffectExtract EE=new EffectExtract();
		EW.ExcelWritingOfColumn(DataToExtractFilePath, StartRow,EndRow, 15,EE.ExE(Abs13));
		//对组件进行提取
		
		
		//存储
		
		//生成功效矩阵	
		
		
		//还有需要完善的：1 CRF和SVM模型的训练，2 分类树中没有句号和本发明的句子
	}
}
