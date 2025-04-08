package com.demoSite.registro;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.demoSite.driver.DriverFactory.getDriver;

public class Components {

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/h1")
    private WebElement pageTitle;
    
    // Campos obrigatórios
    @FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")
    private WebElement fieldFirstName;
    @FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")
    private WebElement fieldLastName;
    // @FindBy(xpath = "")
    // private WebElement fieldEmailAddress;
    // @FindBy(xpath = "")
    // private WebElement fieldPhone;
    // @FindBy(xpath = "")
    // private WebElement fieldGenderM;
    // @FindBy(xpath = "")
    // private WebElement fieldGenderF;
    // @FindBy(xpath = "")
    // private WebElement fieldCountry;

    // Campos opcionais
    // @FindBy(xpath = "")
    // private WebElement fieldAddress;
    // @FindBy(xpath = "")
    // private WebElement fieldHobbies;
    // @FindBy(xpath = "")
    // private WebElement fieldLanguages;
    // @FindBy(xpath = "")
    // private WebElement fieldSkills;
    // @FindBy(xpath = "")
    // private WebElement fieldSelectCountry;
    // @FindBy(xpath = "")
    // private WebElement fieldDateOfBirth;
    // @FindBy(xpath = "")
    // private WebElement fieldPassword;
    // @FindBy(xpath = "")
    // private WebElement fieldConfirmPassword;
    // @FindBy()
    // private WebElement fieldPhoto;

    // Métodos para interagir com os componentes
    
    public Components() {
        PageFactory.initElements(getDriver(), this);
    }

    public void validatePageTitle(String expectedTitle) {
        String actual = pageTitle.getText();
        Assertions.assertEquals(expectedTitle, actual, "O título exibido na página está incorreto!");
    }
    
    public void mandatoryFields(String firstName, String lastName) {
        fieldFirstName.sendKeys(firstName);
        fieldLastName.sendKeys(lastName);

    }

}