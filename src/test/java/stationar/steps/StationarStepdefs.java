package stationar.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.Pages;
import java.io.File;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.confirm;
import static com.codeborne.selenide.Selenide.open;

public class StationarStepdefs {
    public static Pages page;
    public static RemoteWebDriver driver;
    public static ChromeOptions chromeOptions;
    public static ChromeDriverService chromeDriverService;

    @Before
    public static void setupTimeout() throws InterruptedException, MalformedURLException {
        chromeDriverService = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("src/main/resources/chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=1240,1020");
        driver = new ChromeDriver(chromeDriverService, chromeOptions);
        WebDriverRunner.setWebDriver(driver);
        Configuration.timeout = 20000;
        page = new Pages();
    }
    @After
    public static void afterTests(Scenario scenario) {
//        close();
        driver.quit();
//        System.out.println(scenario.getId());
//        System.out.println(scenario.getName());
//        System.out.println(scenario.getStatus());
        System.out.println(scenario.isFailed());
        System.out.println(scenario.getSourceTagNames());
    }


    @Дано("^Каплин авторизовался в интерфейсе стационара$")
    public void каплинАвторизовалсяВИнтерфейсеСтационара() throws InterruptedException {
        open("http://109.95.224.42:2165/test/stationar/stationar_ui/login");
        Thread.sleep(2000);
        $(By.xpath("//div[@class='login-form']/form/div[1]/input")).val("ЯКОВЛЕВСКАЯ ЦРБ");
        $(By.xpath("//*[contains(text(),'ОГБУЗ')]")).click();
//        new PressEnter();
        $(By.xpath("//div[@class='login-form']/form/div[2]/input")).val("st_terapevt");
        $(By.xpath("//div[@class='login-form']/form/div[3]/input")).val("123");
        $(By.xpath("//div[@class='login-form']/form/button")).click();
    }

    @Тогда("^откроется Журнал пациентов стационара$")
    public void откроетсяЖурналПациентовСтационара()  {
        $(byText("Журнал пациентов стационара")).shouldBe(Condition.visible);
    }

    @Дано("^Каплин нашел в поиске журнала пациента скибин$")
    public void каплинНашелВПоискеЖурналаПациентаХолод() throws InterruptedException {
        $(By.xpath("//*[contains(text(),'Мои пациенты')]"))
                .$(By.xpath("../."))
                .$(By.xpath("//*[@id='mat-checkbox-1']/label/div")).click();//*[@id="mat-checkbox-1-input"].//div[@class='mat-checkbox-frame']//*[@id="mat-checkbox-1"]/label/div
        $(By.xpath("//input[@placeholder='Поиск']")).val("скибин николай андреевич");
        Thread.sleep(7000);
        $(By.xpath("//span[contains(.,'search')]"))
                .$(By.xpath("../."))
                .click();
    }


    @Тогда("^на странице журнала отобразится запись содержащая поля$")
    public void наСтраницеЖурналаОтобразитсяЗаписьСодержащаяПоля(Map<String, String> user)  {
        for (Map.Entry<String, String> us : user.entrySet()){
            $(By.xpath("//*[contains(.,'" + us.getValue() + "')]")).shouldBe(Condition.visible);
            System.out.println(us.getValue());
        }
    }

    @Когда("^Пушкарева нажимает на кнопку “Добавить” в журнале$")
    public void пушкареваНажимаетНаКнопкуДобавитьВЖурнале() {
        $(By.xpath("//span[contains(.,'Добавить')]"))
                .$(By.xpath("../."))
                .click();
    }

    @Тогда("^открылась лента “Редактирование стационарного случая”$")
    public void открыласьЛентаРедактированиеСтационарногоСлучая() {
        $(By.xpath("//input[@placeholder='ФИО пациента']"))
                .val("Холод");
        $(By.xpath("//*[@id='find']/div[3]/div[3]/button"))
                .click();
        $(By.xpath("//a[contains(.,'Создать новую карту')]"))
                .click();
    }

    @И("^Пушкарева заполняет блок “Медицинская карта”$")
    public void пушкареваЗаполняетБлокМедицинскаяКарта() {
        page.utils().randomCard();
        $(By.xpath("//*[@placeholder='Тип стационара']")).shouldHave(Condition.attribute("value", "005 - Стационар круглосуточного пребывания"));
        $(By.xpath("//*[@placeholder='Особый случай']")).val("1");
            $(By.xpath("//*[contains(text(),'паспорт')]")).click();
        $(By.xpath("//*[@placeholder='Вид оплаты']")).shouldHave(Condition.attribute("value", "1 - ОМС"));
    }

    @Также("^Пушкарева заполняет блок “Персональные данные”$")
    public void пушкареваЗаполняетБлокПерсональныеДанные() {
//        $(By.xpath("//*[@id='person']/person/div/form/div[1]/div[1]/div/mat-checkbox/label/div/input")).click();
        $(By.xpath("//*[@placeholder='Фамилия']")).val("Тестовый");
        $(By.xpath("//*[@placeholder='Имя']")).val("Пациент");
        $(By.xpath("//*[@placeholder='Отчество']")).val("Автотестович");
        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[1]/div[4]/date-time/div/div/st-date/mat-form-field/div/div[1]/div[1]/input")).val("01.01.2001");
//        $(By.xpath("//*[contains(.,'муж.')]"))
//                .$(By.xpath("../."))
//                .click();
        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[2]/div[1]/div[1]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("14");
            $(By.xpath("//*[contains(text(),'Паспорт')]")).click();
        $(By.xpath("//*[@placeholder='Серия']")).val("1234");//*[@id="person"]/person/div/form/div[1]/person-base/div/form/div/div[2]/div[1]/div[2]/mat-form-field/div/div[1]/div
        $(By.xpath("//*[@placeholder='Номер']")).val("567890");
        $(By.xpath("//*[@placeholder='Кем выдан']")).val("Мной");
        $(By.xpath("//*[@placeholder='Когда выдан']")).val("02.02.2002");
        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[3]/div[1]/mat-form-field/div/div[1]/div/input")).val("12345678999");
        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[3]/div[2]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("010");//*[@id="person"]/person/div/form/div[1]/person-base/div/form/div/div[3]/div[2]/st-autocomplete/mat-form-field/div/div[1]/div[1]
        $(By.xpath("//*[contains(text(),'АНТАРКТИДА')]")).click();
        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[3]/div[3]/mat-form-field/div/div[1]/div/input")).val("123456");//*[@id="person"]/person/div/form/div[1]/person-base/div/form/div/div[3]/div[3]/mat-form-field/div/div[1]/div/input
//        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[5]/div[1]/st-kladr/div/div[1]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).click();//*[@id="person"]/person/div/form/div[1]/person-base/div/form/div/div[5]/div[1]/st-kladr/div/div[1]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input
//        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[5]/div[1]/st-kladr/div/div[1]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("Белгородская обл.,Прелестное");
//        $(By.xpath("//*[contains(text(),'Прохоровский')]")).click();
//        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[5]/div[1]/st-kladr/div/div[2]/mat-form-field/div/div[1]/div/input")).val("1");//*[@id="person"]/person/div/form/div[1]/person-base/div/form/div/div[5]/div[1]/st-kladr/div/div[2]/mat-form-field/div/div[1]/div/input
//        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[5]/div[1]/st-kladr/div/div[3]/mat-form-field/div/div[1]/div/input")).val("2");//*[@id="person"]/person/div/form/div[1]/person-base/div/form/div/div[5]/div[1]/st-kladr/div/div[3]/mat-form-field/div/div[1]/div/input
//        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[5]/div[1]/st-kladr/div/div[4]/mat-form-field/div/div[1]/div/input")).val("3");
//        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[5]/div[1]/st-kladr/div/div[5]/mat-form-field/div/div[1]/div/input")).val("4");
        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[4]/div/mat-checkbox/label/div")).click();
        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[5]/div[1]/mat-form-field/div/div[1]/div/input")).val("Белгородская обл.,Прелестное,д.1");//*[@id="person"]/person/div/form/div[1]/person-base/div/form/div/div[5]/div[1]/mat-form-field/div/div[1]/div/input
        $(By.xpath("//*[@id='person']/person/div/form/div[1]/div[2]/div[1]/div[1]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("1");//*[@id="person"]/person/div/form/div[1]/div[2]/div[1]/div[1]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input
            $(By.xpath("//*[contains(text(),'ОМС')]")).click();
        $(By.xpath("//*[@id='person']/person/div/form/div[1]/div[2]/div[1]/div[2]/mat-form-field/div/div[1]/div/input")).val("123");//*[@id='person']/person/div/form/div[1]/div[2]/div[1]/div[2]/mat-form-field/div/div[1]/div/input
        $(By.xpath("//*[@id='person']/person/div/form/div[1]/div[2]/div[1]/div[3]/mat-form-field/div/div[1]/div/input")).val("789");//*[@id="person"]/person/div/form/div[1]/div[2]/div[1]/div[3]/mat-form-field/div/div[1]/div
        $(By.xpath("//*[@id='person']/person/div/form/div[1]/div[2]/div[2]/div/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("05501");//*[@id="person"]/person/div/form/div[1]/div[2]/div[2]/div/st-autocomplete/mat-form-field/div/div[1]/div[1]
            $(By.xpath("//*[contains(text(),'МАКС')]")).click();
        $(By.xpath("//*[@id='person']/person/div/form/div[1]/div[3]/div[1]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("1");//*[@id="person"]/person/div/form/div[1]/div[3]/div[1]/st-autocomplete/mat-form-field/div/div[1]/div[1]
            $(By.xpath("//*[contains(text(),'Работающий')]")).click();
        $(By.xpath("//*[@id='person']/person/div/form/div[1]/div[3]/div[2]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("809");//*[@id="person"]/person/div/form/div[1]/div[3]/div[2]/st-autocomplete/mat-form-field/div/div[1]/div[1]
            $(By.xpath("//*[contains(text(),'Лепра')]")).click();
//        $(By.xpath("//*[@id='person']/person/div/form/div[2]/div/div/div/div/div[1]/mat-form-field/div/div[1]/div//mat-select/div/")).click();//*[@id="person"]/person/div/form/div[2]/div/div/div/div/div[1]/mat-form-field/div/div[1]/div//mat-select/div/
//            $(By.xpath("//*[contains(text(),'Телефон')]")).click();
//        $(By.xpath("//*[@id='person']/person/div/form/div[2]/div/div/div/div/div[2]/mat-form-field/div/div[1]/div")).val("12345678999");
    }

    @И("^Пушкарева заполняет блок “Поступления”$")
    public void пушкареваЗаполняетБлокПоступления() {
        page.utils().randomDirection();
        $(By.xpath("//input[@placeholder='Кем направлен']")).val("2220100");
            $(By.xpath("//*[contains(text(),'ОБЛАСТНАЯ')]")).click();
        $(By.xpath("//input[@placeholder='Врач']")).val("Иванов");
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        $(By.xpath("//*[@placeholder='Дата направления']")).val(formatForDateNow.format(dateNow));
        $(By.xpath("//*[@id='reception']/flow/form/div[2]/div[5]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("02").pressTab();
//            $(By.xpath("//*[contains(text(),'Направление')]")).click();
        $(By.xpath("//*[@id='reception']/flow/form/div[3]/div/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("Z55.2").pressTab();//*[@id="reception"]/flow/form/div[3]/div/st-autocomplete/mat-form-field/div/div[1]/div[1]
//            $(By.xpath("//*[contains(text(),'Проблемы')]")).click();
        $(By.xpath("//*[@id='reception']/flow/form/div[4]/div/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("Z55.1").pressTab();//*[@id="reception"]/flow/form/div[4]/div/st-autocomplete/mat-form-field/div/div[1]/div[1]
//            $(By.xpath("//*[contains(text(),'Отставание')]")).click();
        $(By.xpath("//*[@id='reception']/flow/form/div[5]/div/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("11").pressTab();//*[@id="reception"]/flow/form/div[5]/div/st-autocomplete/mat-form-field/div/div[1]/div[1]
//            $(By.xpath("//*[contains(text(),'Запах')]")).click();
//        $(By.xpath("//*[contains(text(),'Впервые')]")).click();
//        $(By.xpath("//*[contains(text(),'Планово')]")).click();
//        $(By.xpath("//*[contains(text(),'в первые 6 часов')]")).click();
        $(By.xpath("//*[@id='reception']/flow/form/div[8]/div/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("5").pressTab();//*[@id="reception"]/flow/form/div[8]/div/st-autocomplete/mat-form-field/div/div[1]/div[1]
//            $(By.xpath("//*[contains(text(),'Производственная)]")).click();
//        $(By.xpath("//*[@id='reception']/flow/form/div[9]/div[1]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("777");//*[@id="reception"]/flow/form/div[9]/div[1]/st-autocomplete/mat-form-field/div/div[1]/div[1]
//            $(By.xpath("//*[contains(text(),'отделение')]")).click();
//        $(By.xpath("//*[@id='reception']/flow/form/div[9]/div[2]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).shouldHave(Condition.text(formatForDateNow.format(dateNow)));//*[@id="reception"]/flow/form/div[9]/div[2]/date-time/div/div[1]/st-date/mat-form-field/div/div[1]/div[1]
        SelenideElement time = $(By.xpath("//*[@id='reception']/flow/form/div[9]/div[2]/date-time/div/div[2]/input-time/mat-form-field/div/div[1]/div/input"));
        String timeGosp = time.getValue();
        $(By.xpath("//*[@id='reception']/flow/form/div[5]/div/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("90855").pressTab();//*[@id="reception"]/flow/form/div[9]/div[3]/st-autocomplete/mat-form-field/div/div[1]/div[1]
//            $(By.xpath("//*[contains(text(),'Иващенкова')]")).click();
//        $(By.name("hospitalizationAccept")).click();
        $(By.xpath("//*[@id='reception']/flow/form/div[5]/div/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("001").pressTab();
//            $(By.xpath("//*[contains(text(),'Хирургическое')]")).click();
        $(By.xpath("//*[@id='reception']/flow/form/div[5]/div/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("02").pressTab();
//            $(By.xpath("//*[contains(text(),'терапевтические')]")).click();
//        $(By.xpath("//*[@id='reception']/flow/form/div[5]/div/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val(formatForDateNow.format(dateNow));
        $(By.xpath("//*[@id='reception']/flow/form/div[10]/div[2]/div[3]/date-time/div/div[2]/input-time/mat-form-field/div/div[1]/div/input")).val(timeGosp);

//        $(By.xpath("//div[contains(text(),'Обследован на RW:')]/mat-radio-group/mat-radio-button")).click();
//        $(By.xpath("//div[contains(text(),'Обследован на AIDS:')]/mat-radio-group/mat-radio-button")).click();
    }

    @Тогда("^Пушкарева заполняет блок “Витальная информация”$")
    public void пушкареваЗаполняетБлокВитальнаяИнформация() {
        $(By.xpath("//*[@id='vitalinformation']/vital-information/app-blood-type-rh/form/div/div[3]/div/div/button")).click();//*[@id='vitalinformation']/vital-information/app-blood-type-rh/form/div/div[3]/div/div/button
        $(By.xpath("//*[@id='vitalinformation']/vital-information/app-blood-type-rh/form/div/div[3]/div/mat-card/mat-card-content/div/div[2]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("Четвертая").pressTab();//*[@id='vitalinformation']/vital-information/app-blood-type-rh/form/div/div[3]/div/mat-card/mat-card-content/div/div[2]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input
//            $(By.xpath("//*[contains(text(),'группа')]")).click();
        $(By.xpath("//*[@id='vitalinformation']/vital-information/app-blood-type-rh/form/div/div[3]/div/mat-card/mat-card-content/div/div[3]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("-").pressTab();
//            $(By.xpath("//*[contains(text(),'отрицательный')]")).click();
        $(By.xpath("//*[@id='vitalinformation']/vital-information/app-blood-type-rh/form/div/div[3]/div/mat-card/mat-card-content/div/div[4]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("20006").pressTab();
//            $(By.xpath("//*[contains(text(),'реакции')]")).click();
        $(By.xpath("//*[@id='vitalinformation']/vital-information/app-pathological-reaction/div/div/div[3]/div/div/button")).click();//*[@id="vitalinformation"]/vital-information/app-pathological-reaction/div/div/div[3]/div/div/button
        $(By.xpath("//*[@id='vitalinformation']/vital-information/app-pathological-reaction/div/div/div[3]/div/mat-card/mat-card-content/div[1]/div[2]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("20").pressTab();//*[@id='vitalinformation']/vital-information/app-pathological-reaction/div/div/div[3]/div/mat-card/mat-card-content/div[1]/div[2]/st-autocomplete/mat-form-field/div/div[1]/div[1]
//            $(By.xpath("//*[contains(text(),'реакции')]")).click();
        $(By.xpath("//*[@id='vitalinformation']/vital-information/app-pathological-reaction/div/div/div[3]/div/mat-card/mat-card-content/div[1]/div[3]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("183").pressTab();
//            $(By.xpath("//*[contains(text(),'Дипивефрин')]")).click();
        $(By.xpath("//*[@id='vitalinformation']/vital-information/app-pathological-reaction/div/div/div[3]/div/mat-card/mat-card-content/div[2]/div[1]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("12").pressTab();
//            $(By.xpath("//*[contains(text(),'Ангионевротический')]")).click();
        $(By.xpath("//*[@id='vitalinformation']/vital-information/app-pathological-reaction/div/div/div[3]/div/mat-card/mat-card-content/div[2]/div[2]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("54040").pressTab();
//            $(By.xpath("//*[contains(text(),'Семешко')]")).click();


    }

//    @И("^Пушкарева заполняет блок “Представители пациента”$")
//    public void пушкареваЗаполняетБлокПредставителиПациента() {
//        $(By.xpath("//div[@id='reception']//*[@placeholder='Фамилия']")).val("Тестовый");
//            $(By.xpath("//div[@id='reception']//input[@placeholder='Имя']")).val("Представитель");
//        $(By.xpath("//div[@id='reception']//*[@placeholder='Отчество']")).val("Один");
//        $(By.xpath("//div[@id='reception']//*[@placeholder='Дата рождения']")).val("01.01.2001");
//        $(By.xpath("//div[@id='reception']//span[contains(.,'муж.')]"))
//                .$(By.xpath("../."))
//                .click();
//        $(By.xpath("//*[@formcontrolname='isBasic']/label/div/input")).click();
//        $(By.xpath("//div[@id='reception']//*[@placeholder='Родственная связь']")).val("42");
//        $(By.xpath("//div[@id='reception']//*[contains(text(),'иное')]")).click();
//        $(By.xpath("//div[@id='reception']//*[@placeholder='Тип документа']")).val("14");
//        $(By.xpath("//div[@id='reception']//*[contains(text(),'паспорт')]")).click();
//        $(By.xpath("//div[@id='reception']//*[@placeholder='Серия']")).val("1234");
//        $(By.xpath("//div[@id='reception']//*[@placeholder='Номер']")).val("567890");
//        $(By.xpath("//div[@id='reception']//*[@placeholder='Кем выдан']")).val("Мной");
//        $(By.xpath("//div[@id='reception']//*[@placeholder='Когда выдан']")).val("02.02.2002");
//        $(By.xpath("//div[@id='reception']//*[@placeholder='СНИЛС']")).val("12345678999");
//        $(By.xpath("//div[@id='reception']//*[@placeholder='Гражданство']")).val("010");
//        $(By.xpath("//div[@id='reception']//*[contains(text(),'АНТАРКТИДА')]")).click();
//        $(By.xpath("//div[@id='reception']//*[@placeholder='Телефон']")).val("123456");
//        $(By.xpath("//div[@id='reception']//*[@placeholder='Адрес']")).val("Белгородская обл., Прохоровский р-н., с. Прелестное,");
//        $(By.xpath("//div[@id='reception']//*[@placeholder='Дом']")).val("1");
//        $(By.xpath("//div[@id='reception']//*[@placeholder='Корпус']")).val("2");
//        $(By.xpath("//div[@id='reception']//*[@placeholder='Строение']")).val("3");
//        $(By.xpath("//div[@id='reception']//*[@placeholder='Квартира']")).val("4");
//        $(By.xpath("//div[@id='reception']//*[@placeholder='Тип полиса']")).val("1");
//        $(By.xpath("//div[@id='reception']//*[contains(text(),'ОМС')]")).click();
//        $(By.xpath("//div[@id='reception']//*[@placeholder='Серия']")).val("123");
//        $(By.xpath("//div[@id='reception']//*[@placeholder='Номер']")).val("789");
//        $(By.xpath("//div[@id='reception']//*[@placeholder='Выдан']")).val("05501");
//        $(By.xpath("//div[@id='reception']//*[contains(text(),'МАКС')]")).click();
//        $(By.xpath("//div[@id='reception']//*[@placeholder='Социальный статус']")).val("1");
//        $(By.xpath("//div[@id='reception']//*[contains(text(),'Работающий')]")).click();
//        $(By.xpath("//div[@id='reception']//*[@placeholder='Категория льгот']")).val("809");
//        $(By.xpath("//div[@id='reception']//*[contains(text(),'Лепра')]")).click();
//        $(By.xpath("//div[@id='reception']//*[@placeholder='Тип информации']")).click();
//        $(By.xpath("//div[@id='reception']//*[contains(text(),'Телефон')]")).click();
//        $(By.xpath("//div[@id='reception']//*[@id='person']/person/div/form/div[2]/div/div/div/div/div[2]/mat-form-field/div/div[1]/div")).val("12345678999");
//    }

    @Когда("^Пушкарева нажимает на кнопку Сохранить$")
    public void пушкареваНажимаетНаКнопкуСохранить() throws Throwable {
        $(By.id("buttonSaveCard")).click();

    }

    @Тогда("^заполненная карта сохраняется и происходит редирект в журнал пациентов$")
    public void заполненнаяКартаСохраняетсяИПроисходитРедиректВЖурналПациентов() throws Throwable {
        $(byText("Журнал пациентов стационара")).shouldBe(Condition.visible);
    }

//    @Тогда("^Пушкарева заполняет блок “Медицинские записи”$")
//    public void пушкареваЗаполняетБлокМедицинскиеЗаписи() {
//
//    }
}
