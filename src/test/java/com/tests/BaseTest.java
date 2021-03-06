package com.tests;

import com.utils.DriverManager;
import com.model.Credentials;
import com.model.UserCreds;
import com.utils.CustomJsonParser;
import org.testng.annotations.*;

import java.io.FileNotFoundException;

public class BaseTest {
    protected UserCreds userCreds;
    protected String loginPageTitle = "Пошта @ ukr.net - українська електронна пошта • Створи емейл";
    protected String englishLoginPageTitle = "Mail @ ukr.net - ukrainian electronic mail • Create email";
    protected String inboxPageTitle = "Вхідні • gotestemail@ukr.net";
    protected String resetAccountPageTitle = "Відновлення доступу до поштової скриньки";

    @BeforeMethod
    public void setUp (){
        DriverManager.getInstance();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.close();
    }

    @BeforeSuite
    public void parseUserCredentials () throws FileNotFoundException {
        userCreds=CustomJsonParser.parseUserCreds();
    }

}
