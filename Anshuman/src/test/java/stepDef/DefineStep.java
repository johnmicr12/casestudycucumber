package stepDef;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DefineStep {
	WebDriver driver;
	
	@Given("app is up")
	public void app_is_up() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		//driver= new ChromeDriver();
		//driver.get("https://www.amazon.in/?ie=UTF8&tag=googinabkvernac-21&ascsubtag=_k_Cj0KCQjw5rbsBRCFARIsAGEYRweXi6AN4CwVrauYo4qenVtVhxbkYPqCyJgCwkTTLJoVvKqnJ54J5VsaAkRUEALw_wcB_k_&ext_vrnc=hi&gclid=Cj0KCQjw5rbsBRCFARIsAGEYRweXi6AN4CwVrauYo4qenVtVhxbkYPqCyJgCwkTTLJoVvKqnJ54J5VsaAkRUEALw_wcB");
		//driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}
	@Given("credentials are")
	public void credentials_are(io.cucumber.datatable.DataTable dataTable) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.amazon.in/?ie=UTF8&tag=googinabkvernac-21&ascsubtag=_k_Cj0KCQjw5rbsBRCFARIsAGEYRweXi6AN4CwVrauYo4qenVtVhxbkYPqCyJgCwkTTLJoVvKqnJ54J5VsaAkRUEALw_wcB_k_&ext_vrnc=hi&gclid=Cj0KCQjw5rbsBRCFARIsAGEYRweXi6AN4CwVrauYo4qenVtVhxbkYPqCyJgCwkTTLJoVvKqnJ54J5VsaAkRUEALw_wcB");
		java.util.List<WebElement> ason=driver.findElements(By.tagName("a"));
		System.out.println(ason.size());
		for(int i=0;i<ason.size();i++)
		{
			System.out.println(ason.get(i).getText());
		}
		List<List<String>> data=dataTable.cells();
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		System.out.println(data.get(4));
		System.out.println(data.get(5));
		
		
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    //throw new cucumber.api.PendingException();
	}

	

	@Given("enter {string} and {string}")
	public void enter_and(String string, String string2) {
		
		//for(int i=0;i<=)
		
		//driver.findElement(By.xpath("//input[@id='email']")).sendKeys(string);
		//driver.findElement(By.xpath("//input[@name='password']")).sendKeys(string2);
		//driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(string2);
		//driver.findElement(By.xpath("//input[@name='register']")).click();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}
	@Given("John purchase microwave for {int} rs")
	public void john_purchase_microwave_for_doll(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}
	

	@Given("he has receipt")
	public void he_has_receipt() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new cucumber.api.PendingException();
	}

	@When("John returns the faulty microwave")
	public void john_returns_the_faulty_microwave() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}

	@Then("he got refund of {int} doll")
	public void he_got_refund_of_doll(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}
	
	
}
