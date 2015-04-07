package svm.datawash;

import java.io.IOException;
import java.util.ArrayList;

import tools.all.ExcelRead;

public class SVMedAbstractBack {
	public static void main(String[] args) throws IOException {
		SVMedAbstractBack AA=new SVMedAbstractBack();
		String DataToExtractFilePath="D:/file/DataToExtract/FullData.xls";
		ExcelRead ER=new ExcelRead();
		AA.SVMAB(ER.ExcelReadingGetColumn(DataToExtractFilePath, 1,1107, 8), ER.ExcelReadingGetColumn(DataToExtractFilePath, 1,1107, 12));
	}
	public ArrayList<String> SVMAB(ArrayList<String> SourceAbstract,ArrayList<String> SVMedAbstract){
		ArrayList<String> AbstractString = new ArrayList<String>();
		for(int i =0;i<SVMedAbstract.size();i++)
		{
			String s=SVMedAbstract.get(i);
			if(s.equals("-1")||s.equals("")){
				AbstractString.add("空");
				
			}else{
				String Subs=s.substring(7, s.indexOf(")11####"));
				String fuhao1="";
				String fuhao2="";
				int Count=0;
				if(Subs.endsWith(",")||Subs.endsWith("，")){
					
					fuhao1="，";
					fuhao2="，";
				}
				if(Subs.endsWith("。")){
					
					fuhao1="。";
					fuhao2="。";
				}
				if(Subs.endsWith(";")||Subs.endsWith("；")){
					
					fuhao1="；";
					fuhao2=";";
				}
				for(int p=0;p<Subs.length();p++)
				{
					if(Subs.substring(p, p+1).equals(fuhao1)||Subs.substring(p, p+1).equals(fuhao2)){
						Count+=1;
						
					}
					
				}
				String SA=SourceAbstract.get(i);
				
				for(int q=0;q<SA.length()-1;q++){
					if(SA.substring(q, q+1).equals(fuhao1)||SA.substring(q, q+1).equals(fuhao2)){
						Count=Count-1;
						
					}
					if(Count==0){
						AbstractString.add("####11("+SA.substring(0, q+1)+")11########22("+SA.substring(q+1)+")22####");
						System.out.println("####11("+SA.substring(0, q+1)+")11########22("+SA.substring(q+1)+")22####");
						break;
					}
				}
				
				
				
				
				
				
				
				
			}
			
			
			
		}
		
		
		return AbstractString;
		
	}
	
	

}
