package Automation.FrameworkPractice;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Automation.PageObjects.CartPage;
import Automation.PageObjects.CheckoutPage;
import Automation.PageObjects.ConfirmationPage;
import Automation.PageObjects.LandingPage;
import Automation.PageObjects.ProductCatelog;

public class SubmitOrderTest {

	public static void main(String[] args) {
		
		String productName = "ZARA COAT 3";
		String countryName = "india";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();		
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();		
		ProductCatelog productCatelog = landingPage.login("taniya09@yomail.com", "Tani@2613");
		List<WebElement> products = productCatelog.getProductList();
		productCatelog.addProductToCart(productName);	
		CartPage cartPage = productCatelog.goToCart();	
		
		Boolean match = cartPage.verifyProduct(productName);		
		Assert.assertTrue(match);
		
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry(countryName);
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		
		String confirmMsg = confirmationPage.getConfirmMsg();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thankyou for the order."));
		
		driver.close();
		
		}

}
