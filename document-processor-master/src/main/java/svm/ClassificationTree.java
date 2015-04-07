package svm;

import java.io.IOException;
import java.util.ArrayList;

import org.shirdrn.document.processor.AbstractDocumentProcessorDriver;
import org.shirdrn.document.processor.Sorting;
import org.shirdrn.document.processor.TestDocumentProcessorDriver;

import svm.classification.svm_predict;
import tools.all.FileInputAndOutput;

public class ClassificationTree {

	public static void main(String[] args) throws IOException {
		ClassificationTree CT=new ClassificationTree();
		CT.Classification("本jishu涉及用于术语的通信方法和装置以及术语,在该术语中，针对术语所包括的至少一个小区簇中的一个术语，基于该小区簇中各术语的不可分流业务的不可分流预测量、以及该小区簇中各术语的可与其他小区分流的术语的可分流预测量，确定在下一术语内该小区簇的上下行配比方案，以优化术语利用效率，并且该小区簇中的小区具有相同的术语和上下行配比方案,根据本发明的实施例，可以改进术语利用效率。");
	}

	public String Classification(String s) throws IOException {
		//1 功效
		//2 组件
		

		String result = "";
		StringBuilder sb = new StringBuilder(s);
		String aa = sb.reverse().toString();
		int cas = aa.indexOf("。", 3);
		if (cas == -1) {
			// 只有最后一个句号
			int sas = aa.indexOf("明发本", 1);

			if (sas == -1) {
				// 没找到本发明几个字
				// 按照符号一个一个SVM分类
				

			} else {
				// 找到本发明几个字
				if (sas + 20 < s.length()) {
					// 本发明不在句首
					int p=0;
					for ( p = 1; p < 20; p++) {
						if (s.charAt(s.length() - sas - p) == '，'
								|| s.charAt(s.length() - sas - p) == '；'
									|| s.charAt(s.length() - sas - p) == ','
										|| s.charAt(s.length() - sas - p) == ';') {

							System.out.println(s.substring(0, s.length() - sas
									- p + 1));
							System.out.println(s.substring(s.length() - sas - p
									+ 1));
							// SVM分类
							break;

						}

					}
					if(SVMDataWash(s.substring(s.length() - sas - p+ 1)).equals("1.0")){
						result="####11("+s.substring(0, s.length() - sas- p + 1)+")11####"+"####22("+s.substring(s.length() - sas - p+ 1)+")22####";
							
					}else{
						
						result="-1";
					}
			
					System.out.println(result);
					//完成
				} else {
					// 本发明几个字在句首
					// 按照符号一个一个SVM分类

				}

			}

		} else {
			// 有不止一个句号
			int sas = aa.indexOf("明发本", 1);

			if (sas == -1) {
				// 没找到本发明几个字
				System.out.println(s.substring(0, s.length() - cas));
				System.out.println(s.substring(s.length() - cas));					
				
				if(SVMDataWash(s.substring(s.length() - cas)).equals("1.0")){
					result="####11("+s.substring(0, s.length() - cas)+")11####"+"####22("+s.substring(s.length() - cas)+")22####";
						
				}else{
					
					result="-1";
				}
		
				System.out.println(result);
				//完成
				

			} else {
				// 找到本发明几个字
				if (sas + 20 < s.length()) {
					// 本发明不在句首

					System.out.println(s.substring(0, s.length() - cas));
					System.out.println(s.substring(s.length() - cas));
					result="####11("+s.substring(0, s.length() - cas)+")11####"+"####22("+s.substring(s.length() - cas)+")22####";
					
					//完成

				} else {
					// 本发明几个字在句首
					// 按照句号进行SVM分类
					System.out.println(s.substring(0, s.length() - cas));
					System.out.println(s.substring(s.length() - cas));					
					
					if(SVMDataWash(s.substring(s.length() - cas)).equals("1.0")){
						result="####11("+s.substring(0, s.length() - cas)+")11####"+"####22("+s.substring(s.length() - cas)+")22####";
							
					}else{
						
						result="-1";
					}
					// 如果SVM分类不是功效类再进行识别
					System.out.println(result);
					//完成
				}

			}

		}
		return result;
	}

	public static String SVMDataWash(String s) throws IOException {
		ArrayList<String> Abs = new ArrayList<String>();
		Abs.add(s);
		//先删除所有文件
		FileInputAndOutput.delFolder("D:/file/SVMFile/测试数据/功效/");
		FileInputAndOutput.delFile("D:/file/SVMFile/test.txt");
		FileInputAndOutput.delFile("result");
		FileInputAndOutput.delFile("D:/file/SVMFile/SortedTest.txt");
		//再将摘要写进文件中
		FileInputAndOutput.writetxtFile2(Abs,"D:/file/SVMFile/测试数据/功效/1.txt");
		System.out.println(" s: "+s);
		//再提取向量
		AbstractDocumentProcessorDriver.start(TestDocumentProcessorDriver.class);
		//排序
		Sorting.sort("D:/file/SVMFile/test.txt", "D:/file/SVMFile/SortedTest.txt");		
		//预测
		String[] testArgs = {"D:/file/SVMFile/SortedTest.txt", "D:/file/SVMFile/SVMModel", "result"};
		svm_predict.main(testArgs);
		//取类别号
		ArrayList<String> Ecs = FileInputAndOutput.readTxtFile("result");
		System.out.println("   "+Ecs.get(0)); 
		return Ecs.get(0);
		
	}
}
