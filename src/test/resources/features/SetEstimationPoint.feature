@wip
Feature: User can give estimation point for story


  Background: Background:

    Given navigate to estimation poker welcome page
    When the user enter the username "Markus"
    And the user enter the story "User can login" in welcome page
    And the user accept the privacy-policy


  Scenario Outline: Verify that the user should be able to select the story in order to give the point "<Description>"
    And the user select the card set "<cardSet>"
    And the user click the create game button
    When the user click on the story button
    And the user enter the story "User should be able to send Task" in estimation poker page
    And the user click on the add a story button
    When the user select the new added story
    Then the system display the selected story properly
    Examples: cardSet
      | Description            | cardSet                                   |
      | with Fibonacci cardSet | Fibonacci (0, 1, 2, 3, 5, 8, 13, 21, ...) |
      | with  T-Shirt sizes    | T-Shirt sizes (S, M, L, XL, XXL)          |


  Scenario Outline: Verify that the user should be able to give a estimation point for the user story "<Description>"
    And the user select the card set "<cardSet>"
    And the user click the create game button
    When the user click on the story button
    And the user enter the story "User should be able to send Task" in estimation poker page
    And the user click on the add a story button
    When the user select the new added story
    And the user give a point "<point>" for the story
    Then the system display the selected point properly
    Then the system display the username properly
    Examples: cardSet
      | Description            | cardSet                                   | point |
      | with Fibonacci cardSet | Fibonacci (0, 1, 2, 3, 5, 8, 13, 21, ...) | 13    |
      | with  T-Shirt sizes    | T-Shirt sizes (S, M, L, XL, XXL)          | XS    |


  Scenario Outline: Verify that the user should be able to set a estimation point for the user story "<Description>"
    And the user select the card set "<cardSet>"
    And the user click the create game button
    When the user click on the story button
    And the user enter the story "User should be able to send Task" in estimation poker page
    And the user click on the add a story button
    When the user select the new added story
    And the user enter the estimation point "<point>" on set estimation box
    When the user click on the set estimation button
    Then the system display the given estimation point for the story
    Examples: cardSet
      | Description            | cardSet                                   | point |
      | with Fibonacci cardSet | Fibonacci (0, 1, 2, 3, 5, 8, 13, 21, ...) | 13    |
      | with  T-Shirt sizes    | T-Shirt sizes (S, M, L, XL, XXL)          | M     |











