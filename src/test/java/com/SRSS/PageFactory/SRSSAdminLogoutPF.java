package com.SRSS.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SRSSAdminLogoutPF 
{
	@FindBy(xpath="//table[@id='Table_02']//tr/td[3]/a")
	private WebElement logoutButton;
	
	@FindBy(xpath="//table[@id='Table_01']//tr/td[1]/a")
	private WebElement adminHomePage;
		
	public WebElement getLogoutButton() 
	{
		return logoutButton;
	}

	public WebElement getAdminHomePage() 
	{
		return adminHomePage;
	}		
}
