package pages;

import org.openqa.selenium.By;

import io.qameta.allure.Step;
import utils.MyLogger;

public class ProductPage extends TestBase{
	private By page_hdr = By.id("nava");
	private By addtocart_btn = By.className("btn-success");
	
	@Step("Click_On_Add_To_Cart step ...")
	public void Click_On_Add_To_Cart()
	{
		MyLogger.info("Click on Add to Cart Btn");
		getDriverActions().clickOn(addtocart_btn);
	}
	
	@Step("Back_To_Home_Page step ...")
	public void Back_To_Home_Page()
	{
		MyLogger.info("Click on Home icon to return to home page");
		getDriverActions().clickOn(page_hdr);
	}
	
	@Step("Accept Alert")
	public void AcceptAlert()
	{
		getDriverActions().AcceptAlerts();
	}
}
