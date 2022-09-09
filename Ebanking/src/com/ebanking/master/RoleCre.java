package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RoleCre 
{

	@FindBy(id="txtRname")
	WebElement Rname;
	
	@FindBy(id="lstRtypeN")
	WebElement Rty;
	
	@FindBy(id="btninsert")
	WebElement Rsubmit;
	
	public void Rcreation(String Rn,String Rt) throws InterruptedException
	{
		Rname.sendKeys(Rn);
		Select RT=new Select(Rty);
		RT.selectByVisibleText(Rt);
		Thread.sleep(3000);
		Rsubmit.click();
		
     }
}
