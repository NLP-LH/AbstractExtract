package main.abstractextract;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.shirdrn.document.processor.Sorting;

import crf.datawash.CrfTestedDataBack;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import tools.all.ExcelRead;
import tools.all.ExcelWrite;
import tools.all.FileInputAndOutput;

public class test12 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws BiffException 
	 */
	public static void main(String[] args) throws BiffException, IOException {
		
		
		CrfTestedDataBack aa=new CrfTestedDataBack();
		System.out.println("1");
		aa.CrfTDB("D:\\file\\4", "D:\\file\\5");
		System.out.println("2");
	}
	
	public static void ffk() {
		ArrayList<String> AbstractString = new ArrayList<String>();
		ArrayList<String> Abs = new ArrayList<String>();
		String DataToExtractFilePath="D:/file/DataToExtract/FullData.xls";
		//读取文档中的摘要
		ExcelRead ER=new ExcelRead();	
		AbstractString=ER.ExcelReadingGetColumn(DataToExtractFilePath, 1,1107, 9);
		for (int i=0; i < AbstractString.size(); i++) {
			
			Abs.add(cfk(AbstractString.get(i)));
			
		}	
		
		ExcelWrite EW=new ExcelWrite();
		EW.ExcelWritingOfColumn("D:/file/DataToExtract/FullData.xls", 1,1107, 8,Abs);
		
		
		
	}
	public static String  cfk(String k) {
		String s="";
		int type=0;
		int weizhi=0;
		while(k.length()>2){
			if(k.charAt(2)=='#'){
				type=Integer.parseInt(k.substring(4, 5));
				weizhi=k.indexOf(")"+type+type+"####");
			}
			
			s=s+k.substring(7,weizhi);
			//System.out.println(s);
			k=k.substring(weizhi+7);
			//System.out.println(k);
		}
		
		return s;
		
	}

	public static void ddk() {
		ArrayList<String> List1 = new ArrayList<String>();
		ArrayList<String> List2 = new ArrayList<String>();
		List1 = FileInputAndOutput.readTxtFile("D:/file/1.txt");
		List2 = FileInputAndOutput.readTxtFile2("D:/file/2.txt");
		System.out.println(List1.size());
		int right = 0;
		int wrong = 0;
		int jishu = 0;
		for (int i = 0; i < List1.size(); i++) {
			// System.out.println(List1.get(i));

			// System.out.println(List2.get(i));
			StringBuilder sb = new StringBuilder(List1.get(i));
			String aa = sb.reverse().toString();
			int cas = aa.indexOf("。", 12);
			String ff = "";
		
			if (cas == -1) {
				// System.out.println("只有一个。号");
			

				int sas = aa.indexOf("明发本", 1);
				int saa = 0;
				if (sas == -1) {
					//19
					System.out.println(aa);
				} else {
					//114
					if (sas + 20 < List1.get(i).length()) {
						//34
						for (int p = 1; p < 25; p++) {
						//575
							if (List1.get(i).charAt(
									List1.get(i).length() - sas - p) == '，'
									|| List1.get(i).charAt(
											List1.get(i).length() - sas - p) == '；') {
								//29
								wrong = wrong + 1;
								saa = sas - p;
								System.out.println(i
										+ "   "
										+ List1.get(i)
												.substring(
														List1.get(i).length()
																- sas - p));
								if (List1.get(i).substring(
										List1.get(i).length() - sas - p)
										.contains("33")) {
								
									right += 1;
								} else {
								
								}

								break;

							}else{
								
							//546
							}

						}
					}else{
						//80
						
					}
					
				}

			}

		}
		System.out.println(right + "and " + wrong);
		System.out.println(jishu);
	}

	public static void ck() {
		ArrayList<String> List1 = new ArrayList<String>();
		ArrayList<String> List2 = new ArrayList<String>();
		List1 = FileInputAndOutput.readTxtFile("D:/file/3.txt");
		List2 = FileInputAndOutput.readTxtFile2("D:/file/2.txt");
		System.out.println(List1.size());
		int right = 0;
		int wrong = 0;
		for (int i = 0; i < List1.size(); i++) {
			StringBuilder sb = new StringBuilder(List1.get(i));
			String aa = sb.reverse().toString();
			int cas = aa.indexOf("。", 12);
			String ff = "";
			if (cas == -1) {
				// System.out.println("只有一个。号");

			} else {
				ff = List1.get(i).substring(List1.get(i).length() - cas + 14);
				System.out.println(ff);
				// if(ff.length()<11){}else{
				// if(ff.substring(0, 10).contains("本发明")||ff.substring(0,
				// 10).contains("该方法")||ff.substring(0,
				// 10).contains("本方法")||ff.substring(0, 10).contains("该发明")
				// ){
				if (ff.equals(List2.get(i) + ")33####")) {
					// &&(ff.substring(0, 10).contains("本发明")||ff.substring(0,
					// 10).contains("该方法")||ff.substring(0,
					// 10).contains("本方法")||ff.substring(0, 10).contains("该发明"))
					right = right + 1;
				} else {
					wrong = wrong + 1;

				}// }//}
			}

		}
		System.out.println(right + "and " + wrong);
	}

	public static void cc() {
		ArrayList<String> List1 = new ArrayList<String>();
		ArrayList<String> List2 = new ArrayList<String>();
		List1 = FileInputAndOutput.readTxtFile("D:/file/3.txt");
		List2 = FileInputAndOutput.readTxtFile2("D:/file/2.txt");
		System.out.println(List1.size());
		int a = 0;
		for (int i = 0; i < List1.size(); i++) {
			StringBuilder sb = new StringBuilder(List1.get(i));
			String aa = sb.reverse().toString();
			int cas = aa.indexOf("。", 12);
			String ff = "";
			if (cas == -1) {
				System.out.println("只有一个。号");

			} else {
				ff = List1.get(i).substring(List1.get(i).length() - cas);
				System.out.println(ff.substring(0, 3));
				if (ff.substring(0, 3).equals(")22")) {
					a = a + 1;
				}
			}

		}
		System.out.println(a);
	}

	public static void ff() {
		ArrayList<String> List = new ArrayList<String>();
		ArrayList<String> List2 = new ArrayList<String>();
		List = FileInputAndOutput.readTxtFile("D:/file/1.txt");
		System.out.println("一共有摘要" + List.size() + "条");
		int a = 0;
		for (int i = 0; i < List.size(); i++) {
			System.out.println(List.get(i));
			if (List.get(i).contains("####33(")) {

				List2.add(List.get(i));
			} else {

				a += 1;
			}

		}
		FileInputAndOutput.writetxtFile2(List2, "D:/file/3.txt");
		System.out.println(a);
	}

	public static void ss() {
		// TODO Auto-generated method stub
		ArrayList<String> List = new ArrayList<String>();
		List = FileInputAndOutput.readTxtFile2("D:/file/2.txt");
		System.out.println(List.size());
		int a = 0;
		for (int i = 0; i < List.size(); i++) {

			if (List.get(i).substring(0, 10).contains("本发明")
					|| List.get(i).substring(0, 10).contains("该方法")
					|| List.get(i).substring(0, 10).contains("本方法")
					|| List.get(i).substring(0, 10).contains("该发明")) {
				a = a + 1;

			} else {
				System.out.println(i);
				System.out.println(List.get(i).substring(0, 10));
			}

		}
		System.out.println(a);
	}
}
