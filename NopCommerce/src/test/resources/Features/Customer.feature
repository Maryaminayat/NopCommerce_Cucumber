Feature: Create customer

  Background: Common steps for each scenario
    Given User launch Chrome browser
    When User open URL "https://admin-demo.nopcommerce.com/login"
    And User enter Email as "admin@yourstore.com" and Password as "admin"
    And click on Login
    Then User can view Dashboard
    When User clicks on customers menu
    And Clicks on customer menu item

  Scenario: Add new customer
    And Click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And Click on Save button
    Then User can view confirmation message "The new customer has been added successfully"
    And Close browser

  Scenario: Search Customer by Email ID
    And Enter customer Email
    When Click on search button
    Then User should found Email in the Search table
  	And Close browser

 Scenario: Search Customer by Name
    And Enter customer First name
     And Enter customer Last name
    When Click on  search button
    Then User should found name in the Search table
    And close browser
    