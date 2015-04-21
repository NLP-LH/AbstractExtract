package main.abstractextract.sentenceextract;

import java.util.ArrayList;

import resource.AdjOfEffect;
import resource.NounOfEffect;
import resource.VerbOfEffect;
import tools.all.GetTypeSentence;
import tools.all.SentenceSegment;

public class EffectExtract {
	
	public ArrayList<String> ExE(ArrayList<String> Abstract) {
		ArrayList<String> EffectList=new ArrayList<String>();
		GetTypeSentence GTS =new GetTypeSentence();
		for(String s:Abstract){
			if(s.equals("空")||s.equals("")){				
				EffectList.add("");
			}else{
				EffectList.add(EA(GTS.GTS(s,2)));				
			}		
		}			
		return EffectList;
	}
	public String EA(String Abstract) {
		String result="";
		ArrayList<String> Sentence=new ArrayList<String>();
		SentenceSegment SS=new SentenceSegment();		
		Sentence=SS.SS(Abstract);
		for(String s :Sentence){
			String aa=EE(s);
			if(aa.equals("")){
				
				
			}else{
				result=result+aa+";";
				
			}
		}
		
		return result;
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

			if(Abstract.indexOf(s)!=-1){
				Noun=s;
				break;
			}
			
		}
		for(String s: VerbList){

			if(Abstract.indexOf(s)!=-1){
				Verb=s;
				result=Verb+Noun;
				break;
			}
			
		}
		if(Verb.equals("")){
			for(String s: AdjList){

				if(Abstract.indexOf(s)!=-1){
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
