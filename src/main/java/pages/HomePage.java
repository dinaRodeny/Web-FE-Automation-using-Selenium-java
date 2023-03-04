package pages;

import org.openqa.selenium.By;

import io.qameta.allure.Step;
import utils.MyLogger;

public class HomePage extends TestBase{
	By page_hdr = By.id("nava");
	
	@Step("From Home Page Enter to Category Menu step ...")
	public void EnterToCategoryMenu(String linkpath)
	{
		MyLogger.info("EnterToCategoryMenu :" + linkpath);
		getDriverActions().clickOn(By.xpath("//a[text()=\""+linkpath+"\" and @id=\"itemc\"]"));
	}
	
	@Step("Choose from header menu step ...")
	public void ChooseFromHeaderMenu(String header)
	{
		MyLogger.info("ChooseFromHeaderMenu :" + header);
		getDriverActions().clickOn(By.xpath("//a[text()='"+header+"']"));
	}
	
	@Step("Choose Product step ...")
	public void ChooseProduct(String product)
	{
		MyLogger.info("Choose Product :" + product);
		getDriverActions().clickOn(By.xpath("//a[text()='"+product+"']"));
	}
}

