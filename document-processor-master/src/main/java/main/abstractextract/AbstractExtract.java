package main.abstractextract;

import java.util.ArrayList;

import crf.datawash.CrfDataWash;
import crf.datawash.CrfTestedDataBack;
import crf.term.recognition.CrfCmdControl;
import svm.datawash.AllTermsReplaceByShuYu;
import tools.all.ExcelRead;
import tools.all.ExcelWrite;
import tools.all.FileInputAndOutput;

public class AbstractExtract {

	
	public static void main(String[] args) {
		ArrayList<String> AbstractString = new ArrayList<String>();
		String DataToExtractFilePath="D:/file/DataToExtract/FullData.xls";
		//读取文档中的摘要
		ExcelRead ER=new ExcelRead();	
		AbstractString=ER.ExcelReadingGetColumn(DataToExtractFilePath, 1,1107, 8);
		for (int i=0; i < AbstractString.size(); i++) {
			System.out.println(i+"  "+AbstractString.get(i));
		}	
		
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
		ExcelWrite EW=new ExcelWrite();
		EW.ExcelWritingOfColumn(DataToExtractFilePath, 1,1108, 10, FileInputAndOutput.readTxtFile2("D:/file/Crf/resultAfterCTDB"));
		//将标出来的术语转换成术语两字
		AllTermsReplaceByShuYu ATR=new AllTermsReplaceByShuYu();
		EW.ExcelWritingOfColumn(DataToExtractFilePath, 1,1108, 11, ATR.ATRBSY(FileInputAndOutput.readTxtFile2("D:/file/Crf/resultAfterCTDB")));
		//将转换完的文本进行分类，分类标记好之后再存入文本
	
		//对类型进行提取
		
		//对组件进行提取
		
		//对功效进行提取
	
		
	}
}
