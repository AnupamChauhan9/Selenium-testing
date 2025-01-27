package ApacePoi;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xcel {
	public static void main (String[] args) throws IOException {
	String path = ".\\testData\\Userdata.xlsx";
	FileInputStream xl = new FileInputStream(path);
	XSSFWorkbook workbook = new XSSFWorkbook(xl);
	XSSFSheet sheet =  workbook.getSheetAt(0);
	int rows =sheet.getLastRowNum();
	int cell =sheet.getRow(1).getLastCellNum();
	for(int i = 0;i<=rows;i ++) {
		
		//DataFormatter is can be used instead of switch case
		//we can use itreator class as well
		for(int j = 0;j<cell;j++) {
			XSSFCell cellValue =sheet.getRow(i).getCell(j);
			System.out.print(cellValue +" | ");
			System.out.println(cellValue.getCellType());
			
			
		}
		System.out.println();
	}
	
	

}
}