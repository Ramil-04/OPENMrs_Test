package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Tools {
    public static void wait (int sn){
        try {
            Thread.sleep(sn * 1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public static void SuccessMsgValidation(){
        WebElement msgSuccess = BaseDriver.driver.findElement
                (By.xpath("//*[@class='alert alert-success alert-dismissible']"));
        //alert alert-success alert-dismissible
        Assert.assertTrue(msgSuccess.getText().toLowerCase().contains("success"));
    }
}

