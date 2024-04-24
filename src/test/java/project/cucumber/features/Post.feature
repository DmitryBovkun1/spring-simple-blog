@BlogPost
Feature: Add Blog/Post
  As a Looegd in User of the application
  I want to write a Blog/Post successfully

  Background: User is logged in and is on Homepage
    Given Driver initial
    And I am a logged in user

  @SuccessfulLandOnAddBlogPost
  Scenario: Successful landing on Add a Blog/Post
    When I click on "Create a post" link on the main menu
    Then I should land on the "posts/create" page
    And I close the browser

  @SuccessfulAddBlogPost
  Scenario Outline: Successful creation of a Blog/Post
    When I click on "Create a post" link on the main menu
    And I fill in "title" with "<title>"
    And I fill textarea in "body" with "<body>"
    And I choose posts options in "tags" with "<tags>"
    And I click on the "Create" button
    Then I should land on the "posts" page
    And I should see the new blog title "<title>" listing on the post page
    And I close the browser
    Examples:
      | title					|	body										| tags  |
      |	some title		|	some short description				| General,Tech,Music  |