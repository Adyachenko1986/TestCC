package pages.callDoctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class PatientRecordsPage extends BasePage {
    @FindBy(xpath = "//*[@id='all-patient-records-tab']")
    WebElement allrecord;
    @FindBy(xpath = "//button[@title='Перенести запись']")
    WebElement reschedule;
    @FindBy(xpath = "//*[@id='week-doc-schedule-table-body']/tr[2]/td[7]/button")
    WebElement recordDate;
    @FindBy(xpath = "//*[@id='day-doc-schedule']/div/div/div[2]/button[17]")
    WebElement recordTime;
    @FindBy(xpath = "//*[@id='record-to-doc-form']/div/div[2]/button")
    WebElement rerecord;
    @FindBy(xpath = "//*[@id='ccInfoModal']/div/div/div[3]/button[2]")
    WebElement yes;
    @FindBy(xpath = "//button[@title='Удалить запись']")
    WebElement delete;
    @FindBy(xpath = "//*[@id='talon-list']/tr/td[2]")
    WebElement talonNumber2;

    @FindBy(xpath = "//*[@id='talon-list']/tr/td[4]")
    WebElement docName2;
    @FindBy(xpath = "//*[@id='talon-list']/tr/td[7]")
    WebElement talonTime2;

    public PatientRecordsPage(WebDriver driver) {
        super(driver);
    }

    public void patientRecords() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(allrecord));
        allrecord.click();
        Thread.sleep(1000);
        name2 = docName2.getText();
        time2 = talonTime2.getAttribute("innerHTML");

        number2 = talonNumber2.getAttribute("innerHTML");
        System.out.println(name2 + " " + time2 + " " + number2);
        System.out.println(name + " " + time + " " + number);


        //asserts();
        workRecord();
        deleteRecord();
    }

    public void workRecord() {
        wait.until(ExpectedConditions.elementToBeClickable(reschedule));
        reschedule.click();
        wait.until(ExpectedConditions.elementToBeClickable(recordDate));
        recordDate.click();
        wait.until(ExpectedConditions.elementToBeClickable(recordTime));
        recordTime.click();
        rerecord.click();
    }

    public void deleteRecord() throws InterruptedException {
        //WebElement element = delete;
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000);
        //driver.findElement(By.xpath("//button[@title='Удалить запись']")).click();
        //Thread.sleep(2000);
        //driver.findElement(By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button[2]")).click();
        //wait.until(ExpectedConditions.elementToBeClickable(delete));
        delete.click();
        wait.until(ExpectedConditions.elementToBeClickable(yes));
        yes.click();
    }

    public void asserts() {

    }


}
