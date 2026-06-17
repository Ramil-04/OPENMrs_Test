package Test;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

public class US_508_ListingPatient_POM extends BaseDriver {


    @DataProvider
    Object[][] ValidData() {
        Object[][] Datas = {
                {"admin", "Admin123"}
        };

        return Datas;
    }

    @Test(dataProvider = "ValidData")
    public void ListingPatient(String username, String password) {
        PatientSystem elements = new PatientSystem();
        Actions act = new Actions(BaseDriver.driver);


        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.username))).sendKeys(username);
        logAdd.info("Username yazildi");
        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.password))).sendKeys(password);
        logAdd.info("Password yazildi");
        Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.location))).click();
        logAdd.info("Locatioin sechildi");
        Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.loginBtn))).click();
        logAdd.info("Login duymesi klik edildi");
        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.msg))).getText();
        Assert.assertEquals(elements.msg.getText(),
                "Logged in as Super User (admin) at Inpatient Ward.", "Title eyni deyil");
        logAdd.info("User login oldu");
        Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.findPatient))).click();

        Tools.wait(3);
        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.searchBox))).clear();
        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.searchBox))).sendKeys("10");
        logAdd.info("Butun xesteler uchun ID nomresi 10 daxil edildi.");
        Tools.wait(3);

        act.scrollToElement(elements.lastPage);
        Tools.wait(3);
        Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.lastPage))).click();
      Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.PatientCount))).getText();
        logAdd.info("Xeste sayi melumati alindi");
        System.out.println("Butun xestelerin sayi : "+elements.PatientCount.getText());

    }
}

