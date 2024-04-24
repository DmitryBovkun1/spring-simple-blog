@Logout
Feature: Logout
  As a Looegd in User of the application
  I want to Logout successfully

  Background: User is logged in and is on Homepage
    Given Driver initial
    And I am a logged in user

  @SuccessfulLogout
  Scenario: Successful Logout
    When I click on "logout-mobile" link
    Then I should be successfully logged out
    And I navigate to the "" page
    And I don't see "logout-mobile" link
    And I close the browser