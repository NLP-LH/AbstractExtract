package main.abstractextract;

import java.util.ArrayList;

import tools.all.*;

public class TypeDistinguish {
	public static void main(String[] args) {
		ArrayList<String> List = new ArrayList<String>();
		//CsvInputAndOutput in = new CsvInputAndOutput();
		//List = in.readeCsv("类型");
		String[] Type=distinguish(List);
		for (int i = 0; i < List.size(); i++) {//
		System.out.println(Type[i]+"     "+List.get(i));
		}
	}

	public static String[] distinguish(ArrayList<String> List) {
		String[] TypeList = new String[List.size()];

		for (int i = 0; i < List.size(); i++) {//
			System.out.println(List.get(i));
			String s="";
			if (List.get(i).indexOf("系统") != -1) {

				s =s + "系统;";
			}
			if (List.get(i).indexOf("方法") != -1) {

				s = s+ "方法;";
			}
			if (List.get(i).indexOf("设备") != -1||List.get(i).indexOf("器") != -1||List.get(i).indexOf("装置") != -1) {

				s = s + "装置;";
			}
			if(s.equals("")){
				
				s="装置;";
			}
			TypeList[i] =s;
		}

		return TypeList;
	}

}
