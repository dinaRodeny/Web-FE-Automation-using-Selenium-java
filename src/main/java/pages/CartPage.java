package pages;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;

import io.qameta.allure.Step;
import utils.MyLogger;

public class CartPage extends TestBase{	
	private double priceallitemsincart = 0; 

	private By placeorder_btn = By.xpath("//button[text()='Place Order']");
	private By name_fld = By.id("name");
	private By country_fld = By.id("country");
	private By city_fld = By.id("city");
	private By card_fld = By.id("card");
	private By month_fld = By.id("month");
	private By year_fld = By.id("year");
	private By purchase_btn = By.xpath("//button[text()='Purchase']");
	private By CartItems = By.xpath("(//a[text()='Delete']/parent::td/preceding-sibling::td)[3]");
	private By purchase_success_info= By.xpath("//p[@class='lead text-muted ']");
	
	@Step("Delete Specific Product step ...")
	public void DeleteSpecificProduct(String product)
	{
		By productdeleted = By.xpath("//td[text()='"+product+"']/following-sibling::td/a");
		MyLogger.info("Delete Specific Product :" + product);
		getDriverActions().clickOn(productdeleted);
		getDriverActions().Wait_Explicit_Until_NonVisibility(productdeleted);
	}
	
	@Step("Place Order step ...")
	public void ClickOnPlaceOrder()
	{
		MyLogger.info("Click On Place Order");
		getDriverActions().clickOn(placeorder_btn);
	}
	
	@Step("AddFormFields and Purchase step ...")
	public void AddFormFields()
	{
		String firstname = getFakerDataUser().getFirstname();
		String lastname = getFakerDataUser().getLastname();
		String country = getFakerDataUser().getCountry();
		String city = getFakerDataUser().getCity();
		String creditcard = getFakerDataUser().getCreditcardnumber();
		String month = getFakerDataUser().getMonth();
		String year = getFakerDataUser().getYear();
		MyLogger.info("Enter Fields");
		getDriverActions().textSet(name_fld,firstname+lastname);
		getDriverActions().textSet(country_fld,country);
		getDriverActions().textSet(city_fld,city);
		getDriverActions().textSet(card_fld,creditcard);
		getDriverActions().textSet(month_fld,month);
		getDriverActions().textSet(year_fld,year);
	}
	
	@Step("Click on Purchase step ...")
	public void ClickOnPurchase()
	{
		//getDriverActions().ScrollToBottomOfPage();
		MyLogger.info("Click on Purchase button");
		getDriverActions().clickOn(purchase_btn);
	}
	
	@Step("AddFormFields and Purchase step ...")
	public void CalculatePricesInCart()
	{
		int numofitems = getDriverActions().countAllElements(CartItems);
		ArrayList<Double> prices = new ArrayList<Double>();
		for(int index = 0; index < numofitems ; index++)
		{
			String pricetext = getDriverActions().getTextOfElementIndex(CartItems,index);
			MyLogger.info("Price of item : " + pricetext);
			prices.add(Double.parseDouble(pricetext.replaceAll("[^0-9.]", "")));
		}
		
		for (Double price : prices) {
			priceallitemsincart += price;
		}
		MyLogger.info("Price of All items from cart" + priceallitemsincart);
	}

	public double GetPriceOfAllItemsInCart() {
		return priceallitemsincart;
	}

	public double getInfoSuccessMessage(String txt) {
		String data = getDriverActions().textGet(purchase_success_info);
		String pattern = txt+": (\\d+)";
		double result = 0;
		Matcher matcher = Pattern.compile(pattern).matcher(data);
		
		if (matcher.find()) {
		    String amount = matcher.group(1);
		    result = Double.parseDouble(amount);
		    MyLogger.info(txt + " is : " + result);
		} else {
			MyLogger.error("Data not found in message info");

		}
		return  result;
		
	}

	
}
