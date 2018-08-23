package pages.callCenter;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class PatientRecordsPage extends AbstractPage {
    String name2;
    String time2;
    String number2;

    @FindBy(xpath = "//*[@id='all-patient-records-tab']")
    SelenideElement allrecord;
    @FindBy(xpath = "//button[@title='Перенести запись']")
    SelenideElement reschedule;
    @FindBy(xpath = "//*[@id='week-doc-schedule-table-body']/tr[2]/td[7]/button")
    SelenideElement recordDate;
    @FindBy(xpath = "//*[@id='day-doc-schedule']/div/div/div[2]/button[17]")
    SelenideElement recordTime;
    @FindBy(xpath = "//*[@id='record-to-doc-form']/div/div[2]/button")
    SelenideElement rerecord;
    @FindBy(xpath = "//*[@id='ccInfoModal']/div/div/div[3]/button[2]")
    SelenideElement yes;
    @FindBy(xpath = "//button[@title='Удалить запись']")
    SelenideElement delete;
    @FindBy(xpath = "//*[@id='talon-list']/tr/td[2]")
    SelenideElement talonNumber2;

    @FindBy(xpath = "//*[@id='talon-list']/tr/td[4]")
    SelenideElement docName2;
    @FindBy(xpath = "//*[@id='talon-list']/tr/td[7]")
    SelenideElement talonTime2;

    public PatientRecordsPage() {
    }

    public void patientRecords() throws InterruptedException {
        allrecord.click();
        Thread.sleep(1000);
        name2 = docName2.getText();
        time2 = talonTime2.getAttribute("innerHTML");

        number2 = talonNumber2.getAttribute("innerHTML");
        System.out.println(name2 + " " + time2 + " " + number2);
//        System.out.println(name + " " + time + " " + number);

        //asserts();
        workRecord();
        deleteRecord();
    }

    public void workRecord() {
        reschedule.click();
        recordDate.click();
        recordTime.click();
        rerecord.click();
    }

    public void deleteRecord() throws InterruptedException {
        //SelenideElement element = delete;
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000);
        //driver.findElement(By.xpath("//button[@title='Удалить запись']")).click();
        //Thread.sleep(2000);
        //driver.findElement(By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button[2]")).click();
        //wait.until(ExpectedConditions.elementToBeClickable(delete));
        delete.click();
        yes.click();
    }

    public void asserts() {

    }
}