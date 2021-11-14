
Feature: User can give estimation point for story


  Background: Background:
    Given navigate to estimation poker welcome page
    When the user enter the username "Yasin"
    And the user enter the story "User should be able to send message" in welcome page
    And the user select the card set "T-Shirt sizes (S, M, L, XL, XXL)"
    And the user accept the privacy-policy
    And the user click the create game button


  Scenario: Verify that the user should be able to select the story in order to give the point
    When the user click on the story button
    And the user enter the story "User should be able to send Task" in estimation poker page
    And the user click on the add a story button
    When the user select the new added story
    Then the system display the selected story properly


  Scenario: Verify that the user should be able to give a estimation point for the user story
    When the user click on the story button
    And the user enter the story "User should be able to send Task" in estimation poker page
    And the user click on the add a story button
    When the user select the new added story
    And the user give a point "XS" for the story
    Then the system display the selected point properly
    Then the system display the username properly


  Scenario: Verify that the user should be able to set a estimation point for the user story
    When the user click on the story button
    And the user enter the story "User should be able to send Task" in estimation poker page
    And the user click on the add a story button
    When the user select the new added story
    And the user enter the estimation point "13" on set estimation box
    When the user click on the set estimation button
    Then the system display the given estimation point for the story




  Scenario Outline: Verify that the user should not be able to set a estimation point such as special/String/nonFibonacci Digits character,
    When the user click on the story button
    And the user enter the story "User should be able to send Task" in estimation poker page
    And the user click on the add a story button
    When the user select the new added story
    And the user enter the estimation point "<point>" on set estimation box
    When the user click on the set estimation button
    Then the system must not accept the point and must display "not estimated yet"

    Examples:
      | point      |
      | helloworld |
      | *#$%       |
      | 12         |







