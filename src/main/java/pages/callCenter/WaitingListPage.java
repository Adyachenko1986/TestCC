package pages.callCenter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

import static com.codeborne.selenide.Selenide.$;

public class WaitingListPage extends AbstractPage {
    @FindBy(xpath = "//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']")
    WebElement lpu;

    public WaitingListPage() {
    }

    public void waitingList() throws InterruptedException {
        lpu.click();
        Thread.sleep(2000);
        $(By.xpath("//div[@id='department-12202'")).click();
        Thread.sleep(2000);
        $(By.xpath("//*[contains(text(),'Записать в лист ожидания')]")).click();
        Thread.sleep(2000);
        $(By.xpath("//*[@id='complain']")).sendKeys("тест ожидания");
        $(By.xpath("//*[contains(text(),'Оформить')]")).click();
    }
}
