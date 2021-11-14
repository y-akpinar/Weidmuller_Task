package com.weidmuller.pages;

import com.weidmuller.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class WelcomePage {

    public WelcomePage(){
        PageFactory.initElements(Driver.get(), this);

    }
    @FindBy(css = "#roomname")
    public WebElement roomNameBox;

    @FindBy(css = "#username")
    public WebElement usernameBox;

    @FindBy(css = "#stories")
    public WebElement storiesBox;

    @FindBy(css = "#cardType")
    public WebElement cardSetDropdown;

    @FindBy(css = "#privacy-policy")
    public WebElement privacy_policyBox;

    @FindBy(css = ".btn ")
    public WebElement createGameBtn;

    @FindBy(css = ".invalid.ng-star-inserted>small")
    public WebElement errorMessage;

    @FindBy(xpath = "/html/body/io-games-frontend-root/io-games-frontend-create-layout/div/app-create-user/div/form/button")
    public WebElement joinButton;




    /**
     *  Select the element from Dropdown on the Welcome page
     * @param cardSet
     */
    public void selectDropdown(String cardSet){
        Select dropDown=new Select(cardSetDropdown);
        dropDown.selectByVisibleText(cardSet);
    }

}
