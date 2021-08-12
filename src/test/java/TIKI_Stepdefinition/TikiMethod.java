package TIKI_Stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import CommonBase.CommonBase;

public class TikiMethod extends CommonBase{
	WebDriver driver;
	
	@FindBy(xpath = "//*[@class='product-price__current-price']")
	WebElement productPrice;
	@FindBy(xpath = "//*[@data-view-id='pdp_details_title_tikinow_logo']/../..//.")
	WebElement productName;
	
	public TikiMethod (WebDriver driver) {
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




