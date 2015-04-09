package org.shirdrn.document.processor;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
import tools.all.*;

//给生成好的词向量数据进行排序
public class Sorting {
	
	public static void  sort(String readFilePath,String writeFilePath) {
		ArrayList<String> datainputList = new ArrayList<String>();
		ArrayList<String> datatowriteList = new ArrayList<String>();
		datainputList = FileInputAndOutput.readTxtFile(readFilePath);
		for (String ss :datainputList) {
			String[] aka= ss.split(" ");
			TreeMap<Integer,Double> map=new TreeMap<Integer,Double>();
			String shouxuhao =aka[0];
			String ju=shouxuhao;
			for(int s=1;s<aka.length;s++){
				int xuhao=Integer.parseInt(aka[s].substring(0, aka[s].indexOf(":")));
				double zhi=Double.parseDouble(aka[s].substring(aka[s].indexOf(":")+1));
			map.put(xuhao, zhi);					
			}
			Set<Integer> set=map.keySet();
			for(Integer key:set){
				ju=ju+" "+key.toString()+":"+map.get(key).toString();				
			}
			System.out.println(ju);
			datatowriteList.add(ju);										
		}		
		FileInputAndOutput.writetxtFile(datatowriteList,writeFilePath);//写入文件中
	}		
}
