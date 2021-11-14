package com.weidmuller.step_definitions;

import com.weidmuller.pages.EstimationPokerPage;
import com.weidmuller.pages.WelcomePage;
import com.weidmuller.utilities.BrowserUtils;
import com.weidmuller.utilities.ConfigurationReader;
import com.weidmuller.utilities.Driver;
import com.weidmuller.utilities.StoryGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class CreateGameStepDefs {

    WelcomePage welcomePage = new WelcomePage();
    EstimationPokerPage estimationPokerPage = new EstimationPokerPage();

    String expectedRoomnameNumber;
    static String expectedUsername;

    @Given("navigate to estimation poker welcome page")
    public void navigate_to_estimation_poker_welcome_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        expectedRoomnameNumber= welcomePage.roomNameBox.getAttribute("value");
    }

    @And("the user select the card set {string}")
    public void the_user_select_the_card_set(String cardSet) {
        try{
            welcomePage.selectDropdown(cardSet);
        }catch (Exception e){

        }
    }

    @And("the user accept the privacy-policy")
    public void the_user_accept_the_privacy_policy() {
        welcomePage.privacy_policyBox.click();
    }

    @And("the user click the create game button")
    public void the_user_click_the_create_game_button() {
        welcomePage.createGameBtn.click();
    }

    @Then("the system should display error message {string}")
    public void theSystemShouldDisplayErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = welcomePage.errorMessage.getText();
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);

    }

    @Then("verify that the user create game")
    public void verify_that_the_user_create_game() {

        BrowserUtils.waitForVisibility(estimationPokerPage.inviteLink,5);
        String actualInviteLinkText = estimationPokerPage.inviteLink.getText();
        int indexOfRoom = actualInviteLinkText.indexOf("room");
        String actualRoomnameNumber=actualInviteLinkText.substring(indexOfRoom+5);

        Assert.assertEquals(expectedRoomnameNumber, actualRoomnameNumber);

    }

    @And("add new user")
    public void addNewUser() {

        System.out.println((ConfigurationReader.get("baseUrl") + expectedRoomnameNumber));
        Driver.get().navigate().to(ConfigurationReader.get("baseUrl") + expectedRoomnameNumber);

    }

    @When("the user enter the username {string}")
    public void theUserEnterTheUsername(String username) {
        expectedUsername=username;
        welcomePage.usernameBox.sendKeys(username);
        StoryGenerator.nameList(username);
    }

    @And("the user clicks join button")
    public void theUserClicksJoinButton() {
        welcomePage.joinButton.click();
        BrowserUtils.waitFor(10);
    }

    @Given("delete all cookies")
    public void deleteAllCookies() {
        Driver.get().manage().deleteAllCookies();
        System.out.println(Driver.get().manage().getCookies());

    }

    @And("the user enter the story {string} in welcome page")
    public void theUserEnterTheStoryInWelcomePage(String story) {
        welcomePage.storiesBox.sendKeys(story);

    }
}
