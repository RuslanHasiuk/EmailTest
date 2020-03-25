package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InboxPage extends Pages.BasePage {

    By composeButton = By.xpath("//button[@class=\"default compose\"]");

    public InboxPage openInboxPage(){
        driver.get(INBOX_PAGE_URL);
        return new InboxPage();
    }

    public void waitUntilInboxPageIsLoaded(){
        waiter.until(ExpectedConditions.visibilityOfElementLocated(composeButton));
    }
    public boolean atPage(String title){
        return driver.getTitle().equals(title);
    }
}
