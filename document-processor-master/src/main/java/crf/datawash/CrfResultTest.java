package crf.datawash;

import java.util.ArrayList;
import tools.all.*;

public class CrfResultTest {
	public static void main(String[] args) {
		ArrayList<String> datainputList = new ArrayList<String>();
		ArrayList<String> datatotestList = new ArrayList<String>();
		ArrayList<String> dataRightList = new ArrayList<String>();
		String readFilePath = "D:\\file\\result.txt";// 读取的文件路径
		datainputList = FileInputAndOutput.readTxtFile(readFilePath);
		for(String s :datainputList){
			if(s.length()<3){
				dataRightList.add(" ");
				datatotestList.add(" ");
				
			}else{
			dataRightList.add(s.substring(2, 3));
			datatotestList.add(s.substring(4, 5));
			}
		}
			int RecTermNumber=0;
			int TermNumber=0;
			int RightTermNumber=0;
		for (String s : dataRightList){
		  if(s.equals("B")){			  
			  TermNumber+=1;
		  }
		  if(s.equals("B")){
			  RecTermNumber+=1;
		  }			   		 
		}
		boolean right=false;
		for (int i = 0; i < dataRightList.size(); i++) {//
			 if(datatotestList.get(i).equals("B")  ){		
				 if(dataRightList.get(i).equals("B")){					 
					 right=true;
				 }				 
				 continue;
			  }	
			 if(datatotestList.get(i).equals("I")  ){	
				 if(dataRightList.get(i).equals("I")){									 
				 }else{					 
					 right=false;
				 }	
				 continue;
			  }	
			 if(datatotestList.get(i).equals("O")  ){	
				 if(dataRightList.get(i).equals("O")&& right==true){				
					 RightTermNumber+=1;
					 right=false;
				 }else{					 
					 right=false;
				 }				
			  }				 
		}
		  System.out.println( "语料中的术语数为"+TermNumber);
		  System.out.println(  "识别的术语总数为"+RecTermNumber);
		  System.out.println(  "正确识别的术语总数为"+RightTermNumber);
		  float p=(float)RightTermNumber/(float)RecTermNumber;
		  System.out.println(  "p值："+p);
		  float r=(float)RightTermNumber/(float)TermNumber;
		  System.out.println(  "R值："+r);	  
		  float f=2*p*r/(p+r);
		  System.out.println(  "F值："+f);
	}
	
}
