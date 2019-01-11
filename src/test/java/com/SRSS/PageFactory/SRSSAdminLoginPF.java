package com.SRSS.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SRSSAdminLoginPF 
{
	@FindBy(id="txtuId")
	private WebElement usernameTextbox;
	
	@FindBy(name="txtPword")
	private WebElement pwdTextbox;
	
	@FindBy(id="login")
	private WebElement loginButton;

	public WebElement getUsernameTextbox() 
	{
		return usernameTextbox;
	}

	public WebElement getPwdTextbox() 
	{
		return pwdTextbox;
	}
	
	public WebElement getLoginButton() 
	{
		return loginButton;
	}
}
