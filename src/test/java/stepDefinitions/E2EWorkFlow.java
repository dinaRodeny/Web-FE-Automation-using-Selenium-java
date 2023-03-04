package stepDefinitions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;		
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;	

public class E2EWorkFlow {
	
	HomePage homepage = new HomePage();
	ProductPage productpage = new ProductPage();
	CartPage cartpage = new CartPage();
	
	@Given("^User navigates to category menu \"(.*)\"$")
	 public void User_Navigates_to_category_menu(String category){
		 homepage.EnterToCategoryMenu(category);
	 }
	 @When("^User chooses Product \"(.*)\"$")
	 public void User_Chooses_Product(String product){
		 homepage.ChooseProduct(product);
	 }
	 @When("^User clicks on Addtocart$")
	 public void User_Clicks_on_Addtocart(){
		 productpage.Click_On_Add_To_Cart();
	 }
	 @When("^User accepts Alert$")
	 public void User_Accepts_Alert(){
		 productpage.AcceptAlert();
	 }
	 @When("^User goes to Home Page$")
	 public void User_goes_to_Home_Page(){
		 productpage.Back_To_Home_Page();
	 }
	 
	 @When("^User navigates to header \"(.*)\"$")
	 public void User_Navigates_to_headermenu(String headercategory){
		 homepage.ChooseFromHeaderMenu(headercategory);
	 }
	 @When("^User deletes item \"(.*)\" from cart$")
	 public void User_deletes_item_from_cart(String item){
		 cartpage.DeleteSpecificProduct(item);
	 }
	 
	 @When("^User click on PlaceOrder$")
	 public void User_click_on_PlaceOrder(){
		 cartpage.CalculatePricesInCart();
		 cartpage.ClickOnPlaceOrder();
	 }
	 
	 @When("^User writes the data in form$")
	 public void User_writes_the_data_in_form(){
		 cartpage.AddFormFields();
	 }
	 
	 @When("^User clicks on Purchase$")
	 public void User_clicks_on_Purchase(){
		 cartpage.ClickOnPurchase();
	 }
	 
	 @Then("^Check purchase amount as expected$")
	 public void Check_purchase_amount_as_expected(){
		 Assert.assertEquals(cartpage.getInfoSuccessMessage("Amount"), cartpage.GetPriceOfAllItemsInCart());
		 Assert.assertEquals(0, 0, null);
	 }
	 
	 @Then("^User Press ok$")
	 public void User_Press_Ok(){

	 }
}
