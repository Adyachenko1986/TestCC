package pages.callCenter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;


public class RecordDoctorPage extends BasePage {
    @FindBy(xpath = "//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']")
    WebElement lpu;
    @FindBy(xpath = "//div[@id='department-11400']")
    WebElement special;
    @FindBy(xpath = "//*[contains(text(),'Ближайшая запись')]")
    WebElement docDate;
    @FindBy(xpath = "//*[contains(text(),'13:00')]")
    WebElement docTime;
    @FindBy(xpath = "//*[contains(text(),'Записать на прием')]")
    WebElement record;
    @FindBy(xpath = "//*[@id='ccInfoModal']/div/div/div[3]/button")
    WebElement close;
    @FindBy(xpath = "//*[@id='ccIngoModalCont']/dl/dd[3]")
    WebElement docName;
    @FindBy(xpath = "//*[@id='ccIngoModalCont']/dl/dd[6]")
    WebElement talonTime;
    @FindBy(xpath = "//*[@id='ccIngoModalCont']/dl/dd[7]")
    WebElement talonNumber;

    public RecordDoctorPage() {
    }

    public void recordDoctor() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(lpu));
        lpu.click();
        wait.until(ExpectedConditions.elementToBeClickable(special));
        special.click();
        wait.until(ExpectedConditions.elementToBeClickable(docDate));
        docDate.click();
        wait.until(ExpectedConditions.elementToBeClickable(docTime));
        docTime.click();
        record.click();
        wait.until(ExpectedConditions.elementToBeClickable(close));
        name = docName.getText();
        time = talonTime.getText();
        number = talonNumber.getAttribute("innerHTML");
        System.out.println(name + " " + time + " " + number);
        close.click();

    }
}
