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
		for (int i = 0; i < datainputList.size(); i++) {//
			ArrayList<String> datatowriteList = new ArrayList<String>();
			String s=datainputList.get(i);//把一句摘要放到字符串S中
			System.out.println(datainputList.get(i));
		
		
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
		for(int i=0;i<abs.size();i++){
			res.add(abs.get(i).replaceAll("####\\(.*?\\)####", "术语"));
			
		}
		
		return res;
	}
	

}
