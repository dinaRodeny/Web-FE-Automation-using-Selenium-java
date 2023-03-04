@test
Feature: E2E WorkFlow
  Scenario: Buy Product
    Given User navigates to category menu "Laptops"
    And User chooses Product "Sony vaio i5"
    And User clicks on Addtocart
    And User accepts Alert
    And User goes to Home Page
    And User navigates to category menu "Laptops"
    And User chooses Product "Dell i7 8gb"
    And User clicks on Addtocart
    And User accepts Alert
    And User navigates to header "Cart"
    And User deletes item "Dell i7 8gb" from cart
    And User click on PlaceOrder
    And User writes the data in form
    And User clicks on Purchase
    Then Check purchase amount as expected
    And User Press ok