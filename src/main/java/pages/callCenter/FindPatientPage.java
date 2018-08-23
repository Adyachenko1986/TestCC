package pages.callCenter;

import org.openqa.selenium.By;
import pages.AbstractPage;

import static com.codeborne.selenide.Selenide.$;


public class FindPatientPage extends AbstractPage {

    public FindPatientPage() {
    }

    String snpol = "45 558320";

    public void findPatient() throws InterruptedException {
        Thread.sleep(1000);
        $(By.name("snPol")).sendKeys(snpol);
        $(By.xpath("//button[@id='search-patient']")).click();
        //Thread.sleep(2000);
    }
}
