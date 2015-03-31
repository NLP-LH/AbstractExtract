package tools.all;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class FileInputAndOutput {
	public static ArrayList<String> readTxtFile(String filePath) {// 读取路径为filePath的文件
		ArrayList<String> List = new ArrayList<String>();
		try {
			String encoding = "GBK";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					List.add(lineTxt);
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return List;// 返回LIST，List每一个元素就是一行
	}
	public static ArrayList<String> readTxtFile2(String filePath) {// 读取路径为filePath的文件
		ArrayList<String> List = new ArrayList<String>();
		try {
			String encoding = "UTF-8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					List.add(lineTxt);
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return List;// 返回LIST，List每一个元素就是一行
	}
	public static void writetxtFile(ArrayList<String> List, String path) {// 将List写入路径为Path的文件
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(
					path), true));
			for (int i = 0; i < List.size(); i++) {
				writer.write(List.get(i));
				writer.newLine();// 换行
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 写入的文件路径

	}
	public static void writetxtFile2(ArrayList<String> List, String path) {// 将List写入路径为Path的文件,采用OUTPUTSTREAMWRITER
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(path), Charset.forName("GBK")));
			for (int i = 0; i < List.size(); i++) {
				bw.write(List.get(i));
				bw.newLine();// 换行
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 写入的文件路径

	}
	
	
}
