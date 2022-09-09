package com.ebanking.master;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static void main(String[] args) throws IOException, InterruptedException
	{
		
		//Instance Class
		
		Library LB=new Library();
		
		LB.OpenApp("http://103.211.39.246/ranford2");
		LB.AdminLgn("Admin","Mq$ystems@");
		
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
			
			String Res=LB.Role(Rname,Rty);
	         WC2.setCellValue(Res);		
			
		}
	
		//Results
		
		FileOutputStream FOS=new FileOutputStream("D:\\EvngAug\\Ebanking\\src\\com\\ebanking\\results\\Res_Role.xlsx");
		WB.write(FOS);
		WB.close();
		
		
	}
	}