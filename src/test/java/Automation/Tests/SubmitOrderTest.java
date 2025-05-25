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
import Automation.PageObjects.OrderPage;
import Automation.PageObjects.ProductCatelog;
import Automation.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
	
	String productName = "ZARA COAT 3";
	
	@Test
	public void submitOrder() throws IOException {
		
		String countryName = "india";
		
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
		
	}
	
	@Test(dependsOnMethods={"submitOrder"}) 
	public void orderHistory() {
		ProductCatelog productCatelog = landingPage.login("taniya09@yomail.com", "Tani@2613");
		OrderPage orderPage = productCatelog.goToOrder();
		Assert.assertTrue(orderPage.verifyOrder(productName)); 
	}
	
}
