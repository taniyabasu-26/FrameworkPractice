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
	
	public void elementToApper(By findBy) {				
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void elementToDisapper(By findBy) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));		
	}
	
	public CartPage goToCart() {
		cartHeader.click();
		return new CartPage(driver);
		
	}
}
