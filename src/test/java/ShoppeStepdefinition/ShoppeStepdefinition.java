package ShoppeStepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonBase.CommonBase;
import POM.Product;

public class ShoppeStepdefinition extends CommonBase{
	WebDriver driver;
	public ShoppeStepdefinition(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//*[@class='WTFwws _1k2Ulw _5W0f35']")
	WebElement ProductName;
	@FindBy(xpath = "//*[@class='shopee-search-result-header__text-highlight']")
	WebElement ProductResult;
	
	public void clickProduct() {
		waitForPageLoaded(driver);
		Click(ProductName, driver);
	}
	public String getText() {
		waitForPageLoaded(driver);
		return ProductResult.getText();	
	}
	
		///Get lis iphone
	// get list
	
		public List<WebElement> getUrlProduct() {
			return getListElements("//div[@class='_1jowzv']", driver); ///url link prodcut
		}
		public List<WebElement> getListProduct() {
			return getListElements("//div[@class='customized-overlay-image']", driver); //list
		}

		public List<WebElement> getListNameProduct() {   
			return getListElements("//div[@class='yQmmFK _1POlWt _36CEnF']", driver);//name
		}

		public List<WebElement> getListPriceProduct() {
			return getListElements("//span[@class='_24JoLh']", driver);//price
		}

		public List<String> getListUrlProduct() {
			List<String> list = new ArrayList<String>();
			for (WebElement element : getUrlProduct()) {
				list.add(element.getAttribute("href"));
			}
			return list;
		}
		
		public String trimPrice(String value) {
			String Price = trimCharactor(
					trimCharactor(value, ","), "VND");
			return Price;
		
	}

  public List<Product> listProduct() {
	List<Product> listProduct = new ArrayList<Product>();
	for (int i = 0; i < 10; i++) {
		Product tp = new Product("Shopee", getListNameProduct().get(i).getText(), getListUrlProduct().get(i),
				trimPrice(getListPriceProduct().get(i).getText()));
		listProduct.add(tp);
	}
	return listProduct;
}

}
