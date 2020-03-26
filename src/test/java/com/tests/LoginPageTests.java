package com.tests;

import com.pages.EnglishLoginPage;
import com.pages.InboxPage;
import com.pages.LoginPage;
import com.pages.ResetAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {

    @Test
    public void VerifyLogInToInboxPageWithValidCredentionals(){
        LoginPage loginPage = new LoginPage();
        InboxPage inboxPage = new InboxPage();
        loginPage.openLoginPage();
        Assert.assertTrue(loginPage.atPage(loginPageTitle));
        loginPage.enterEmail("GoTestEmail").enterPassword("1234test").submitLoginForm();
        inboxPage.waitUntilInboxPageIsLoaded();
        Assert.assertTrue(inboxPage.atPage(inboxPageTitle));
    }
    @Test
    public void VerifyLogInToInboxPageWithInvalidPassword(){
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage();
        Assert.assertTrue(loginPage.atPage(loginPageTitle));
        loginPage.enterEmail("GoTestEmail").enterPassword("123test").submitLoginForm();
        loginPage.waitUntilErrorMessageElementIsLoaded();
        Assert.assertTrue(loginPage.isErrorDisplayed());
    }

    @Test
    public void VerifyLogInToInboxPageWithInvalidEmail(){
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage();
        Assert.assertTrue(loginPage.atPage(loginPageTitle));
        loginPage.enterEmail("GoTestEmaill").enterPassword("1234test").submitLoginForm();
        loginPage.waitUntilErrorMessageElementIsLoaded();
        Assert.assertTrue(loginPage.isErrorDisplayed());
    }
    @Test
    public void VerifyRedirectToResetAccountPage(){
      LoginPage loginPage = new LoginPage();
      ResetAccountPage resetPage = new ResetAccountPage();
      loginPage.openLoginPage();
      Assert.assertTrue(loginPage.atPage(loginPageTitle));
      loginPage.goToResetPage();
      resetPage.waitUntilInputFieldIsVisible();
      Assert.assertTrue(resetPage.inputFieldLabelIsDisplayed());
    }

    @Test
    public void VerifySwitchLoginPageToEnglishLanguage(){
        LoginPage loginPage = new LoginPage();
        EnglishLoginPage englishPage = new EnglishLoginPage();
        loginPage.openLoginPage();
        Assert.assertTrue(loginPage.atPage(loginPageTitle));
        loginPage.goToEnglishPage();
        englishPage.waitUntilTitleIsPresent(englishLoginPageTitle);
        Assert.assertTrue(englishPage.isEnglishLanguageSelected());
    }
}
