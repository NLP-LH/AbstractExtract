package svm.datawash;

import java.util.ArrayList;
import tools.all.*;

public class PutInTxts {
	public static void main(String[] args) {
		//将文档内数据，每一行都存在一个文件夹下，这样才可以使用processor进行TFIDF取值等步骤。	
		ArrayList<String> datainputList = new ArrayList<String>();				
		String readFilePath = "D:\\file\\1.txt";// 读取的文件路径
	   //String writeFilePath = "D:\\file\\Result.txt";// 写入的文件路径
		datainputList = FileInputAndOutput.readTxtFile(readFilePath);
		for(int i=0;i<datainputList.size();i++){
			ArrayList<String> datatowriteList = new ArrayList<String>();
			datatowriteList.add(datainputList.get(i));
			System.out.println(datainputList.get(i));
			int n=i+1;
			String address="D:\\file\\gongxiao"+n+".txt";
			FileInputAndOutput.writetxtFile2(datatowriteList,address);			
		}		
	}
}
