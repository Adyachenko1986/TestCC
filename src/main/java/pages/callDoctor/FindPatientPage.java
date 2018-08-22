package pages.callDoctor;

import org.openqa.selenium.By;
import pages.BasePage;


public class FindPatientPage extends BasePage {

    public FindPatientPage() {
    }

    String snpol = "45 558320";

    public void findPatient() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.name("snPol")).sendKeys(snpol);
        driver.findElement(By.xpath("//button[@id='search-patient']")).click();
        //Thread.sleep(2000);
    }
}
