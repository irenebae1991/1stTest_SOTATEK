package TIKI_Stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonBase.CommonBase;
import POM.Product;

public class TikiStepDefinition extends CommonBase {
	WebDriver driver;
	
	public TikiStepDefinition (WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@class='product-item']//span[contains(text(),'iPhone 11')][1]")
	WebElement Product;
	@FindBy(xpath = "//*[contains(text(),'Kết quả tìm kiếm cho')]//following-sibling::h4")
	WebElement Result;
	@FindBy(xpath = "//*[@class='name']")
	WebElement ListProduct;
	
	public void clickProduct() {
		waitForPageLoaded(driver);
		Click(Product, driver);
	}
	public String getText(WebElement List) {
		waitForPageLoaded(driver);
		return List.getText();
	}
	
	
	//Get information List product 
	
	public List<WebElement> getListProduct() {
		return getListElements("//*[@class='product-item']", driver);// *[@class='product-item']
	}

	public List<WebElement> getListNameProduct() {
		return getListElements("//*[@class='name']", driver);
	}

	public List<WebElement> getListPriceProduct() {
		return getListElements("//*[@class='price-discount__price']", driver);
	}

	public List<String> getListUrlProduct() {
		List<String> list = new ArrayList<String>();
		for (WebElement element : getListProduct()) {
			list.add(element.getAttribute("href"));
		}
		return list;
	}
	public String trimPrice(String value) {
		String Price = trimCharactor(
				trimCharactor(value, "₫"), ".");
		return Price;
	}
	
	//getlist funtion
	public List<Product> listProduct() {
		List<Product> listProduct = new ArrayList<Product>();
		for (int i = 0; i < 10; i++) {
			Product iphone = new Product("Tiki", getListNameProduct().get(i).getText(), getListUrlProduct().get(i),
					trimPrice(getListPriceProduct().get(i).getText()));
			listProduct.add(iphone);
		}
		return listProduct;
	}

}

