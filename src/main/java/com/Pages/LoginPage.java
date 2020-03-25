package Pages;

import com.Pages.EnglishLoginPage;
import com.Pages.ResetAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends Pages.BasePage {

    By emailField = By.id("id-l");
    By passField = By.id("id-p");
    By submitButton = By.xpath("//button[@type=\"submit\"]");
    By errorMessage = By.xpath("//p[@class=\"form__error form__error_fail\"]");
    By headerLogo = By.xpath("//div[@class=\"header__logo header__logo_lang-uk\"]");
    By resetAccountButton = By.xpath("//a[@class=\"link link_style-main\"][contains(text(),\"Не вдається увійти?\")]");
    By englishButton = By.xpath("//button/span[contains(text(),\"English\")]");


    public void waitUntilLoginPageLogoIsLoaded(){
        waiter.until(ExpectedConditions.visibilityOfElementLocated(headerLogo));
    }
    public Pages.InboxPage openLoginPage () {
        driver.get(LOGIN_PAGE_URL);
        waitUntilLoginPageLogoIsLoaded();
        return new Pages.InboxPage();
    }

    public LoginPage enterEmail (String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword (String pass){
        driver.findElement(passField).sendKeys(pass);
        return this;
    }

    public Pages.InboxPage submitLoginForm (){
        driver.findElement(submitButton).click();
        return new Pages.InboxPage();
    }

    public Pages.InboxPage loginToInboxPage(String email, String pass){
       String loginPageTitle = "Пошта @ ukr.net - українська електронна пошта • Створи емейл";
        openLoginPage();
       waitUntilLoginPageLogoIsLoaded();
        enterEmail(email).enterPassword(pass).submitLoginForm();
        Assert.assertTrue(atPage(loginPageTitle));
        return new Pages.InboxPage();
    }

    public boolean isErrorDisplayed(){
       String text =  driver.findElement(errorMessage).getText();
       return text.contains("Неправильні дані");
    }
    public void waitUntilErrorMessageElementIsLoaded(){
        waiter.until(ExpectedConditions.presenceOfElementLocated(errorMessage));
    }
    public boolean atPage(String title){
        return (driver.getTitle().equals(title));
    }

    public ResetAccountPage resetAccountPage (){
        driver.findElement(resetAccountButton).click();
        return new ResetAccountPage();
    }

    public ResetAccountPage goToResetPage(){
        driver.findElement(resetAccountButton).click();
        return new ResetAccountPage();
    }

    public EnglishLoginPage goToEnglishPage(){
        driver.findElement(englishButton).click();
        return new EnglishLoginPage();
    }


//    public EnglishHomePage switchtoEnglishLanguage(){
//        driver.findElement(englishLanguageRaddioButton).click();
//        driver.findElement(saveButton).click();
//        return  new EnglishHomePage();
//    }

}
