package com.SRSS.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SRSSBranchCreationPF 
{
	@FindBy(xpath="//table[@id='Table_01']//tr[2]//tbody/tr[2]//a")
	private WebElement branchDetailsPage;
	
	@FindBy(id="BtnNewBR")
	private WebElement newBranch;
	
	@FindBy(name="txtbName")
	private WebElement branchName;
	
	@FindBy(id="txtAdd1")
	private WebElement address1;
	
	@FindBy(id="Txtadd2")
	private WebElement address2;
	
	@FindBy(name="txtadd3")
	private WebElement address3;
	
	@FindBy(id="txtArea")
	private WebElement area;
	
	@FindBy(id="txtZip")
	private WebElement zipCode;
	
	@FindBy(id="lst_counrtyU")
	private WebElement country;
	
	@FindBy(name="lst_stateI")
	private WebElement state;
	
	@FindBy(id="lst_cityI")
	private WebElement city;
	
	@FindBy(id="btn_insert")
	private WebElement insertBranch;
	
	@FindBy(name="Btn_Reset")
	private WebElement resetBranch;
	
	@FindBy(id="Btn_cancel")
	private WebElement cancelBranch;	
		
	public WebElement getBranchDetailsPage() 
	{
		return branchDetailsPage;
	}

	public WebElement getNewBranch() 
	{
		return newBranch;
	}

	public WebElement getBranchName() 
	{
		return branchName;
	}

	public WebElement getAddress1() 
	{
		return address1;
	}

	public WebElement getAddress2()
	{
		return address2;
	}

	public WebElement getAddress3() 
	{
		return address3;
	}

	public WebElement getArea() 
	{
		return area;
	}

	public WebElement getZipCode() 
	{
		return zipCode;
	}

	public WebElement getCountry() 
	{
		return country;
	}

	public WebElement getState() 
	{
		return state;
	}

	public WebElement getCity() 
	{
		return city;
	}

	public WebElement getInsertBranch() 
	{
		return insertBranch;
	}

	public WebElement getResetBranch()
	{
		return resetBranch;
	}

	public WebElement getCancelBranch() 
	{
		return cancelBranch;
	}	
}
