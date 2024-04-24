@Profile
Feature: View/Edit Profile
  As a Registered User of the application
  I want to view and update my profile

  Background: User is logged in and is on Homepage
    Given Driver initial
    And I am a logged in user

  @ViewProfile
  Scenario: Successful View Profile
    When I navigate to the "users/profile" page
    Then I should see "User Profile" heading on the Profile page
    And Profile "username" field should be prepopulated on the Profile page
    And Profile "email" field should be prepopulated on the Profile page
    And I close the browser

  @EdiProfile
  Scenario Outline: Successful Edit Profile
    When I navigate to the "users/profile" page
    And I click on the edit profile link
    And I fill in "username" with "<username>"
    And I fill in "email" with "<email>"
    And I fill in "password" with "<password>"
    And I press Enter
    Then Profile "username" field should be contain "<username>"
    And Profile "email" field should be contain "<email>"
    And I close the browser
    Examples:
      | username    | email   | password							|
      | test        | test1234@gmail.com			 	| 2202	|