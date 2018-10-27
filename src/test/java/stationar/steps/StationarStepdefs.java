package stationar.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
//import com.codeborne.selenide.Selenmport cucumber.api.Scenario;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.*;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.Pages;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.core.har.Har;


import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class StationarStepdefs {
    public static Pages page;
    public static RemoteWebDriver driver;
    public static ChromeOptions chromeOptions;
    public static ChromeDriverService chromeDriverService;
    BrowserMobProxy proxy = new BrowserMobProxyServer();

    @Before
    public void setupTimeout() throws InterruptedException, MalformedURLException {
        proxy.start(4300);
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        proxy.newHar("stat");
        chromeDriverService = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("src/main/resources/chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=1240,1020");
        chromeOptions.setProxy(seleniumProxy);
        driver = new ChromeDriver(chromeDriverService, chromeOptions);
        WebDriverRunner.setWebDriver(driver);
        Configuration.timeout = 20000;
        page = new Pages();
    }

    @After
    public void afterTests(Scenario scenario) throws IOException {
//        close();
        Har har = proxy.getHar();
        for (HarEntry entry : har.getLog().getEntries()) {
            if (entry.getRequest().getMethod().equals("PUT")) {

//                HarEntry entry = har.getLog().getEntries().get(74);
                System.out.println("entry.getTimings()");
                System.out.println(entry.getTimings().getWait());
//        System.out.println("entry.getCache()");
//        System.out.println(entry.getCache());
//        System.out.println("entry.getConnection()");
//        System.out.println(entry.getConnection());
                System.out.println("entry.getPageref()");
                System.out.println(entry.getPageref());
                System.out.println("entry.getServerIPAddress()");
                System.out.println(entry.getServerIPAddress());
                System.out.println("entry.getStartedDateTime()");
                System.out.println(entry.getStartedDateTime());
                System.out.println("entry.getTime()");
                System.out.println(entry.getTime());
                System.out.println("entry.getRequest().getMethod");
                System.out.println(entry.getRequest().getMethod());
                System.out.println("entry.getRequest().getUrl()");
                System.out.println(entry.getRequest().getUrl());
                System.out.println("entry.getRequest().getPostData()");
                System.out.println(entry.getRequest().getPostData().getText());
                System.out.println("entry.getResponse()");
                System.out.println(entry.getResponse().getStatus());
            }
        }
//        for (HarEntry entry : har.getLog().getEntries()) {
//            System.out.println(entry.getTimings().getWait());
//        }
//        Har har = proxy.addRequestFilter();
//        try {
//            FileOutputStream fos = new FileOutputStream("target/selenium_logs.har");
//                har.writeTo(fos);
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//        finally {
//            driver.quit();
//            proxy.stop();
//        }
        FileOutputStream fileOutputStream = new FileOutputStream("target/selenium_logs.har");
        har.writeTo(fileOutputStream);
        driver.quit();

        System.out.println(scenario.getId());
        System.out.println(scenario.getName());
        System.out.println(scenario.getStatus());
        System.out.println(scenario.isFailed());
        System.out.println(scenario.getSourceTagNames());
    }


    @Дано("^Пушкарева авторизовался в интерфейсе стационара$")
    public void ПушкареваАвторизовалсяВИнтерфейсеСтационара() throws InterruptedException {
        open("http://109.95.224.42:2165/test/stationar/stationar_ui/login");
        Thread.sleep(2000);
        $(By.xpath("//div[@class='login-form']/form/div[1]/input")).val("Яковлев"); //Талдом
        $(By.xpath("//*[contains(text(),'ОГБУЗ')]")).click(); //Талдомская ЦРБ
//        new PressEnter();
        $(By.xpath("//div[@class='login-form']/form/div[2]/input")).val("st_terapevt");
        $(By.xpath("//div[@class='login-form']/form/div[3]/input")).val("123");
        $(By.xpath("//div[@class='login-form']/form/button")).click();
    }

    @Тогда("^откроется Журнал пациентов стационара$")
    public void откроетсяЖурналПациентовСтационара() {
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
    public void наСтраницеЖурналаОтобразитсяЗаписьСодержащаяПоля(Map<String, String> user) {
        for (Map.Entry<String, String> us : user.entrySet()) {
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
//        $(By.xpath("//input[@placeholder='ФИО пациента']"))
//                .val("Холод");
        $(By.xpath("//input[@name='snilsNg']"))
                .val("11111111111");
        $(By.xpath("//*[@id='find']/div[3]/div[3]/button"))
                .click();
        $(By.xpath("//a[contains(.,'Создать новую карту')]"))
                .click();
    }

    @И("^Пушкарева заполняет блок “Медицинская карта”$")
    public void пушкареваЗаполняетБлокМедицинскаяКарта() {
        /** Ввод номера карты
         * типа стационара
         * особого случая
         * вида оплаты*/
        page.utils().randomCard();
//        $(By.xpath("//*[@placeholder='Тип стационара']")).shouldHave(Condition.attribute("value", "005 - Стационар круглосуточного пребывания"));
        $(By.xpath("//*[@placeholder='Тип стационара']")).val("005 ");
        $(By.xpath("//*[contains(text(),'005 - Стационар круглосуточного пребывания')]")).click();
        $(By.xpath("//*[@placeholder='Особый случай']")).val("1");
        $(By.xpath("//*[contains(text(),'паспорт')]")).click();
//        $(By.xpath("//*[@placeholder='Вид оплаты']")).shouldHave(Condition.attribute("value", "1 - ОМС"));
        $(By.xpath("//div[@id='medicalcard']//*[@placeholder='Вид оплаты']")).val("1 ");//*[@placeholder='Вид оплаты']
        $(By.xpath("//*[contains(text(),'1 - ОМС')]")).click();
    }

    @Также("^Пушкарева заполняет блок “Персональные данные”$")
    public void пушкареваЗаполняетБлокПерсональныеДанные() {
//        $(By.xpath("//*[@id='person']/person/div/form/div[1]/div[1]/div/mat-checkbox/label/div/input")).click();
        /** Ввод фамилиии
         * имени
         * отчества
         * даты рождения
         * пола*/
        $(By.xpath("//div[@id='person']//input[@placeholder='Фамилия']")).val("Тестовый");
        $(By.xpath("//div[@id='person']//input[@placeholder='Имя']")).val("Пациент");
        $(By.xpath("//div[@id='person']//input[@placeholder='Отчество']")).val("Автотестович");
        $(By.xpath("//div[@id='person']//input[@placeholder='Дата рождения']")).val("01.01.2001");

        /** Ввод тип документа
         * серия
         * номер*/
        $(By.xpath("//*[@id='person']//div[@formgroupname='identityDoc']//input[@placeholder='Тип документа']")).hover().setValue("14");
        $(By.xpath("//*[contains(text(),'Паспорт')]")).click();
        $(By.xpath("//div[@id='person']//div[@formgroupname='identityDoc']//input[@placeholder='Серия']")).val("1234");
        $(By.xpath("//div[@id='person']//div[@formgroupname='identityDoc']//input[@placeholder='Номер']")).val("567890");

        /** Ввод кем выдан документ
         * дата выдачи*/
        $(By.xpath("//*[@placeholder='Кем выдан']")).val("НЛО");
        $(By.xpath("//*[@placeholder='Когда выдан']")).val("02.02.2002");

        /** Ввод СНИЛС
         * Гражданство*/
        $(By.xpath("//*[@id='person']//input[@placeholder='СНИЛС']")).val("12345678999");
        $(By.xpath("//*[@id='person']//input[@placeholder='Гражданство']")).val("010");
        $(By.xpath("//*[contains(text(),'АНТАРКТИДА')]")).click();

        /** Ввод адреса по КЛАДР*/
//        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[3]/div[3]/mat-form-field/div/div[1]/div/input")).val("123456");//*[@id="person"]/person/div/form/div[1]/person-base/div/form/div/div[3]/div[3]/mat-form-field/div/div[1]/div/input
//        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[5]/div[1]/st-kladr/div/div[1]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).click();//*[@id="person"]/person/div/form/div[1]/person-base/div/form/div/div[5]/div[1]/st-kladr/div/div[1]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input
//        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[5]/div[1]/st-kladr/div/div[1]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("Белгородская обл.,Прелестное");
//        $(By.xpath("//*[contains(text(),'Прохоровский')]")).click();
//        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[5]/div[1]/st-kladr/div/div[2]/mat-form-field/div/div[1]/div/input")).val("1");//*[@id="person"]/person/div/form/div[1]/person-base/div/form/div/div[5]/div[1]/st-kladr/div/div[2]/mat-form-field/div/div[1]/div/input
//        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[5]/div[1]/st-kladr/div/div[3]/mat-form-field/div/div[1]/div/input")).val("2");//*[@id="person"]/person/div/form/div[1]/person-base/div/form/div/div[5]/div[1]/st-kladr/div/div[3]/mat-form-field/div/div[1]/div/input
//        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[5]/div[1]/st-kladr/div/div[4]/mat-form-field/div/div[1]/div/input")).val("3");
//        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[5]/div[1]/st-kladr/div/div[5]/mat-form-field/div/div[1]/div/input")).val("4");

        /** Ввод адреса не по КЛАДР*/
        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[4]/div/mat-checkbox/label/div")).click();
        $(By.xpath("//*[@id='person']//input[@placeholder='Адрес']")).val("Белгородская обл.,Прелестное,д.1");

        /** Ввод типа полиса
         * серия
         * номер
         * кем выдан*/
        $(By.xpath("//*[@id='person']//div[@formgroupname='policy']//input[@placeholder='Тип полиса']")).val("1");
        $(By.xpath("//*[contains(text(),'Полис ОМС')]")).click(); //полис ОМС //Полис ОМС
        $(By.xpath("//*[@id='person']//div[@formgroupname='policy']//input[@placeholder='Серия']")).val("123");
        $(By.xpath("//*[@id='person']//div[@formgroupname='policy']//input[@placeholder='Номер']")).val("789");
        $(By.xpath("//*[@id='person']//div[@formgroupname='policy']//input[@placeholder='Выдан']")).val("05501");
        $(By.xpath("//*[contains(text(),'МАКС')]")).click();

        /** Ввод социального статуса
         * категории льгот*/
        $(By.xpath("//*[@id='person']//input[@placeholder='Социальный статус']")).val("1");
        $(By.xpath("//*[contains(text(),'Работающий')]")).click();
        $(By.xpath("//*[@id='person']//input[@placeholder='Категория льгот']")).val("809");
        $(By.xpath("//*[contains(text(),'Лепра')]")).click();//080 - Инвалиды

        /** Ввод телефона контактной информации*/
//        $(By.xpath("//*[@id='person']/person/div/form/div[2]/div[2]/div/button")).click();
//        $(By.xpath("//*[@id='person']/person/div/form/div[2]/div[1]/div/div/div/div[1]/mat-form-field/div/div[1]/div/mat-select/div")).click();
//            $(By.xpath("//*[contains(text(),'Телефон')]")).click();
//        $(By.xpath("//*[@id='person']/person/div/form/div[2]/div[1]/div/div/div/div[2]/mat-form-field/div/div[1]/div/input")).val("12345678999");
    }

    @И("^Пушкарева заполняет блок “Поступления”$")
    public void пушкареваЗаполняетБлокПоступления() throws InterruptedException {
        /** Ввод номера направления
         * кем направлен
         * ФИО врача
         * дата направления*/
        page.utils().randomDirection();
//        $(By.xpath("//input[@placeholder='Кем направлен']")).val("2220100");
        $(By.xpath("//*[@id='reception']//input[@placeholder='Кем направлен']")).val("2223000");
        $(byText("2223000 - ДЕПАРТАМЕНТ ЗДРАВООХРАНЕНИЯ И СОЦИАЛЬНОЙ ЗАЩИТЫ НАСЕЛЕНИЯ БЕЛГОРОДСКОЙ ОБЛАСТИ")).click();
//            $(By.xpath("//*[contains(text(),'ОБЛАСТНАЯ')]")).click();
        $(By.xpath("//*[@id='reception']//input[@placeholder='Врач']")).val("Иванов");
//        $(By.xpath("//input[@placeholder='Врач']")).val("Иванов");
        // определяем текущую дату для направления и госпитализации
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        $(By.xpath("//*[@placeholder='Дата направления']")).val(formatForDateNow.format(dateNow));

        /** Ввод кем доставлен
         * диагноз направившего учреждения
         * диагноз приемного учреждения
         * состояние
         * вид транспорта*/
        $(By.xpath("//*[@id='reception']//input[@placeholder='Кем доставлен']")).val("02");
        $(byText("02 - Направление Минздравсоцразвития России")).click();
        $(By.xpath("//*[@id='reception']//input[@placeholder='Диагноз направившего учреждения']")).val("Z55.2");
        $(byText("Z55.2 - Провал на экзаменах")).click();
        $(By.xpath("//*[@id='reception']//input[@placeholder='Диагноз приёмного отделения']")).val("Z55.1");
        $(byText("Z55.1 - Отсутствие способности к обучению")).click();
        $(By.xpath("//*[@id='reception']//input[@placeholder='Доставлен в состоянии опьянения']")).val("11");
        $(byText("11 - Запах алкоголя")).click();
        $(By.xpath("//*[@id='reception']//input[@placeholder='Вид транспорта']")).val("3");
        $(byText("3 - Может идти")).click();

        /** Ввод впервые
         * планово
         * в первые 6 часов*/
//            $(By.xpath("//*[contains(text(),'Запах')]")).click();
//        $(By.xpath("//*[contains(text(),'Впервые')]")).click();
//        $(By.xpath("//*[contains(text(),'Планово')]")).click();
//        $(By.xpath("//*[contains(text(),'в первые 6 часов')]")).click();

        $(By.xpath("//*[@id='reception']//input[@placeholder='Травма']")).val("5");
        $(byText("5 - Производственные прочие")).click();

        /** Копирование времени приемного отделения для вставки в госпитализацию
         * ввод врача приемного отделения*/
        SelenideElement time = $(By.xpath("//*[@id='reception']//*[@name='dateEntrance']//*[@placeholder='Время']")); //input[@placeholder='Дата поступления']
        String timeGosp = time.getValue();
        $(By.xpath("//*[@id='reception']//input[@placeholder='Врач приемного отделения']")).val("90855");
        $(byText("90855 - ПУШКАРЕВА Р. В.")).click();
//            $(By.xpath("//*[contains(text(),'Иващенкова')]")).click();$(byText("02 - терапевтические")).click();
//        $(By.name("hospitalizationAccept")).click();

        /** Ввод отделения госпитализации
         * профиля коек
         * даты
         * подстановка времени*/
        $(By.xpath("//*[@id='reception']//input[@placeholder='Отделение']")).val("001");
        $(byText("001 - Хирургическое отд.1")).click();
        $(By.xpath("//*[@id='reception']//input[@placeholder='Профиль коек']")).val("19");
        $(byText("19 - хирургические для взрослых")).click();
//        dateHospitalization
        $(By.xpath("//*[@id='reception']//input[@placeholder='Дата']")).val(formatForDateNow.format(dateNow));
        Thread.sleep(2000);
        $(By.xpath("//*[@id='reception']//*[@name='dateHospitalization']//input[@placeholder='Время']")).val(timeGosp);

//        $(By.xpath("//div[contains(text(),'Обследован на RW:')]/mat-radio-group/mat-radio-button")).click();
//        $(By.xpath("//div[contains(text(),'Обследован на AIDS:')]/mat-radio-group/mat-radio-button")).click();
    }

    @Тогда("^Пушкарева заполняет блок “Витальная информация”$")
    public void пушкареваЗаполняетБлокВитальнаяИнформация() {
        $(By.xpath("//*[@id='vitalinformation']/vital-information/app-blood-type-rh/form/div/div[3]/div/div/button")).hover().click();
        /** Ввод группы крови
         * резус-фактор
         * Специалист*/
        $(By.xpath("//*[@id='vitalinformation']//input[@placeholder='Группа крови']")).val("Четвертая");
        $(byText("AB (IV) - Четвертая группа")).click();
        $(By.xpath("//*[@id='vitalinformation']//input[@placeholder='Резус-фактор']")).val("-");
        $(byText("RH- - Резус - отрицателен")).click();
        $(By.xpath("//*[@id='vitalinformation']//input[@placeholder='Специалист']")).val("Пушкарева"); //Андреева //Пушкарева
        $(byText("90855, ПУШКАРЕВА РЕГИНА ВЯЧЕСЛАВОВНА, Эндокринология")).click();
        //SSTO, Андреева Екатерина Алексеевна, Лечебное дело  //90855, ПУШКАРЕВА РЕГИНА ВЯЧЕСЛАВОВНА, Эндокринология

        /** Ввод типа реакции
         * Аллергена
         * Аллергена по мнн
         * Проявления реакции
         * Специалист
         * ПРимечание*/
        $(By.xpath("//*[@id='vitalinformation']/vital-information/app-pathological-reaction/div/div/div[3]/div/div/button")).click();
        $(By.xpath("//*[@id='vitalinformation']//input[@placeholder='Тип реакции']")).val("20");
        $(byText("20 - Аллергические реакции")).click();
        $(By.xpath("//*[@id='vitalinformation']//input[@placeholder='Аллерген']")).val("002");
        $(byText("002 - Пыль")).click();
        $(By.xpath("//*[@id='vitalinformation']//input[@placeholder='Аллерген по МНН']")).val("дак");
        $(byText("2 - Дактиномицин")).click();
        $(By.xpath("//*[@id='vitalinformation']//input[@placeholder='Проявление реакции']")).val("12");
        $(byText("12 - Зуд")).click();
        $(By.xpath("//*[@id='vitalinformation']//*[@name='pathological_group']//input[@placeholder='Специалист']")).val("сокол"); //соболь //сокол
        $(byText("16236, Соколовская Ирина Анатольевна, Терапия")).click();
        //ssXO, Соболева Юлия Евгеньевна, Средний мед. персонал //16236, Соколовская Ирина Анатольевна, Терапия


    }

    @И("^Пушкарева заполняет блок “Представители пациента”$")
    public void пушкареваЗаполняетБлокПредставителиПациента() {
        $(By.xpath("//*[@id='agents']/div/div/h1/div/div/div/button")).click();
        /** Ввод фамилиии
         * имени
         * отчества
         * даты рождения
         * пола*/
        $(By.xpath("//*[@id='agents']//input[@placeholder='Фамилия']")).hover().val("Тестовый");
        $(By.xpath("//*[@id='agents']//input[@placeholder='Имя']")).val("Представитель");
        $(By.xpath("//*[@id='agents']//input[@placeholder='Отчество']")).val("Один");
        $(By.xpath("//*[@id='agents']//input[@placeholder='Дата рождения']")).val("01.01.2001");
        $(By.xpath("//*[@formcontrolname='isBasic']/label/div")).click();
//        $(By.xpath("//*[@id='agents']/div[3]/div/mat-card/div[2]/person/div/form/div[1]/person-base/div/form/div/div[2]/div/div[1]/mat-checkbox/label/div")).click();
        $(By.xpath("//*[@id='agents']//input[@placeholder='Родственная связь']")).val("42");
        $(byText("42 - Иное")).click();

        /** Ввод тип документа
         * серия
         * номер
         * кем выдан
         * когда выдан*/
        $(By.xpath("//*[@id='agents']//div[@formgroupname='identityDoc']//input[@placeholder='Тип документа']")).val("9");
        $(byText("9 - Иностранный паспорт")).click();
        $(By.xpath("//*[@id='agents']//div[@formgroupname='identityDoc']//input[@placeholder='Серия']")).val("S");
        $(By.xpath("//*[@id='agents']//div[@formgroupname='identityDoc']//input[@placeholder='Номер']")).val("567890");
        $(By.xpath("//*[@id='agents']//div[@formgroupname='identityDoc']//input[@placeholder='Кем выдан']")).val("Мной");
        $(By.xpath("//*[@id='agents']//input[@placeholder='Когда выдан']")).val("02.02.2002");


        /** Ввод снилс
         * гражданство*/
        $(By.xpath("//*[@id='agents']//input[@placeholder='СНИЛС']")).val("12345678999");
        $(By.xpath("//*[@id='agents']//input[@placeholder='Гражданство']")).val("748");
        $(byText("748 - СВАЗИЛЕНД")).click();

        /** Ввод адреса не по КЛАДР*/
        $(By.xpath("//*[@id='agents']/div[3]/div/mat-card/div[2]/person/div/form/div[1]/person-base/div/form/div/div[5]/div/mat-checkbox/label/div")).click();
        $(By.xpath("//*[@id='agents']//input[@placeholder='Адрес']")).val("Белгородская обл., Прохоровский р-н., с. Прелестное,");
//        $(By.xpath("//div[@id='agents']//*[@placeholder='Корпус']")).val("2");
//        $(By.xpath("//div[@id='agents']//*[@placeholder='Строение']")).val("3");
//        $(By.xpath("//div[@id='agents']//*[@placeholder='Квартира']")).val("4");


        /** Ввод ТИП ПОЛИСА
         * серия
         * номер
         * кем выдан*/
        $(By.xpath("//*[@id='agents']//div[@formgroupname='policy']//input[@placeholder='Тип полиса']")).val("4");
        $(byText("4 - Состояние на учёте без полиса ОМС")).click();
        $(By.xpath("//*[@id='agents']//div[@formgroupname='policy']//input[@placeholder='Серия']")).val("123");
        $(By.xpath("//*[@id='agents']//div[@formgroupname='policy']//input[@placeholder='Номер']")).val("789");
        $(By.xpath("//*[@id='agents']//div[@formgroupname='policy']//input[@placeholder='Выдан']")).val("86003");
        $(By.xpath("//*[contains(text(),'МАКСИМУС')]")).click();

        /** Ввод контактой информации*/
        $(By.xpath("//*[@id='agents']/div[3]/div/mat-card/div[2]/person/div/form/div[2]/div[2]/div/button")).click();
        $(By.xpath("//*[@id='agents']/div[3]/div/mat-card/div[2]/person/div/form/div[2]/div[1]/div/div/div/div[1]/mat-form-field/div/div[1]/div")).click();
        $(byText("Электронная почта")).click();
        $(By.xpath("//*[@id='agents']//input[@name='comInfo']")).val("123@qwe.ru");
    }

    @Когда("^Пушкарева нажимает на кнопку Сохранить$")
    public void пушкареваНажимаетНаКнопкуСохранить() throws Throwable {
        $(By.xpath("//div[@id='buttonSaveCard']/button[3]")).hover().click();
        SelenideElement medCartNumber = $(By.name("medCardNum"));
        String number = medCartNumber.getValue();
        $(byText("Cлучай по карте № " + number + " успешно сохранен")).waitUntil(Condition.visible, 5000);

    }

    @Тогда("^Пушкарева нажимает выйти$")
    public void заполненнаяКартаСохраняетсяИПроисходитРедиректВЖурналПациентов() throws Throwable {
//        $(byText("Журнал пациентов стационара")).shouldBe(Condition.visible);
        $(By.xpath("//div[@id='buttonSaveCard']/button[2]")).hover().click();
        $(By.xpath("/html/body/app-root/app-statist/app-header/header/div/statist-header/div/div[1]/div/div/div[2]/span")).shouldHave(Condition.text("Журнал пациентов стационара"));
//        $("title").shouldHave(Condition.attribute("text", "Your page title"));
    }

//    @Когда("^Пушкарева ищет в поиске пациента$")
//    public void пушкареваИщетВПоискеПациента() throws Throwable {
////        $(By.xpath("//*[@placeholder='Поиск по ФИО, СНИЛС (123-456-789 12), № страхового полиса']")).val("54585").pressEnter();
//        open("http://109.95.224.42:2165/test/stationar/stationar_ui/statist/edit/card/61960");
//
//    }
//
//    @Тогда("^в журнале отобразится фио$")
//    public void вЖурналеОтобразитсяФио() throws Throwable {
//
//    }
//
//    @И("^Пушкарева нажимает редактировать$")
//    public void пушкареваНажимаетРедактировать() throws Throwable {
//
//    }
//
//    @Тогда("^открылась лента стационарного случая пациента$")
//    public void открыласьЛентаСтационарногоСлучаяПациента() throws Throwable {
//
//    }

    @И("^Пушкарева заполняет обязательные поля в блоке “Медицинская карта”$")
    public void пушкареваЗаполняетОбязательныеПоляВБлокеМедицинскаяКарта() throws Throwable {
        /** Ввод номера карты
         * проверка типа стационара
         * проверка вида оплаты*/
        page.utils().randomCard();
//        $(By.xpath("//*[@placeholder='Тип стационара']")).shouldHave(Condition.attribute("value", "005 - Стационар круглосуточного пребывания"));
        $(By.xpath("//*[@placeholder='Тип стационара']")).val("005 ");
        $(By.xpath("//*[contains(text(),'005 - Стационар круглосуточного пребывания')]")).click();
//        $(By.xpath("//*[@placeholder='Вид оплаты']")).shouldHave(Condition.attribute("value", "1 - ОМС"));
        $(By.xpath("//div[@id='medicalcard']//*[@placeholder='Вид оплаты']")).val("1");
        $(By.xpath("//*[contains(text(),'1 - ОМС')]")).click();
    }

    @Также("^Пушкарева заполняет обязательные поля в блоке “Персональные данные”$")
    public void пушкареваЗаполняетОбязательныеПоляВБлокеПерсональныеДанные() throws Throwable {
        $(By.xpath("//*[@id='person']/person/div/form/div[1]/div[1]/div/mat-checkbox/label/div")).click();
        /** Ввод фамилиии
         * имени
         * даты рождения*/
        $(By.xpath("//div[@id='person']//input[@placeholder='Фамилия']")).val("АвтоТестовый");
        $(By.xpath("//div[@id='person']//input[@placeholder='Имя']")).val("Пациент");
        $(By.xpath("//div[@id='person']//input[@placeholder='Дата рождения']")).val("01.01.2001");

        /** Ввод тип документа
         * серия
         * номер*/
        $(By.xpath("//div[@id='person']//input[@placeholder='Тип документа']")).val("14");
        $(By.xpath("//div[@id='person']//*[contains(text(),'Паспорт')]")).click();
        $(By.xpath("//div[@id='person']//input[@placeholder='Серия']")).val("1234");
        $(By.xpath("//div[@id='person']//input[@placeholder='Номер']")).val("567890").pressTab();

//        /** Ввод кем выдан документ
//         * дата выдачи*/
//        $(By.xpath("//*[@placeholder='Кем выдан']")).val("НЛО");
//        $(By.xpath("//*[@placeholder='Когда выдан']")).val("02.02.2002");
//
//        /** Ввод СНИЛС
//         * Гражданство*/
//        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[3]/div[1]/mat-form-field/div/div[1]/div/input")).val("12345678999");
//        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[3]/div[2]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("010");
//        $(By.xpath("//*[contains(text(),'АНТАРКТИДА')]")).click();

        /** Ввод адреса по КЛАДР*/
        $(By.xpath("//div[@id='person']//input[@placeholder='Адрес']")).hover().click();

        $(By.xpath("//div[@id='person']//input[@placeholder='Адрес']")).val("Бел");
        $(By.xpath("//div[@id='person']//*[contains(text(),'Белгородская обл.,')]")).click();
        $(By.xpath("//div[@id='person']//input[@placeholder='Дом']")).val("1");
        $(By.xpath("//div[@id='person']//input[@placeholder='Корпус']")).val("2");
        $(By.xpath("//div[@id='person']//input[@placeholder='Строение']")).val("3");
        $(By.xpath("//div[@id='person']//input[@placeholder='Квартира']")).val("4");

//        /** Ввод адреса не по КЛАДР*/
//        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[4]/div/mat-checkbox/label/div")).click();
//        $(By.xpath("//*[@id='person']/person/div/form/div[1]/person-base/div/form/div/div[5]/div[1]/mat-form-field/div/div[1]/div/input")).val("Белгородская обл.,Прелестное,д.1");

        /** Ввод типа полиса
         * номер
         * кем выдан*/
        $(By.xpath("//div[@id='person']//input[@placeholder='Тип полиса']")).val("3");
        $(By.xpath("//*[contains(text(),'Полис ОМС единого образца')]")).click();
        $(By.xpath("//div[@id='person']//input[@placeholder='Номер']")).val("0123456787654321");
        $(By.xpath("//div[@id='person']//input[@placeholder='Выдан']")).val("05501");
        $(By.xpath("//*[contains(text(),'МАКС')]")).click();

//        /** Ввод социального статуса
//         * категории льгот*/
//        $(By.xpath("//*[@id='person']/person/div/form/div[1]/div[3]/div[1]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("1");
//        $(By.xpath("//*[contains(text(),'Работающий')]")).click();
//        $(By.xpath("//*[@id='person']/person/div/form/div[1]/div[3]/div[2]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("809");
//        $(By.xpath("//*[contains(text(),'Лепра')]")).click();

        /** Ввод телефона контактной информации*/
//        $(By.xpath("//*[@id='person']/person/div/form/div[2]/div[2]/div/button")).click();
//        $(By.xpath("//*[@id='person']/person/div/form/div[2]/div[1]/div/div/div/div[1]/mat-form-field/div/div[1]/div/mat-select/div")).click();
//            $(By.xpath("//*[contains(text(),'Телефон')]")).click();
//        $(By.xpath("//*[@id='person']/person/div/form/div[2]/div[1]/div/div/div/div[2]/mat-form-field/div/div[1]/div/input")).val("12345678999");
    }

    @И("^Пушкарева заполняет обязательные поля в блоке “Поступления”$")
    public void пушкареваЗаполняетОбязательныеПоляВБлокеПоступления() throws Throwable {
//        /** Ввод номера направления
//         * кем направлен
//         * ФИО врача
//         * дата направления*/
//        page.utils().randomDirection();
////        $(By.xpath("//input[@placeholder='Кем направлен']")).val("2220100");
//        $(By.xpath("//*[@id='reception']/flow/form/div[2]/div[2]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("2223000");
//        $(byText("2223000 - ДЕПАРТАМЕНТ ЗДРАВООХРАНЕНИЯ И СОЦИАЛЬНОЙ ЗАЩИТЫ НАСЕЛЕНИЯ БЕЛГОРОДСКОЙ ОБЛАСТИ")).click();
////            $(By.xpath("//*[contains(text(),'ОБЛАСТНАЯ')]")).click();
//        $(By.xpath("//*[@id='reception']/flow/form/div[2]/div[3]/mat-form-field/div/div[1]/div/input")).val("Иванов");
////        $(By.xpath("//input[@placeholder='Врач']")).val("Иванов");
        // определяем текущую дату для направления и госпитализации
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
//        $(By.xpath("//*[@placeholder='Дата направления']")).val(formatForDateNow.format(dateNow));

        /** Ввод кем доставлен
         * диагноз направившего учреждения
         * диагноз приемного учреждения
         * состояние
         * вид транспорта*/
        $(By.xpath("//div[@id='reception']//input[@placeholder='Кем доставлен']")).val("12");
        $(byText("12 - Самотек")).click();
        $(By.xpath("//div[@id='reception']//input[@placeholder='Диагноз направившего учреждения']")).val("Z55.2");
        $(byText("Z55.2 - Провал на экзаменах")).click();
        $(By.xpath("//div[@id='reception']//input[@placeholder='Диагноз приемного отделения']")).val("Z55.1");
        $(byText("Z55.1 - Отсутствие способности к обучению")).click();
//        $(By.xpath("//*[@id='reception']/flow/form/div[5]/div/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("11");
//        $(byText("11 - Запах алкоголя")).click();
//        $(By.xpath("//*[@id='reception']/flow/form/div[5]/div[2]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("3");
//        $(byText("3 - Может идти")).click();

        /** Ввод впервые
         * планово
         * в первые 6 часов*/
//            $(By.xpath("//*[contains(text(),'Запах')]")).click();
//        $(By.xpath("//*[contains(text(),'Впервые')]")).click();
//        $(By.xpath("//*[contains(text(),'Планово')]")).click();
//        $(By.xpath("//*[contains(text(),'в первые 6 часов')]")).click();

//        $(By.xpath("//*[@id='reception']/flow/form/div[8]/div/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("5");
//        $(byText("5 - Производственные прочие")).click();

        /** Копирование времени приемного отделения для вставки в госпитализацию
         * ввод врача приемного отделения*/
        $(By.xpath("//*[@id='reception']//input[@placeholder='Приемное отделение']")).shouldHave(value("777 - Приемное отделение"));
        SelenideElement time = $(By.xpath("//div[@id='reception']//*[@name='dateEntrance']//input[@placeholder='Время']"));
        String timeGosp = time.getValue();
        $(By.xpath("//*[@id='reception']/flow/form/div[9]/div[3]/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val("90855");
        $(byText("90855 - ПУШКАРЕВА Р. В.")).click();
//            $(By.xpath("//*[contains(text(),'Иващенкова')]")).click();$(byText("02 - терапевтические")).click();
//        $(By.name("hospitalizationAccept")).click();

        /** Ввод причины отказа от госпитализации
         * проверка даты
         * примечание*/
        $(By.xpath("//*[@name='hospitalizationRefuse']/label/div")).click();
        $(By.xpath("//*[@id='reception']//input[@placeholder='Специалист']")).val("отказ");
        $(byText("Пациент отказался от госпитализации")).click();
//        $(By.xpath("//*[@id='reception']/flow/form/div[5]/div/st-autocomplete/mat-form-field/div/div[1]/div[1]/input")).val(formatForDateNow.format(dateNow));
        $(By.xpath("//*[@id='reception']//input[@placeholder='Специалист']")).shouldHave(value(formatForDateNow.format(dateNow)));
//        $(By.xpath("//*[@id='reception']/flow/form/div[10]/div[2]/div[3]/date-time/div/div[2]/input-time/mat-form-field/div/div[1]/div/input")).val(timeGosp);
        $(By.xpath("//*[@id='reception']//input[@placeholder='Специалист']")).val("автотест отказа");

//        $(By.xpath("//div[contains(text(),'Обследован на RW:')]/mat-radio-group/mat-radio-button")).click();
//        $(By.xpath("//div[contains(text(),'Обследован на AIDS:')]/mat-radio-group/mat-radio-button")).click();
    }

    @Когда("^Пушкарева ищет в поиске пациента$")
    public void пушкареваИщетВПоискеПациента() throws Throwable {
//       String Curl = driver.getCurrentUrl();
//       System.out.println(Curl);
//       page.testResponseCode().linkExists(Curl);
        $(By.xpath("//input[@name='search']")).val("555888").pressEnter();
        $(By.xpath("//a[@href='/test/stationar/stationar_ui/statist/edit/card/61923']")).click();
//        open("http://109.95.224.42:2165/test/stationar/stationar_ui/statist/edit/card/61923");
    }

    @Дано("^Каплин авторизовался в интерфейсе стационара$")
    public void каплинАвторизовалсяВИнтерфейсеСтационара() throws Throwable {
        open("http://109.95.224.42:2165/test/stationar/stationar_ui/login");
        Thread.sleep(2000);
        $(By.xpath("//div[@class='login-form']/form/div[1]/input")).val("Яковлев"); //Талдом
        $(By.xpath("//*[contains(text(),'ОГБУЗ')]")).click(); //Талдомская ЦРБ
//        new PressEnter();
        $(By.xpath("//div[@class='login-form']/form/div[2]/input")).val("st_doctor");
        $(By.xpath("//div[@class='login-form']/form/div[3]/input")).val("123");
        $(By.xpath("//div[@class='login-form']/form/button")).click();
    }

    @Когда("^Каплин находит в поиске пациента$")
    public void каплинНаходитВПоискеПациента() throws Throwable {
        $(By.xpath("//input[@name='search']")).val("28944").pressEnter();
    }

    @Тогда("^В журнале отобразится пациент$")
    public void вЖурналеОтобразитсяПациент() throws Throwable {
        $(By.xpath("//*[@class='mat-table']//div")).shouldHave(Condition.text("28944"));

    }

    @И("^Каплин нажимает редактировать$")
    public void каплинНажимаетРедактировать() throws Throwable {
        $(By.xpath("//a[@href='/test/stationar/stationar_ui/statist/edit/card/61977']")).click();
    }

    @Тогда("^Открывается МКСБ пациента$")
    public void открываетсяМКСБПациента() throws Throwable {
        $(By.xpath("//header/div/statist-header/div/div[1]/div/div/div[2]/span")).shouldHave(Condition.text("Тестовый Пациент Автотестович, 01.01.2001, 789"));
    }

    @И("^Каплин проверяет заплненные поля$")
    public void каплинПроверяетЗаплненныеПоля() throws Throwable {

    }

    @Тогда("^Каплин заполняет блок “Движения пациента по отделениям”$")
    public void каплинЗаполняетБлокДвиженияПациентаПоОтделениям() throws Throwable {
        $(By.xpath("//*[@id='motion']/referral-patient/div[3]/div/ngx-datatable/div/datatable-body")).click();
        $(By.xpath("//*[@id='motion']//input[@placeholder='Врач']")).val("Каплин");
//                $(byText("11001 - КАПЛИН Г. В.")).click();
        $(By.xpath("//*[@id='motion']//div[class='autocomplete-list-container']//li[contains(., '11001 - КАПЛИН Г. В.')]")).click();
        $(By.xpath("//*[@id='motion']//input[@placeholder='Врач']")).val("Каплин");
        $(By.xpath("//*[@id='motion']//input[@placeholder='Врач']")).val("Каплин");
        $(By.xpath("//*[@id='motion']//input[@placeholder='Врач']")).val("Каплин");

        //*[@id="ui-id-101"]/li[2]
        //*[@id='motion']/referral-patient/div[4]/div/form/div/div/div/mat-card/mat-card-content/div[1]/div[3]/st-autocomplete/mat-form-field/div/div[1]/div[1]/div
        //*[@id="motion"]/referral-patient/div[3]/div/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]
//        $(By.xpath("//*[@id='motion']/referral-patient/div[3]/div/div/button")).click();
        $(By.xpath("//*[@id='motion']//button/span[.='add']")).click();
    }

    @И("^Каплин заполняет блок “Лечащий врач”$")
    public void каплинЗаполняетБлокЛечащийВрач() throws Throwable {
        $(By.xpath("//*[@id='agents']/div/div/h1/div/div/div/button")).click();
    }

    @И("^Каплин заполняет блок “Диагнозы”$")
    public void каплинЗаполняетБлокДиагнозы() throws Throwable {
        $(By.xpath("//*[@id='agents']/div/div/h1/div/div/div/button")).click();
    }

    @И("^Каплин заполняет блок “Койки”$")
    public void каплинЗаполняетБлокКойки() throws Throwable {
        $(By.xpath("//*[@id='agents']/div/div/h1/div/div/div/button")).click();
    }

    @И("^Каплин заполняет блок “Диетический стол”$")
    public void каплинЗаполняетБлокДиетическийСтол() throws Throwable {
        $(By.xpath("//*[@id='agents']/div/div/h1/div/div/div/button")).click();
    }

    @И("^Каплин заполняет блок “Назначения”$")
    public void каплинЗаполняетБлокНазначения() throws Throwable {
        $(By.xpath("//*[@id='agents']/div/div/h1/div/div/div/button")).click();
    }

    @И("^Каплин заполняет блок “Реанимационные периоды”$")
    public void каплинЗаполняетБлокРеанимационныеПериоды() throws Throwable {
        $(By.xpath("//*[@id='agents']/div/div/h1/div/div/div/button")).click();
    }

    @И("^Каплин заполняет блок “Медицинские услуги”$")
    public void каплинЗаполняетБлокМедицинскиеУслуги() throws Throwable {
        $(By.xpath("//*[@id='agents']/div/div/h1/div/div/div/button")).click();
    }

    @И("^Каплин заполняет блок “Хирургические операции”$")
    public void каплинЗаполняетБлокХирургическиеОперации() throws Throwable {
        $(By.xpath("//*[@id='agents']/div/div/h1/div/div/div/button")).click();
    }

    @И("^Каплин проверяет расчет КСГ$")
    public void каплинПроверяетРасчетКСГ() throws Throwable {
        $(By.xpath("//*[@id='agents']/div/div/h1/div/div/div/button")).click();
    }

    @И("^Каплин заполняет блок “Направления на исследования”$")
    public void каплинЗаполняетБлокНаправленияНаИсследования() throws Throwable {
        $(By.xpath("//*[@id='agents']/div/div/h1/div/div/div/button")).click();
    }

    @И("^Каплин заполняет блок “Выписка”$")
    public void каплинЗаполняетБлокВыписка() throws Throwable {
        $(By.xpath("//*[@id='agents']/div/div/h1/div/div/div/button")).click();
    }

//    @Тогда("^Пушкарева заполняет блок “Медицинские записи”$")
//    public void пушкареваЗаполняетБлокМедицинскиеЗаписи() {
//
//    }
}
