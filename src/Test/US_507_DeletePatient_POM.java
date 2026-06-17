package Test;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

public class US_507_DeletePatient_POM extends BaseDriver {


        @DataProvider
        Object[][] ValidData() {
            Object[][] Datas = {
                    {"admin", "Admin123"}
            };

            return Datas;
        }

        @Test(dataProvider = "ValidData")
        public void deletePatient(String username, String password) {
            PatientSystem elements = new PatientSystem();


            Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.username))).sendKeys(username);
           // Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.username))).sendKeys(username);
            logAdd.info("Username yazildi");
            Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.password))).sendKeys(password);
            logAdd.info("Password yazildi");
            Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.location))).click();
            logAdd.info("Location sechildi");
            Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.loginBtn))).click();
            logAdd.info("Login duymesi klik edildi");
            Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.msg))).getText();
            Assert.assertEquals(elements.msg.getText(),
                    "Logged in as Super User (admin) at Inpatient Ward.", "Title eyni deyil");
            logAdd.info("User login oldu");
            Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.findPatient))).click();

            Tools.wait(3);
            Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.searchBox))).clear();
            Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.searchBox))).sendKeys("Jo");
            logAdd.info("Axtarilan xeste melumati daxil edildi.");
            Tools.wait(3);
            Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.table))).getText();
            System.out.println(elements.table.getText());
            Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.raw1))).getText();
            String xeste = elements.raw1.getText().substring(0,6);
            System.out.println("Sechildi Xestenin ID-i: " + xeste);
            logAdd.info("Sechildi Xestenin ID-i: " + xeste);
            Tools.wait(3);

            Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.raw1))).click();
            logAdd.info("Xeste sechildi.");
            Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.DeletePatient))).click();
            Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.inputReason))).sendKeys("Just Delete");
            Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.confirmBtn))).click();
            logAdd.info("Sechildi xeste silindi.");
            Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.searchBox))).clear();
            Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.searchBox))).sendKeys(xeste);
            System.out.println("Silinen xestenin ID-i: " + xeste);
            logAdd.info("Silinen xestenin ID-i: ", xeste);
            wait.until(ExpectedConditions.visibilityOf(elements.assertDeletedPatient));
            Assert.assertEquals(elements.assertDeletedPatient.getText(), "No matching records found", "Eyni deyil");
        }
    }


