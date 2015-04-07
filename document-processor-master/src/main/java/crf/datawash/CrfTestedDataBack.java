package crf.datawash;

import java.util.ArrayList;

import tools.all.FileInputAndOutput;

public class CrfTestedDataBack {
	public void CrfTDB(String readFilePath, String writeFilePath) {
		boolean shuyu = false;
		String sentence = "";
		ArrayList<String> datainputList = new ArrayList<String>();
		ArrayList<String> datatowriteList = new ArrayList<String>();
		datainputList = FileInputAndOutput.readTxtFile2(readFilePath);
		for (int i = 0; i < datainputList.size(); i++) {
			//System.out.println(i);
		//	System.out.println(datainputList.get(i));
			String s = datainputList.get(i);
			if (s.length() <2) {//datatowriteList.add("");
			datatowriteList.add(sentence);
			System.out.println(sentence);
			sentence="";
			} else {
				if (s.charAt(4) == 'B') {
					shuyu = true;
					sentence = sentence + "####(";
					sentence = sentence + s.substring(0, 1);

				} else if (s.charAt(4) == 'I') {
					sentence = sentence + s.substring(0, 1);

				} else if (s.charAt(4) == 'O') {
					
					if (shuyu == true) {
						sentence = sentence + ")####";
						shuyu = false;
					}
					sentence = sentence + s.substring(0, 1);
				}
			}
			
		}
		datatowriteList.add(sentence);
		FileInputAndOutput.writetxtFile(datatowriteList, writeFilePath);// 写入文件中
	}
}
