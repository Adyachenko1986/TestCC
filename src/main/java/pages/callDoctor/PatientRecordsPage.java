package pages.callDoctor;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import org.openqa.selenium.By;

public class PatientRecordsPage extends BasePage {
    public PatientRecordsPage(WebDriver driver) {super(driver);}
    public void patientRecords() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='all-patient-records-tab']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@title='Перенести запись']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='week-doc-schedule-table-body']/tr[2]/td[7]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='day-doc-schedule']/div/div/div[2]/button[17]")).click();
        driver.findElement(By.xpath("//*[@id='record-to-doc-form']/div/div[2]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@title='Удалить запись']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@title='Удалить запись']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button[2]")).click();
        // webDriver.findElement(By.xpath ("//button[@id='search-patient']")).click();
    }
}
