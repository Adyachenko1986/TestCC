package pages.callCenter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import pages.SElements;

import java.io.IOException;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;
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
//    @FindBy(xpath = "//*[@id='ccIngoModalCont']/dl/dd[3]")
//    WebElement docName;
//    @FindBy(xpath = "//*[@id='ccIngoModalCont']/dl/dd[6]")
//    WebElement talonTime;
//    @FindBy(xpath = "//*[@id='ccIngoModalCont']/dl/dd[7]")
//    WebElement talonNumber;

    public RecordDoctorPage() {
    }

    public void recordDoctor() {
//        lpu.click();
        spec.click();
        dayz.click();
        timerec.click();
        recordbutton.click();

//        String name = docName.getText();
//        String time = talonTime.getText();
//        String number = talonNumber.getAttribute("innerHTML");
//        System.out.println(name + " " + time + " " + number);
        closemodal.click();
    }

    public void assertDoc(String lpu, String special, String fioDoc, String kab, String date, String time, String ticketNumber) {

        String eq1 = lpuName.getText();
        String eq2 = specName.getText();
        String eq3 = doctor.getText();
        String eq4 = kabName.getText();
        String eq5 = dateTicket.getText();
        String eq6 = timeTicket.getText();
        String eq7 = numTicket.getText();

        System.out.println("Код гавно2");

        assertTrue(lpu.contains(eq1));
        System.out.println(eq1+" есть");
        assertTrue(special.contains(eq2));
        System.out.println(eq2+" есть");
        assertTrue(fioDoc.contains(eq3));
        System.out.println(eq3+" есть");
        assertTrue(kab.contains(eq4));
        System.out.println(eq4+" есть");
        assertTrue(date.contains(eq5));
        System.out.println(eq5+" есть");
        assertTrue(time.contains(eq6));
        System.out.println(eq6+" есть");
        assertTrue(ticketNumber.contains(eq7));
        System.out.println(eq7+" есть");
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
