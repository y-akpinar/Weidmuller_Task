package com.weidmuller.step_definitions;

import com.weidmuller.pages.EstimationPokerPage;
import com.weidmuller.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DeleteStoryStepDefs {

    EstimationPokerPage estimationPokerPage = new EstimationPokerPage();


    @When("the user click on the delete story button")
    public void the_user_click_on_the_delete_story_button() {

        BrowserUtils.waitForClickablility(estimationPokerPage.getDeleteButton(),10);
        estimationPokerPage.getDeleteButton().click();

    }

    @Then("verify that story is already deleted")
    public void verify_that_story_is_already_deleted() {

        String actualStory = estimationPokerPage.getActualStory();
        String expectedStory = AddNewStoryStepDefs.expectedStory;
        Assert.assertNotEquals(expectedStory,actualStory);

    }

}
