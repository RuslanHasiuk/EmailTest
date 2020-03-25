package com.Tests;

import com.Utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
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

}
