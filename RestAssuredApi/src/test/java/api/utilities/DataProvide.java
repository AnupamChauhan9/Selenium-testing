package api.utilities;

import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;
public class DataProvide {
	@DataProvider(name = "Data")

	public String[][] getAllData() throws IOException{
		String path = System.getProperty("user.dir")+"//target//dataUser.xlsx";
		System.out.println(path);
		XLUtility xl = new XLUtility(path);
		/*row index start from 0 -first rowand columnalso from zero
		//but to exclude row header we skip first row and start from 1
		 * for 3 row 4 column
		//getlastRow- it include the empty row as well and reurn thr last index value-2 
		getlastCell- two case 1.for overall empty it return=-1;
		2. If one cell has data or other is empty it will give last index of cell+1 =4;
		but getPhysicalNumberOfRows =3andgetPhysicalNumberOfCells=4
		do no include the empty row and cells just give last index as result. 
		*/
		int row = xl.getRowCount("Sheet1");
		System.out.println(row);
		int col = xl.getCellCount("Sheet1", 0);
		System.out.println(col);
		String [][] apiData = new String[row][col];
		for (int i=1;i<row;i++) {
//			XSSFSheet sheet =xl.getSheet("Sheet1")
//			XSSFRow row1 = sheet.getRow(i);
//	        if (row1 != null) {
//	            sheet.removeRow(row1);  // Removes the row
//	           
//	        }

			for(int  j = 0;j < col;j++) {
				apiData[i-1][j] = xl.getCellData("Sheet1",i ,j);
				//System.out.println(xl.getCellData("Sheet1", i, j));
				//System.out.println(j);
				
			}
		}
		for (String[] row1 : apiData) {
            System.out.println(Arrays.toString(row1));
        }
			
		return apiData;
	}
	@DataProvider(name = "userNames")
	public String[] getUserNames() {
		
		return null;
	}

}
