package com.weidmuller.step_definitions;

import com.weidmuller.pages.EstimationPokerPage;
import com.weidmuller.utilities.BrowserUtils;
import com.weidmuller.utilities.StoryGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;


public class SetEstimationPointstepDefs {

    EstimationPokerPage estimationPokerPage = new EstimationPokerPage();
    String expectedStoryPoint1;
    String expectedStoryPoint2;

    @When("the user select the new added story")
    public void theUserSelectTheNewAddedStory() {
        WebElement storyElement = estimationPokerPage.getStoryElement(StoryGenerator.storyList.get(0));
        BrowserUtils.waitForClickablility(storyElement, 10);
        storyElement.click();
    }

    @Then("the system display the selected story properly")
    public void the_system_display_the_selected_story_properly() {
        String actualStory = estimationPokerPage.estimatedStoryText.getText().substring(13);
        Assert.assertEquals(StoryGenerator.storyList.get(0), actualStory);
        StoryGenerator.storyList.clear();
    }


    @And("the user give a point {string} for the story")
    public void theUserGiveAPointForTheStory(String storyPoint) {
        expectedStoryPoint1 = storyPoint;
        estimationPokerPage.getLocationOfPoint(storyPoint).click();
    }

    @Then("the system display the selected point properly")
    public void theSystemDisplayTheSelectedPointProperly() {
        String actualStoryPoint = estimationPokerPage.estimatedPointText.getText();
        Assert.assertEquals(expectedStoryPoint1, actualStoryPoint);
    }

    @Then("the system display the username properly")
    public void theSystemDisplayTheUsernameProperly() {
        String expectedUsername = StoryGenerator.nameList.get(0);
        String actualUsername = estimationPokerPage.estimatedPersonName.getText();
        Assert.assertEquals(expectedUsername, actualUsername);
        StoryGenerator.nameList.clear();

    }

    @And("the user enter the estimation point {string} on set estimation box")
    public void theUserEnterTheEstimationPointOnSetEstimationBox(String storyPoint) {
        expectedStoryPoint2 = storyPoint;
        estimationPokerPage.setEstimationBox.sendKeys(storyPoint);
    }

    @When("the user click on the set estimation button")
    public void theUserClickOnTheSetEstimationButton() {
        estimationPokerPage.setEstimationButton.click();
    }

    @Then("the system display the given estimation point for the story")
    public void theSystemDisplayTheGivenEstimationPointForTheStory() {
        String actualStoryPoint = estimationPokerPage.getEstimationPointOfStory(StoryGenerator.storyList.get(0));
        Assert.assertEquals(expectedStoryPoint2,actualStoryPoint);
        StoryGenerator.storyList.clear();
    }


}
