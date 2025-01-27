package qa.utilties;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utility {
	public static final int impli_wait_time = 10;
	public static final int page_load = 6;
	public static String currentDate() {
	Date date = new Date();
	String  dateText = date.toString();
	String t = dateText.replace(" ", "_").replace(":", "_");
	return "anupam"+t+"@gamil.com";
	}
public static Object[][] getDataXl(String SheetName) {
		File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\qa\\config\\turorialtest.xlsx");
		XSSFWorkbook workbook = null;
		try {
			FileInputStream xl = new FileInputStream(file);
			workbook = new XSSFWorkbook(xl);
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheet(SheetName);
		int rows = sheet.getLastRowNum();
		int column = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rows][column];
		for (int i = 0;i<rows;i++) {
			XSSFRow row = sheet.getRow(i+1);
			for (int j = 0;j<column;j++) {
				XSSFCell  cell =row.getCell(j);
				CellType cellType = cell.getCellType();
				switch (cellType) {
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] =Integer.toString((int) cell.getNumericCellValue());
					break;
				default:
					break;
				
				}
			
			  
			}
		}
		return data;
	}

}
