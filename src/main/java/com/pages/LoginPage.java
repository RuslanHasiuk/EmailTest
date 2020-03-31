package com.pages;

import com.google.gson.Gson;
import com.model.UserCreds;
import com.utils.Log;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.*;

public class LoginPage extends BasePage {

    @FindBy(id = "id-l")
    WebElement emailField;

    @FindBy(id = "id-p")
    WebElement passField;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement submitButton;

    @FindBy(xpath = "//p[@class=\"form__error form__error_fail\"]")
    WebElement errorCredsMessage;

    @FindBy(xpath = "//div[@class=\"header__wrapper\"]")
    WebElement headerLogo;

    @FindBy(xpath = "//a[@class=\"link link_style-main\"][contains(text(),\"Не вдається увійти?\")]")
    WebElement resetAccountButton;

    @FindBy(xpath = "//button/span[contains(text(),\"English\")]")
    WebElement englishButton;

    @FindBy(xpath = "//p[@class=\"form__error form__error_fail\"]")
    WebElement errorEmptyEmailMessage;

    @FindBy(xpath = "//p[@class=\"form__error form__error_fail\"]")
    WebElement errorEmptyPassMessage;

    public void waitUntilLoginPageLogoIsLoaded(){
        waiter.until(ExpectedConditions.visibilityOf(headerLogo));
        Log.info("Make sure PageLogo is present on LoginPage");
    }

    public InboxPage openLoginPage () {
        driver.get(LOGIN_PAGE_URL);
        waiter.until(ExpectedConditions.visibilityOf(headerLogo));
        Log.info("Make sure PageLogo is present on LoginPage");
        return new InboxPage();
    }

    public LoginPage enterEmail (String email){
        emailField.clear();
        emailField.sendKeys(email);
        Log.info("Email has been entered");
        return this;
    }

    public LoginPage enterPassword (String password){
        passField.clear();
        passField.sendKeys(password);
        Log.info("Password has been entered");
        return this;
    }

    public InboxPage submitLoginForm (){
        submitButton.click();
        Log.info("Login Form has been submitted");
        return new InboxPage();
    }
    public InboxPage submitWithEnterKey (){
        submitButton.sendKeys(Keys.RETURN);
        Log.info("Login Form has been submitted by pressing Enter Key");
        return new InboxPage();
    }

    public InboxPage loginToInboxPage(String email, String pass){
       openLoginPage();
       waitUntilLoginPageLogoIsLoaded();
       enterEmail(email).enterPassword(pass).submitWithEnterKey();
       Log.info("User is logged in successfully");
       return new InboxPage();
    }

    public boolean isErrorAboutInvaliCredsDisplayed(){
       String text =  errorCredsMessage.getText();
       Log.info("Message about wrong creds is displayed");
       return text.contains("Неправильні дані");
    }

    public boolean isErrorAboutEmptyEmailFieldDisplayed(){
        waitUntilEmptyEmailErrorIsLoaded();
        String text =  errorEmptyEmailMessage.getText();
        Log.info("Message about empty Email field is displayed");
        return text.contains("Поле має бути заповнене");
    }

    public boolean isErrorAboutEmptyPasswordFieldDisplayed(){
        waitUntilEmptyEmailErrorIsLoaded();
        String text =  errorEmptyPassMessage.getText();
        Log.info("Message about empty Password field is displayed");
        return text.contains("Поле має бути заповнене");
    }

    public void waitUntilErrorMessageElementIsLoaded(){
        waiter.until(ExpectedConditions.visibilityOf(errorCredsMessage));
        Log.info("Wait for presenting Error Message");
    }
    public void waitUntilEmptyEmailErrorIsLoaded(){
        waiter.until(ExpectedConditions.visibilityOf(errorEmptyEmailMessage));
        Log.info("Wait for presenting Error Message");
    }

    public boolean atPage(String title){
        Log.info("Make sure we are on LoginPage");
        return (driver.getTitle().equals(title));
    }

    public ResetAccountPage goToResetPage(){
        resetAccountButton.click();
        Log.info("Go to ResetPage");
        return new ResetAccountPage();
    }

    public EnglishLoginPage goToEnglishPage(){
        englishButton.click();
        Log.info("Go to EnglishPage for login");
        return new EnglishLoginPage();
    }
}
