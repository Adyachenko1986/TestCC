package callcenter.steps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Pages;
import pages.SElements;
import com.codeborne.selenide.Condition;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class MyStepdefs implements SElements {
    public static Pages page;
    public static WebDriver driver;
    public static ChromeOptions chromeOptions;
    public static ChromeDriverService chromeDriverService;

    static String perek = "тест";
    static String url;
    static String snpol;
    static String fam;
    static String bd;
    static SelenideElement lpu;
    static SelenideElement mcod;
    static SelenideElement apoinmentsList;
    static SelenideElement apoLpu;

    @Before
    public static void setupTimeout() {
        chromeDriverService = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("src/main/resources/chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=1240,1020");
        driver = new ChromeDriver(chromeDriverService, chromeOptions);
        WebDriverRunner.setWebDriver(driver);
        Configuration.timeout = 8000;
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        Configuration.browser = "chrome";
        page = new Pages();
    }

    @After
    public static void afterTests() {
//        close();
        driver.quit();
    }
    @After
    public void getScenarioInfo(Scenario scenario) {
        System.out.println(scenario.getId());
        System.out.println(scenario.getName());
        System.out.println(scenario.getStatus());
        System.out.println(scenario.isFailed());
        System.out.println(scenario.getSourceTagNames());
    }


    /*Вход в АРМ */
    @Допустим("^что Андрей вошел в АРМ оператора под своей учетной записью$")
    public void LoginCC() {
        page.loginPage().login();
    }

    @Тогда("^Андрей успешно входит в АРМ оператора$")
    public void SucsessLog() {
        find.shouldBe(Condition.visible);
    }

    /*Поиск пациента по номеру полиса*/
    @Дано("^Андрей хочет найти пациента по номеру полиса$")
    public void FindPol() {
        find.shouldBe(Condition.visible);
    }

    @Когда("^Андрей заполняет данные \"([^\"]*)\"$")
    public void EnerPolis(String polisNumber) throws Throwable  {
        page.findPatientPage().enterPol(polisNumber);
    }

    @И("^нажимает кнопку найти$")
    public void EnterArm() {
        page.findPatientPage().clickBtn();
    }

    @Тогда("^в колонке появится строка содержащая следующие поля: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void Patient(String family, String born, String polisNumber)  {
        page.findPatientPage().assertTable(family, born, polisNumber);

    }

//    @Когда("^Андрей заполняет данные \"([^\"]*)\"$")
//    public void EnterFio(String arg) throws Throwable {
//        page.findPatientPage().findByFio(arg);
//    }

    @Дано("^очистка поиска$")
    public void ClearSearch() {
        clear.click();
    }

    @Дано("^Андрей хочет записать пациента к терапевту$")
    public void RecordToDocor() {
//        mcod.shouldBe(Condition.visible);
    }

    @Когда("^Андрей выбирает \"([^\"]*)\"$")
    public void FiendLpu() {
//        lpu.click();
    }

    @И("^затем выбирает \"([^\"]*)\"$")
    public void FiendSrec() {
        spec.click();
    }

    @И("^выбирает ближайшую запись у \"([^\"]*)\"$")
    public void FiendDay() {
        dayz.click();
    }

    @И("^выбирает время приема$")
    public void FiendTime() {
        timerec.click();
    }

    @И("^затем выбирает: Записать на прием$")
    public void RecToDoc() {
        recordbutton.click();
    }

    @Тогда("^появится всплывающее окно с полями \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void WinModal(String lpu, String special, String fioDoc, String kab, String date, String time, String ticketNumber) {

        page.recordDoctorPage().assertDoc(lpu, special, fioDoc, kab, date, time, ticketNumber);
//        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
//        Map<String, String> proData = new ObjectMapper().readValue(reader, Map.class);
        closemodal.click();
    }

    @Когда("^Андрей хочет записать пациента в лист ожидания$")
    public void RecordWait() {
        waitbutton.shouldBe(Condition.visible);
    }

    @И("^выбирает “Оформить лист ожидания” у специальности \"([^\"]*)\"$")
    public void RecWait() {
        waitbutton.click();
    }

    @И("^заполняет поле \"([^\"]*)\"$")
    public void Complaint() {
        complain.sendKeys("тест ожидания");
    }

    @И("^выбирает “Оформить”$")
    public void Oformit() {
        oform.click();
    }

    @И("^Появится всплывающее окно с записью \"([^\"]*)\"$")
    public void ModalWin(String arg0) {
        $(By.xpath("//div[@id='notifies']")).shouldHave(Condition.text(arg0));
    }


//    @И("^найден пациент Астахова $")
//    public void Scenar() {
//
//        page.findPatientPage().enterPol();
//        page.findPatientPage().clickBtn();
//    }

    @Допустим("^Андрей захотел просмотреть записи пациента$")
    public void WatchPatientRecord() {
        allrecord.shouldBe(Condition.visible);
    }

    @Когда("^Андрей выбрал “Все записи пациента”$")
    public void ChooseAllRecord() {
        allrecord.click();
    }

    @Тогда("^открылась вкладка с записями \"([^\"]*)\" \"([^\"]*)\"$")
    public void OpeninigTabRecord(String arg0, String arg1) {
        $(By.xpath("//div[contains(text()]")).shouldHave(Condition.text(arg0));
        $(By.xpath("//div[contains(text()]")).shouldHave(Condition.text(arg1));
    }

    @Допустим("^Андрей захотел просмотреть активный лист ожидания$")
    public void WatchActiveWl() {
        $(By.xpath("//*[@class='waiting-list-item']")).shouldHave(Condition.text("Создана"));
    }

    @Когда("^Андрей нажимает “Подробная информация”$")
    public void DetailsWl() {
        $(By.xpath("//*[@class='waiting-list-item']/div/button")).click();
    }

    @То("^появится всплывающие окно с полями:$")
    public void DetailModal() {
        $(By.xpath("//*[@class='waiting-list-item']/div")).getText();
    }

    @Тогда("^Андрей нажимает “История”$")
    public void ChangeHistory() {
        $(By.xpath("//*[@class='waiting-list-item']/div[2]/button")).click();
    }

    @И("^появится всплывающие окно с таблицей с полями:$")
    public void HistoryModal() {
        $(By.xpath("//*[@id='waiting-list-history']/table/tbody[2]")).getText();
    }

    @Допустим("^Андрей захотел просмотреть все листы ожидания$")
    public void WatchAllWl() {
        $(By.xpath("//input[@id='show-all-waiting-list']")).shouldBe(Condition.visible);
    }

    @Когда("^Андрей ставит отметку “Показать все”$")
    public void WiewAll() {
        $(By.xpath("//input[@id='show-all-waiting-list']")).click();
    }

    @Тогда("^появляется список всех созданных листов ожидания$")
    public void ListWl() {
        $(By.xpath("//*[@class='waiting-list-item']")).shouldHave(Condition.text("Отменена"));
    }

    @Допустим("^Андрей захотел перенести запись на прием$")
    public void WantRerecord() {
        reschedule.shouldBe(Condition.visible);
    }

    @Когда("^Андрей нажимает “Перенести запись”$")
    public void ClickRerecord() {
        reschedule.click();
    }

    @Тогда("^открывается окно “перенос записи талона” с расписанием врачей этой специальности$")
    public void RerecordWindow() {
        $(By.xpath("//div[@class='modal-header']")).shouldHave(Condition.text("Перенос записи талона"));
    }

    @И("^Андрей выбирает дату$")
    public void ChangeData() {
        recordDate.click();
    }

    @И("^нажимает “перенести запись”$")
    public void RerecordButton() {
        rerecord.click();
    }

    @То("^появляется всплывающее окно “Запись перенесена успешно”$")
    public void ModalSucsess() {
        yes.click();
    }

    @Допустим("^Андрей захотел отменить лист ожидания$")
    public void WantCancelWl() {
        $(By.xpath("//*[@class='waiting-list-item']/td[7]/button")).shouldBe(Condition.visible);
    }

    @Когда("^Андрей нажимает “Удалить”$")
    public void DeleteWl() {
        $(By.xpath("//*[@class='waiting-list-item']/td[7]/button")).click();
    }

    @Тогда("^у вызова проставляется статус “Отменена”$")
    public void CancelWl() {
        $(By.xpath("//*[@class='waiting-list-item']")).shouldHave(Condition.text("Отменена"));
    }

    @Допустим("^Андрей захотел отменить запись на прием$")
    public void WantCancelRecord() {
        delete.shouldBe(Condition.visible);
    }

    @Когда("^Андрей нажимает “Удалить запись”$")
    public void CancelRecord() {
        delete.click();
    }

    @Тогда("^запись пропадает из поля “записи на прием”$")
    public void ClearRecord() {
    }

    @И("^создана запись на прием$")
    public void CreateRecord()  {
        page.recordDoctorPage().recordDoctor();
    }

    @И("^создан запись в ЛО$")
    public void CreateWl()  {
        page.waitingListPage().waitingList();
    }

    @Допустим("^Андрей захотел просмотреть направления пациента$")
    public void WantDirectionList()  {
//        apoinmentsList.shouldBe(Condition.visible);
    }

    @Когда("^Андрей выбрал “Записать по направлению”$")
    public void DirectionList() {
//        apoinmentsList.click();
    }

    @Тогда("^открылась вкладка с активными направлениями, где указано куда направлен пациент, специализация, ФИО врача и период действия направления$")
    public void ActiveDirectionList() {
    }

    @Допустим("^Андрей захотел записать пациента по направлению$")
    public void WantDirection()  {
//        apoLpu.shouldBe(Condition.visible);
    }

    @Когда("^Андрей нажал на выбранное направление$")
    public void Direction()  {
//        apoLpu.click();
    }

    @То("^появляется расписание врачей этой специальности$")
    public void SheduleDoc()  {
        recordDate.shouldBe(Condition.visible);
    }

    @Тогда("^появляется всплывающее окно с заполненными полями:$")
    public void ModalRecord()  {
        closemodal.shouldBe(Condition.visible);
    }

    @То("^в “Записях пациента” появится активная запись на прием$")
    public void ActiveRecordDirection()  {
        allrecord.click();
        reschedule.shouldBe(Condition.visible);
    }

    @Допустим("^Андрей перешел на страницу вызова врача$")
    public void CalldoctorPage() {
    }

    @Допустим("^Андрей не известен пациент$")
    public void PatientNoFound() {
    }

    @Когда("^Андрей заполняет обязательные поля$")
    public void андрейЗаполняетОбязательныеПоля(String kartashev) {
    }

    @Тогда("^вводит название ЛПУ в фильтре списка учреждений$")
    public void вводитНазваниеЛПУВФильтреСпискаУчреждений() {
    }

    @Также("^нажимает “Вызвать врача”$")
    public void нажимаетВызватьВрача() {
    }

    @То("^появится всплывающие окно с заполненными полями$")
    public void появитсяВсплывающиеОкноСЗаполненнымиПолями() {
    }

    @Допустим("^Андрей хочет вызвать врача$")
    public void андрейХочетВызватьВрача() {
    }

    @Тогда("^Андрей заполняет поля$")
    public void андрейЗаполняетПоля(String kartashev) {
    }

    @И("^найден пациент Астахова$")
    public void найденПациент() throws Throwable {
        page.findPatientPage().findPatient();
//        page.findPatientPage().enterPol(name);
//        page.findPatientPage().clickBtn();
        throw new PendingException();
    }

    @Дано("^Андрей хочет найти пациента по ФИО и Дате рождения$")
    public void андрейХочетНайтиПациентаПоФИОИДатеРождения() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Когда("^Андрей заполняет данные \"([^\"]*)\" и \"([^\"]*)\"$")
    public void андрейЗаполняетДанныеФИОИДатаРождения(String arg1, String arg2) throws Throwable {
        page.findPatientPage().findByFio(arg1,arg2);

    }

    @Когда("^Андрей заполняет данные <ФИО> и <Дата рождения>$")
    public void андрейЗаполняетДанныеФИОИДатаРождения() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


    public void появитсяВсплывающееОкноСПолями(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
