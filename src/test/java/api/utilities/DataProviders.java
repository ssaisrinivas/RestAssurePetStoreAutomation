package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="UserData")
	public String[][] getAllPetData() throws IOException{
		
		String path = System.getProperty("user.dir")+"//TestData.xlsx";
		XLUtility xl = new XLUtility(path);
		
		int rownum=xl.getRowCount("AccountCreationData");
		int colcount= xl.getCellCount("AccountCreationData",1);
		String apidata[][]= new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			
			for(int j=0;j<colcount;j++) {
				
				apidata[i-1][j]=xl.getCellData("AccountCreationData", i, j);
				System.out.println(apidata[i-1][j]);
			}
		}			
		
		return apidata;		
	}
	
	@DataProvider(name="UserName")
	public String[] getUserNames() throws IOException{
		
		String path = System.getProperty("user.dir")+"//TestData.xlsx";
		XLUtility xl = new XLUtility(path);
		
		int rownum=xl.getRowCount("AccountCreationData");
		
		String apidata[]= new String[rownum];
		
		for(int i=1;i<=rownum;i++) {
			
				
				apidata[i-1]=xl.getCellData("AccountCreationData", i, 1);			
		}	
		
		return apidata;		
	}
		
	@DataProvider(name="PetData")
	public String[][] getAllData() throws IOException{
		
		String path = System.getProperty("user.dir")+"//TestData.xlsx";
		XLUtility xl = new XLUtility(path);
		
		int rownum=xl.getRowCount("PetDetails");
		int colcount= xl.getCellCount("PetDetails",1);
		String apidata[][]= new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			
			for(int j=0;j<colcount;j++) {
				
				apidata[i-1][j]=xl.getCellData("PetDetails", i, j);
				System.out.println(apidata[i-1][j]);
			}
		}	
		
		
		
		return apidata;		
	}
	
	@DataProvider(name="PetId")
	public String[] getPetIds() throws IOException{
		
		String path = System.getProperty("user.dir")+"//TestData.xlsx";
		XLUtility xl = new XLUtility(path);
		
		int rownum=xl.getRowCount("PetDetails");
		
		String apidata[]= new String[rownum];
		
		for(int i=1;i<=rownum;i++) {
			
				
				apidata[i-1]=xl.getCellData("PetDetails", i, 0);			
		}	
		
		return apidata;		
	}

}
