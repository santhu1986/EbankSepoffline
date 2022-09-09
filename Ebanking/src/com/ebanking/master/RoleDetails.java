package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoleDetails 
{

	@FindBy(xpath="/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")
	WebElement Home;
	
	@FindBy(xpath="//*[@id=\"btnRoles\"]")
	WebElement Nrole;
	
	
	public void Rhome()
	{
		Home.click();
	}
	
	public void NewRol()
	{
		Nrole.click();
	}
	
}
