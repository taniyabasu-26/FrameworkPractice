package Automation.AbstructComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstructComponent {
	
	WebDriver driver;		
	WebDriverWait wait; 
	public AbstructComponent(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		
	}
	
	public void elementToApper(By findBy) {				
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void elementToDisapper(By findBy) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));		
	}
}
