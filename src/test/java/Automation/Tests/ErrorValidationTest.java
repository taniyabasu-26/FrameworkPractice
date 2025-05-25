package Automation.Tests;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import Automation.PageObjects.CartPage;
import Automation.PageObjects.CheckoutPage;
import Automation.PageObjects.ConfirmationPage;
import Automation.PageObjects.LandingPage;
import Automation.PageObjects.ProductCatelog;
import Automation.TestComponents.BaseTest;

public class ErrorValidationTest extends BaseTest {
	
	@Test(groups= {"Error Handling"})
	public void loginErrorValidation() throws IOException {
		
		landingPage.login("taniya09@yopmail.com", "Tani@2613");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMsg());		
	}
	
	@Test
	public void productErrorValidation() throws IOException{
		String productName = "ZARA COAT 3";	
		
		ProductCatelog productCatelog = landingPage.login("rajiv09@yopmail.com", "Rajiv@123");
		List<WebElement> products = productCatelog.getProductList();
		productCatelog.addProductToCart(productName);	
		CartPage cartPage = productCatelog.goToCart();	
		
		Boolean match = cartPage.verifyProduct("Flipkart");		
		Assert.assertFalse(match);
	}
	
}
