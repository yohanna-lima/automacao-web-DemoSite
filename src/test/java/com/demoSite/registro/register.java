package com.demoSite.registro;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.cdimascio.dotenv.Dotenv;

public class register {
    private components components;
    private WebDriver driver;
    private Dotenv dotenv;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get(dotenv.get("LINK_REGISTER_PAGE"));
        // Assert.assertEquals(pageTitle, "Automation Demo Site");
    }

    @Test
    public void registerMandatoryFields() {       
        components.mandatoryFields("Yohanna", "Lima");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }   
}
