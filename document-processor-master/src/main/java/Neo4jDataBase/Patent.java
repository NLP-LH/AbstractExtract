package Neo4jDataBase;

public class Patent {
	String Name;
	String AppNum;
	String PubNum;
	String Applicant;
	String Inventor;
	String AppDate;
	String PubDate;
	String PatIllu;
	String Abstract;
	String Type;
	String Effect;
	
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getEffect() {
		return Effect;
	}
	public void setEffect(String effect) {
		Effect = effect;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAppNum() {
		return AppNum;
	}
	public void setAppNum(String appNum) {
		AppNum = appNum;
	}
	public String getPubNum() {
		return PubNum;
	}
	public void setPubNum(String pubNum) {
		PubNum = pubNum;
	}
	public String getApplicant() {
		return Applicant;
	}
	public void setApplicant(String applicant) {
		Applicant = applicant;
	}
	public String getInventor() {
		return Inventor;
	}
	public void setInventor(String inventor) {
		Inventor = inventor;
	}
	public String getAppDate() {
		return AppDate;
	}
	public void setAppDate(String appDate) {
		AppDate = appDate;
	}
	public String getPubDate() {
		return PubDate;
	}
	public void setPubDate(String pubDate) {
		PubDate = pubDate;
	}
	public String getPatIllu() {
		return PatIllu;
	}
	public void setPatIllu(String patIllu) {
		PatIllu = patIllu;
	}
	public String getAbstract() {
		return Abstract;
	}
	public void setAbstract(String abstract1) {
		Abstract = abstract1;
	}
	
	@Override
	public String toString() {
		return "Patent [Name=" + Name + 
		", AppNum=" + AppNum + 
		", PubNum=" + PubNum + 
		", Applicant=" + Applicant+ 
		", Inventor=" + Inventor + 
		", AppDate=" + AppDate+ 
		", PubDate=" + PubDate + 
		", PatIllu="+ PatIllu + 
		",Abstract=" + Abstract +
		",Type="+Type+
		",Effect="+Effect+
		"]";
	}
	
}
