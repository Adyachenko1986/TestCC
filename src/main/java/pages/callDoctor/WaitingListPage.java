package pages.callDoctor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class WaitingListPage extends BasePage {
    public WaitingListPage(WebDriver driver) {super(driver);}
    public void waitingList() throws InterruptedException {
        driver.findElement(By.xpath("//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='spec-doc-list']/div[4]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(text(),'Записать в лист ожидания')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='complain']")).sendKeys("тест ожидания");
        driver.findElement(By.xpath("//*[contains(text(),'Оформить')]")).click();
    }
}
