package com.pages;

import com.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResetAccountPage extends BasePage {

    @FindBy(id = "id-login")
    WebElement inputField;

    @FindBy(xpath = "//label[contains(@class,\"checkbox\")][1]")
    WebElement checkBox;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement submitButton;

    @FindBy(xpath = "//label[contains(@class,\"input-label\")]")
    WebElement inputLabel;

    public void waitUntilInputFieldIsVisible(){
        waiter.until(ExpectedConditions.visibilityOf(inputField));
        Log.info("Wait for presenting Input field");
    }

    public boolean inputFieldLabelIsDisplayed(){
        String text = inputLabel.getText();
        Log.info("Check if Label of input field is displayed on ResetPage");
        return text.contains("Введіть ім'я вашої поштової скриньки:");
    }

}
