package main.abstractextract.sentenceextract;

import java.util.ArrayList;

import resource.AdjOfEffect;
import resource.NounOfEffect;
import resource.VerbOfEffect;
import tools.all.GetTypeSentence;

public class EffectExtract {
	
	public ArrayList<String> ExE(ArrayList<String> Abstract) {
		ArrayList<String> EffectList=new ArrayList<String>();
		GetTypeSentence GTS =new GetTypeSentence();
		for(String s:Abstract){
			if(s.equals("空")||s.equals("")){				
				EffectList.add("");
			}else{
				EffectList.add(EE(GTS.GTS(s,2)));				
			}		
		}			
		return EffectList;
	}
	public String EE(String Abstract) {
		String result="";
		ArrayList<String> VerbList=new ArrayList<String>();
		ArrayList<String> NounList=new ArrayList<String>();
		ArrayList<String> AdjList=new ArrayList<String>();
		VerbOfEffect VOE=new VerbOfEffect();
		VerbList=VOE.getVerbString();
		NounOfEffect NOE=new NounOfEffect();
		NounList=NOE.getNounString();
		AdjOfEffect AOE=new AdjOfEffect();
		AdjList=AOE.getAdjString();
		String Noun="";
		String Verb="";
		String Adj="";
		for(String s: NounList){

			if(Abstract.contains(s)){
				Noun=s;
				break;
			}
			
		}
		for(String s: VerbList){

			if(Abstract.contains(s)){
				Verb=s;
				result=Verb+Noun;
				break;
			}
			
		}
		if(Verb.equals("")){
			for(String s: AdjList){

				if(Abstract.contains(s)){
					Adj=s;
					result=Noun+Adj;
					break;
				}
				
			}
			
		}
		System.out.println(result);
		return result;	
	}
}
