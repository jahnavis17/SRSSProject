package com.SRSS;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.LogManager;

import com.google.common.base.Verify;

import com.SRSS.PageFactory.SRSSAdminLoginPF;
import com.SRSS.PageFactory.SRSSAdminLogoutPF;
import com.SRSS.PageFactory.SRSSBranchCreationPF;
import com.SRSS.PageFactory.SRSSEmployeeCreationPF;
import com.SRSS.PageFactory.SRSSRoleCreationPF;

public class SRSSTestNGTest
{
	WebDriver wd = new FirefoxDriver();
	public static final Logger log = LogManager.getLogger(SRSSTestNGTest.class);   
	
	//File f = null;
	//FileWriter fw = null;
	//BufferedWriter bw = null;
	//FileInputStream fis = null;
	//Properties p = null;
	SRSSAdminLoginPF loginPF = PageFactory.initElements(wd, SRSSAdminLoginPF.class);
	SRSSAdminLogoutPF logoutPF = PageFactory.initElements(wd, SRSSAdminLogoutPF.class);
	SRSSBranchCreationPF branchCreationPF = PageFactory.initElements(wd, SRSSBranchCreationPF.class);
	SRSSRoleCreationPF roleCreationPF = PageFactory.initElements(wd, SRSSRoleCreationPF.class);
	SRSSEmployeeCreationPF employeeCreationPF = PageFactory.initElements(wd, SRSSEmployeeCreationPF.class);

	@BeforeClass
	public void SRSSAppOpen() throws IOException
	{	
		//f = new File("C:/Users/Hari/Desktop/Selenium/SRSSProj/src/Pack1/SRSSAdmin.txt");
		//f.createNewFile();
		//fw = new FileWriter("C:/Users/Hari/Desktop/Selenium/SRSSProj/src/Pack1/SRSSAdmin.txt", true);
		//bw = new BufferedWriter(fw);
		//System.out.println("With Gekco Firefox Driver:");
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hari\\Desktop\\Cucumber_Selenium\\Gekco_Driver\\geckodriver.exe");				
		/*System.setProperty("webdriver.ie.driver", "C:\\Users\\Hari\\Desktop\\Drivers\\IEDriverServer.exe");
        wd = new InternetExplorerDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hari\\Desktop\\Drivers\\chromedriver.exe");
        wd = new ChromeDriver();*/
		//fis = new FileInputStream("C:/Users/Hari/Desktop/Selenium/SRSSProj/src/Pack1/OR_SRSS");
		//p = new Properties();
		//p.load(fis);
		//log = Logger.getLogger("rootLogger");
		//DOMConfigurator.configure("./src/test/java/resources/log4j2.xml");
	    wd.get("http:srssprojects.in");
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		//Comments Added
		log.info("SRSS Application Opened from TestNG");
		//System.out.println("SRSS Application Opened from TestNG");
		//bw.write("SRSS Application Opened from TestNG\n");
		//bw.flush();
		//Comments Added
		loginPF.getUsernameTextbox().sendKeys("Admin");
		loginPF.getPwdTextbox().sendKeys("Admin");
		wd.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);	
		loginPF.getLoginButton().click();
		/*wd.findElement(By.xpath(p.getProperty("Admin_UN"))).sendKeys("Admin");		  
		wd.findElement(By.xpath(p.getProperty("Admin_PW"))).sendKeys("Admin"); 
		wd.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);		
		wd.findElement(By.xpath(p.getProperty("Admin_Login"))).click();  */	    
		try
		{		
			//wd.findElement(By.xpath("html/body/table"));
			logoutPF.getAdminHomePage();
			log.info("Admin Home Page is Displayed");
			//System.out.println("Admin Home Page is Displayed");    	
			//bw.write("Admin Home Page is Displayed\n");
			//bw.flush();	// Data which is in buffer is permanently committed to a file.		    		
		}
		catch(Throwable e)
		{		
			log.info("InCorrect Banker Name/Password");
			//System.out.println("InCorrect Banker Name/Password");
			//bw.write("InCorrect Banker Name/Password\n");
			//bw.flush();	// Data which is in buffer is permanently committed to a file. 
		}			    
		wd.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
	}

	@AfterClass
	public void SRSSAppClose() throws IOException
	{
		logoutPF.getLogoutButton().click(); 
		log.info("Successfully Logged-Out from AHP");
		//System.out.println("Successfully Logged-Out from AHP");
		//bw.write("Successfully Logged-Out from AHP\n");
		wd.quit();
		log.info("SRSS Application Closed from TestNG");
		//System.out.println("SRSS Application Closed from TestNG");
		//bw.write("SRSS Application Closed from TestNG\n");
		//bw.flush();
	}

	/*@BeforeMethod (enabled = true)
	public void loginToAdmin() throws Exception 
	{

	}*/

	@AfterMethod (enabled = true)
	public void AHP() throws IOException
	{    	
		logoutPF.getAdminHomePage().click();
	}   

	@DataProvider
	public Object[][] supplyDataBranchCreation() throws InvalidFormatException, IOException
	{
		Object data[][] = new Object[2][9];
		InputStream f = new FileInputStream("C:\\Users\\Hari\\Desktop\\BranchCreation.xlsx"); // Get a workbook by using InputStream
		Workbook wb = WorkbookFactory.create(f); //Load the workbook into a buffer
		Sheet s = wb.getSheetAt(0); //Get a sheet from workbook
		int rowCount = s.getLastRowNum(); // Get LastRow No from a sheet	      
		for(int i=0;i<rowCount;i++) //For getting all the rows from a sheet
		{
			Row r = s.getRow(i+1); //Get a row from a sheet( Here, We are getting from 2nd Row, ignoring headings(1st Row)
			int cellCount = r.getLastCellNum(); //Get LastCell No from a Row	      
			for(int j=0;j<cellCount;j++) //For getting all the cells from a row
			{    
				Cell c = r.getCell(j); //Get a cell from a row
				if(c.getCellType() == c.CELL_TYPE_STRING)
				{
					data[i][j] = c.getStringCellValue(); //Get a string value from a cell	     
				}
				else if(c.getCellType() == c.CELL_TYPE_NUMERIC)
				{
					data[i][j] = c.getNumericCellValue(); //Get a integer value from a cell 	      
				}	      
			}
		}	      
		return data;	     
	}

	@Test(dataProvider = "supplyDataBranchCreation")
	public void branchCreation(String BranchName, String address1, String address2, String address3, String area, double ZipCode, String country, String state, String city) throws IOException, InterruptedException
	{  	
		branchCreationPF.getBranchDetailsPage().click();	
		branchCreationPF.getNewBranch().click();
		branchCreationPF.getBranchName().sendKeys(BranchName);
		branchCreationPF.getAddress1().sendKeys(address1);
		branchCreationPF.getAddress2().sendKeys(address2);  
		branchCreationPF.getAddress3().sendKeys(address3);
		branchCreationPF.getArea().sendKeys(area);
		branchCreationPF.getZipCode().sendKeys(String.valueOf(ZipCode));	
		Select dropdown = new Select(branchCreationPF.getCountry());
		//int Country = (int) country;    
		dropdown.selectByVisibleText(country);
		//dropdown.selectByIndex(Country);      
		dropdown = new Select(branchCreationPF.getState());
		//int State = (int) state;
		//dropdown.selectByIndex(State);
		dropdown.selectByVisibleText(state);
		dropdown = new Select(branchCreationPF.getCity());
		//int City = (int) city;
		//dropdown.selectByIndex(City);   
		dropdown.selectByVisibleText(city);
		branchCreationPF.getInsertBranch().click();
		Alert a = wd.switchTo().alert();
		boolean x = a.getText().contains("created Sucessfully");
		if(x == true)
		{
			log.info("New Branch is Created Successfully");
			//System.out.println("New Branch is Created Successfully");
			//bw.write("New Branch is Created Successfully\n");
			//bw.flush();	// Data which is in buffer is permanently committed to a file.	
		}
		else
		{
			log.info("New Branch is not Created/Already Exists");
			//System.out.println("New Branch is not Created/Already Exists");
			//bw.write("New Branch is not Created/Already Exists\n");
			//bw.flush();	// Data which is in buffer is permanently committed to a file.		
		}
		a.accept(); 
		wd.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);      
	} 

	@Test(dataProvider = "supplyDataBranchCreation")
	public void branchReset(String BranchName, String address1, String address2, String address3, String area, double ZipCode, String country, String state, String city) throws IOException, InterruptedException
	{ 	   
		//Reset the Data
		branchCreationPF.getBranchDetailsPage().click();	
		branchCreationPF.getNewBranch().click();
		branchCreationPF.getBranchName().sendKeys(BranchName);
		branchCreationPF.getAddress1().sendKeys(address1);
		branchCreationPF.getAddress2().sendKeys(address2);  
		branchCreationPF.getAddress3().sendKeys(address3);
		branchCreationPF.getArea().sendKeys(area);
		branchCreationPF.getZipCode().sendKeys(String.valueOf(ZipCode));	
		Select dropdown = new Select(branchCreationPF.getCountry());   
		dropdown.selectByVisibleText(country);      
		dropdown = new Select(branchCreationPF.getState());
		dropdown.selectByVisibleText(state);
		dropdown = new Select(branchCreationPF.getCity()); 
		dropdown.selectByVisibleText(city);
		Thread.sleep(1000l);
		branchCreationPF.getResetBranch().click();

		//After Resetting the Data
		String bName = branchCreationPF.getBranchName().getAttribute("value");
		String add1 = branchCreationPF.getAddress1().getAttribute("value");
		String add2 = branchCreationPF.getAddress2().getAttribute("value");
		String add3 = branchCreationPF.getAddress3().getAttribute("value");
		String Area = branchCreationPF.getArea().getAttribute("value");
		String zipCode = branchCreationPF.getZipCode().getAttribute("value");
		Select selectItem = new Select(branchCreationPF.getCountry());	
		String Country = selectItem.getFirstSelectedOption().getAttribute("value");	
		selectItem = new Select(branchCreationPF.getState());	
		String State = selectItem.getFirstSelectedOption().getAttribute("value");
		selectItem = new Select(branchCreationPF.getCity());	
		String City = selectItem.getFirstSelectedOption().getAttribute("value");		
		if(bName.isEmpty() == true  && add1.isEmpty() == true && add2.isEmpty() == true && add3.isEmpty() == true && Area.isEmpty() == true && zipCode.isEmpty() == true && Country.equals("Select") && State.equals("Select") && City.equals("Select"))
		{
			log.info("Field values in NBCP is cleared");
			//System.out.println("Field values in NBCP is cleared");
			//bw.write("Field values in NBCP is cleared\n");
			//bw.flush();
		}	
		else
		{
			log.info("Field values in NBCP is not cleared");
			//System.out.println("Field values in NBCP is not cleared");
			//bw.write("Field values in NBCP is not cleared\n");
			//System.out.println("After Reset the Data in NBCP, Field values are: (BName: "+bName+", Add1: "+add1+", Add2: "+add2+", Add3: "+add3+", Area: "+Area+", ZipCode: "+zipCode+", Country: "+Country+", State: "+State+", City: "+City+")");
			//bw.write("After Reset the Data in NBCP, Field values are: (BName: "+bName+", Add1: "+add1+", Add2: "+add2+", Add3: "+add3+", Area: "+Area+", ZipCode: "+zipCode+", Country: "+Country+", State: "+State+", City: "+City+")\n");
			//bw.flush();
		}
		Thread.sleep(1000l);

		//Closing the Page
		branchCreationPF.getCancelBranch().click();
		Thread.sleep(1000l);
	}

	@DataProvider
	public Object[][] supplyDataRoleCreation() throws InvalidFormatException, IOException
	{
		Object data[][] = new Object[2][3];
		InputStream f = new FileInputStream("C:\\Users\\Hari\\Desktop\\RoleCreation.xlsx"); // Get a workbook by using InputStream
		Workbook wb = WorkbookFactory.create(f); //Load the workbook into a buffer
		Sheet s = wb.getSheetAt(0); //Get a sheet from workbook
		int rowCount = s.getLastRowNum(); // Get LastRow No from a sheet	      
		for(int i=0;i<rowCount;i++) //For getting all the rows from a sheet
		{
			Row r = s.getRow(i+1); //Get a row from a sheet( Here, We are getting from 2nd Row, ignoring headings(1st Row)
			int cellCount = r.getLastCellNum(); //Get LastCell No from a Row	      
			for(int j=0;j<cellCount;j++) //For getting all the cells from a row
			{    
				Cell c = r.getCell(j); //Get a cell from a row
				if(c.getCellType() == c.CELL_TYPE_STRING)
				{
					data[i][j] = c.getStringCellValue(); //Get a string value from a cell
				}
				else if(c.getCellType() == c.CELL_TYPE_NUMERIC)
				{
					data[i][j] = c.getNumericCellValue(); //Get a integer value from a cell 
				}	      
			}
		}  
		return data;
	}

	@Test(dataProvider = "supplyDataRoleCreation")
	public void roleCreation(String roleName, String roleDesc, String roleType) throws IOException, InterruptedException
	{     
		roleCreationPF.getRoleDetailsPage().click();
		roleCreationPF.getNewRole().click();
		roleCreationPF.getRoleName().sendKeys(roleName);
		roleCreationPF.getRoleDesc().sendKeys(roleDesc); 
		Select rolType = new Select(roleCreationPF.getRoleType());
		rolType.selectByVisibleText(roleType);
		//wd.findElement(By.xpath("NRCP_RT")).sendKeys(roleType); 
		roleCreationPF.getInsertRole().click();
		Alert a = wd.switchTo().alert();
		boolean x = a.getText().contains("Created Sucessfully");
		if(x == true)
		{
			log.info("New Role is Created Successfully");
			//System.out.println("New Role is Created Successfully: " + roleName+" : "+roleDesc+" : "+roleType);
			//bw.write("New Role is Created Successfully: " + roleName+" : "+roleDesc+" : "+roleType+"\n");
			//bw.flush();	// Data which is in buffer is permanently committed to a file.	
		}
		else
		{
			log.info("New Role is not Created/Already Exists");
			//System.out.println("New Role is not Created/Already Exists: " + roleName+" : "+roleDesc+" : "+roleType); // If we want to print which data we have passed
			//bw.write("New Role is not Created/Already Exists: " + roleName+" : "+roleDesc+" : "+roleType+"\n");
			//bw.flush();	// Data which is in buffer is permanently committed to a file.		
		}
		a.accept();
		wd.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS); 
	} 

	@Test(dataProvider = "supplyDataRoleCreation")
	public void roleReset(String roleName, String roleDesc, String roleType) throws IOException, InterruptedException
	{     
		//Reset the Data
		roleCreationPF.getRoleDetailsPage().click();
		roleCreationPF.getNewRole().click();
		roleCreationPF.getRoleName().sendKeys(roleName);
		roleCreationPF.getRoleDesc().sendKeys(roleDesc); 
		Select rolType = new Select(roleCreationPF.getRoleType());
		rolType.selectByVisibleText(roleType);
		roleCreationPF.getResetRole().click();

		//After Resetting the Data
		String rName = roleCreationPF.getRoleName().getAttribute("value");
		String rDesc = roleCreationPF.getRoleDesc().getAttribute("value");
		Select selectItem = new Select(roleCreationPF.getRoleType());	
		String rType = selectItem.getFirstSelectedOption().getAttribute("value");		
		if(rName.isEmpty() == true && rDesc.isEmpty() == true && rType.equals("Select"))
		{
			log.info("Field values in NRCP is cleared");
            //System.out.println("Field values in NRCP is cleared");
			//bw.write("Field values in NRCP is cleared\n");
			//bw.flush();
		}
		else
		{
			log.info("Field values in NRCP is not cleared");
			//System.out.println("Field values in NRCP is not cleared");
			//bw.write("Field values in NRCP is not cleared\n");
			log.info("After Reset the Data in NRCP, Field values are: (RName: "+rName+", RDesc: "+rDesc+", RType: "+rType+")");
			//System.out.println("After Reset the Data in NRCP, Field values are: (RName: "+rName+", RDesc: "+rDesc+", RType: "+rType+")");
			//bw.write("After Reset the Data in NRCP, Field values are: (RName: "+rName+", RDesc: "+rDesc+", RType: "+rType+")\n");
			//bw.flush();
		}
		Thread.sleep(1000l);

		//Closing the Page
		roleCreationPF.getCancelRole().click();
		Thread.sleep(1000l);
	}

	@DataProvider
	public Object[][] supplyDataEmployeeCreation() throws InvalidFormatException, IOException
	{
		Object data[][] = new Object[2][4];
		InputStream f = new FileInputStream("C:\\Users\\Hari\\Desktop\\EmployeeCreation.xlsx"); // Get a workbook by using InputStream
		Workbook wb = WorkbookFactory.create(f); //Load the workbook into a buffer
		Sheet s = wb.getSheetAt(0); //Get a sheet from workbook
		int rowCount = s.getLastRowNum(); // Get LastRow No from a sheet	      
		for(int i=0;i<rowCount;i++) //For getting all the rows from a sheet
		{
			Row r = s.getRow(i+1); //Get a row from a sheet( Here, We are getting from 2nd Row, ignoring headings(1st Row)
			int cellCount = r.getLastCellNum(); //Get LastCell No from a Row	      
			for(int j=0;j<cellCount;j++) //For getting all the cells from a row
			{    
				Cell c = r.getCell(j); //Get a cell from a row
				if(c.getCellType() == c.CELL_TYPE_STRING)
				{
					data[i][j] = c.getStringCellValue(); //Get a string value from a cell	     
				}
				else if(c.getCellType() == c.CELL_TYPE_NUMERIC)
				{
					data[i][j] = c.getNumericCellValue(); //Get a integer value from a cell 	      
				}	      
			}
		}	      
		return data;	     
	}

	@Test(dataProvider = "supplyDataEmployeeCreation")
	public void employeeCreation(String employerName, String loginPassword, double role, double branch) throws IOException, InterruptedException
	{  	
		employeeCreationPF.getEmployeeDetailsPage().click();	
		employeeCreationPF.getNewEmployee().click();
		employeeCreationPF.getEmployeeName().sendKeys(employerName);
		employeeCreationPF.getLoginPassword().sendKeys(loginPassword);    	
		Select dropdown = new Select(employeeCreationPF.getRoles());
		int Role = (int) role;
		dropdown.selectByIndex(Role);      
		dropdown = new Select(employeeCreationPF.getBranches());
		int Branch = (int) branch;
		dropdown.selectByIndex(Branch);
		employeeCreationPF.getInsertemployee().click();
		Alert a = wd.switchTo().alert();
		boolean x = a.getText().contains("Successfully");
		if(x == true)
		{		
			log.info("New Employee is Created Successfully");
			//System.out.println("New Employee is Created Successfully");
			//bw.write("New Employee is Created Successfully\n");
			//bw.flush();	// Data which is in buffer is permanently committed to a file.	
		}
		else
		{
			log.info("New Employee is not Created/Already Exists");
			//System.out.println("New Employee is not Created/Already Exists");
			//bw.write("New Employee is not Created/Already Exists\n");
			//bw.flush();	// Data which is in buffer is permanently committed to a file.	
			//throw new Error("New Employee is not Created Successfully"); // If we use this, if error occurs in 1st row of execution then it will skips the remaining execution until it resolves.
		}
		//Assert.assertEquals(true, x); // If we use this stmt instead of if,else if there is any error it will skip remaining execution until it resolves.
		a.accept(); 
		wd.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);		
	} 

	@Test(dataProvider = "supplyDataEmployeeCreation")
	public void employeeReset(String employerName, String loginPassword, double role, double branch) throws IOException, InterruptedException
	{      
		//Reset the Data
		employeeCreationPF.getEmployeeDetailsPage().click();	
		employeeCreationPF.getNewEmployee().click();
		employeeCreationPF.getEmployeeName().sendKeys(employerName);
		employeeCreationPF.getLoginPassword().sendKeys(loginPassword);    	
		Select dropdown = new Select(employeeCreationPF.getRoles());
		int Role = (int) role;
		dropdown.selectByIndex(Role);      
		dropdown = new Select(employeeCreationPF.getBranches());
		int Branch = (int) branch;
		dropdown.selectByIndex(Branch);
		employeeCreationPF.getResetEmployee().click();

		//After Resetting the Data
		String EmployerName = employeeCreationPF.getEmployeeName().getAttribute("value");
		String LoginPwd = employeeCreationPF.getLoginPassword().getAttribute("value");
		Select selectItem = new Select(employeeCreationPF.getRoles());	
		String roles = selectItem.getFirstSelectedOption().getAttribute("value");
		selectItem = new Select(employeeCreationPF.getBranches());	
		String branches = selectItem.getFirstSelectedOption().getAttribute("value");	
		if(EmployerName.isEmpty() == true && LoginPwd.isEmpty() == true && roles.equals("0") && branches.equals("0"))
		{
			log.info("Field values in NECP is cleared");
			//System.out.println("Field values in NECP is cleared");
			//bw.write("Field values in NECP is cleared\n");
			//bw.flush();
		}
		else
		{
			log.info("Field values in NECP is not cleared");
			//System.out.println("Field values in NECP is not cleared");
			//bw.write("Field values in NECP is not cleared\n");
			log.info("After Reset the Data in NECP, Field values are: (EmployerName: "+EmployerName+", LoginPwd: "+LoginPwd+", Roles: "+roles+", Branches: "+branches+")");
			//System.out.println("After Reset the Data in NECP, Field values are: (EmployerName: "+EmployerName+", LoginPwd: "+LoginPwd+", Roles: "+roles+", Branches: "+branches+")");
			//bw.write("After Reset the Data in NECP, Field values are: (EmployerName: "+EmployerName+", LoginPwd: "+LoginPwd+", Roles: "+roles+", Branches: "+branches+")\n");
			//bw.flush();
		}
		Thread.sleep(1000l);

		//Closing the Page
		employeeCreationPF.getCancelEmployee().click();
		Thread.sleep(1000l);
	}
}
