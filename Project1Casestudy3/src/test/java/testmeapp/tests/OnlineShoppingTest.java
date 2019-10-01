package testmeapp.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

//import testmeapp.utility.Drivers;



public class OnlineShoppingTest {
	WebDriver driver;
	ExtentReports extent;
	ExtentHtmlReporter htmlReporter;
	ExtentTest logger;
	
	@BeforeTest
	public void f() {
	driver=testmeapp.utility.Drivers.getdriver("chrome");
	   driver.manage().window().maximize();
	   driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
}
	@AfterMethod
	public void grtResultAfterMethod(ITestResult result) throws IOException {
	 if(result.getStatus()==ITestResult.FAILURE) {
	  logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+" - Test Case Failed",ExtentColor.RED));
	  TakesScreenshot snapshot=(TakesScreenshot)driver;
	  File src=snapshot.getScreenshotAs(OutputType.FILE);
	  String path=System.getProperty("user.dir")+"/extent-reports/snapshots/"+result.getName()+".png";
	  FileUtils.copyFile(src,new File(path));
	  logger.addScreenCaptureFromPath(path,result.getName());
	  logger.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable()+" - Test Case Failed",ExtentColor.RED));
	 
	 }
	 else if(result.getStatus()==ITestResult.SKIP) {
	  logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+" - Test Case Skipped",ExtentColor.ORANGE));
	 }
	}
    @Test(priority=4)
	public void testPayment() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='btn btn-success btn-block']")).click();
		driver.findElement(By.xpath("//textarea[@id='add1']")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("//form[2]//input[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[contains(text(),'Andhra Bank')]//i")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/label[1]/i[1]")).click();
		 // driver.findElement(By.xpath("//input[@name='username']")).click();
		  driver.findElement(By.id("btn")).click();
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("123456");
		  driver.findElement(By.xpath("//input[@name='password']")).click();
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Pass@456");
		  driver.findElement(By.xpath("//div[3]//input[1]")).click();
		 // wait.until(presenceOfElementLocated(By.xpath("//input[@name='transpwd']")));
		  driver.findElement(By.xpath("//input[@name='transpwd']")).click();
		  driver.findElement(By.xpath("//input[@name='transpwd']")).sendKeys("Trans@456");
		  driver.findElement(By.xpath("//div[@class='user-right']//input")).click();
		  driver.close();
	}
	@Test(priority=3)
	public void testCart() {
	 driver.findElement(By.xpath("//span[contains(text(),'All')]")).click();
	 Actions act =new Actions(driver);
	 WebElement search=driver.findElement(By.id("myInput"));

	 act.keyDown(search, Keys.SHIFT).sendKeys("bag").keyUp(Keys.SHIFT).perform();
	 //act.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Hand bag')]"))).click().perform();
	 driver.findElement(By.xpath("//form//input[@name='val']")).click();
	 driver.findElement(By.xpath("//div[@class='col-sm-9']//div[2]//div[1]//div[1]//div[2]//center[1]//a[1]")).click();
	 
	 driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[2]")).click();
	// WebElement ca = driver.findElement(By.tagName("h4"));
	// String productname = ca.getText();
	// Assert.assertEquals("Shopping bag", productname);
	  }
	@Test(priority=2)
	public void testLogin() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[contains(text(),'SignIn')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Arunraj");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Arunraj");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		
	}
	@Test(priority=1)
	public void testRegistration() throws InterruptedException {
	 
	  driver.findElement(By.xpath("//a[contains(text(),'SignUp')]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("userName")).sendKeys("Arunraj");
	  driver.findElement(By.xpath("//span[@id='err']")).click();
	  Thread.sleep(2000);
	  String uname=driver.findElement(By.xpath("//span[@id='err']")).getText();
	  if(uname.equalsIgnoreCase("Available"))
	  {
	   System.out.println("User name is available");
	  }
	  else {
	   System.out.println("UserName already taken");
	   
	  }
	  driver.findElement(By.id("firstName")).sendKeys("Arun");
	  boolean fname=driver.findElement(By.id("firstName")).isDisplayed();
	  System.out.println("Firstname displayed: "+fname);
	 
	 
	  driver.findElement(By.id("lastName")).sendKeys("Raj");
	  boolean lname=driver.findElement(By.id("lastName")).isDisplayed();
	  System.out.println("Lastname displayed: "+lname);
	 
	 
	  driver.findElement(By.id("password")).sendKeys("Arunraj");
	  boolean pass=driver.findElement(By.id("password")).isDisplayed();
	  System.out.println("Password displayed: "+pass);
	 
	 
	  driver.findElement(By.id("pass_confirmation")).sendKeys("Arunraj");
	  boolean con=driver.findElement(By.id("pass_confirmation")).isDisplayed();
	  System.out.println("pass_confirmation displayed: "+con);
	 
	 
	  driver.findElement(By.xpath("//label[@class='form-control input-lg']//input[1]")).click();
	  boolean gender=driver.findElement(By.xpath("//label[@class='form-control input-lg']//input[1]")).isSelected();
	   System.out.println("Gender:"+gender);
	   
	 
	  driver.findElement(By.id("emailAddress")).sendKeys("arun@gmail.com");
	  boolean eml=driver.findElement(By.name("emailAddress")).isDisplayed();
	  System.out.println("email Address displayed: "+eml);
	 
	 
	  driver.findElement(By.id("mobileNumber")).sendKeys("9870098700");
	  boolean phn=driver.findElement(By.name("answer")).isDisplayed();
	  System.out.println("Mobile number displayed: "+phn);
	 
	 
	  driver.findElement(By.name("dob")).sendKeys("01/02/1999");
	  boolean dob=driver.findElement(By.name("dob")).isDisplayed();
	  System.out.println("DateOfBirth displayed: "+dob);
	 
	 
	  driver.findElement(By.name("address")).sendKeys("hyderabad");
	  boolean add=driver.findElement(By.name("address")).isDisplayed();
	  System.out.println("Address displayed: "+add);
	 
	 
	  Actions act=new Actions(driver);
	  WebElement sq=driver.findElement(By.id("securityQuestion"));
	  act.moveToElement(sq).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  boolean ques=driver.findElement(By.id("securityQuestion")).isDisplayed();
	  System.out.println("Answer displayed: "+ques);
	 
	  driver.findElement(By.name("answer")).sendKeys("blue");
	  boolean ans=driver.findElement(By.name("answer")).isDisplayed();
	  System.out.println("Answer displayed: "+ans);
	  Thread.sleep(2000);
	 
	  boolean submit=driver.findElement(By.name("Submit")).isEnabled();
	  System.out.println("Submit Enabled: "+submit);
	  driver.findElement(By.name("Submit")).click();
	  Thread.sleep(3000);
	  driver.navigate().back();
	 

	  }
	
}
