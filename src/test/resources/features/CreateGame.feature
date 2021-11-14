
Feature: The user should be able to Create Game

  Background:
    Given navigate to estimation poker welcome page


  Scenario Outline: Verify that the user should not be able to create game "<Description>"
    When the user enter the username "<username>"
    And the user enter the story "<storyName>" in welcome page
    And the user select the card set "<cardSet>"
    And the user accept the privacy-policy
    And the user click the create game button
    Then the system should display error message "Dieses Feld muss ausgefüllt werden."
    Examples: username,storyName,cardSet,
      | Description         | username | storyName                           | cardSet                                   |
      | without username    |          | User should be able to send Task    | Fibonacci (0, 1, 2, 3, 5, 8, 13, 21, ...) |
      | without story       | Marcus   |                                     | T-Shirt sizes (S, M, L, XL, XXL)          |
      | without cardSet     | Stephan  | User should be able to send Massage |                                           |



  Scenario: Verify that the user should not be able to create game without entering story
    When the user enter the username "Yasin"
    And the user enter the story "" in welcome page
    And the user select the card set "Fibonacci (0, 1, 2, 3, 5, 8, 13, 21, ...)"
    And the user accept the privacy-policy
    And the user click the create game button
    Then the system should display error message "Dieses Feld muss ausgefüllt werden."


  Scenario: Verify that the user should not be able to create game without selecting card set
    When the user enter the username "Yasin"
    And the user enter the story "User should be able to send message" in welcome page
    And the user select the card set ""
    And the user accept the privacy-policy
    And the user click the create game button
    Then the system should display error message "Dieses Feld muss ausgefüllt werden."


  Scenario: Verify that the user should not be able to create game without clicking privacy-policy checkbox
    When the user enter the username "Yasin"
    And the user enter the story "User should be able to send message" in welcome page
    And the user select the card set "Fibonacci (0, 1, 2, 3, 5, 8, 13, 21, ...)"
    And the user click the create game button
    Then the system should display error message "Dieses Feld muss ausgefüllt werden."


  Scenario Outline: Verify that the user should be able create game successfully by entering all credentials
    When the user enter the username "Yasin"
    And the user enter the story "User should be able to send message" in welcome page
    And the user select the card set "<cardSet>"
    And the user accept the privacy-policy
    And the user click the create game button
    Then verify that the user create game
    Examples: cardSet
      | cardSet                                   |
      | Fibonacci (0, 1, 2, 3, 5, 8, 13, 21, ...) |
      | T-Shirt sizes (S, M, L, XL, XXL)          |


#  Scenario: Verify
#    When the user enter the username "Yasin"
#    And the user enter the story "User should be able to send message" in welcome page
#    And the user select the card set "Fibonacci (0, 1, 2, 3, 5, 8, 13, 21, ...)"
#    And the user accept the privacy-policy
#    And the user click the create game button
#    Given delete all cookies
#    And add new user
#    When the user enter the username "Cagri"
#    And the user accept the privacy-policy
#    And the user clicks join button


















