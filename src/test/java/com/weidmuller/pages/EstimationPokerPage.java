package com.weidmuller.pages;

import com.weidmuller.step_definitions.AddNewStoryStepDefs;
import com.weidmuller.utilities.BrowserUtils;
import com.weidmuller.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EstimationPokerPage {

    public EstimationPokerPage(){
        PageFactory.initElements(Driver.get(), this);

    }

    @FindBy(css = ".header.mb-4>h3")
    public WebElement header;

    @FindBy(xpath = "//table[@class='table table-sm']/tbody/tr[1]/td")
    public WebElement firstTableRowData;

    @FindBy(xpath = "(//button[@type='button'])[2]")
    public WebElement storyBtn;

    @FindBy(css = "#storyText")
    public WebElement storyTextBox;

    @FindBy(xpath = "//*[.='Add']")
    public WebElement addStoryBtn;

    @FindBy(xpath = "//*[.='Close']")
    public WebElement closeStoryBtn;

    @FindBy(xpath = "//*[@class=\"modal-content\"]//div//span")
    public WebElement exitStoryBtn;

    @FindBy(css = ".invalid.ng-star-inserted>small")
    public WebElement addStoryErrorMessage;

    @FindBy(xpath = "//table[@class='table table-sm']/tbody/tr")
    public List<WebElement> rowList;

    @FindBy(xpath = "//div[@class='header mb-4']/span/small")
    public WebElement inviteLink;

    @FindBy(xpath = "//h4[@class=\"mt-3\"]")
    public WebElement estimatedStoryText;

    @FindBy(xpath = "//div[@class=\"btn-group w-100\"]/button")
    public List<WebElement> estimationNumbers;

    @FindBy(xpath = "//*[@class=\"card h-100\"]/div/h1")
    public WebElement estimatedPointText;

    @FindBy(xpath = "//*[@class=\"card h-100\"]/div/small")
    public WebElement estimatedPersonName;

    @FindBy(xpath = "//div[@class=\"input-group\"]/input")
    public WebElement setEstimationBox;

    @FindBy(xpath = "//div[@class=\"input-group\"]/div/button")
    public WebElement setEstimationButton;




    /**
     *  after adding new story, story is stored under the table
     *  get the actual story which is on the last row of table
     *
     * @return
     */
    public String getActualStory(){

        BrowserUtils.waitFor(2);
        int size = rowList.size();
        String lastStoryLocator="//table[@class='table table-sm']/tbody/tr[" + size+ "]/td[2]";
        WebElement lastStoryOfTable = Driver.get().findElement(By.xpath(lastStoryLocator));

        String actualStory=lastStoryOfTable.getText();

        return actualStory;
    }

    /**
     *  it return the estimation point of specific story
     * @param expectedStory
     * @return
     */
    public String getEstimationPointOfStory(String expectedStory) {

        BrowserUtils.waitFor(1);
        String locatorOfEstimationPoint= "//table[@class='table table-sm']//td[.='" + expectedStory + "']/../td[3]";
        WebElement estimationPointLocate = Driver.get().findElement(By.xpath(locatorOfEstimationPoint));
        String actualEstimationPoint=estimationPointLocate.getText();

        return actualEstimationPoint;
    }

    /**
     *  get the location of story on the table
     * @param expectedStory
     * @return
     */

    public WebElement getStoryElement(String expectedStory){

        WebElement expectedElement=null;
        BrowserUtils.waitFor(1);
        List<WebElement> elements = Driver.get().findElements(By.xpath("//table[@class='table table-sm']/tbody/tr/td[2]/span")); // story list of table

        for (WebElement element : elements) {
            if(element.getText().equals(expectedStory)){
                expectedElement=element;
                break;
            }
        }
        return expectedElement;
    }


    /**
     *  it return the delete button of story that is on the last row of table
     *
     * @return
     */

    public WebElement getDeleteButton(){

        BrowserUtils.waitFor(2);
        int size = rowList.size();
        String lastDeleteLocator="//table[@class='table table-sm']/tbody/tr[" + size+ "]/td[4]/button";
        WebElement lastDeleteButtonOfTable = Driver.get().findElement(By.xpath(lastDeleteLocator));

        return lastDeleteButtonOfTable;

    }

    /**
     *  get the location of fibonacci numbers
     * @param expectedPoint
     * @return
     */
    public WebElement getLocationOfPoint(String expectedPoint){

        WebElement expectedElement=null;
        for (WebElement estimationNumber : estimationNumbers) {
            if(estimationNumber.getText().equals(expectedPoint)){
                expectedElement=estimationNumber;
                break;
            }
        }
        return expectedElement;
    }









}
