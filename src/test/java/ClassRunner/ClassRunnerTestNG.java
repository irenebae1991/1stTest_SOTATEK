package ClassRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import CommonBase.CommonBase;

import POM.*;
import TIKI_Stepdefinition.*;

import ShoppeStepdefinition.*;

public class ClassRunnerTestNG {
	
	CommonBase commonBase;
	WebDriver driver;
	String product = "iphone 11";
	
	//tiki page
	TIKI_Step TikiStepRun;
	TikiStepDefinition TikiSearch;
	
	//shoppe page
	ShopeeStep ShopeeStep; 
	ShoppeStepdefinition ShopeeStepDefinition;
	
	//VerifyCompare
	Sort sort;
	
	@BeforeMethod
	public void innit() {
		//System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
		
		System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");
		//driver = new ChromeDriver();		
		driver =new FirefoxDriver();
		//open tikiPage
		driver.get("https://tiki.vn/");		
		driver.manage().window().maximize();

		//tiki Step run
		TikiStepRun= new TIKI_Step(driver);
		
		TikiSearch=new TikiStepDefinition(driver);
		
		ShopeeStep =new ShopeeStep(driver);
		
		ShopeeStepDefinition=new ShoppeStepdefinition(driver);
		
	}
		@Test
		public void Test() throws InterruptedException {		
			TikiStepRun.setTxtSearch(product);
			
			TikiStepRun.clickBtnSearch();
			
			Thread.sleep(5000);				
			// verify result;
			List<Product> List = new ArrayList<Product>();
			List = TikiSearch.listProduct();
			
		// ShoppePage Continue ()
			ShopeeStep.openShopee();
			
			ShopeeStep.setTxtSearch(product);
			
			ShopeeStep.clickBtnSearch();
			
			Thread.sleep(5000);		
			
			List.addAll(ShopeeStepDefinition.listProduct());
			Collections.sort(List, new Sort());
			
			//System.out =>> list product show
			
			ShopeeStepDefinition.printList(List);
						
	}
		@AfterMethod
		public void after() {
			driver.quit();
			driver.close();
		}
}
