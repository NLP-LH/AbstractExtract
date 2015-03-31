package svm.datawash;

import java.util.ArrayList;
import tools.all.*;
public class LabeledAbstractDataWash {

	/**
	 * @param args
	 */
	//输入文件是已经标注好####11()11####等符号的摘要数据，程序将类型、组件、功效分开存在三个文档中。
	static ArrayList<String> datatowriteList1 = new ArrayList<String>();
	static ArrayList<String> datatowriteList2 = new ArrayList<String>();
	static ArrayList<String> datatowriteList3 = new ArrayList<String>();

	public static void main(String[] args) {
		ArrayList<String> datainputList = new ArrayList<String>();		
		String readFilePath = "D:\\file\\1.txt";// 读取的文件路径
		String writeFilePath1 = "D:\\file\\leixing.txt";// 写入的文件路径
		String writeFilePath2 = "D:\\file\\zujian.txt";// 写入的文件路径
		String writeFilePath3 = "D:\\file\\gongxiao.txt";// 写入的文件路径
		datainputList = FileInputAndOutput.readTxtFile(readFilePath);
		for(int i=0;i<datainputList.size();i++){
			System.out.println(i);	
			String OneAbstract=datainputList.get(i);
			boolean reachEnd=false;
			while(reachEnd==false){
				String leixing= OneAbstract.substring(4,5);
				String weichuan=")"+leixing+leixing+"####";
				int weichuanweizhi=OneAbstract.indexOf(weichuan);
				store (OneAbstract.substring(0, weichuanweizhi+7));			
				if(OneAbstract.length()==weichuanweizhi+7){
					reachEnd=true;
				}else {
					OneAbstract=OneAbstract.substring(weichuanweizhi+7);				
				}			 
				//System.out.println(weichuanweizhi +"   "+OneAbstract.substring(0, 36));			
			}						
		}
		FileInputAndOutput.writetxtFile(datatowriteList1, writeFilePath1);
		FileInputAndOutput.writetxtFile(datatowriteList2, writeFilePath2);
		FileInputAndOutput.writetxtFile(datatowriteList3, writeFilePath3);
	}
	
	public static void store(String s){//将带标记的一个字符串去掉标记存入链表
		String number=s.substring(4, 5);
		String subString = s.substring(7, s.length()-7);
		if(number.equals("1")){
			datatowriteList1.add(subString);
		}else if(number.equals("2")){
			datatowriteList2.add(subString);
		}else if(number.equals("3")){
			datatowriteList3.add(subString);
		}				
	}


}
