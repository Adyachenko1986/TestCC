package pages.callCenter;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.AbstractPage;
import pages.SElements;

import static com.codeborne.selenide.Selenide.$;

public class PatientRecordsPage extends AbstractPage implements SElements {
    String name2;
    String time2;
    String number2;


//    SelenideElement allrecord = $(By.xpath("//*[@id='all-patient-records-tab']"));
//    SelenideElement reschedule = $(By.xpath("//button[@title='Перенести запись']"));
//    SelenideElement recordDate = $(By.xpath("//*[@id='week-doc-schedule-table-body']/tr[2]/td[7]/button"));
//    SelenideElement recordTime = $(By.xpath("//*[@id='day-doc-schedule']/div/div/div[2]/button[17]"));
//    SelenideElement rerecord = $(By.xpath("//*[@id='record-to-doc-form']/div/div[2]/button"));
//    SelenideElement yes = $(By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button[2]"));
//    SelenideElement delete = $(By.xpath("//button[@title='Удалить запись']"));
//    SelenideElement talonNumber2 = $(By.xpath("//*[@id='talon-list']/tr/td[2]"));
//    SelenideElement docName2 = $(By.xpath("//*[@id='talon-list']/tr/td[4]"));
//    SelenideElement talonTime2 = $(By.xpath("//*[@id='talon-list']/tr/td[7]"));

    public PatientRecordsPage() {
    }

    public void patientRecords() {
        allrecord.click();
        name2 = docName2.getText();
        time2 = talonTime2.getAttribute("innerHTML");
        number2 = talonNumber2.getAttribute("innerHTML");
        System.out.println(name2 + " " + time2 + " " + number2);
//        System.out.println(name + " " + time + " " + number);

        //asserts();
//        workRecord();
//        deleteRecord();
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
        //driver.findElement(B y $.By.xpath("//button[@title='Удалить запись']")).click();
        //Thread.sleep(2000);
        //driver.findElement(B y $.By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button[2]")).click();
        //wait.until(ExpectedConditions.elementToBeClickable(delete));
        delete.click();
        yes.click();
    }

    public void asserts() {

    }
}