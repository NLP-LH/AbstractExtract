package svm.datawash;

import java.util.ArrayList;
import tools.all.*;

public class LabeledAbstractDataWash2 {
	/**
	 * @param args
	 */
	//输入文件是已经标注好####11()11####等符号的摘要数据，程序将类型、组件、功效分开存在两个文档中，类型和组件存在同一个文档内
	
	
	public static void main(String[] args) {
		ArrayList<String> datatowriteList2 = new ArrayList<String>();
		ArrayList<String> datatowriteList3 = new ArrayList<String>();
		ArrayList<String> datainputList = new ArrayList<String>();		
		String readFilePath = "D:\\file\\1.txt";// 读取的文件路径
		String writeFilePath2 = "D:\\file\\leixingzujian.txt";// 写入的文件路径
		String writeFilePath3 = "D:\\file\\gongxiao.txt";// 写入的文件路径
		datainputList = FileInputAndOutput.readTxtFile(readFilePath);
		for(int i=0;i<datainputList.size();i++){
			System.out.println(i);	
			String OneAbstract=datainputList.get(i);
			String leixinghezujian="";
			String gongxiao="";
			boolean reachEnd=false;
			while(reachEnd==false){
				String leixing= OneAbstract.substring(4,5);
				String weichuan=")"+leixing+leixing+"####";
				int weichuanweizhi=OneAbstract.indexOf(weichuan);
				if(leixing.equals("1")){
					leixinghezujian=leixinghezujian+OneAbstract.substring(7, weichuanweizhi);					
				}else if(leixing.equals("2")){					
					leixinghezujian=leixinghezujian+OneAbstract.substring(7, weichuanweizhi);
				} else if(leixing.equals("3")){					
					gongxiao=gongxiao+OneAbstract.substring(7, weichuanweizhi);
				} 		
				if(OneAbstract.length()==weichuanweizhi+7){
					reachEnd=true;
				}else {
					OneAbstract=OneAbstract.substring(weichuanweizhi+7);				
				}												
			}	
			datatowriteList2.add(leixinghezujian);
			if(gongxiao.equals("")){								
			}else{				
				datatowriteList3.add(gongxiao);
			}
		}
		FileInputAndOutput.writetxtFile(datatowriteList2, writeFilePath2);
		FileInputAndOutput.writetxtFile(datatowriteList3, writeFilePath3);
	}	
	public void LADW(String Path,int StartRow,int EndRow,int Column) {
		ArrayList<String> AbstractString = new ArrayList<String>();
		ExcelRead ER=new ExcelRead();	
		AbstractString=ER.ExcelReadingGetColumn(Path, StartRow,EndRow, Column);
	
		ArrayList<String> datatowriteList2 = new ArrayList<String>();
		ArrayList<String> datatowriteList3 = new ArrayList<String>();		
		for(int i=0;i<AbstractString.size();i++){
			
			System.out.println(i+"  "+AbstractString.get(i));	
			String OneAbstract=AbstractString.get(i);
			String leixinghezujian="";
			String gongxiao="";
			boolean reachEnd=false;
			while(reachEnd==false){
				String leixing= OneAbstract.substring(4,5);
				String weichuan=")"+leixing+leixing+"####";
				int weichuanweizhi=OneAbstract.indexOf(weichuan);
				if(leixing.equals("1")){
					leixinghezujian=leixinghezujian+OneAbstract.substring(7, weichuanweizhi);					
				}else if(leixing.equals("2")){					
					leixinghezujian=leixinghezujian+OneAbstract.substring(7, weichuanweizhi);
				} else if(leixing.equals("3")){					
					gongxiao=gongxiao+OneAbstract.substring(7, weichuanweizhi);
				} 		
				if(OneAbstract.length()==weichuanweizhi+7){
					reachEnd=true;
				}else {
					OneAbstract=OneAbstract.substring(weichuanweizhi+7);				
				}												
			}	
			datatowriteList2.add(leixinghezujian);
			if(gongxiao.equals("")){								
			}else{				
				datatowriteList3.add(gongxiao);
			}
		}
		PutInTxts PTI=new PutInTxts();
		PTI.PIT("组件", datatowriteList2);
		PTI.PIT("功效", datatowriteList3);
		
	}
	
	
}
