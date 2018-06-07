package pages.callDoctor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class RecordDoctorPage extends BasePage {
    public RecordDoctorPage(WebDriver driver) { super(driver); }
    public void recordDoctor() throws InterruptedException {
        driver.findElement(By.xpath("//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='spec-doc-list']/div[3]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(text(),'Ближайшая запись')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(text(),'13:00')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Записать на прием')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button")).click();
        Thread.sleep(2000);
    }
}
