package pages.callCenter;;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.AbstractPage;
import pages.SElements;
import java.io.IOException;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;


public class RecordDoctorPage extends AbstractPage implements SElements {

    public RecordDoctorPage() {
    }

    public void recordDoctor(String arg0) throws InterruptedException {
        changeLpu("СТЕНД ЕМИАС МО");
        changeSpec("Терапия");
        changeDoc(arg0);
        timerec.shouldBe(enabled).click();
        recordbutton.shouldBe(enabled).click();
        closemodal.shouldBe(enabled).click();
    }

    public void recordDoctor2(String arg0) throws InterruptedException {
        changeLpu("СТЕНД ЕМИАС МО");
        changeSpec("Терапия");
        changeDoc(arg0);
        timerec.shouldBe(enabled).click();
        recordbutton.shouldBe(enabled).click();
    }

    public void assertDir(String lpu, String special, String fioDoc, String kab) throws InterruptedException {
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

        System.out.println("Код гавно2");

        System.out.println("текст в lpu и eq1 = "+lpu+" и "+eq1);
        System.out.println("текст в фио док и eq3 = "+fioDoc+" и "+eq3);

        Assert.assertTrue(eq1.contains("Стенд ЕМИАС МО | Московская область, г. Неизвестный, ул. Светлая, д. 5"));
        System.out.println("Лпу есть");
        Assert.assertTrue(eq2.contains(special));
        System.out.println("Специальность есть");
        Assert.assertTrue(eq3.contains(fioDoc));
        System.out.println(eq3+" есть");
        Assert.assertTrue(kab.contains(eq4));
        System.out.println(eq4+" есть");
        Assert.assertTrue(eq5 != null);
        System.out.println(eq5+" есть");
        Assert.assertTrue(eq6 != null);
        System.out.println(eq6+" есть");

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
        Assert.assertTrue(eq1.contains("Стенд ЕМИАС МО Московская область, г. Неизвестный, ул. Светлая, д. 5"));
        System.out.println("Лпу есть");
        Assert.assertTrue(eq2.contains("Терапевты"));
        System.out.println("Специальность есть");
        Assert.assertTrue(eq3.contains(fioDoc));
        System.out.println(eq3+" есть");
        Assert.assertTrue(kab.contains(eq4));
        System.out.println(eq4+" есть");
        Assert.assertTrue(eq5 != null);
        System.out.println(eq5+" есть");
        Assert.assertTrue(eq6 != null);
        System.out.println(eq6+" есть");
        Assert.assertTrue(eq7 != null);
        System.out.println(eq7+" есть");

    }

    public void EqualDoc() throws InterruptedException {
        System.out.println("метка1");
        String eq1 = lpuName.getText();
        String eq2 = specName.getText();
        String eq3 = doctor.getText();
        String eq4 = kabName.getText();
        String eq5 = dateTicket.getText();
        String eq6 = timeTicket.getText();
        String eq7 = numTicket.getText();
        closemodal.click();

        System.out.println("метка2");
        Thread.sleep(2000);

        allrecord.click();
        Thread.sleep(2000);

        String equal7 = $(By.xpath("//*[@id='talon-list']/tr/td[2]")).getText();
        String equal2 = $(By.xpath("//*[@id='talon-list']/tr/td[4]")).getText();
        String equal3 = $(By.xpath("//*[@id='talon-list']/tr/td[3]")).getText();
        String equal6 = $(By.xpath("//*[@id='talon-list']/tr/td[7]")).getText();
        String istok = $(By.xpath("//*[@id='talon-list']/tr/td[5]")).getText();
        String equal5 = $(By.xpath("//*[@id='talon-list']/tr/td[6]")).getText();
        System.out.println("Код гавно2");

        Assert.assertTrue(equal2.contains("Терапия"));
        System.out.println(eq2+" есть");
        Assert.assertTrue(equal3.contains("Ай Бо Лит"));
        System.out.println(eq3+" есть");
        Assert.assertTrue(equal6.contains(eq6));
        System.out.println(eq6+" есть");
        Assert.assertTrue(equal7.contains(eq7));
        System.out.println(eq7+" есть");
        Assert.assertTrue(istok.contains("Колл-центр"));
        System.out.println("Код гавно3");
    }

    public void EqualDetal() {

//        String eq1 = lpuName.getText();
//
//        String equal8 = $(By.xpath("//*[@id='talon-list']/tr/td[1]/div/ul/li/div/h4")).getText();
//        String equal9 = $(By.xpath("//*[@id='talon-list']/tr/td[1]/div/ul/li/div/p[4]")).getText();
//        String istok = $(By.xpath("//*[@id='talon-list']/tr/td[5]")).getText();
//
//        System.out.println("Код гавно3");
//
//        Assert.assertTrue();(istok.contains("Колл-центр"));
//        Assert.assertTrue();(equal8.contains(eq1));
//        System.out.println(eq1+" есть");
//        Assert.assertTrue();(istok.contains(equal9));
//        System.out.println(" есть");
        SelenideElement lpuName2 = $(By.xpath("//*[@id='talon-list']/tr/td[1]/div/ul/li/div/h4"));
        //*[@id="talon-list"]/tr/td[1]/div/ul/li/div/h4
        SelenideElement adress = $(By.xpath("//*[@id='talon-list']/tr/td[1]/div/ul/li/div/p[1]"));
        SelenideElement istok = $(By.xpath("//*[@id='talon-list']/tr/td[1]/div/ul/li/div/p[3]"));
        SelenideElement createData = $(By.xpath("//*[@id='talon-list']/tr/td[1]/div/ul/li/div/p[4]"));


        String eq1 = lpuName2.getText();
        String eq2 = adress.getText();
        String eq3 = istok.getText();
        String eq4 = createData.getText();

        Assert.assertTrue(eq1.contains("Стенд ЕМИАС МО"));
        System.out.println(eq1+" есть");
        Assert.assertTrue(eq2.contains("Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5"));
        System.out.println(eq2+" есть");
        Assert.assertTrue(eq3.contains("Источник: Колл-центр"));
        System.out.println(eq3+" есть");
        Assert.assertTrue(eq4 != null);
        System.out.println(eq4+" есть");
    }

    public void changeLpu(String arg0) throws InterruptedException {
        Thread.sleep(1000);
        SelenideElement lpu = $(By.xpath("//button[contains(.,'"+arg0+"')]"));
        lpu.shouldBe(enabled).click();
    }

    public void changeSpec(String arg0) throws InterruptedException {
        Thread.sleep(1000);
        SelenideElement spec = $(By.xpath("//button[@data-department-name='"+arg0+"']"));
        spec.shouldBe(enabled).click();
    }

    public void changeDoc(String arg0) throws InterruptedException {
        Thread.sleep(1000);
        SelenideElement fastDoc =
                $(By.xpath("//*[contains(text(),'"+arg0+"')]"))
                .$(By.xpath("../../."))
                .$(By.xpath(".//button[@class='btn btn-little btn-block btn-success']"));
        fastDoc.shouldBe(enabled);
        fastDoc.click();
    }

    public void createNewCall(String arg0) throws IOException {
        SelenideElement lpu = $(By.xpath("//button[contains(.,'СТЕНД ЕМИАС МО')]"));
        lpu.hover();
        lpu.click();
        SelenideElement spec = $(By.xpath("//button[@data-department-name='Терапия']"));
        spec.click();
        // TODO: 11.09.2018 переделать
        SelenideElement fastDoc =
                $(By.xpath("//*[contains(text(),'"+arg0+"')]"))
                        .$(By.xpath("../../."))
                        .$(By.xpath(".//button[@class='btn btn-little btn-block btn-success']"));
        fastDoc.click();

//        $(By.xpath("//button[contains(.,'СТЕНД ЕМИАС МО')]")).click();
//        $(By.xpath("//button[@data-department-name='Терапия']")).click();
//        $(By.xpath("//tr[contains(.,'" + arg0 + "')]//button[@class='btn btn-little btn-block btn-success']")).click();
        timerec.click();
        recordbutton.click();
    }

}
