package com.Tests;

import Pages.InboxPage;
import com.Pages.EnglishLoginPage;
import com.Pages.ResetAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {

    @Test
    public void VerifyLogInToInboxPageWithValidCredentionals(){
        Pages.LoginPage loginPage = new Pages.LoginPage();
        InboxPage inboxPage = new InboxPage();
        loginPage.openLoginPage();
        Assert.assertTrue(loginPage.atPage(loginPageTitle));
        loginPage.enterEmail("GoTestEmail").enterPassword("1234test").submitLoginForm();
        inboxPage.waitUntilInboxPageIsLoaded();
        Assert.assertTrue(inboxPage.atPage(inboxPageTitle));
    }
    @Test
    public void VerifyLogInToInboxPageWithInvalidPassword(){
        Pages.LoginPage loginPage = new Pages.LoginPage();
        loginPage.openLoginPage();
        Assert.assertTrue(loginPage.atPage(loginPageTitle));
        loginPage.enterEmail("GoTestEmail").enterPassword("123test").submitLoginForm();
        loginPage.waitUntilErrorMessageElementIsLoaded();
        Assert.assertTrue(loginPage.isErrorDisplayed());
    }

    @Test
    public void VerifyLogInToInboxPageWithInvalidEmail(){
        Pages.LoginPage loginPage = new Pages.LoginPage();
        loginPage.openLoginPage();
        Assert.assertTrue(loginPage.atPage(loginPageTitle));
        loginPage.enterEmail("GoTestEmaill").enterPassword("1234test").submitLoginForm();
        loginPage.waitUntilErrorMessageElementIsLoaded();
        Assert.assertTrue(loginPage.isErrorDisplayed());
    }
    @Test
    public void VerifyRedirectToResetAccountPage(){
        Pages.LoginPage loginPage = new Pages.LoginPage();
        ResetAccountPage resetPage = new ResetAccountPage();
      loginPage.openLoginPage();
        Assert.assertTrue(loginPage.atPage(loginPageTitle));
        loginPage.goToResetPage();
        resetPage.waitUntilInputFieldIsPresent();
      Assert.assertTrue(resetPage.inputFieldLabelIsDisplayed());
    }

    @Test
    public void VerifySwitchLoginPageToEnglishLanguage(){
        Pages.LoginPage loginPage = new Pages.LoginPage();
        EnglishLoginPage englishPage = new EnglishLoginPage();
        loginPage.openLoginPage();
        Assert.assertTrue(loginPage.atPage(loginPageTitle));
        loginPage.goToEnglishPage();
        englishPage.waitUntilTitleIsPresent(englishLoginPageTitle);
        Assert.assertTrue(englishPage.isEnglishLanguageSelected());
    }
}
