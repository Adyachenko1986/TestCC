package pages.callDoctor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class WaitingListPage extends BasePage {
    @FindBy(xpath = "//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']")
    WebElement lpu;

    public WaitingListPage() {
    }

    public void waitingList() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(lpu));
        lpu.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='department-12202'")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(text(),'Записать в лист ожидания')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='complain']")).sendKeys("тест ожидания");
        driver.findElement(By.xpath("//*[contains(text(),'Оформить')]")).click();
    }
}
