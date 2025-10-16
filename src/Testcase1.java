
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase1 {
	
	WebDriver driver=new FirefoxDriver();
	
	@BeforeTest
	public void BTest()
	{
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void login()
	{
		//Elements
		WebElement username= driver.findElement(By.id("user-name"));
		WebElement password= driver.findElement(By.id("password"));
		WebElement login=driver.findElement(By.id("login-button"));
		
		//Actions
		password.sendKeys("secret_sauce");
		username.sendKeys("standard_user");
		login.click();		
		
	}
	@Test(priority = 2)
	public void addToCart()
	{
		//Eelements
		WebElement addToCart1=driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		WebElement addToCart2=driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
		//Actions
		addToCart1.click();
		addToCart2.click();

	}
	
	@Test(priority = 3)
	public void remove()
	{
		WebElement remove1=driver.findElement(By.id("remove-sauce-labs-backpack"));
		remove1.click();
		WebElement remove2=driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt"));
		remove2.click();
	}
	
	@Test(priority = 4)
	public void addAfterRemove()
	{
		WebElement add1=driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		add1.click();
		WebElement add2=driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
		add2.click();
	}
	
	@Test(priority = 5)
	public void checkAddToCart()
	{
		WebElement cart= driver.findElement(By.className("shopping_cart_link"));
		cart.click();
		WebElement checkout=driver.findElement(By.id("checkout"));
		checkout.click();
		WebElement firstName=driver.findElement(By.id("first-name"));
		firstName.sendKeys("Shireen");
		WebElement lastName=driver.findElement(By.id("last-name"));
		lastName.sendKeys("Bataineh");
		WebElement postalCode=driver.findElement(By.id("postal-code"));
		postalCode.sendKeys("7487");
		WebElement continue1=driver.findElement(By.id("continue"));
		continue1.click();
		WebElement finish=driver.findElement(By.id("finish"));
		finish.click();
		WebElement back=driver.findElement(By.id("back-to-products"));
		back.click();
		
	}
	
	@Test(priority = 6, enabled=true)
	public void logout()throws InterruptedException
	{
		 WebElement burger=driver.findElement(By.className("bm-burger-button"));
		 burger.click();
		Thread.sleep(1000);
		WebElement logout=driver.findElement(By.id("logout_sidebar_link"));
		logout.click();
		
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.close();
	}
	

}
