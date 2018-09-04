package callcenter.steps;
import com.codeborne.selenide.Configuration;

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
import java.io.IOException;
import java.lang.management.ManagementFactory;

import static com.codeborne.selenide.Selenide.$;

public class MyStepdefs implements SElements {
    public static Pages page;
    public static WebDriver driver;
    public static ChromeOptions chromeOptions;
    public static ChromeDriverService chromeDriverService;


    @Before
    public static void setupTimeout() throws InterruptedException {
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
        long threadId = Thread.currentThread().getId();
        String processName = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println("Started in thread: " + threadId + ", in JVM: " + processName);
//        page.patientRecordsPage().deleteRecord();
    }

    @After
    public static void afterTests() {
//        close();
        driver.quit();
    }
//    @After
//    public void getScenarioInfo(Scenario scenario) {
//        System.out.println(scenario.getId());
//        System.out.println(scenario.getName());
//        System.out.println(scenario.getStatus());
//        System.out.println(scenario.isFailed());
//        System.out.println(scenario.getSourceTagNames());
//    }


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

        clear.shouldBe(Condition.visible);
    }

    @Когда("^Андрей выбирает \"([^\"]*)\"$")
    public void FindLpu(String arg0) {
        page.recordDoctorPage().changeLpu(arg0);
        }

    @И("^затем выбирает \"([^\"]*)\"$")
    public void FindSrec(String arg0) {
        page.recordDoctorPage().changeSpec(arg0);
    }

    @И("^выбирает ближайшую запись у \"([^\"]*)\"$")
    public void FindDay(String arg0) {
        page.recordDoctorPage().changeDoc(arg0);
//        dayz.click();
    }

    @И("^выбирает время приема$")
    public void FindTime() {
        timerec.click();
    }

    @И("^затем выбирает: Записать на прием$")
    public void RecToDoc() {
        recordbutton.click();
    }

    @Тогда("^появится всплывающее окно с полями \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void WinModal(String lpu, String special, String fioDoc, String kab) throws InterruptedException {

        page.recordDoctorPage().assertDoc(lpu, special, fioDoc, kab);
//        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
//        Map<String, String> proData = new ObjectMapper().readValue(reader, Map.class);
        closemodal.click();
    }

    @Когда("^Андрей хочет записать пациента в лист ожидания$")
    public void RecordWait() throws InterruptedException {
        clear.shouldBe(Condition.visible);
    }

    @И("^выбирает Оформить лист ожидания$")
    public void RecWait() {
        waitbutton.click();
    }

    @И("^заполняет поле \"([^\"]*)\"$")
    public void Complaint(String com) {
        complain.sendKeys(com);
    }

    @И("^выбирает Оформить$")
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
        allrecord.click();
        $(By.xpath("//*[@class='waiting-list-item']")).shouldHave(Condition.text("Создана"));
    }

    @Когда("^Андрей нажимает “Подробная информация” в записи на прием$")
    public void DetailsWl() {
        $(By.xpath("//*[@id='talon-list']/tr/td[1]/div/button[2]")).click();
    }

    @То("^появится всплывающие окно с полями: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void DetailModal(String arg0, String arg1, String arg2) {
        page.waitingListPage().assertWL(arg0,arg1,arg2);
    }

    @Тогда("^Андрей нажимает История$")
    public void ChangeHistory() {
        $(By.xpath("//*[@id='waiting-list']/tr[2]/td[1]/div[2]/button")).click();
    }

    @И("^появится всплывающие окно с таблицей с полями Дата, Автор, Что изменилось, Изменение$")
    public void HistoryModal() {
        page.waitingListPage().assertWLHis();
        $(By.xpath("//*[@id='waiting-list-history']/table/tbody[2]")).getText();
    }

    @Допустим("^Андрей захотел просмотреть все листы ожидания$")
    public void WatchAllWl() {
        $(By.xpath("//input[@id='show-all-waiting-list']")).shouldBe(Condition.visible);
    }

    @Когда("^Андрей ставит отметку Показать все$")
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

    @Когда("^Андрей нажимает Перенести запись$")
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

    @Когда("^Андрей нажимает Удалить$")
    public void DeleteWl() {
        $(By.xpath("//*[@class='waiting-list-item']/td[7]/button")).click();
    }

    @Тогда("^у вызова проставляется статус Отменена$")
    public void CancelWl() {
        $(By.xpath("//*[@class='waiting-list-item']")).shouldHave(Condition.text("Отменена"));
    }

    @Допустим("^Андрей захотел отменить запись на прием$")
    public void WantCancelRecord() {
        allrecord.click();
        delete.shouldBe(Condition.visible);
    }

    @Когда("^Андрей нажимает Удалить запись$")
    public void CancelRecord() {
        delete.click();
        yes.click();
    }

    @Тогда("^запись к \"([^\"]*)\" пропадает из поля Записи на прием$")
    public void ClearRecord(String arg0) {
        zapis.shouldNotHave(Condition.text(arg0));
    }

    @И("^создана запись на прием к \"([^\"]*)\"$")
    public void CreateRecord(String arg0)  {
        page.recordDoctorPage().recordDoctor2(arg0);
    }

    @И("^создана запись в ЛО к Клименко$")
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

    @Тогда("^открылась вкладка с активными направлениями,с указанием \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void ActiveDirectionList(String arg0, String arg1,String arg2) {
        page.apoinmentsPage().eqNapr(arg0, arg1, arg2);
    }

    @Допустим("^Андрей захотел записать пациента по направлению$")
    public void WantDirection()  {
        apolpu.shouldBe(Condition.visible);
    }

    @Когда("^Андрей нажал на выбранное направление$")
    public void Direction()  {
        apolpu.click();
    }

    @То("^появляется расписание врачей этой специальности$")
    public void SheduleDoc()  {
        recordDate.shouldBe(Condition.visible);
    }

    @Тогда("^появляется всплывающее окно с заполненными полями:$")
    public void ModalRecord()  {
        closemodal.shouldBe(Condition.visible);
    }

    @То("^в Записях пациента появится активная запись на прием к \"([^\"]*)\"$")
    public void ActiveRecordDirection(String arg0)  {
        allrecord.click();
        zapis.shouldNotHave(Condition.text(arg0));
    }

    @Допустим("^Андрей перешел на страницу вызова врача$")
    public void CalldoctorPage() {
        calldoc.click();
    }
//
    @Допустим("^Андрей не известен пациент$")
    public void PatientNoFound() {
        fondPatient1.shouldNotHave(Condition.text("АСТАХОВА"));
    }
//
//    @Когда("^Андрей заполняет обязательные поля$")
//    public void FillInField(String kartashev) {
//    }

    @Тогда("^вводит \"([^\"]*)\" в фильтре списка учреждений$")
    public void LpuFilter(String arg0) {
        page.callDoctorPage().getLpu(arg0);
    }

    @Также("^нажимает “Вызвать врача”$")
    public void CallDoc() {
        $(By.xpath("//button[@id='call-doctor-button']")).click();
    }

    @То("^появится всплывающие окно с заполненными полями \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void aseertModal(String arg1,String arg2,String arg3,String arg4,String arg5,String arg6,String arg7,String arg8,String arg9) {
        page.callDoctorPage().eqCallDoc(arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    }

    @Допустим("^Андрей хочет вызвать врача$")
    public void WantCall() {
        calldocdom.click();
        fondPatient1.click();
    }

    @Тогда("^Андрей заполняет поля \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void FillInFields(String comp,String porch,String floor,String intercomCode, String phone, String adr) {
        page.callDoctorPage().writePat(comp, porch, floor, intercomCode, phone, adr);

    }

    @И("^найден пациент Астахова$")
    public void FindPat() throws IOException, InterruptedException {
        page.findPatientPage().findPatient();
    }

//    @Дано("^Андрей хочет найти пациента по ФИО и Дате рождения$")
//    public void WantFindByFioAndDate() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }

    @Когда("^Андрей заполняет данные \"([^\"]*)\" и \"([^\"]*)\"$")
    public void FindByFioAndDate(String arg1, String arg2) throws Throwable {
        page.findPatientPage().findByFio(arg1,arg2);

    }

    @Допустим("^Андрей захотел проверить корректость полей: Номер талона, Врач, Специальность, Дата создания записи, Дата приема, Время приема$")
    public void EqRec() throws Throwable {
        page.recordDoctorPage().EqualDoc();
    }

    @То("^появится всплывающие окно с полями ЛПУ, адрес ЛПУ, Источник вызова, Дата создания$")
    public void modWind() throws Throwable {
        page.recordDoctorPage().EqualDetal();
    }

    @И("^подтверждает создание вызова$")
    public void confirmCall() throws Throwable {
        $(By.xpath("//button[@class='btn btn-success']")).click();
    }

    @Допустим("^Андрей захотел увидеть ошибку при создании повторной записи к врачу$")
    public void WantWatchEx() throws Throwable {
        fondPatient1.shouldHave(Condition.text("АСТАХОВА"));
    }

    @Тогда("^он увидит ошибку содержащую \"([^\"]*)\"$")
    public void WatchEx(String arg0) throws Throwable {
        notyfyRec.shouldHave(Condition.text(arg0));
    }

    @Когда("^Андрей хочет записать пациента повторно к \"([^\"]*)\"$")
    public void DoubleRecord(String arg0) throws Throwable {
        page.recordDoctorPage().createNewCall(arg0);
    }

    @Дано("^Андрей авторизуется в ВебМис$")
    public void андрейАвторизуетсяВВебМис() throws Throwable {
        page.loginPage().loginMis();
    }

    @И("^открывает расписание врача \"([^\"]*)\"$")
    public void открываетРасписаниеВрача(String arg0) throws Throwable {
        $(By.xpath("//a[text()='Расписание приёма']/@href")).click();
        $(By.id("sinpdocprvdgrid1")).val(arg0);
        $(By.id("btnfinddocprvdgrid1")).click();
        $(By.id("docprvdgrid1")).click();
    }

    @Тогда("^Проверяет наличие созданной записи на прием$")
    public void проверяетНаличиеСозданнойЗаписиНаПрием() throws Throwable {
        $(By.xpath("//div[class='qtip-titlebar ui-widget-header ui-tooltip-header']")).shouldHave(Condition.text("Астахова"));
    }

    @И("^найден пациент Темников$")
    public void найденПациентТемников() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @И("^создана карта диспансеризации$")
    public void созданаКартаДиспансеризации() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Тогда("^в колонке \"([^\"]*)\" отобразится действующий маршрутный лист$")
    public void вКолонкеОтобразитсяДействующийМаршрутныйЛист(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }
}
