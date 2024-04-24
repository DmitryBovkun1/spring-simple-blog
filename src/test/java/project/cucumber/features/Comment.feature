@Comment
Feature: Add Comment on a Blog/Post
  As a Looegd in User of the application
  I want to write a comment to a Blog/Post successfully

  Background: User sees a blog on Homepage and clicks on it
    Given Driver initial
    And I am a logged in user
    And I navigate to the "posts" page

  @SuccessfulAddComment
  Scenario Outline: Successful Add Comment to a Blog/Post
    When I navigate to the "posts/1" page
    And I fill in "newComment" with "<message>"
    And I click on the "Add Comment" button
    Then I should land on the "posts/1" page
    And I should see the comment "<message>" added to the blog
    And I close the browser
    Examples:
      |	message			|
      |	test comment				|