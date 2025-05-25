package Automation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Automation.AbstructComponents.AbstructComponent;

public class LandingPage extends AbstructComponent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassord;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMsg;
	
	public ProductCatelog login(String email, String password) {
		userEmail.sendKeys(email);
		userPassord.sendKeys(password);
		submit.click();
		return new ProductCatelog(driver);
		
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMsg() {
		webElementToApper(errorMsg);
		return errorMsg.getText();
		
	}

}
