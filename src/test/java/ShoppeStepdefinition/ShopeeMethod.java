package ShoppeStepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonBase.CommonBase;

public class ShopeeMethod  extends CommonBase {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@class='WTFwws _1k2Ulw _5W0f35']")
	WebElement productPrice;
	@FindBy(xpath = "//*[@class='yQmmFK _1POlWt _36CEnF']")
	WebElement productName;
	
	public ShopeeMethod(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String getPrice() {
		waitForPageLoaded(driver);
		return getText(productPrice);
	}
	public String getName() {
		waitForPageLoaded(driver);
		return getText(productName);
	}
	public String trimPrice() {
		String Price = trimCharactor(
				trimCharactor(getPrice(), "â‚«"), ".");
		return Price;
	}
	public String getCurrentUrl() {
		return driver.getCurrentUrl();		
	}

}
