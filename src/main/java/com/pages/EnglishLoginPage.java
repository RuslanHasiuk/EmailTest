package com.pages;

import com.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EnglishLoginPage extends BasePage {

    @FindBy(xpath = "//button/span[contains(text(),\"English\")]")
    WebElement englishButton;

    public void waitUntilTitleIsPresent(String title) {
        waiter.until(ExpectedConditions.titleIs(title));
        Log.info("Title of EnglishLoginPage is present");
    }

    public boolean isEnglishLanguageSelected(){
        String color = englishButton.getCssValue("color");
        String hex = Color.fromString(color).asHex();
        Log.info("Color of \"English\" header is already black");
        return (hex.contains("#343840"));
    }
}
