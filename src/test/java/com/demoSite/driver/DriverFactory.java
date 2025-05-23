package com.demoSite.driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static WebDriver driver;

    private DriverFactory(){}

    public static WebDriver getDriver(){
        if (driver == null){
            driver = new ChromeDriver();
            driver.manage().window().setSize(new Dimension(1280, 720));
        }
        return driver;
    }


    public static void killDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

    
}
