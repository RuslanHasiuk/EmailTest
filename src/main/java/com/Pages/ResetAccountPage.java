package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResetAccountPage extends Pages.BasePage {

    By inputField = By.id("id-login");
    By checkBox = By.xpath("//label[contains(@class,\"checkbox\")][1]");
    By submitButton = By.xpath("//button[@type=\"submit\"]");
    By inputLabel = By.xpath("//label[contains(@class,\"input-label\")]");


    public void waitUntilInputFieldIsPresent(){
        waiter.until(ExpectedConditions.presenceOfElementLocated(inputField));
    }
    public boolean inputFieldLabelIsDisplayed(){
        String text = driver.findElement(inputLabel).getText();
        return text.contains("Введіть ім'я вашої поштової скриньки:");
    }



}
