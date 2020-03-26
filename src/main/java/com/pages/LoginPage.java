package com.pages;

import com.pages.EnglishLoginPage;
import com.pages.ResetAccountPage;
import com.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {

    @FindBy(id = "id-l")
    WebElement emailField;

    @FindBy(id = "id-p")
    WebElement passField;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement submitButton;

    @FindBy(xpath = "//p[@class=\"form__error form__error_fail\"]")
    WebElement errorMessage;

    @FindBy(xpath = "//div[@class=\"header__logo header__logo_lang-uk\"]")
    WebElement headerLogo;

    @FindBy(xpath = "//a[@class=\"link link_style-main\"][contains(text(),\"Не вдається увійти?\")]")
    WebElement resetAccountButton;

    @FindBy(xpath = "//button/span[contains(text(),\"English\")]")
    WebElement englishButton;

  //  private By emailField = By.id("id-l");
  //  private By passField = By.id("id-p");
   // private By submitButton = By.xpath("//button[@type=\"submit\"]");
  //  private By errorMessage = By.xpath("//p[@class=\"form__error form__error_fail\"]");
   // private By headerLogo = By.xpath("//div[@class=\"header__logo header__logo_lang-uk\"]");
  //  private By resetAccountButton = By.xpath("//a[@class=\"link link_style-main\"][contains(text(),\"Не вдається увійти?\")]");
  //  private By englishButton = By.xpath("//button/span[contains(text(),\"English\")]");

    public void waitUntilLoginPageLogoIsLoaded(){
        waiter.until(ExpectedConditions.visibilityOf(headerLogo));
        Log.info("Make sure PageLogo is present on LoginPage");
    }

    public InboxPage openLoginPage () {
        driver.get(LOGIN_PAGE_URL);
        waitUntilLoginPageLogoIsLoaded();
        Log.info("Make sure PageLogo is present on LoginPage");
        return new InboxPage();
    }

    public LoginPage enterEmail (String email){
        emailField.sendKeys(email);
        Log.info("Email has been entered");
        return this;
    }

    public LoginPage enterPassword (String pass){
        passField.sendKeys(pass);
        Log.info("Password has been entered");
        return this;
    }

    public InboxPage submitLoginForm (){
        submitButton.click();
        Log.info("Login Form has been submitted");
        return new InboxPage();
    }

    public InboxPage loginToInboxPage(String email, String pass){
       openLoginPage();
       waitUntilLoginPageLogoIsLoaded();
       enterEmail(email).enterPassword(pass).submitLoginForm();
       Log.info("User is logged in successfully");
       return new InboxPage();
    }

    public boolean isErrorDisplayed(){
       String text =  errorMessage.getText();
       Log.info("Message about wrong creds is displayed");
       return text.contains("Неправильні дані");
    }

    public void waitUntilErrorMessageElementIsLoaded(){
        waiter.until(ExpectedConditions.visibilityOf(errorMessage));
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

//   public EnglishHomePage switchtoEnglishLanguage(){
//        driver.findElement(englishLanguageRaddioButton).click();
//        driver.findElement(saveButton).click();
//        return  new EnglishHomePage();
//    }
}
