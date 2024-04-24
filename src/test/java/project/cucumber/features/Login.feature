@Login
Feature: Login
  As a Registered User of the application
  I want to validate the Login functionality
  In order to check if it works as desired

  Background: A Registered User navigates to Login page
    Given Driver initial
    And I navigate to the "login" page

  @SuccessfulLogin
  Scenario Outline: Successful login using valid credentials
    When I fill in "username" with "<username>"
    And I fill in "password" with "<password>"
    And I click Login button
    Then I should be successfully logged in
    And I close the browser
    Examples:
      | username			|	password	|
      |	test			|	2202	|

  @failedLogin
  Scenario Outline: Failed login using wrong credentials
    When I fill in "username" with "<username>"
    And I fill in "password" with "<password>"
    And I click Login button
    Then I should be redirected on the "login" page
    And I should see "error" message as "<alert>" on login page
    And I close the browser
    Examples:
      | username    | password   | alert                            |
      | araj        | !23	     |  Invalid Username and Password.  |
      | ARAJ        | !23        |  Invalid Username and Password.  |
      |             | !23        |  Invalid Username and Password.  |
      | Test        |            |  Invalid Username and Password.  |
