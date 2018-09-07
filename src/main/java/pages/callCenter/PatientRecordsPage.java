package pages.callCenter;
import pages.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.AbstractPage;
import pages.SElements;

import static com.codeborne.selenide.Selenide.*;

public class PatientRecordsPage extends AbstractPage implements SElements {
    String name2;
    String time2;
    String number2;

    public PatientRecordsPage() {
    }

    public void patientRecords() {
        allrecord.click();
        name2 = docName2.getText();
        time2 = talonTime2.getAttribute("innerHTML");
        number2 = talonNumber2.getAttribute("innerHTML");
        System.out.println(name2 + " " + time2 + " " + number2);

    }

    public void workRecord() {
        reschedule.click();
        recordDate.click();
        recordTime.click();
        rerecord.click();
    }

    public void deleteRecord() throws InterruptedException {
        System.out.println("Поехале");
        open("http://call.emias.mosreg.ru/");
        log.val("ccg");
        pass.val("ccg123");
        loginButton.click();
        open(url);
        polis.val("45 558320");
        find.click();
        Thread.sleep(5000);
        allrecord.click();
        delete.click();
        yes.click();
        close();
    }

    public void asserts() {

    }
}