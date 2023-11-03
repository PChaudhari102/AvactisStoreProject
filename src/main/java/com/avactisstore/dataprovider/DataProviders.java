package com.avactisstore.dataprovider;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import com.avactisstore.utility.ExcelDemo;

public class DataProviders {
		//NewExcelLibrary obj = new NewExcelLibrary();
		//ExcelDemo obj1 = new ExcelDemo();

	//Class --> LoginPageTest,HomePageTest Test Case--> loginTest, wishListTest, orderHistoryandDetailsTest
		
		@DataProvider(name="RegistrationData")
		public String [][] getData() throws IOException 
		{
			//get the data from excel
			String path= System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\AvactisTestData.xlsx";
			ExcelDemo obj1=new ExcelDemo(path);
			
			int totalrows=obj1.getRowCount("RegisterData");
			int totalcols=obj1.getCellCount("RegisterData",1);	
					
			String loginData[][]=new String[totalrows][totalcols];
				
			
			for(int i=1;i<=totalrows;i++) //1
			{
				for(int j=0;j<totalcols;j++) //0
				{
					loginData[i-1][j]=obj1.getCellData("RegisterData", i, j);
				}
					
			}
			
			return loginData;
		}
		
		@DataProvider(name="ProductData1")
		public String [][] getData1() throws IOException 
		{
			//get the data from excel
			String path= System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\AvactisTestData.xlsx";
			ExcelDemo obj1=new ExcelDemo(path);
			
			int totalrows=obj1.getRowCount("ProductData");
			int totalcols=obj1.getCellCount("ProductData",1);	
					
			String productData[][]=new String[totalrows][totalcols];
				
			
			for(int i=1;i<=totalrows;i++) //1
			{
				for(int j=0;j<totalcols;j++) //0
				{
					productData[i-1][j]=obj1.getCellData("ProductData", i, j);
				}
					
			}
			
			return productData;
		}
		
	}

