package resource;

import java.util.ArrayList;

public class AdjOfEffect {
	ArrayList<String> AdjString=new ArrayList<String>();
	public AdjOfEffect(){
		
		String[] Adj={"广","强","高","方便","快捷","简单","简便","灵活","大","快速","低廉","广泛","低","小","少","容易"};
		for(String s:Adj){
			AdjString.add(s);
			//System.out.println(s);
		}
	
	
	}
	public ArrayList<String> getAdjString() {
		return AdjString;
	}
	public void setAdjString(ArrayList<String> adjString) {
		AdjString = adjString;
	}
}
