Feature: User can delete the story

  Background:
    Given navigate to estimation poker welcome page
    When the user enter the username "Yasin"
    And the user enter the story "User should be able to send Message" in welcome page
    And the user accept the privacy-policy

  @wip
  Scenario Outline: Verify that the user should be able to delete the story "<Description>"
    And the user select the card set "<cardSet>"
    And the user click the create game button
    When the user click on the story button
    And the user enter the story "ABCDEFGHJK" in estimation poker page
    And the user click on the add a story button
    When the user click on the delete story button
    Then verify that story is already deleted
    Examples: cardSet
      | Description            | cardSet                                   |
      | with Fibonacci cardSet | Fibonacci (0, 1, 2, 3, 5, 8, 13, 21, ...) |
      | with  T-Shirt sizes    | T-Shirt sizes (S, M, L, XL, XXL)          |





#  Scenario: Verify that the user should be able to delete the story
#    When the user click on the story button
#    And the user enter the story "User should be able to send Task" in estimation poker page
#    And the user click on the add a story button
#    When the user click on the delete story button
#    Then verify that story is already deleted












