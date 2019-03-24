package com.training.jan;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class HomePage1 {

	static ExtentReports report;
	static ExtentTest logger;

	public static void main(String[] args) throws InterruptedException {
		String path = "C:\\Data\\Reports\\Report2.html";
		report = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);

		//initialize logger
		logger = report.startTest("Homepage");

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver.get("https://selenium-prd.firebaseapp.com/");
		System.out.println("Application launched Successfully");
		logger.log(LogStatus.INFO, "Application launched Successfully");
		Thread.sleep(5000);

		//Enter the UserName
		WebElement emailUserName = driver.findElement(By.id("email_field"));
		emailUserName.clear();
		emailUserName.sendKeys("admin123@gmail.com");
		System.out.println("UserName is entered Successfully");
		logger.log(LogStatus.PASS, "UserName is entered Successfully");
		//Enter the Password
		WebElement password = driver.findElement(By.id("password_field"));
		password.clear();
		password.sendKeys("admin123");
		System.out.println("Password is entered Successfully");
		//Click on Login Button
		WebElement login = driver.findElement(By.xpath("//button[@onclick='login()']"));
		login.click();
		System.out.println("Login button is clicked Successfully");
		//Click on the Home Button
		Thread.sleep(5000);
		WebElement HomeTab = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		HomeTab.click();
		System.out.println("Home tab is clicked Successfully");
		// Enter the Name 
		WebElement Name = driver.findElement(By.xpath("//input[@id='name']"));
		Name.clear();
		Name.sendKeys("Divya");
		System.out.println("Name entered successfully");
		//Enter the Father Name
		WebElement fatherName = driver.findElement(By.xpath("//input[@id='lname']"));
		fatherName.clear();
		fatherName.sendKeys("Krishnam raju");
		System.out.println("FatherName entered successfully");
		//Enter Postal Address
		WebElement postalAddress = driver.findElement(By.id("postaladdress"));
		postalAddress.clear();
		postalAddress.sendKeys("534202");
		System.out.println("Postal address entered");
		//Enter Personal Address
		WebElement personalAddress = driver.findElement(By.id("personaladdress"));
		personalAddress.clear();
		personalAddress.sendKeys("Bhimavaram");
		System.out.println("Personal address entered");
		//Click gender
		WebElement GenderFemale = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/form[1]/div[5]/span[2]/input[1]"));
		GenderFemale.click();
		System.out.println("Gender  radio button selected");
		//Select the City from dropdown
		Select City = new Select(driver.findElement(By.name("city")));
		City.selectByVisibleText("GOA");
		System.out.println("City selected from dropdown");
		//Select course from dropdown
		Select Course = new Select(driver.findElement(By.name("course")));
		Course.selectByValue("mba");
		System.out.println("Course selected from dropdown");
		//Select district from dropdown
		Select District = new Select(driver.findElement(By.id("district")));
		District.selectByValue("mumbai");
		System.out.println("District selected from dropdown");
		//select state from dropdown
		Select State = new Select(driver.findElement(By.id("state")));
		State.selectByValue("bca");
		System.out.println("State selected from dropdown");
		//Enter pincode
		WebElement pinCode = driver.findElement(By.id("pincode"));
		pinCode.sendKeys("534670");
		System.out.println("Pincode entered");
		//enter email id
		WebElement email_ID = driver.findElement(By.id("emailid"));
		email_ID.sendKeys("divya.jampana9@gmail.com");
		System.out.println("Email id entered successfully");
		//click submit button
		Thread.sleep(4000);
		WebElement Submit = driver.findElement(By.xpath("//button[@class='bootbutton']"));
		Submit.click();
		System.out.println("Clicked on submit button");

		//Click on Switch to tab
		WebElement SwitchTo = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
		SwitchTo.click();
		System.out.println("Clicked on SwitchTo tab");
		WebElement alert = driver.findElement(By.xpath("//a[contains(text(),'Alert')]"));
		alert.click();
		System.out.println("Clicked on alert link");
		//click on window alert 
		WebElement windowAlert = driver.findElement(By.xpath("//button[contains(text(),'Window Alert')]"));
		windowAlert.click();
		System.out.println("Clicked on windowAlert");
		Thread.sleep(4000);
		Alert windowAlert1 = driver.switchTo().alert();
		String s1 = windowAlert1.getText();
		System.out.println(s1);
		windowAlert1.dismiss();
		System.out.println("Alert popup dismissed");
		//click on prompt alert
		WebElement promptAlert = driver.findElement(By.xpath("//button[contains(text(),'Promt Alert')]"));
		promptAlert.click();
		System.out.println("Clicked on promptAlert");
		Thread.sleep(4000);
		Alert promptAlert1 = driver.switchTo().alert();
		promptAlert1.sendKeys("Mohana");
		promptAlert1.accept();

		report.endTest(logger);
		report.flush();




	}

}




