package resource;

import java.util.ArrayList;

public class NounOfEffect {

	ArrayList<String> NounString=new ArrayList<String>();
	public ArrayList<String> getNounString() {
		return NounString;
	}
	public void setNounString(ArrayList<String> nounString) {
		NounString = nounString;
	}
	public NounOfEffect(){
		
		String[] Noun={"冲突","利用率","有效利用","电量","可靠性","规模","效率","容量","质量","保障","拥塞","步骤","难度","时间","复杂度","失败","性能","成本","体验","不确定性","干扰","传输距离","满意度","安全","误码率","灵敏度","消耗","延迟","功率","稳定","时延","浪费","流程","结构","功耗","数据","容错","损失","难度","范围","原理","实用性","安全性","容量","利用率","保密性","灵活性","操作","耗电","加工","成本","应用","开销","结构","自动化"};
		for(String s:Noun){
			NounString.add(s);
			//System.out.println(s);
		}
		
	} 
	
	
	
}
