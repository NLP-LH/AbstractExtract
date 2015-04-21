package svm.datawash;

import java.util.ArrayList;

import tools.all.ExcelRead;
import tools.all.ExcelWrite;

public class SVMLabelWithCRFed {
	//把CRF和SVM的手工标注结果相结合
	public  void SWC(String DataToExtractFilePath,int StartRow,int EndRow,int SVMColumn,int CRFColumn,int ResultRow) {
		ArrayList<String> AbstractSVMString = new ArrayList<String>();
		ArrayList<String> AbstractCRFString = new ArrayList<String>();
		ArrayList<String> AbstractClaString = new ArrayList<String>();
		ArrayList<String> AbstractNewString = new ArrayList<String>();
		ExcelRead ER = new ExcelRead();
		AbstractSVMString = ER.ExcelReadingGetColumn(DataToExtractFilePath, StartRow,
				EndRow, SVMColumn);
		AbstractCRFString = ER.ExcelReadingGetColumn(DataToExtractFilePath, StartRow,
				EndRow, CRFColumn);

		 for (int i=0; i < AbstractCRFString.size(); i++) {
			String s = AbstractSVMString.get(i);
			System.out.println("s"+"  "+s);
			String type = "";
			String EndStr = "";
			String SubStr = "";	
			while (s.length() > 2) {
				int juhao = 0;
				int douhao = 0;
				int fenhao=0;
				if (s.charAt(1) == '#') {
					type = s.substring(4, 5);
					EndStr = ")" + type + type + "####";
					SubStr = s.substring(7, s.indexOf(EndStr));
					s = s.substring(s.indexOf(EndStr) + 7);
					System.out.println("SubStr"+"  "+SubStr);
					System.out.println("s"+"  "+s);
					for (int u = 0; u < SubStr.length(); u++) {
						if (SubStr.charAt(u) == '。') {
							juhao += 1;
						}
						if (SubStr.charAt(u) == '，'||SubStr.charAt(u) == ',') {
							douhao += 1;
						}
						if (SubStr.charAt(u) == '；') {
							fenhao += 1;
						}
					}
					AbstractClaString.add(i + "," + type + "," + douhao + ","
							+ juhao+ ","+fenhao);
					System.out.println(i+","+type+","+juhao + " " + douhao+","+fenhao);
				} else {
					System.out.println("  出错了");
				}
			}
		}

		int nm = -1;
		String Abs = "";
		String NewStr = "";
		for (int i = 0; i < AbstractClaString.size(); i++) {
			String s = AbstractClaString.get(i);
			//System.out.println(i+"  "+AbstractClaString.get(i));
			int num = 0;
			int type = 0;
			int douhao = 0;
			int juhao = 0;
			int fenhao =0;

			int a = s.indexOf(",");
			num = Integer.parseInt(s.substring(0, a));
			s = s.substring(a + 1);

			a = s.indexOf(",");
			type = Integer.parseInt(s.substring(0, a));
			s = s.substring(a + 1);

			a = s.indexOf(",");
			douhao = Integer.parseInt(s.substring(0, a));
			s = s.substring(a + 1);
			
			a = s.indexOf(",");
			juhao = Integer.parseInt(s.substring(0, a));
			s = s.substring(a + 1);
			
			fenhao = Integer.parseInt(s);
			System.out.println("---------------------------");
			System.out.println("  num "+num + "," + type + "," + douhao + "," + juhao+ "," + fenhao);
				
			if (num == nm) {
				// 处理
				int ju = 0;
				int dou = 0;
				int fen=0;
				for (int p = 0; p < Abs.length(); p++) {
					if (Abs.charAt(p) == '，'||Abs.charAt(p) == ',') {
						dou = dou + 1;
						if(dou==douhao&&ju==juhao&&fen==fenhao){
							NewStr=NewStr+"####"+type+type+"("+Abs.substring(0, p+1)+")"+type+type+"####";
							Abs=Abs.substring(p+1);
							System.out.println(NewStr);
							System.out.println(Abs);
							break;
						}
					}
					if (Abs.charAt(p) == '。') {

						ju = ju + 1;
						if(dou==douhao&&ju==juhao&&fen==fenhao){
							NewStr=NewStr+"####"+type+type+"("+Abs.substring(0, p+1)+")"+type+type+"####";
							Abs=Abs.substring(p+1);
							System.out.println(NewStr);
							System.out.println(Abs);
							break;
						}
					}
					if (Abs.charAt(p) == '；') {
						fen = fen + 1;
						if(dou==douhao&&ju==juhao&&fen==fenhao){
							NewStr=NewStr+"####"+type+type+"("+Abs.substring(0, p+1)+")"+type+type+"####";
							Abs=Abs.substring(p+1);
							System.out.println(NewStr);
							System.out.println(Abs);
							break;
						}
					}
				}
			} else {
				AbstractNewString.add(NewStr);
				System.out.println("haha "+NewStr);
				NewStr="";
				nm = num;
				Abs = AbstractCRFString.get(num);
				// 处理
				int ju = 0;
				int dou = 0;
				int fen=0;
				for (int p = 0; p < Abs.length(); p++) {
					if (Abs.charAt(p) == '，'||Abs.charAt(p) == ',') {
						dou = dou + 1;
						if(dou==douhao&&ju==juhao&&fen==fenhao){
							NewStr=NewStr+"####"+type+type+"("+Abs.substring(0, p+1)+")"+type+type+"####";
							Abs=Abs.substring(p+1);
							System.out.println(NewStr);
							System.out.println(Abs);
							break;
						}
					}
					if (Abs.charAt(p) == '。') {
						ju = ju + 1;
						if(dou==douhao&&ju==juhao&&fen==fenhao){
							NewStr=NewStr+"####"+type+type+"("+Abs.substring(0, p+1)+")"+type+type+"####";
							Abs=Abs.substring(p+1);
							System.out.println(NewStr);
							System.out.println(Abs);
							break;
						}
					}
					if (Abs.charAt(p) == '；') {
						fen = fen + 1;
						if(dou==douhao&&ju==juhao&&fen==fenhao){
							NewStr=NewStr+"####"+type+type+"("+Abs.substring(0, p+1)+")"+type+type+"####";
							Abs=Abs.substring(p+1);
							System.out.println(NewStr);
							System.out.println(Abs);
							break;
						}
					}
				}
			}
		}
		AbstractNewString.add(NewStr);
		ExcelWrite EW=new ExcelWrite();
		EW.ExcelWritingOfColumn(DataToExtractFilePath, StartRow-1,EndRow, ResultRow, AbstractNewString);		
		for (int i = 1; i < AbstractNewString.size(); i++) {
			System.out.println(i+"  "+AbstractNewString.get(i));						
		}		
	}
}
