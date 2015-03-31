package tools.all;

import java.io.File;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
public class ExcelWrite {
	  public void ExcelWriting(String FilePath,int Row,int Column, String Word) {//参数为路径，行，列，要输入的内容
	        try {
	        	//文件读取是从0行0列开始
	            // Excel获得文件
	           // Workbook wb = Workbook.getWorkbook(new File("D:/file/DataToExtract/FullData.xls"));
	        	Workbook wb = Workbook.getWorkbook(new File(FilePath));
	            // 打开一个文件的副本，并且指定数据写回到原文件
	           // WritableWorkbook book = Workbook.createWorkbook(new File("D:/file/DataToExtract/FullData.xls"), wb);
	            WritableWorkbook book = Workbook.createWorkbook(new File(FilePath), wb);
	            WritableSheet sheet = book.getSheet(0);
	            sheet.addCell(new Label(Column, Row, Word));
	            book.write();
	            book.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	  
	  public void ExcelWritingOfColumn(String FilePath,int StartRow,int EndRow,int Column, ArrayList<String> Word) {//参数为路径，行，列，要输入的内容
	        try {
	        	//文件读取是从0行0列开始
	            // Excel获得文件
	           // Workbook wb = Workbook.getWorkbook(new File("D:/file/DataToExtract/FullData.xls"));
	        	Workbook wb = Workbook.getWorkbook(new File(FilePath));
	            // 打开一个文件的副本，并且指定数据写回到原文件
	           // WritableWorkbook book = Workbook.createWorkbook(new File("D:/file/DataToExtract/FullData.xls"), wb);
	            WritableWorkbook book = Workbook.createWorkbook(new File(FilePath), wb);
	            WritableSheet sheet = book.getSheet(0);
	            int s=0;
	           for (int i = StartRow; i < EndRow+1; i++) {
	        	   
	            sheet.addCell(new Label(Column, i, Word.get(s)));
	            s=s+1;
	           }
	            book.write();
	            book.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
}
