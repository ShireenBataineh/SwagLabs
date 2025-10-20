package AddToCart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToCartLoop {
	
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
	
	@Test(priority=2)
	public void addAllItemsToCart() throws InterruptedException
	{
		//To print the prices
		List <WebElement> price=driver.findElements(By.className("inventory_item_price"));
		System.out.println(price.size());
		for(int i=0;i<price.size();i++)
		{
			System.out.println(price.get(i).getText());

		}
		List <WebElement> adds=driver.findElements(By.cssSelector(".btn_primary.btn_inventory"));
		List <WebElement> name=driver.findElements(By.className("inventory_item_name"));
		for(int i=0;i<price.size();i++)
		{
			if(i==0 || i==2 ||i==4) {
			    adds.get(i).click();
			    System.out.println(price.get(i).getText());
			    System.out.println(name.get(i).getText());
			    System.out.println("This item "+name.get(i).getText()+"has been added");}
			
			else
				{
		    System.out.println(price.get(i).getText());
		    System.out.println(name.get(i).getText());
		    System.out.println("This item "+name.get(i).getText()+"has NOT been added");}		


		}

		Thread.sleep(2000);

	}
	
	@AfterTest(enabled=true)
	public void afterTest()
	{
		driver.close();
	}


}
