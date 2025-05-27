package Automation.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Automation.PageObjects.CartPage;
import Automation.PageObjects.CheckoutPage;
import Automation.PageObjects.ConfirmationPage;
import Automation.PageObjects.LandingPage;
import Automation.PageObjects.OrderPage;
import Automation.PageObjects.ProductCatelog;
import Automation.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
	
	HashMap<String, String> testInput;
	String countryName = "india";
	
	@Test(dataProvider="getData",groups="Purchase")
	public void submitOrder(HashMap<String,String> input) throws IOException {
				
		this.testInput = input;
		ProductCatelog productCatelog = landingPage.login(input.get("email"), input.get("password"));
		List<WebElement> products = productCatelog.getProductList();
		productCatelog.addProductToCart(input.get("productName"));	
		CartPage cartPage = productCatelog.goToCart();	
		
		Boolean match = cartPage.verifyProduct(input.get("productName"));		
		Assert.assertTrue(match);
		
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry(countryName);
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		
		String confirmMsg = confirmationPage.getConfirmMsg();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thankyou for the order."));
		
	}
	
	@Test(dependsOnMethods={"submitOrder"}) 
	public void orderHistory() {
		ProductCatelog productCatelog = landingPage.login(testInput.get("email"), testInput.get("password"));
		OrderPage orderPage = productCatelog.goToOrder();
		Assert.assertTrue(orderPage.verifyOrder(testInput.get("productName"))); 
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\Automation\\Data\\purchaseData.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
}
