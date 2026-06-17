package Utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.awt.*;
import java.time.Duration;

public class BaseDriver {



        public static WebDriver driver;
        public static WebDriverWait wait;
        public static Logger logAdd = LogManager.getLogger();

        @BeforeClass
        public void Bashlangic() throws InterruptedException, AWTException {
            logAdd.info("Loglama bashladildi");

            driver = new ChromeDriver();
            logAdd.info("Driver bashladildi");

            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.manage().window().maximize();

            Login();
        }

        @AfterClass
        public void Baglanish() {
            Tools.wait(3);
            driver.quit();
            logAdd.info("Browserden chixish edildi");
        }

        public void Login() throws AWTException, InterruptedException {
            driver.get("https://o2.openmrs.org/");
            logAdd.info("Hompage-e gedildi");

        }
    }
