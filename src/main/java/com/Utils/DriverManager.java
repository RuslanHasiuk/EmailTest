package com.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private static WebDriver webDriver;

    private DriverManager() {
    }

    public static WebDriver getInstance() {
        if (webDriver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            webDriver = new ChromeDriver(options);
        }
        return webDriver;
    }

    public static void close() {
     //   Log.info("Close driver");
        if (webDriver != null) {
            webDriver.close();
            webDriver.quit();
            webDriver = null;
        } else {
            throw new RuntimeException("Error : Driver do not exist.");
        }
    }
}
