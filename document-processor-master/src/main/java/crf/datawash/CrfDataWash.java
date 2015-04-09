package crf.datawash;

import java.util.ArrayList;
import tools.all.*;

public class CrfDataWash {

	public void CrfDW(String readFilePath, String writeFilePath) {
		// 将用####()####标注好的专利摘要语料变成CRF要求的格式。如电 B 冰 I 箱 I
		ArrayList<String> datainputList = new ArrayList<String>();		
	
		datainputList = FileInputAndOutput.readTxtFile(readFilePath);
		for(String s:datainputList){		
			ArrayList<String> datatowriteList = new ArrayList<String>();
			for(int u=0;u<s.length();u++){//对S进行遍历
				if(s.substring(u, u+1).equals("#")){//判断遍历到的字符是否为#			
					if(s.substring(u+1, u+5).equals("###(")){//是#的话再判断后面是不是###(
						u=u+4;
						int x=0;
						for( x=u;x<s.length();x++){
							System.out.println(s.substring(x, x+5));
							if(s.substring(x, x+5).equals(")####")){
								datatowriteList.add(s.subSequence(u+1, u+2)+" "+"B");
								System.out.println(s.subSequence(u+1, u+2)+" "+"B");
								for(int p=u+2;p<x;p++){
									datatowriteList.add(s.subSequence(p, p+1)+" "+"I");
									System.out.println(s.subSequence(p, p+1)+" "+"I");									
								}							
								break;								
							}							
						}
						u=x+4;												
					}else{
						
						datatowriteList.add(s.subSequence(u, u+1)+" "+"O");
						System.out.println(s.subSequence(u, u+1)+" "+"O");
					}					
				}else{//不是的话就标记上
					datatowriteList.add(s.subSequence(u, u+1)+" "+"O");
					System.out.println(s.subSequence(u, u+1)+" "+"O");
				}				
			}
			FileInputAndOutput.writetxtFile(datatowriteList,writeFilePath);//写入文件中
		}
		
	}
	
	public ArrayList<String> CrfwdOfString(String s){
		ArrayList<String> datatowriteList = new ArrayList<String>();
		for(int u=0;u<s.length();u++){//对S进行遍历
			if(s.substring(u, u+1).equals("#")){//判断遍历到的字符是否为#			
				if(s.substring(u+1, u+5).equals("###(")){//是#的话再判断后面是不是###(
					u=u+4;
					int x=0;
					for( x=u;x<s.length();x++){
						System.out.println(s.substring(x, x+5));
						if(s.substring(x, x+5).equals(")####")){
							datatowriteList.add(s.subSequence(u+1, u+2)+" "+"B");
							System.out.println(s.subSequence(u+1, u+2)+" "+"B");
							for(int p=u+2;p<x;p++){
								datatowriteList.add(s.subSequence(p, p+1)+" "+"I");
								System.out.println(s.subSequence(p, p+1)+" "+"I");									
							}							
							break;								
						}							
					}
					u=x+4;												
				}else{
					
					datatowriteList.add(s.subSequence(u, u+1)+" "+"O");
					System.out.println(s.subSequence(u, u+1)+" "+"O");
				}					
			}else{//不是的话就标记上
				datatowriteList.add(s.subSequence(u, u+1)+" "+"O");
				System.out.println(s.subSequence(u, u+1)+" "+"O");
			}				
		}
		return datatowriteList;
	}

	
	public ArrayList<String> CrfDWOfList(ArrayList<String> datainputList) {
		// 将用####()####标注好的专利摘要语料变成CRF要求的格式。如电 B 冰 I 箱 I
		ArrayList<String> datatowriteList = new ArrayList<String>();
		for(String s:datainputList){	
			for(int u=0;u<s.length();u++){//对S进行遍历
				if(s.substring(u, u+1).equals("#")){//判断遍历到的字符是否为#			
					if(s.substring(u+1, u+5).equals("###(")){//是#的话再判断后面是不是###(
						u=u+4;
						int x=0;
						for( x=u;x<s.length();x++){
							//System.out.println(s.substring(x, x+5));
							if(s.substring(x, x+5).equals(")####")){
								datatowriteList.add(s.subSequence(u+1, u+2)+" "+"B");
								//System.out.println(s.subSequence(u+1, u+2)+" "+"B");
								for(int p=u+2;p<x;p++){
									datatowriteList.add(s.subSequence(p, p+1)+" "+"I");
									//System.out.println(s.subSequence(p, p+1)+" "+"I");									
								}							
								break;								
							}							
						}
						u=x+4;												
					}else{
						
						datatowriteList.add(s.subSequence(u, u+1)+" "+"O");
						//System.out.println(s.subSequence(u, u+1)+" "+"O");
					}					
				}else{//不是的话就标记上
					datatowriteList.add(s.subSequence(u, u+1)+" "+"O");
					//System.out.println(s.subSequence(u, u+1)+" "+"O");
				}				
			}
			datatowriteList.add("");
		}
		return datatowriteList;
	}
}
