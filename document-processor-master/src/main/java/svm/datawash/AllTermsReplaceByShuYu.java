package svm.datawash;

import java.util.ArrayList;

import tools.all.FileInputAndOutput;

public class AllTermsReplaceByShuYu {
	public static void main(String[] args) {
		// 把所有用####()####标注出来的术语用术语两个字代替
		ArrayList<String> datainputList = new ArrayList<String>();		
		String readFilePath = "D:\\file\\1.txt";// 读取的文件路径
		String writeFilePath = "D:\\file\\Result.txt";// 写入的文件路径
		datainputList = FileInputAndOutput.readTxtFile(readFilePath);
		for(String s: datainputList){
			ArrayList<String> datatowriteList = new ArrayList<String>();		
				String ac=s.replaceAll("####\\(.*?\\)####", "术语");				
				datatowriteList.add(ac);				
			FileInputAndOutput.writetxtFile(datatowriteList,writeFilePath);//写入文件中
		}
	}
	
	public String ATRBSY(String s){
		String ac=s.replaceAll("####\\(.*?\\)####", "术语");		
		return ac;
	}
	public ArrayList<String> ATRBSY(ArrayList<String> abs){
		ArrayList<String> res=new ArrayList<String>();
		for(String s:abs){
			res.add(s.replaceAll("####\\(.*?\\)####", "术语"));			
		}	
		
		return res;
	}
	

}
