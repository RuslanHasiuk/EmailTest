package com.tests;

import com.model.Credentials;
import com.model.UserCreds;
import com.pages.EnglishLoginPage;
import com.pages.InboxPage;
import com.pages.LoginPage;
import com.pages.ResetAccountPage;
import com.utils.CustomJsonParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class LoginPageTests extends BaseTest {

    @Test
    public void VerifyLogInToInboxPageWithValidCredentials() {
        LoginPage loginPage = new LoginPage();
        InboxPage inboxPage = new InboxPage();
        loginPage.openLoginPage();
        Assert.assertTrue(loginPage.atPage(loginPageTitle));
        Credentials validCreds = userCreds.getUserCredentials().get(0);
        loginPage.enterEmail(validCreds.getEmail()).enterPassword(validCreds.getPassword()).submitLoginForm();
        inboxPage.waitUntilInboxPageIsLoaded();
        Assert.assertTrue(inboxPage.atPage(inboxPageTitle));
    }

    @Test
    public void VerifyLogInToInboxPageWithInvalidPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage();
        Assert.assertTrue(loginPage.atPage(loginPageTitle));
        Credentials validCreds = userCreds.getUserCredentials().get(1);
        loginPage.enterEmail(validCreds.getEmail()).enterPassword(validCreds.getPassword()).submitLoginForm();
        loginPage.waitUntilErrorMessageElementIsLoaded();
        Assert.assertTrue(loginPage.isErrorAboutInvaliCredsDisplayed());
    }

    @Test
    public void VerifyLogInToInboxPageWithInvalidEmail() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage();
        Assert.assertTrue(loginPage.atPage(loginPageTitle));
        Credentials validCreds = userCreds.getUserCredentials().get(2);
        loginPage.enterEmail(validCreds.getEmail()).enterPassword(validCreds.getPassword()).submitLoginForm();
        loginPage.waitUntilErrorMessageElementIsLoaded();
        Assert.assertTrue(loginPage.isErrorAboutInvaliCredsDisplayed());
    }

    @Test
    public void VerifyLogInToInboxPageWitEmptyEmail() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage();
        Assert.assertTrue(loginPage.atPage(loginPageTitle));
        Credentials validCreds = userCreds.getUserCredentials().get(3);
        loginPage.enterEmail(validCreds.getEmail()).enterPassword(validCreds.getPassword()).submitLoginForm();
        Assert.assertTrue(loginPage.isErrorAboutEmptyEmailFieldDisplayed());
    }

    @Test
    public void VerifyLogInToInboxPageWitEmptyPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage();
        Assert.assertTrue(loginPage.atPage(loginPageTitle));
        Credentials validCreds = userCreds.getUserCredentials().get(4);
        loginPage.enterEmail(validCreds.getEmail()).enterPassword(validCreds.getPassword()).submitLoginForm();
        Assert.assertTrue(loginPage.isErrorAboutEmptyPasswordFieldDisplayed());
    }

    @Test
    public void VerifySubmitLoginPageWithEnterKey (){
        LoginPage loginPage = new LoginPage();
        InboxPage inboxPage = new InboxPage();
        Credentials validCreds = userCreds.getUserCredentials().get(0);
        loginPage.openLoginPage();
        Assert.assertTrue(loginPage.atPage(loginPageTitle));
        loginPage.enterEmail(validCreds.getEmail()).enterPassword(validCreds.getPassword()).submitWithEnterKey();
        inboxPage.waitUntilInboxPageIsLoaded();
        Assert.assertTrue(inboxPage.atPage(inboxPageTitle));
    }

    @Test
    public void VerifyRedirectToResetAccountPage() {
        LoginPage loginPage = new LoginPage();
        ResetAccountPage resetPage = new ResetAccountPage();
        loginPage.openLoginPage();
        Assert.assertTrue(loginPage.atPage(loginPageTitle));
        loginPage.goToResetPage();
        resetPage.waitUntilInputFieldIsVisible();
        Assert.assertTrue(resetPage.inputFieldLabelIsDisplayed());
    }

    @Test
    public void VerifySwitchLoginPageToEnglishLanguage() {
        LoginPage loginPage = new LoginPage();
        EnglishLoginPage englishPage = new EnglishLoginPage();
        loginPage.openLoginPage();
        Assert.assertTrue(loginPage.atPage(loginPageTitle));
        loginPage.goToEnglishPage();
        englishPage.waitUntilTitleIsPresent(englishLoginPageTitle);
        Assert.assertTrue(englishPage.isEnglishLanguageSelected());
    }

}
