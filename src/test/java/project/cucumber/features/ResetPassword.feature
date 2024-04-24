@ResetPassword
Feature: Reset Password
  As a Registered User of the application
  I want to reset my password via Reset Password functionality

  Background: A Registered User reset password
    Given Driver initial

  @FailedResetPassword
  Scenario: Password reset token is invalid or has expired
    When I navigate to the "resetpassword?token=123123" page
    Then Invalid or expired reset token message is displayed
    And I close the browser