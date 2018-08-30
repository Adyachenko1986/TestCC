package pages.callCenter;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import pages.SElements;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
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

    public void recordDoctor(String arg0) {
//        lpu.click();
//        spec.click();
//        dayz.click();
        String lp="Стенд ЕМИАС МО";
        String sp="Терапия";
        changeLpu(lp);
        changeSpec(sp);
        changeDoc(arg0);
        timerec.click();
        recordbutton.click();

//        String name = docName.getText();
//        String time = talonTime.getText();
//        String number = talonNumber.getAttribute("innerHTML");
//        System.out.println(name + " " + time + " " + number);
//        closemodal.click();
    }

    public void assertDoc(String lpu, String special, String fioDoc, String kab) {

        String eq1 = lpuName.getText();
        String eq2 = specName.getText();
        String eq3 = doctor.getText();
        String eq4 = kabName.getText();
        String eq5 = dateTicket.getText();
        String eq6 = timeTicket.getText();
        String eq7 = numTicket.getText();

        System.out.println("Код гавно2");

        System.out.println("текст в lpu и eq1 = "+lpu+" и "+eq1);

        System.out.println("ЗБС");

        assertTrue(lpu.contains(eq1));
        System.out.println(eq1+" есть");
        assertTrue(special.contains(eq2));
        System.out.println(eq2+" есть");
        assertTrue(fioDoc.contains(eq3));
        System.out.println(eq3+" есть");
        assertTrue(kab.contains(eq4));
        System.out.println(eq4+" есть");
        assertTrue(eq5 != null);
        System.out.println(eq5+" есть");
        assertTrue(eq6 != null);
        System.out.println(eq6+" есть");
        assertTrue(eq7 != null);
        System.out.println(eq7+" есть");
    }

    public void EqualDoc() {

        String eq1 = lpuName.getText();
        String eq2 = specName.getText();
        String eq3 = doctor.getText();
        String eq4 = kabName.getText();
        String eq5 = dateTicket.getText();
        String eq6 = timeTicket.getText();
        String eq7 = numTicket.getText();

        String equal7 = $(By.xpath("//*[@id='talon-list']/tr/td[2]")).getText();
        String equal2 = $(By.xpath("//*[@id='talon-list']/tr/td[4]")).getText();
        String equal3 = $(By.xpath("//*[@id='talon-list']/tr/td[3]")).getText();
        String equal6 = $(By.xpath("//*[@id='talon-list']/tr/td[7]")).getText();
        String istok = $(By.xpath("//*[@id='talon-list']/tr/td[5]")).getText();
        String equal5 = $(By.xpath("//*[@id='talon-list']/tr/td[6]")).getText();
//        String equal8 = $(By.xpath("//*[@id='talon-list']/tr/td[2]")).getText();

        System.out.println("Код гавно2");

//        assertTrue(equal.contains(eq1));
//        System.out.println(eq1+" есть");
        assertTrue(equal2.contains(eq2));
        System.out.println(eq2+" есть");
        assertTrue(equal3.contains(eq3));
        System.out.println(eq3+" есть");
//        assertTrue(kab.contains(eq4));
//        System.out.println(eq4+" есть");
        assertTrue(equal5.contains(eq5));
        System.out.println(eq5+" есть");
        assertTrue(equal6.contains(eq6));
        System.out.println(eq6+" есть");
        assertTrue(equal7.contains(eq7));
        System.out.println(eq7+" есть");
        assertTrue(istok.contains("Колл-центр"));
    }

    public void EqualDetal() {

        String eq1 = lpuName.getText();

        String equal8 = $(By.xpath("//*[@id='talon-list']/tr/td[1]/div/ul/li/div/h4")).getText();
        String equal9 = $(By.xpath("//*[@id='talon-list']/tr/td[1]/div/ul/li/div/p[4]")).getText();
        String istok = $(By.xpath("//*[@id='talon-list']/tr/td[5]")).getText();

        System.out.println("Код гавно3");

        assertTrue(istok.contains("Колл-центр"));
        assertTrue(equal8.contains(eq1));
        System.out.println(eq1+" есть");
        assertTrue(istok.contains(equal9));
        System.out.println(" есть");
    }

    public void changeLpu(String arg0){

        SelenideElement lpu = $(By.xpath("//button[contains(.,'"+arg0+"')]"));
        lpu.click();
    }

    public void changeSpec(String arg0){

        SelenideElement spec = $(By.xpath("//button[@data-department-name='"+arg0+"']"));
        spec.click();
    }

    public void changeDoc(String arg0){

        SelenideElement fastDoc = $(By.xpath("//tr[contains(.,'"+arg0+"')]//button[@class='btn btn-little btn-block btn-success']"));
//        SelenideElement fastDoc = $(By.xpath("//*[@id='a7f391d4-d5d8-44d5-a770-f7b527bb12330b58bf2f-b6ff-423e-bff8-018953417c50']//td[contains(.,'Ближайшая запись')]")); //$(By.xpath("//td[contains(.,'"+arg0+"')]")).
        //*[@id="a7f391d4-d5d8-44d5-a770-f7b527bb12330b58bf2f-b6ff-423e-bff8-018953417c50"]
        fastDoc.click();
    }

    public void createNewCall(String arg0) throws IOException {
        SelenideElement lpu = $(By.xpath("//button[contains(.,'Стенд ЕМИАС МО')]"));
        lpu.click();
        SelenideElement spec = $(By.xpath("//button[@data-department-name='Терапия']"));
        spec.click();
        SelenideElement fastDoc = $(By.xpath("//tr[contains(.,'"+arg0+"')]//button[@class='btn btn-little btn-block btn-success']"));
        fastDoc.click();
        timerec.click();
        recordbutton.click();

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
