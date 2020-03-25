package Pages;

import com.Utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait waiter;

    public BasePage(){
        driver = DriverManager.getInstance();
        waiter = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }


   public static final String LOGIN_PAGE_URL = "https://accounts.ukr.net/login";
   public static final String ENGLISH_LOGIN_PAGE_URL = "https://accounts.ukr.net/login";
   public static final String INBOX_PAGE_URL = "https://mail.ukr.net/desktop";
   public static final String RESET_ACCOUNT_URL = "https://accounts.ukr.net/recovery?client_id=9GLooZH9KjbBlWnuLkVX";
   public static final String RESET_CONFIRMATION_PAGE = "https://accounts.ukr.net/recovery/";

 }

