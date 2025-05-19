package Automation.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Automation.AbstructComponents.AbstructComponent;

import org.openqa.selenium.WebElement;

public class ProductCatelog extends AbstructComponent{
	
	WebDriver driver;
		
	public ProductCatelog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMsg = By.cssSelector("#toast-container");
	By spinner = By.cssSelector(".ng-animating");
	
	public List<WebElement> getProductList() {
		elementToApper(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		elementToApper(toastMsg);
		elementToDisapper(spinner);
		
	}

}
