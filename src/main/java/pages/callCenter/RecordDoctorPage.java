package pages.callCenter;;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import pages.AbstractPage;
import pages.SElements;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

import static org.assertj.core.api.Assertions.*;


public class RecordDoctorPage extends AbstractPage implements SElements {

    public RecordDoctorPage() {
    }

    public void recordDoctor(String arg0) {

        String lp="Стенд ЕМИАС МО";
        String sp="Терапия";
        changeLpu(lp);
        changeSpec(sp);
        changeDoc(arg0);
        timerec.click();
        recordbutton.click();

    }

    public void assertDoc(String lpu, String special, String fioDoc, String kab) throws InterruptedException {
        Thread.sleep(2000);
        SelenideElement specialist = $(By.xpath("//*[@id='a7f391d4-d5d8-44d5-a770-f7b527bb12330b58bf2f-b6ff-423e-bff8-018953417c50']/td[1]/br[1]"));
        String spec1= specialist.getText();
        System.out.println(spec1);
        String eq1 = lpuName.getText();
        String eq2 = specName.getText();
        String eq3 = doctor.getText();
        String eq4 = kabName.getText();
        String eq5 = dateTicket.getText();
        String eq6 = timeTicket.getText();
        String eq7 = numTicket.getText();

        System.out.println("Код гавно2");

        System.out.println("текст в lpu и eq1 = "+lpu+" и "+eq1);

//        assertThat(lpu).isEqualToIgnoringCase(eq1);
        assertTrue(eq1.contains("Стенд ЕМИАС МО Московская область, г. Неизвестный, ул. Светлая, д. 5"));
        System.out.println("Лпу есть");
        assertTrue(eq2.contains("Терапевты"));
        System.out.println("Специальность есть");
        assertTrue(eq3.contains(fioDoc));
        System.out.println(eq3+" есть");
        assertTrue(kab.contains(eq4));
        System.out.println(eq4+" есть");
        assertTrue(eq5 != null);
        System.out.println(eq5+" есть");
        assertTrue(eq6 != null);
        System.out.println(eq6+" есть");
        assertTrue(eq7 != null);
        System.out.println(eq7+" есть");

//        assertTrue(lpu.contains(eq1));
//        System.out.println(eq1+" есть");
//        assertTrue(special.contains(eq2));
//        System.out.println(eq2+" есть");
//        assertTrue(fioDoc.contains(eq3));
//        System.out.println(eq3+" есть");
//        assertTrue(kab.contains(eq4));
//        System.out.println(eq4+" есть");
//        assertTrue(eq5 != null);
//        System.out.println(eq5+" есть");
//        assertTrue(eq6 != null);
//        System.out.println(eq6+" есть");
//        assertTrue(eq7 != null);
//        System.out.println(eq7+" есть");
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

//    public void createShedule() throws InterruptedException {
////        waitAllEmias();
//
//        Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
//        String a = "2330", b = "2344";
//        String c = "2344", d = "2359";
//        createShedule.click();
//
//        setTimeCalendar(a, b);
//        setTypeOfReception(priemNaDomu);
//
//        setTimeCalendar(c, d);
//        setTypeOfReception(priemPoOcheredi);
//
////        waitWhileClickable(btn_save_schedule);
//        btn_save_schedule.click();                   //нажимаем кнопку сохранить
//        keyboard.pressKey(Keys.ENTER);
////        waitAllEmias();
////        Waiter.waitAllEmias();
//    }
}
