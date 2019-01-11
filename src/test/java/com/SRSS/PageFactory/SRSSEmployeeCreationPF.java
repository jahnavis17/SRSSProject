package com.SRSS.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SRSSEmployeeCreationPF 
{
	@FindBy(xpath="//table[@id='Table_01']//tr[2]//tbody/tr[8]//a")
	private WebElement employeeDetailsPage;
	
	@FindBy(id="BtnNew")
	private WebElement newEmployee;
	
	@FindBy(id="txtUname")
	private WebElement employeeName;
	
	@FindBy(id="txtLpwd")
	private WebElement loginPassword;
	
	@FindBy(id="lst_Roles")
	private WebElement roles;
	
	@FindBy(id="lst_Branch")
	private WebElement branches;
	
	@FindBy(id="BtnSubmit")
	private WebElement insertemployee;
	
	@FindBy(id="btnreset")
	private WebElement resetEmployee;
	
	@FindBy(id="btnCancel")
	private WebElement cancelEmployee;

	public WebElement getEmployeeDetailsPage() 
	{
		return employeeDetailsPage;
	}

	public WebElement getNewEmployee() 
	{
		return newEmployee;
	}

	public WebElement getEmployeeName() 
	{
		return employeeName;
	}

	public WebElement getLoginPassword() 
	{
		return loginPassword;
	}

	public WebElement getRoles()
	{
		return roles;
	}

	public WebElement getBranches()
	{
		return branches;
	}

	public WebElement getInsertemployee() 
	{
		return insertemployee;
	}

	public WebElement getResetEmployee() 
	{
		return resetEmployee;
	}

	public WebElement getCancelEmployee() 
	{
		return cancelEmployee;
	}	
}
