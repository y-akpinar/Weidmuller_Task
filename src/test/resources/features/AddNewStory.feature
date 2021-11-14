Feature: User should be able to add story


  Background:
    Given navigate to estimation poker welcome page
    When the user enter the username "Marcus"
    And the user enter the story "User can login" in welcome page
    And the user accept the privacy-policy


  Scenario Outline: Verify that the user should be able to add new story "<Description>"
    And the user select the card set "<cardSet>"
    And the user click the create game button
    When the user click on the story button
    And the user enter the story "New Story" in estimation poker page
    And the user click on the add a story button
    Then verify that story is already added
    Examples: cardSet
      | Description            | cardSet                                   |
      | with Fibonacci cardSet | Fibonacci (0, 1, 2, 3, 5, 8, 13, 21, ...) |
      | with  T-Shirt sizes    | T-Shirt sizes (S, M, L, XL, XXL)          |





    #NEGATIVE SCENARIO FOR ADDING NEW STORY
  Scenario Outline: Verify that the user should not be able to add story without entering the story on story text box  "<Description>"
    And the user select the card set "<cardSet>"
    And the user click the create game button
    When the user click on the story button
    And the user click on the add a story button
    Then verify that system display error message "Dieses Feld muss ausgefüllt werden."
    Examples: cardSet
      | Description            | cardSet                                   |
      | with Fibonacci cardSet | Fibonacci (0, 1, 2, 3, 5, 8, 13, 21, ...) |
      | with  T-Shirt sizes    | T-Shirt sizes (S, M, L, XL, XXL)          |


 #NEGATIVE SCENARIO FOR ADDING NEW STORY
  Scenario Outline: Verify that the user should not be able to add story by clicking close button "<Description>"
    And the user select the card set "<cardSet>"
    And the user click the create game button
    When the user click on the story button
    And the user enter the story "User should be able to send Task" in estimation poker page
    And the user click on the story close button
    Then verify that the story is not added
    Examples: cardSet
      | Description            | cardSet                                   |
      | with Fibonacci cardSet | Fibonacci (0, 1, 2, 3, 5, 8, 13, 21, ...) |
      | with  T-Shirt sizes    | T-Shirt sizes (S, M, L, XL, XXL)          |



 #NEGATIVE SCENARIO FOR ADDING NEW STORY
  Scenario Outline: Verify that the user should not be able to add story by clicking exit button  "<Description>"
    And the user select the card set "<cardSet>"
    And the user click the create game button
    When the user click on the story button
    And the user enter the story "User should be able to send Task" in estimation poker page
    And the user click on the story exit button
    Then verify that the story is not added
    Examples: cardSet
      | Description            | cardSet                                   |
      | with Fibonacci cardSet | Fibonacci (0, 1, 2, 3, 5, 8, 13, 21, ...) |
      | with  T-Shirt sizes    | T-Shirt sizes (S, M, L, XL, XXL)          |






#  Scenario: Verify that the user should not able to add story without entering the story
#    When the user click on the story button
#    And the user click on the add a story button
#    Then verify that system display error message "Dieses Feld muss ausgefüllt werden."
#
#
#  Scenario: Verify that the user should not able to add story by clicking close button
#    When the user click on the story button
#    And the user enter the story "User should be able to send Task" in estimation poker page
#    And the user click on the story close button
#    Then verify that the story is not added
#
#  Scenario: Verify that the user should not able to add story by clicking exit button
#    When the user click on the story button
#    And the user enter the story "User should be able to send Task" in estimation poker page
#    And the user click on the story exit button
#    Then verify that the story is not added




