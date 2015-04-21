package main.abstractextract.sentenceextract;

import java.util.ArrayList;

import resource.FilePath;
import tools.all.ExcelRead;

public class DomainExtract {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String DataToExtractFilePath=FilePath.DataToExtractFilePath;
		ArrayList<String> AbstractString = new ArrayList<String>();			
		int StartRow=1;
		int EndRow=1107;
		ExcelRead ER=new ExcelRead();	

		AbstractString=ER.ExcelReadingGetColumn(DataToExtractFilePath, StartRow,EndRow, 8);	
		int c=1;
		for(String s :AbstractString){
			int a=s.indexOf("属于");
			int b=s.indexOf("领域");
			if(a!=-1&&b!=-1){

				System.out.println(s.substring(a, b+2));
				c=c+1;
			}
			
			
		}
		System.out.println(c);
	}

}
