@wip
Feature: The user should be able to delete story

  Background:
    Given navigate to estimation poker welcome page
    When the user enter the username "Yasin"
    And the user enter the story "User should be able to send Message" in welcome page
    And the user accept the privacy-policy


  Scenario Outline: Verify that the user should be able to delete any story "<Description>"
    And the user select the card set "<cardSet>"
    And the user click the create game button
    When the user click on the story button
    And the user enter the story "ABCDEFGHJK" in estimation poker page
    And the user click on the add a story button
    When the user click on the story button
    And the user enter the story "ABCDEFGHJfxgfdhhhhhhhhhhhhhK" in estimation poker page
    And the user click on the add a story button
    When the user click on the story button
    And the user enter the story "Hallo" in estimation poker page
    And the user click on the add a story button
    When the user click on the story button
    And the user enter the story "Bielefeld" in estimation poker page
    And the user click on the add a story button
    When the user click on the story button
    And the user enter the story "Berlin" in estimation poker page
    And the user click on the add a story button
    When the user click on the delete story button of the story "Hallo"
    Then verify that story "Hallo" is already deleted
    Examples: cardSet
      | Description            | cardSet                                   |
      | with Fibonacci cardSet | Fibonacci (0, 1, 2, 3, 5, 8, 13, 21, ...) |
      | with  T-Shirt sizes    | T-Shirt sizes (S, M, L, XL, XXL)          |


















