package pages.callCenter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import pages.SElements;

import static com.codeborne.selenide.Selenide.$;

public class WaitingListPage extends AbstractPage implements SElements {
//    @FindBy(xpath = "//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']")
//    WebElement lpu;

    public WaitingListPage() {
    }

    public void waitingList() {
//        lpu.click();
        waitspec.click();
        waitbutton.click();
        complain.sendKeys("тест ожидания");
        oform.click();
    }
}
