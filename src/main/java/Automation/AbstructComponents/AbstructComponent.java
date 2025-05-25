package Automation.AbstructComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Automation.PageObjects.CartPage;
import Automation.PageObjects.OrderPage;


public class AbstructComponent {
	
	WebDriver driver;		
	WebDriverWait wait; 
	public AbstructComponent(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;
	
	public void elementToApper(By findBy) {				
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void webElementToApper(WebElement findBy) {				
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void elementToDisapper(By findBy) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));		
	}
	
	public CartPage goToCart() {
		cartHeader.click();
		return new CartPage(driver);
	}
		
		public OrderPage goToOrder() {
			orderHeader.click();
			return new OrderPage(driver);
		
	}
}
