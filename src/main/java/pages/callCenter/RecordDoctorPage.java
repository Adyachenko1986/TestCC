package pages.callCenter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import pages.SElements;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
//import pages.callCenter.connections.Setup;


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

    public void recordDoctor() {
//        lpu.click();
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

    public void createNewCall(String profile, String nameGen, String searchPolis) throws IOException {
//        File reader = new File("src\\main\\java\\pages\\callCenter\\profiles\\" + profile + ".json");
//        Map<String, String> proData = new ObjectMapper().readValue(reader, Map.class);
//        if (searchPolis.equals("n")) {
//            recordDoctor()
//                    .lpuName(proData)
//                    .adress(proData)
//                    .vozrastKat(proData)
//                    .birthDay(proData)
//                    .adressAddition(proData)
//                    .sex(proData)
//                    .complaint(proData)
//                    .polis(proData)
//                    .FIO(nameGen, proData)
//                    .caller(nameGen, proData)
//                    .telephone(proData)
//                    .saveBtn()
//                    .adressAlarma(proData);
//        }
    }

//    public RecordDoctorPage verifyCallProfile1(String profile, String nameGen) throws IOException {
//        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
//        Map proData = new ObjectMapper().readValue(reader, Map.class);
//        System.out.println("Корректность данных на странице редактирования выполнена! " + driver.getCurrentUrl());
//        return this;
//    }
}
