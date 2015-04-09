package tools.all;

import java.io.File;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelRead {
	public String ExcelReading(String FilePath, int Row, int Column) {//获取一个单元格格的数据
		String result = "";
		;
		try {
			// 文件读取是从0行0列开始
			Workbook book = Workbook.getWorkbook(new File(FilePath));
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);

			// 得到单元格
			Cell cell1 = sheet.getCell(Column, Row);
			result = cell1.getContents();
			book.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	public ArrayList<String> ExcelReadingGetColumn(String FilePath,
			int StartRow, int EndRow, int Column) {//获取一列的数据		
		ArrayList<String> Abs = new ArrayList<String>();
		try {
			// 文件读取是从0行0列开始
			Workbook book = Workbook.getWorkbook(new File(FilePath));
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			for (int i = StartRow; i < EndRow+1; i++) {
				Abs.add(sheet.getCell(Column, i).getContents());
			}
			book.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return Abs;
	}

}
