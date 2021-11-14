package com.weidmuller.step_definitions;

import com.weidmuller.pages.EstimationPokerPage;
import com.weidmuller.utilities.BrowserUtils;
import com.weidmuller.utilities.StoryGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AddNewStoryStepDefs {

    EstimationPokerPage estimationPokerPage = new EstimationPokerPage();
    static String expectedStory;

    @When("the user click on the story button")
    public void the_user_click_on_the_story_button() {
        estimationPokerPage.storyBtn.click();
    }

    @And("the user enter the story {string} in estimation poker page")
    public void theUserEnterTheStoryInEstimationPokerPage(String story) {
        expectedStory=story;
        estimationPokerPage.storyTextBox.sendKeys(story);
        StoryGenerator.addStoryToList(story);

    }

    @And("the user click on the add a story button")
    public void theUserClickOnTheAddAStoryButton() {
        BrowserUtils.waitForClickablility(estimationPokerPage.addStoryBtn,10);
        estimationPokerPage.addStoryBtn.click();

    }

    @Then("verify that story is already added")
    public void verifyThatStoryIsAlreadyAdded() {

        BrowserUtils.waitFor(1);
        List<String> actualStoryList = BrowserUtils.getElementsText(estimationPokerPage.storyList);

        Assert.assertTrue(actualStoryList.containsAll(StoryGenerator.storyList));
        StoryGenerator.storyList.clear();
    }

    @And("the user click on the story close button")
    public void theUserClickOnTheStoryCloseButton() {
        BrowserUtils.waitForClickablility(estimationPokerPage.closeStoryBtn,5);
        estimationPokerPage.closeStoryBtn.click();
    }

    @Then("verify that the story is not added")
    public void verifyThatTheStoryIsNotAdded() {
        Assert.assertNotEquals(expectedStory,estimationPokerPage.getActualStory());
    }

    @And("the user click on the story exit button")
    public void theUserClickOnTheStoryExitButton() {
        estimationPokerPage.exitStoryBtn.click();
    }

    @Then("verify that system display error message {string}")
    public void verifyThatSystemDisplayErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = estimationPokerPage.addStoryErrorMessage.getText();
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }



}
