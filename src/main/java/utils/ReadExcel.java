package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExcel {
	
	

	public static String[][] getInValidLoginExcelData() throws IOException {
		//String sheetLoc = "E:\\EateasyTest\\data\\datasheet.xlsx";  --> hard coded the filepath not fetching the updating data.

		

		XSSFWorkbook book = new XSSFWorkbook(System.getProperty("user.dir")+"//data//datasheet.xlsx");

		XSSFSheet sheet = book.getSheetAt(1);

		int total_active_rows = sheet.getPhysicalNumberOfRows();
		int physicalNumberOfCells = sheet.getRow(0).getPhysicalNumberOfCells();
		 System.out.println("physical number of rows :"+total_active_rows);

		String userdata[][] = new String[total_active_rows-1][physicalNumberOfCells];

		for (int i = 1; i < total_active_rows; i++) {

			XSSFRow active_row = sheet.getRow(i);

			int total_active_cell_datas = active_row.getPhysicalNumberOfCells();

			for (int j = 0; j < total_active_cell_datas; j++) {

				XSSFCell current_cell = active_row.getCell(j);
				DataFormatter dataformat = new DataFormatter();
				String formatted_cell_value = dataformat.formatCellValue(current_cell);

				

				// System.out.print(formatted_cell_value+" ");
				userdata[i-1][j] = formatted_cell_value;

				

			}
			

		}

		book.close();
		return userdata;

	}

	
	
	public static String[][] getValidLoginExcelData() throws IOException {
		//String sheetLoc = "E:\\EateasyTest\\data\\datasheet.xlsx";

		

		XSSFWorkbook book = new XSSFWorkbook(System.getProperty("user.dir")+"//data//datasheet.xlsx");

		XSSFSheet sheet = book.getSheetAt(0);

		int total_active_rows = sheet.getPhysicalNumberOfRows();
		int physicalNumberOfCells = sheet.getRow(0).getPhysicalNumberOfCells();
		 System.out.println("physical number of rows :"+total_active_rows);

		String userdata[][] = new String[total_active_rows-1][physicalNumberOfCells];

		for (int i = 1; i < total_active_rows; i++) {

			XSSFRow active_row = sheet.getRow(i);

			int total_active_cell_datas = active_row.getPhysicalNumberOfCells();

			for (int j = 0; j < total_active_cell_datas; j++) {

				XSSFCell current_cell = active_row.getCell(j);
				DataFormatter dataformat = new DataFormatter();
				String formatted_cell_value = dataformat.formatCellValue(current_cell);

				

				// System.out.print(formatted_cell_value+" ");
				userdata[i-1][j] = formatted_cell_value;

				

			}
			

		}

		book.close();
		return userdata;

	}
	
	
	@DataProvider(/* parallel = true */ )
	public String[][] getValidLoginExcelSheetData() throws IOException {
		
		String[][] excelData = getValidLoginExcelData();
		return excelData;

	}
	
	
	@DataProvider(name = "invalidData"/* parallel = true */ )
	public String[][] getInValidLoginExcelSheetData() throws IOException {
		
		String[][] excelData = getInValidLoginExcelData();
		return excelData;

	}
	
}
