package com.weidmuller.step_definitions;

import com.weidmuller.pages.EstimationPokerPage;
import com.weidmuller.utilities.BrowserUtils;
import com.weidmuller.utilities.StoryGenerator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DeleteStoryStepDefs {

    EstimationPokerPage estimationPokerPage = new EstimationPokerPage();



    @Then("verify that story {string} is already deleted")
    public void verify_that_story_is_already_deleted(String storyName) {
        Assert.assertFalse(StoryGenerator.storyList.contains(storyName));
        StoryGenerator.storyList.clear();

    }

    @When("the user click on the delete story button of the story {string}")
    public void theUserClickOnTheDeleteStoryButtonOfTheStory(String storyName) {
        StoryGenerator.removeStoryFromList(storyName);
        BrowserUtils.waitForClickablility(estimationPokerPage.getDeleteButton(storyName),10);
        estimationPokerPage.getDeleteButton().click();

    }
}
