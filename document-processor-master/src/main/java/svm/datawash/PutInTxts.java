package svm.datawash;

import java.util.ArrayList;
import tools.all.*;

public class PutInTxts {
	public static void main(String[] args) {
		//将文档内数据，每一行都存在一个文件夹下，这样才可以使用processor进行TFIDF取值等步骤。	
		ArrayList<String> datainputList = new ArrayList<String>();				
		String readFilePath = "D:\\file\\leixingzujian.txt";// 读取的文件路径
	   //String writeFilePath = "D:\\file\\Result.txt";// 写入的文件路径
		datainputList = FileInputAndOutput.readTxtFile2(readFilePath);
		int n=1;
		for(String s:datainputList){		
			ArrayList<String> datatowriteList = new ArrayList<String>();
			datatowriteList.add(s);
			System.out.println(s);		
			String address="D:\\file\\leixingzujian\\leixingzujian"+n+".txt";
			n+=1;
			FileInputAndOutput.writetxtFile2(datatowriteList,address);			
		}		
	}
	public void PIT(String name,ArrayList<String> datainputList) {
		int n=1;	
		for(String s:datainputList){	
			ArrayList<String> datatowriteList = new ArrayList<String>();
			datatowriteList.add(s);
			System.out.println(s);
			String address="D:\\file\\SVMFile\\训练数据\\"+name+"\\"+name+n+".txt";
			n+=1;
			FileInputAndOutput.writetxtFile2(datatowriteList,address);			
		}	
		
	}
	
}
