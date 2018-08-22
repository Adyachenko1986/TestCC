package pages.callDoctor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class ApoinmentsPage extends AbstractPage {
    @FindBy(xpath = "//*[@id='direction-list-tab']")
    WebElement apo;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public ApoinmentsPage() {
    }

    public void apoinmets() throws InterruptedException {
        (js).executeScript("arguments[0].scrollIntoView();"
                , apo);
        apo.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='direction-list']/div/div[2]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='a7f391d4-d5d8-44d5-a770-f7b527bb123326f407bc-01c7-4e64-ae16-80ae909b1574']/td[6]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='day-doc-schedule']/div/div/div[2]/button[17]")).click();
        driver.findElement(By.xpath("//*[@id='record-to-doc-form']/div/div[2]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button")).click();
    }
}
