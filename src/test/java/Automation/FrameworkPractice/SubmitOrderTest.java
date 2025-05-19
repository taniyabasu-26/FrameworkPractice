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

import Automation.PageObjects.LandingPage;
import Automation.PageObjects.ProductCatelog;

public class SubmitOrderTest {

	public static void main(String[] args) {
		
		String productName = "ZARA COAT 3";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();		
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		landingPage.login("taniya09@yomail.com", "Tani@2613");		
		
		ProductCatelog productCatelog = new ProductCatelog(driver);
		List<WebElement> products = productCatelog.getProductList();
		productCatelog.addProductToCart(productName);	
			
		
		/*driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream().anyMatch(cartProduct->
		cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions act = new Actions(driver);
		act.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "india").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		driver.findElement(By.cssSelector("action__submit ")).click();
		
		String confirmMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thankyou for the order."));
		
		driver.close();*/

	}

}
