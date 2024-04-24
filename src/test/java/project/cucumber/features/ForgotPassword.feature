@ForgotPassword
Feature: Forgot Password
  As a Registered User of the application
  I want to reset/regenerate my password via Forgot Password functionality

  Background: A Registered User navigates to Login page
    Given Driver initial
    And I navigate to the "login" page
    And I navigate to the "forgot-password" page

  @SuccessfulForgotPassword
  Scenario Outline: Successful submit of forgot password form with valid email
    When I fill in "email" with "<email>"
    And I click on the "Submit" input button
    Then I should land on the "forgot-password" page
    And I should see forget password "success" status message as "<success>"
    And I close the browser
    Examples:
      | email							| success                               	 		|
      |	test1234@gmail.com	| Password reset email sent successfully. |

  @failedForgotPassword
  Scenario Outline: Failed submit of forgot password form with invalid email
    When I fill in "email" with "<email>"
    And I click on the "Submit" input button
    Then I should land on the "forgot-password" page
    And I should see forget password "danger" status message as "<alert>"
    And I close the browser
    Examples:
      | email											| alert                               	 		|
      |	asdf.invalid@example.com	| We didn't find this user	|