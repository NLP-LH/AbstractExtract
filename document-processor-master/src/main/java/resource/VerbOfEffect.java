package resource;

import java.util.ArrayList;

public class VerbOfEffect {
	ArrayList<String> VerbString=new ArrayList<String>();
	
	public VerbOfEffect(){
		String[] Verb={"减少","提高","提升","改善","保障","保证","防止","增加","增强","节省","消除","降低","节约","优化","避免","完善","简化"};
		for(String s:Verb){
			VerbString.add(s);
			//System.out.println(s);
		}
	}

	public ArrayList<String> getVerbString() {
		return VerbString;
	}

	public void setVerbString(ArrayList<String> verbString) {
		VerbString = verbString;
	}
}
