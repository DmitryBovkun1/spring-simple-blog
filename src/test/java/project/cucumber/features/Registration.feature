@Registration
Feature: Registration
  As an Un-registered User of the application
  I want to validate the Registration functionality
  In order to check if it works as desired

  Background: User navigates to Registration page
    Given Driver initial
    And I navigate to the "register" page

  @SuccessfulRegistration
  Scenario Outline: Successful Registration using valid credentials
    When I fill in "username" with "<username>"
    And I fill in "email" with "<email>"
    And I fill in "password" with "<password>"
    And I press Enter
    Then I should land on the "" page
    And I should be successfully logged in
    And I close the browser
    Examples:
      | username			|	email										|	password  |
      |	asdf.asdf			|	asdf.asdf@example.com		|	Asdf@1234		|


  @DisabledRegistration
  Scenario Outline: Disabled Registration when one of the required fields is left blank
    When I fill in "username" with "<username>"
    And I fill in "email" with "<email>"
    And I fill in "password" with "<password>"
    And I press Enter
    Then I should see "<form error>" message for "<input field>" field on page
    And I close the browser
    Examples:
      | username    | email									|	password   |	form error																					|	input field				|
      | 		        | asdf.asdf@example.com	|	Asdf@1234	 |	Username cant be empty						|	username					|
      | asdf        |  		       						|	Asdf@1234	 |	Email cant be empty						|	email							|
      | asdf        | asdf       						|	Asdf@1234	 |	Invalid email						|	email							|