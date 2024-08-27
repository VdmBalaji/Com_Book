package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data_stays {

	public  static String [][] Fetch_data() throws IOException
	{
		//src/main/java/Utilities/Booking data.xlsx
		//src/main/java/Test_Data/BD.xlsx
		System.out.println("Begin kick");
		String one = System.getProperty("user.dir");
		System.out.println("Start 1");
		String two = File.separator + "src" + File.separator + "test" + File.separator + "java" +File.separator + "Test_Data"+
		             File.separator + "BD.xlsx";
		System.out.println("Start 2");
		String location = one+File.separator+two;
		System.out.println("Start 3");
		
		XSSFWorkbook File = new XSSFWorkbook(location);
		System.out.println("Start 4");
		XSSFSheet page = File.getSheet("Sheet1");
		System.out.println("Start 5");
		int row_count = page.getLastRowNum();
		int col_count = page.getRow(0).getLastCellNum();
		
		System.out.println("total row " +row_count);
		System.out.println("total col " + col_count);
		
		String Final_data [][]  = new String [row_count][col_count];
		
		for(int i =1 ; i<=row_count; i++)
		{
			for (int j =0 ; j<col_count ; j++)
			{
				DataFormatter df = new DataFormatter();
				Final_data [i-1][j] = df.formatCellValue(page.getRow(i).getCell(j));
				
				System.out.println(i);
				System.out.println(j);
				System.out.println(Final_data [i-1][j]);
				
			}
			
		}
		
		
		System.out.println(Arrays.toString(Final_data));
				
		return Final_data;
		
	}
}
