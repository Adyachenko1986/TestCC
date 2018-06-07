package pages.callDoctor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;


public class FindPatientPage extends BasePage {
    public FindPatientPage(WebDriver driver) { super(driver); }
    public void findPatient() {
        driver.findElement(By.name("snPol")).sendKeys("38-09 560219");
        driver.findElement(By.xpath("//button[@id='search-patient']")).click();
        //Thread.sleep(2000);
    }
}
