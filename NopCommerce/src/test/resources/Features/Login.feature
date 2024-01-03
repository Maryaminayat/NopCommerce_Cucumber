Feature: Login
Scenario: Successful login with valid credentials
Given User launch Chrome browser
When User open URL "https://admin-demo.nopcommerce.com/login"
And User enter Email as "admin@yourstore.com" and Password as "admin"
And click on Login
Then Page Title should be "Dashboard/ nop Commerce administration"
When User clicks on Logout link
Then Page Title should be "Your store. Login"
And close the browser


Scenario Outline: login Data driven
Given User launch Chrome browser
When User open URL "https://admin-demo.nopcommerce.com/login"
And User enter Email as "<email>" and Password as "<password>"
And click on Login
Then Page Title should be "Dashboard/ nop Commerce administration"
When User clicks on Logout link
Then Page Title should be "Your store. Login"
And close the browser

Examples: 
| email | password |
| admin@yourstore.com | admin |
| admin1@yourstore.com | admin123 |
