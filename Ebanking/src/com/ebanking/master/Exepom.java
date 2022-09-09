package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exepom 
{
	
	WebDriver driver;
	
     @BeforeTest
	public void Login() throws InterruptedException
	{
	    driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://103.211.39.246/ranford2");
		
		//Login
		
		RanfordHP RHP=PageFactory.initElements(driver,RanfordHP.class);
		RHP.login();
		
	}
     @Test
     public void Rcrea() throws InterruptedException, IOException
     {
    	 
    	//To Get Test Data File
 		
 		FileInputStream FIS=new FileInputStream("D:\\EvngAug\\Ebanking\\src\\com\\ebanking\\testdata\\Role.xlsx");
 	
 	    //WorkBook
 				
 				XSSFWorkbook WB=new XSSFWorkbook(FIS);
 		
 		   //Sheet
 		
 		XSSFSheet WS=WB.getSheet("Rdata");
 		
 		//Row Count
 		
 		int Rcount=WS.getLastRowNum();
 		
 		//Multiple Iterations ---- Loop
 		
 		for (int i=1;i<=Rcount;i++)
 		{
 		      //Rows
 			
 			XSSFRow WR=WS.getRow(i);
 			
 			//Cell
 			
 			XSSFCell WC=WR.getCell(0);
 			XSSFCell WC1=WR.getCell(1);
 			
 			XSSFCell WC2=WR.createCell(2);
 			
 			//Cell Values
 			
 			String Rname=WC.getStringCellValue();
 			String Rty=WC1.getStringCellValue();
 	
		Thread.sleep(3000);
		
		//Role
		
		AdminHP AHP=PageFactory.initElements(driver,AdminHP.class);
		AHP.Rol();
		Thread.sleep(3000);
		//New Role
		
		RoleDetails RD=PageFactory.initElements(driver,RoleDetails.class);
		RD.NewRol();
		
		//Role Creation
		
		RoleCre RC=PageFactory.initElements(driver,RoleCre.class);
		RC.Rcreation(Rname,Rty);
		Thread.sleep(3000);
		//Alert
		
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
	     //Home
		
		RD.Rhome();
	
	}
     }  
     @DataProvider
     
     public Object [][] Rdata()
     {
     	Object[][] Obj=new Object[3][2];
     	
     	Obj[0][0]="CashierBom";
     	Obj[0][1]="E";
     	
     	Obj[1][0]="TellerBom";
     	Obj[1][1]="E";
     	
     	Obj[2][0]="ManagerBom";
     	Obj[2][1]="E";
     	
     	return Obj;
     }
     
}
