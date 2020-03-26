package com.pages;

import com.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InboxPage extends BasePage {

    @FindBy(xpath = "//button[@class=\"default compose\"]")
    WebElement composeButton;

    public InboxPage openInboxPage(){
        driver.get(INBOX_PAGE_URL);
        Log.info("InboxPage is opened");
        return new InboxPage();
    }

    public void waitUntilInboxPageIsLoaded(){
        waiter.until(ExpectedConditions.visibilityOf(composeButton));
        Log.info("Title of InboxPage is present");
    }

    public boolean atPage(String title){
        Log.info("Make sure we are on InboxPage");
        return driver.getTitle().equals(title);
    }
}
