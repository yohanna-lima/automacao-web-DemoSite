package com.demoSite.registro;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.demoSite.driver.DriverFactory;
import static com.demoSite.driver.DriverFactory.getDriver;

import io.github.cdimascio.dotenv.Dotenv;

public class RegisterTest {
    private Components fields;
    private Dotenv dotenv;
    private TestInfo testInfo;

    @BeforeEach
    public void init(TestInfo testInfo) {
        this.testInfo = testInfo;
    }
    
    @BeforeEach
    public void setup() {
        // Carregando as váriaveis do arquivo .env
        dotenv = Dotenv.load();
        // Instanciando a classe Components
        fields = new Components();
        // Abrindo o link definido no arquivo .env
        getDriver().get(dotenv.get("LINK_REGISTER_PAGE"));
        // Verificando se o título da página está correto
        fields.validatePageTitle("Automation Demo Site");
        // Espera implícita de 30seg para encontrar elementos na página
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void registerMandatoryFields() { 
        fields.mandatoryFields("Yohanna", "Lima");
    }

    @AfterEach
    public void tearDown() throws IOException {
        // Tirando screenshot
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        File file = screenshot.getScreenshotAs(OutputType.FILE);

        // Obtendo o nome do método de teste
        String testName = testInfo.getTestMethod().get().getName();
        
        // Salvando o screenshot com o nome do teste
        FileUtils.copyFile(file, new File(testName+".jpg"));

        // Finalizando o driver
        DriverFactory.killDriver();
    }   
}
