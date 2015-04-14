package tools.all;

import java.io.File;
import java.util.ArrayList;

import Neo4jDataBase.Patent;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelRead {
	public String ExcelReading(String FilePath, int Row, int Column) {// 获取一个单元格格的数据
		String result = "";
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
			int StartRow, int EndRow, int Column) {// 获取一列的数据
		ArrayList<String> Abs = new ArrayList<String>();
		try {
			// 文件读取是从0行0列开始
			Workbook book = Workbook.getWorkbook(new File(FilePath));
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			for (int i = StartRow; i < EndRow + 1; i++) {
				Abs.add(sheet.getCell(Column, i).getContents());
			}
			book.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return Abs;
	}

	public ArrayList<Patent> ExcelReadingGetPatentData(String FilePath,
			int StartRow, int EndRow) {// 获取一行的数据
		ArrayList<Patent> Pat = new ArrayList<Patent>();
		try {
			// 文件读取是从0行0列开始
			Workbook book = Workbook.getWorkbook(new File(FilePath));
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			
			for (int p = StartRow; p < EndRow; p++) {

				Patent patent = new Patent();
				patent.setName(sheet.getCell(0, p).getContents());
				patent.setAppNum(sheet.getCell(1, p).getContents());
				patent.setPubNum(sheet.getCell(2, p).getContents());
				patent.setApplicant(sheet.getCell(3, p).getContents());
				patent.setInventor(sheet.getCell(4, p).getContents());
				patent.setAppDate(sheet.getCell(5, p).getContents());
				patent.setPubDate(sheet.getCell(6,p).getContents());
				patent.setPatIllu(sheet.getCell(7, p).getContents());
				patent.setAbstract(sheet.getCell(8, p).getContents());
				Pat.add(patent);
				
			}
			book.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return Pat;
	}
}
