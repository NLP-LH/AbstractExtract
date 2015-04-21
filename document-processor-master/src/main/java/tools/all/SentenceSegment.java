package tools.all;

import java.util.ArrayList;

public class SentenceSegment {
	public static void main(String[] args) {
		SentenceSegment s=new SentenceSegment();
		String a="本发明提供一种适用于####(模块化多电平换流器控制系统)####的####(通信架构)####，该####(架构)####包括####(阀基控制设备)####（VBC）的####(光纤通信板卡)####及其####(光收发模块)####、####(换流器控制子模块单元)####（SMC）及其光####(收发模块)####、####(光纤通道)####；其中，一台所述####(VBC)####配置至少一个####(光纤通信板卡)####，一个####(光纤通信板卡)####配置至少一个####(光收发模块)####；所述####(光纤通道)####，用于实现所述####(VBC)####和所述####(SMC)####之间的信息传输，和/或####(SMC)####之间的信息传输。";
		s.SS(a);
		
	}
	public ArrayList<String> SS(String Sen) {
		ArrayList<String> Sentence=new ArrayList<String>();
		int begin=0;
		int end;
		for(int i=0;i<Sen.length();i++){			
			if(symbol(Sen.substring(i, i+1))){
				end=i;				
				Sentence.add(Sen.substring(begin, end+1));
				
				Sen=Sen.substring(end+1);
				i=0;				
			}									
		}	
		return Sentence;
	}
	public boolean symbol(String s) {
		boolean symbol = false;
		if (s.equals(",") || s.equals("，") || s.equals("。") || s.equals("；") || s.equals(";") || s.equals("：") || s.equals("、")) {
			symbol = true;
		}
		return symbol;
	}
}
