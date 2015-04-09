package tools.all;


public class GetTypeSentence {
	public String GTS(String Sentence, int TypeNum) {
		String Sen="";
		Sen=Sentence.substring(Sentence.indexOf("####"+TypeNum+TypeNum+"(")+7, Sentence.indexOf(")"+TypeNum+TypeNum+"####"));
		return Sen;
		
	}

}
