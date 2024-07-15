package UtilityLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BaseLayer.BaseClass;

public class ExcelReader extends BaseClass {
	private static XSSFWorkbook workbook;

	public ExcelReader(String excelpath) throws Exception, IOException {
		workbook = new XSSFWorkbook(new FileInputStream(new File(excelpath)));
	}

	public static int getTotalRowCount(int index) {
		return workbook.getSheetAt(index).getLastRowNum() + 1;
	}

	public static int getTotalColumnCount(int index) {
		return workbook.getSheetAt(index).getRow(0).getLastCellNum();
	}

	public static Object getTotalSheetData(int index, int row, int cell) {
		XSSFCell cells = workbook.getSheetAt(index).getRow(row).getCell(cell);

		if (cells.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
			return " ";
		} else if (cells.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
			return cells.getBooleanCellValue();
		} else if (cells.getCellType() == XSSFCell.CELL_TYPE_ERROR) {
			return cells.getErrorCellValue();
		} else if (cells.getCellType() == XSSFCell.CELL_TYPE_FORMULA) {
			return cells.getCellFormula();
		} else if (cells.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
			return cells.getRawValue();
		} else if (cells.getCellType() == XSSFCell.CELL_TYPE_STRING) {
			return cells.getStringCellValue();
		} else {
			return null;
		}
	}

	public Object[][] getAllTotalSheetData(int index) {
		int row = getTotalRowCount(index);
		int cell = getTotalColumnCount(index);

		Object[][] data = new Object[row][cell];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cell; j++) {

				data[i][j] = getTotalSheetData(index, i, j);
			}
		}

		return data;

	}
}
