package main.abstractextract.sentenceextract;

import java.util.ArrayList;

import tools.all.GetTypeSentence;

public class TypeExtract {


	public ArrayList<String> distinguish(ArrayList<String> List) {
		GetTypeSentence GTS=new GetTypeSentence();
		ArrayList<String> TypeList = new ArrayList<String>();
		for(String Str:List){
			if(Str.equals("")||Str.equals("空")||Str.equals("-1")){
				TypeList.add("");			
			}else{
				String s="";
				String Sen=GTS.GTS(Str, 1);			
				if (Sen.indexOf("系统") != -1) {
					s =s + "系统;";
				}
				if (Sen.indexOf("方法") != -1) {
					s = s+ "方法;";
				}
				if (Sen.indexOf("设备") != -1||Sen.indexOf("器") != -1||Sen.indexOf("装置") != -1) {
					s = s + "装置;";
				}				
				TypeList.add(s);			
			}			
		}
		return TypeList;
	}
}
