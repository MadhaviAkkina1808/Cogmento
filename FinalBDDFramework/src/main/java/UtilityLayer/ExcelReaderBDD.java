package UtilityLayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BaseLayer.BaseClass;

public class ExcelReaderBDD extends BaseClass {

	public static XSSFWorkbook workbook;

	public List<Map<String, String>> getAllSheetTestData(String excelpath, String sheetName) throws IOException {

		FileInputStream fis = new FileInputStream(excelpath);
		workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		int rows = sheet.getLastRowNum();

		List<Map<String, String>> rowTestData = new ArrayList<Map<String, String>>();

		for (int i = 1; i <= rows; i++) {

			int cells = sheet.getRow(0).getLastCellNum();

			LinkedHashMap<String, String> columnTestData = new LinkedHashMap<String, String>();

			for (int j = 0; j < cells; j++) {
				String columnheaders = sheet.getRow(0).getCell(j).getStringCellValue();

				XSSFCell cell = sheet.getRow(i).getCell(j);
				if (cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
					columnTestData.put(columnheaders, " ");
				}

				else if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
					String cellvalue = cell.getStringCellValue();
					columnTestData.put(columnheaders, cellvalue);
				}

				else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
					String cellvalue = cell.getRawValue();
					columnTestData.put(columnheaders, cellvalue);
				} else if (cell.getCellType() == XSSFCell.CELL_TYPE_FORMULA) {
					String cellvalue = cell.getCellFormula();
					columnTestData.put(columnheaders, cellvalue);
				}
			}
			rowTestData.add(columnTestData);
		}
		return rowTestData;

	}

}
