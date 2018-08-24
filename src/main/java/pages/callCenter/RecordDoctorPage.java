package pages.callCenter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractPage;
import pages.SElements;


public class RecordDoctorPage extends AbstractPage implements SElements {
//    @FindBy(xpath = "//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']")
//    WebElement lpu;
//    @FindBy(xpath = "//div[@id='department-11400']")
//    WebElement special;
//    @FindBy(xpath = "//*[contains(text(),'Ближайшая запись')]")
//    WebElement docDate;
//    @FindBy(xpath = "//*[contains(text(),'13:00')]")
//    WebElement docTime;
//    @FindBy(xpath = "//*[contains(text(),'Записать на прием')]")
//    WebElement record;
//    @FindBy(xpath = "//*[@id='ccInfoModal']/div/div/div[3]/button")
//    WebElement close;
    @FindBy(xpath = "//*[@id='ccIngoModalCont']/dl/dd[3]")
    WebElement docName;
    @FindBy(xpath = "//*[@id='ccIngoModalCont']/dl/dd[6]")
    WebElement talonTime;
    @FindBy(xpath = "//*[@id='ccIngoModalCont']/dl/dd[7]")
    WebElement talonNumber;

    public RecordDoctorPage() {
    }

    public void recordDoctor()  {
        lpu.click();
        spec.click();
        dayz.click();
        timerec.click();
        recordbutton.click();

        String name = docName.getText();
        String time = talonTime.getText();
        String number = talonNumber.getAttribute("innerHTML");
        System.out.println(name + " " + time + " " + number);
        closemodal.click();
    }
}
