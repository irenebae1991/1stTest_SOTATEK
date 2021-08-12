package ShoppeStepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonBase.CommonBase;


public class ShopeeStep extends CommonBase{
	WebDriver driver;
	
public void openShopee() {
	getURL("https://shopee.vn/", driver);
	waitForPageLoaded(driver);
}
	
	public ShopeeStep (WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@class='shopee-searchbar-input__input']")
	WebElement txtSearch;
	@FindBy(xpath = "//button[@class='btn btn-solid-primary btn--s btn--inline']")
	WebElement btnSearch;
	@FindBy(xpath = "//span[@class='shopee-search-result-header__text']")
	WebElement result;
	public void setTxtSearch(String values) {
		waitForPageLoaded(driver);
		setText(txtSearch,driver, values);

	}
	public void clickBtnSearch() {
		Click(btnSearch, driver);	
		waitForPageLoaded(driver);
	
	}
}
