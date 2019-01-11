package com.SRSS.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SRSSRoleCreationPF 
{
	@FindBy(xpath="//table[@id='Table_01']//tr[2]//tbody/tr[4]//a")
	private WebElement roleDetailsPage;
	
	@FindBy(id="btnRoles")
	private WebElement newRole;
	
	@FindBy(id="txtRname")
	private WebElement roleName;
	
	@FindBy(id="txtRDesc")
	private WebElement roleDesc;
	
	@FindBy(id="lstRtypeN")
	private WebElement roleType;
	
	@FindBy(id="btninsert")
	private WebElement insertRole;
	
	@FindBy(id="Btn_Reset")
	private WebElement resetRole;
	
	@FindBy(id="Btn_cancel")
	private WebElement cancelRole;

	public WebElement getRoleDetailsPage() 
	{
		return roleDetailsPage;
	}

	public WebElement getNewRole() 
	{
		return newRole;
	}

	public WebElement getRoleName() 
	{
		return roleName;
	}

	public WebElement getRoleDesc() 
	{
		return roleDesc;
	}

	public WebElement getRoleType() 
	{
		return roleType;
	}

	public WebElement getInsertRole() 
	{
		return insertRole;
	}

	public WebElement getResetRole() 
	{
		return resetRole;
	}

	public WebElement getCancelRole() 
	{
		return cancelRole;
	}
}
