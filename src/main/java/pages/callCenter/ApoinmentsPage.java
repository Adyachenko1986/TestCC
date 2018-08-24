package pages.callCenter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import pages.SElements;

import static com.codeborne.selenide.Selenide.$;

public class ApoinmentsPage extends AbstractPage implements SElements {
//    @FindBy(xpath = "//*[@id='direction-list-tab']")
//    WebElement apo;
//    JavascriptExecutor js = (JavascriptExecutor) driver;

    public ApoinmentsPage() {
    }

    public void apoinmets() throws InterruptedException {
//        (js).executeScript("arguments[0].scrollIntoView();"
//                , apo);
        apoinmentsList.click();
//        apoinment.click();
        apoLpu.click();
        $(By.xpath("//*[@id='day-doc-schedule']/div/div/div[2]/button[17]")).click();
        $(By.xpath("//*[@id='record-to-doc-form']/div/div[2]/button")).click();
        closemodal.click();
    }
}
