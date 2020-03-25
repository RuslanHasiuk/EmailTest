package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EnglishLoginPage extends Pages.BasePage {

    By englishButton = By.xpath("//button/span[contains(text(),\"English\")]");


    public void waitUntilTitleIsPresent(String title){
        waiter.until(ExpectedConditions.titleIs(title));
    }
    public boolean isEnglishLanguageSelected(){
        String color = driver.findElement(englishButton).getCssValue("color");
        String hex = Color.fromString(color).asHex();
        return (hex.contains("#343840"));
    }
}
