package org.shirdrn.document.processor.analyzer;
import java.util.ArrayList;
import tools.all.*;

public class Testaa {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> datainputList = new ArrayList<String>();		
		String readFilePath = "D:\\file\\1.txt";// 读取的文件路径
	//	String writeFilePath = "D:\\file\\Result.txt";// 写入的文件路径
		datainputList = FileInputAndOutput.readTxtFile2(readFilePath);
		int ss=0;
		for (int i = 0; i < datainputList.size(); i++) {//
		//	ArrayList<String> datatowriteList = new ArrayList<String>();
			String s=datainputList.get(i);
		    if(s.indexOf("装置")==-1&&s.indexOf("系统")==-1&&s.indexOf("方法")==-1&&s.indexOf("设备")==-1&&s.indexOf("器")==-1&&s.indexOf("器")==-1&&s.indexOf("终端")==-1&&s.indexOf("的")==-1&&s.indexOf("平台")==-1&&s.indexOf("电路")==-1&&s.indexOf("材料")==-1&&s.indexOf("缆")==-1&&s.indexOf("产品")==-1&&s.indexOf("柜")==-1&&s.indexOf("塔")==-1&&s.indexOf("机")==-1&&s.indexOf("仪")==-1&&s.indexOf("一种")==-1){
		    	System.out.println(s);
				ss++;
		    }					
			//FileInputAndOutput.writetxtFile(datatowriteList,writeFilePath);//写入文件中
		}
	 	System.out.println(ss);
	}
	

}
