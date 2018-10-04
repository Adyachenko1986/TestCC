package stationar.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
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
                .val("Мармеладова");
        $(By.xpath("//a[contains(.,'Найти')]"))
                .click();
        $(By.xpath("//a[contains(.,'Создать новую карту')]"))
                .click();
    }

    @И("^Пушкарева заполняет блок “Медицинская карта”$")
    public void пушкареваЗаполняетБлокМедицинскаяКарта() {
        page.utils().randomCard();
        $(By.xpath("//input[@placeholder='Тип стационара']")).shouldBe(Condition.text("005 - Стационар круглосуточного пребывания"));
        $(By.xpath("//input[@placeholder='Особый случай']")).val("1");
            $(By.xpath("//*[contains(text(),'паспорт')]")).click();
        $(By.xpath("//input[@placeholder='Вид оплаты']")).shouldBe(Condition.text("1 - ОМС"));
    }

    @Также("^Пушкарева заполняет блок “Персональные данные”$")
    public void пушкареваЗаполняетБлокПерсональныеДанные() {
        $(By.xpath("//input[@placeholder='Фамилия']")).val("Тестовый");
        $(By.xpath("//input[@placeholder='Имя']")).val("Пациент");
        $(By.xpath("//input[@placeholder='Отчество']")).val("Один");
        $(By.xpath("//input[@placeholder='Дата рождения']")).val("01.01.2001");
        $(By.xpath("//span[contains(.,'муж.')]"))
                .$(By.xpath("../."))
                .click();
        $(By.xpath("//input[@placeholder='Тип документа']")).val("14");
            $(By.xpath("//*[contains(text(),'паспорт')]")).click();
        $(By.xpath("//input[@placeholder='Серия']")).val("1234");
        $(By.xpath("//input[@placeholder='Номер']")).val("567890");
        $(By.xpath("//input[@placeholder='Кем выдан']")).val("Мной");
        $(By.xpath("//input[@placeholder='Когда выдан']")).val("02.02.2002");
        $(By.xpath("//input[@placeholder='СНИЛС']")).val("12345678999");
        $(By.xpath("//input[@placeholder='Гражданство']")).val("010");
            $(By.xpath("//*[contains(text(),'АНТАРКТИДА')]")).click();
        $(By.xpath("//input[@placeholder='Телефон']")).val("123456");
        $(By.xpath("//input[@placeholder='Адрес']")).val("Белгородская обл., Прохоровский р-н., с. Прелестное,");
        $(By.xpath("//input[@placeholder='Дом']")).val("1");
        $(By.xpath("//input[@placeholder='Корпус']")).val("2");
        $(By.xpath("//input[@placeholder='Строение']")).val("3");
        $(By.xpath("//input[@placeholder='Квартира']")).val("4");
        $(By.xpath("//input[@placeholder='Тип полиса']")).val("1");
            $(By.xpath("//*[contains(text(),'ОМС')]")).click();
        $(By.xpath("//input[@placeholder='Серия']")).val("123");
        $(By.xpath("//input[@placeholder='Номер']")).val("789");
        $(By.xpath("//input[@placeholder='Выдан']")).val("05501");
            $(By.xpath("//*[contains(text(),'МАКС')]")).click();
        $(By.xpath("//input[@placeholder='Социальный статус']")).val("1");
            $(By.xpath("//*[contains(text(),'Работающий')]")).click();
        $(By.xpath("//input[@placeholder='Категория льгот']")).val("809");
            $(By.xpath("//*[contains(text(),'Лепра')]")).click();
        $(By.xpath("//input[@placeholder='Тип информации']")).click();
            $(By.xpath("//*[contains(text(),'Телефон')]")).click();
        $(By.xpath("//*[@id='person']/person/div/form/div[2]/div/div/div/div/div[2]/mat-form-field/div/div[1]/div")).val("12345678999");
    }

    @И("^Пушкарева заполняет блок “Поступления”$")
    public void пушкареваЗаполняетБлокПоступления() {
        page.utils().randomDirection();
        $(By.xpath("//input[@placeholder='Кем направлен']")).val("2220100");
            $(By.xpath("//*[contains(text(),'ОГБУЗ')]")).click();
        $(By.xpath("//input[@placeholder='Врач']")).val("Иванов");
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        $(By.xpath("//input[@placeholder='Дата направления']")).val(formatForDateNow.format(dateNow));
        $(By.xpath("//input[@placeholder='Кем доставлен']")).val("02");
            $(By.xpath("//*[contains(text(),'Направление')]")).click();
        $(By.xpath("//input[@placeholder='Диагноз направившего учреждения']")).val("Z55");
            $(By.xpath("//*[contains(text(),'Проблемы')]")).click();
        $(By.xpath("//input[@placeholder='Диагноз приемного отделения']")).val("Z55");
            $(By.xpath("//*[contains(text(),'Проблемы')]")).click();
        $(By.xpath("//input[@placeholder='Доставлен в состоянии опьянения']")).val("11");
            $(By.xpath("//*[contains(text(),'Запах')]")).click();
        $(By.xpath("//*[contains(text(),'Впервые')]")).click();
        $(By.xpath("//*[contains(text(),'Планово')]")).click();
        $(By.xpath("//*[contains(text(),'в первые 6 часов')]")).click();
        $(By.xpath("//input[@placeholder='Травма']")).val("2");
            $(By.xpath("//*[contains(text(),'Прочие)]")).click();
        $(By.xpath("//input[@placeholder='Приемное отделение']")).val("777");
            $(By.xpath("//*[contains(text(),'отделение')]")).click();
        $(By.xpath("//input[@placeholder='Дата поступления']")).shouldHave(Condition.text(formatForDateNow.format(dateNow)));
        $(By.xpath("//input[@placeholder='Врач приемного отделения']")).val("59136");
            $(By.xpath("//*[contains(text(),'Иващенкова')]")).click();
        $(By.name("hospitalizationAccept")).click();
        $(By.xpath("//input[@placeholder='Отделение']")).val("001");
        $(By.xpath("//*[contains(text(),'Хирургическое')]")).click();
        $(By.xpath("//input[@placeholder='Врач приемного отделения']")).val("02");
        $(By.xpath("//*[contains(text(),'терапевтические')]")).click();
        $(By.xpath("//input[@placeholder='Дата поступления']")).shouldHave(Condition.text(formatForDateNow.format(dateNow)));
        $(By.xpath("//div[contains(text(),'Обследован на RW:')]/mat-radio-group/mat-radio-button")).click();
        $(By.xpath("//div[contains(text(),'Обследован на AIDS:')]/mat-radio-group/mat-radio-button")).click();
    }

    @Тогда("^Пушкарева заполняет блок “Витальная информация”$")
    public void пушкареваЗаполняетБлокВитальнаяИнформация() {
        $(By.xpath("//input[@placeholder='Группа крови']")).val("Четвертая");
            $(By.xpath("//*[contains(text(),'группа')]")).click();
        $(By.xpath("//input[@placeholder='резус-фактор']")).val("-");
            $(By.xpath("//*[contains(text(),'отрицательный')]")).click();
        $(By.xpath("//*[@id='vitalinformation']/vital-information/app-blood-type-rh/form/div/div[3]/div/mat-card/mat-card-content/div/div[4]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("20006");
            $(By.xpath("//*[contains(text(),'реакции')]")).click();
        $(By.xpath("//input[@placeholder='Тип реакции']")).val("20");
            $(By.xpath("//*[contains(text(),'реакции')]")).click();
        $(By.xpath("//input[@placeholder='Аллерген по МНН']")).val("1");
            $(By.xpath("//*[contains(text(),'Дипивефрин')]")).click();
        $(By.xpath("//input[@placeholder='Проявление реакции']")).val("2");
            $(By.xpath("//*[contains(text(),'Ангионевротический')]")).click();
        $(By.xpath("//*[@id='vitalinformation']/vital-information/app-pathological-reaction/div/div/div[3]/div/mat-card/mat-card-content/div[2]/div[2]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("54040");
            $(By.xpath("//*[contains(text(),'Семешко')]")).click();


    }

    @И("^Пушкарева заполняет блок “Представители пациента”$")
    public void пушкареваЗаполняетБлокПредставителиПациента() {
        $(By.xpath("//div[@id='reception']//input[@placeholder='Фамилия']")).val("Тестовый");
            $(By.xpath("//div[@id='reception']//input[@placeholder='Имя']")).val("Представитель");
        $(By.xpath("//div[@id='reception']//input[@placeholder='Отчество']")).val("Один");
        $(By.xpath("//div[@id='reception']//input[@placeholder='Дата рождения']")).val("01.01.2001");
        $(By.xpath("//div[@id='reception']//span[contains(.,'муж.')]"))
                .$(By.xpath("../."))
                .click();
        $(By.xpath("//*[@formcontrolname='isBasic']/label/div/input")).click();
        $(By.xpath("//div[@id='reception']//input[@placeholder='Родственная связь']")).val("42");
        $(By.xpath("//div[@id='reception']//*[contains(text(),'иное')]")).click();
        $(By.xpath("//div[@id='reception']//input[@placeholder='Тип документа']")).val("14");
        $(By.xpath("//div[@id='reception']//*[contains(text(),'паспорт')]")).click();
        $(By.xpath("//div[@id='reception']//input[@placeholder='Серия']")).val("1234");
        $(By.xpath("//div[@id='reception']//input[@placeholder='Номер']")).val("567890");
        $(By.xpath("//div[@id='reception']//input[@placeholder='Кем выдан']")).val("Мной");
        $(By.xpath("//div[@id='reception']//input[@placeholder='Когда выдан']")).val("02.02.2002");
        $(By.xpath("//div[@id='reception']//input[@placeholder='СНИЛС']")).val("12345678999");
        $(By.xpath("//div[@id='reception']//input[@placeholder='Гражданство']")).val("010");
        $(By.xpath("//div[@id='reception']//*[contains(text(),'АНТАРКТИДА')]")).click();
        $(By.xpath("//div[@id='reception']//input[@placeholder='Телефон']")).val("123456");
        $(By.xpath("//div[@id='reception']//input[@placeholder='Адрес']")).val("Белгородская обл., Прохоровский р-н., с. Прелестное,");
        $(By.xpath("//div[@id='reception']//input[@placeholder='Дом']")).val("1");
        $(By.xpath("//div[@id='reception']//input[@placeholder='Корпус']")).val("2");
        $(By.xpath("//div[@id='reception']//input[@placeholder='Строение']")).val("3");
        $(By.xpath("//div[@id='reception']//input[@placeholder='Квартира']")).val("4");
        $(By.xpath("//div[@id='reception']//input[@placeholder='Тип полиса']")).val("1");
        $(By.xpath("//div[@id='reception']//*[contains(text(),'ОМС')]")).click();
        $(By.xpath("//div[@id='reception']//input[@placeholder='Серия']")).val("123");
        $(By.xpath("//div[@id='reception']//input[@placeholder='Номер']")).val("789");
        $(By.xpath("//div[@id='reception']//input[@placeholder='Выдан']")).val("05501");
        $(By.xpath("//div[@id='reception']//*[contains(text(),'МАКС')]")).click();
        $(By.xpath("//div[@id='reception']//input[@placeholder='Социальный статус']")).val("1");
        $(By.xpath("//div[@id='reception']//*[contains(text(),'Работающий')]")).click();
        $(By.xpath("//div[@id='reception']//input[@placeholder='Категория льгот']")).val("809");
        $(By.xpath("//div[@id='reception']//*[contains(text(),'Лепра')]")).click();
        $(By.xpath("//div[@id='reception']//input[@placeholder='Тип информации']")).click();
        $(By.xpath("//div[@id='reception']//*[contains(text(),'Телефон')]")).click();
        $(By.xpath("//div[@id='reception']//*[@id='person']/person/div/form/div[2]/div/div/div/div/div[2]/mat-form-field/div/div[1]/div")).val("12345678999");
    }

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
