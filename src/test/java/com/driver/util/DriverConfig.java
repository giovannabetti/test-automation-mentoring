package com.driver.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverConfig {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if ( driver == null ) {

            System.setProperty("webdriver.chrome.driver", "/home/giovannabetti/Documents/chromedriver-linux64/chromedriver");
            ChromeOptions opt = new ChromeOptions();
            opt.setBinary("/opt/google/chrome-beta/google-chrome-beta");
            driver = new ChromeDriver(opt);

        }

        return driver;

    }
}
