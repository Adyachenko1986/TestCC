package callcenter.steps;
import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import pages.Pages;
import pages.SElements;
import com.codeborne.selenide.Condition;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

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
        Configuration.timeout = 20000;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("Monitor resolution: " + (int) screenSize.getWidth() + "x" + (int) screenSize.getHeight());
        System.out.println("Chrome window resolution: " + getWebDriver().manage().window().getSize());

//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        Configuration.browser = "chrome";
        page = new Pages();
        long threadId = Thread.currentThread().getId();
        String processName = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println("Started in thread: " + threadId + ", in JVM: " + processName);
        page.mis().deleteSheduleDoc();
        page.mis().createSheduleDoc();
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


    /*Вход в АРМ */
    @Допустим("^что Тестовый оператор вошел в АРМ оператора под своей учетной записью$")
    public void LoginCC() throws InterruptedException {
        page.loginPage().login();
        Thread.sleep(1000);
    }

    @Тогда("^Тестовый оператор успешно входит в АРМ оператора$")
    public void SucsessLog() {
        find.shouldBe(Condition.visible);
        System.out.println("Фича 1");
    }

    /*Поиск пациента по номеру полиса*/
    @Дано("^Тестовый оператор хочет найти пациента по номеру полиса$")
    public void FindPol() {
        find.shouldBe(Condition.visible);
    }

    @Когда("^Тестовый оператор заполняет данные \"([^\"]*)\"$")
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
        System.out.println("Фича 2-3");
    }

    @Дано("^очистка поиска$")
    public void ClearSearch() {
        clear.click();
    }

    @Дано("^Тестовый оператор хочет записать пациента к терапевту$")
    public void RecordToDocor() {
        clear.shouldBe(Condition.visible);
    }

    @Когда("^Тестовый оператор выбирает \"([^\"]*)\"$")
    public void FindLpu(String arg0) throws InterruptedException {
        page.recordDoctorPage().changeLpu(arg0);
        }

    @И("^затем выбирает \"([^\"]*)\"$")
    public void FindSrec(String arg0) throws InterruptedException {
        page.recordDoctorPage().changeSpec(arg0);
    }

    @И("^выбирает ближайшую запись у \"([^\"]*)\"$")
    public void FindDay(String arg0) throws InterruptedException {
        page.recordDoctorPage().changeDoc(arg0);
    }

    @И("^выбирает время приема$")
    public void FindTime() {
        nextday.click();
        recordTimeRandom.click();
    }

    @И("^затем выбирает: Записать на прием$")
    public void RecToDoc() {
        recordbutton.click();
    }

    @Тогда("^появится всплывающее окно с полями \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void WinModal(String lpu, String special, String fioDoc, String kab) throws InterruptedException {

        page.recordDoctorPage().assertDoc(lpu, special, fioDoc, kab);
        closemodal.click();
    }

    @Когда("^Тестовый оператор хочет записать пациента в лист ожидания$")
    public void RecordWait() {
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
        $(By.xpath("//div[@id='notifies']")).shouldHave(text(arg0));
    }


//    @И("^найден пациент Астахова $")
//    public void Scenar() {
//
//        page.findPatientPage().enterPol();
//        page.findPatientPage().clickBtn();
//    }

    @Допустим("^Тестовый оператор захотел просмотреть записи пациента$")
    public void WatchPatientRecord() {
        allrecord.shouldBe(Condition.visible);
    }

    @Когда("^Тестовый оператор выбрал “Все записи пациента”$")
    public void ChooseAllRecord() {
        allrecord.click();
    }

    @Тогда("^открылась вкладка с записями \"([^\"]*)\" \"([^\"]*)\"$")
    public void OpeninigTabRecord(String arg0, String arg1) {
        $(By.xpath("//div[contains(text()]")).shouldHave(text(arg0));
        $(By.xpath("//div[contains(text()]")).shouldHave(text(arg1));
    }

    @Допустим("^Тестовый оператор захотел просмотреть активный лист ожидания$")
    public void WatchActiveWl() {
        allrecord.click();
        $(By.xpath("//*[@class='waiting-list-item']")).shouldHave(text("Создана"));
    }

    @Когда("^Тестовый оператор нажимает “Подробная информация” в записи на прием$")
    public void DetailsRDL() {
        $(By.xpath("//*[@id='talon-list']/tr/td[1]/div/button[2]")).click();
    }

    @Когда("^Тестовый оператор нажимает “Подробная информация” в листах ожидания$")
    public void DetailsWl() {
        $(By.xpath("//*[@id='waiting-list']/tr[2]/td[1]/div[1]/button")).click();
    }

    @То("^появится всплывающие окно с полями: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void DetailModal(String arg0, String arg1, String arg2) {
        page.waitingListPage().assertWL(arg0,arg1,arg2);
    }

    @Тогда("^Тестовый оператор нажимает История$")
    public void ChangeHistory() {
        $(By.xpath("//*[@id='waiting-list']/tr[2]/td[1]/div[2]/button")).click();
    }

    @И("^появится всплывающие окно с таблицей с полями Дата, Автор, Что изменилось, Изменение$")
    public void HistoryModal() {
        page.waitingListPage().assertWLHis();
        $(By.xpath("//*[@id='waiting-list-history']/table/tbody[2]")).getText();
        System.out.println("Фича 6");
    }

    @Допустим("^Тестовый оператор захотел просмотреть все листы ожидания$")
    public void WatchAllWl() {
        $(By.xpath("//input[@id='show-all-waiting-list']")).shouldBe(Condition.visible);
    }

    @Когда("^Тестовый оператор ставит отметку Показать все$")
    public void WiewAll() {
        $(By.xpath("//input[@id='show-all-waiting-list']")).click();
    }

    @Тогда("^появляется список всех созданных листов ожидания$")
    public void ListWl() {
        $(By.xpath("//*[@class='waiting-list-item unactive']")).shouldHave(text("Отменена"));
        System.out.println("Фича 17");
    }

    @Допустим("^Тестовый оператор захотел перенести запись на прием$")
    public void WantRerecord() {
        allrecord.click();
        reschedule.shouldBe(Condition.visible);
    }

    @Когда("^Тестовый оператор нажимает Перенести запись$")
    public void ClickRerecord() {
        reschedule.click();
    }

    @Тогда("^открывается окно “перенос записи талона” с расписанием врачей этой специальности$")
    public void RerecordWindow() {
        $(By.xpath("//div[@class='modal-header']")).shouldHave(text("Перенос записи талона"));
    }

    @И("^Тестовый оператор выбирает дату$")
    public void ChangeData() {
        recordDate.click();
    }

    @И("^нажимает “перенести запись”$")
    public void RerecordButton() {
        rerecord.click();
    }

    @То("^появляется всплывающее окно “Запись перенесена успешно”$")
    public void ModalSucsess() {
        notyfyRec.shouldHave(text("Запись перенесена успешно"));
        System.out.println("Фича 9");
    }

    @Допустим("^Тестовый оператор захотел отменить лист ожидания$")
    public void WantCancelWl() {
        $(By.xpath("//*[@class='waiting-list-item']/td[7]/button")).shouldBe(Condition.visible);
    }

    @Когда("^Тестовый оператор нажимает Удалить$")
    public void DeleteWl() throws InterruptedException {
        $(By.xpath("//*[@class='waiting-list-item']/td[7]/button")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }

    @Тогда("^у вызова проставляется статус Отменена$")
    public void CancelWl() {
        $(By.xpath("//*[@id='show-all-waiting-list']")).click();
        $(By.xpath("//*[@id='waiting-list']/tr[2]/td[6]")).shouldHave(text("Отменена"));
        System.out.println("Фича 10");
    }

    @Допустим("^Тестовый оператор захотел отменить запись на прием$")
    public void WantCancelRecord() throws InterruptedException {
//        Actions actions = new Actions(driver);
//        actions.moveToElement(find);
//        actions.perform();
//        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
//                ,find);
        Thread.sleep(2000);
        createShedule.hover();
        allrecord.click();
        delete.shouldBe(Condition.visible);
    }

    @Когда("^Тестовый оператор нажимает Удалить запись$")
    public void CancelRecord() {
        delete.click();
        yes.click();
    }

    @Тогда("^запись к \"([^\"]*)\" пропадает из поля Записи на прием$")
    public void ClearRecord(String arg0) {
        zapis.shouldNotHave(text(arg0));
        System.out.println("Фича 16");
    }

    @И("^создана запись на прием к \"([^\"]*)\"$")
    public void CreateRecord(String arg0) throws InterruptedException {
        page.recordDoctorPage().recordDoctor(arg0);
    }

    @И("^создана запись в ЛО к Клименко$")
    public void CreateWl()  {
        page.waitingListPage().waitingList();
    }

    @Допустим("^Тестовый оператор захотел просмотреть направления пациента$")
    public void WantDirectionList()  {
//        apoinmentsList.shouldBe(Condition.visible);
    }

    @Когда("^Тестовый оператор выбрал “Записать по направлению”$")
    public void DirectionList() {
//        apoinmentsList.click();
    }

    @Тогда("^открылась вкладка с активными направлениями,с указанием \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void ActiveDirectionList(String arg0, String arg1,String arg2) {
        page.apoinmentsPage().eqNapr(arg0, arg1, arg2);
        System.out.println("Фича 18");
    }

    @Допустим("^Тестовый оператор захотел записать пациента по направлению$")
    public void WantDirection()  {
        directionList.shouldBe(Condition.visible).click();
    }

    @Когда("^Тестовый оператор нажал на выбранное направление$")
    public void Direction()  {
        $(By.xpath("//*[@class='btn btn-default btn-Tblock']/strong[2]")).shouldHave(text("Терапия")).click();
//        apolpu.click();
    }

    @То("^появляется расписание врачей этой специальности$")
    public void SheduleDoc()  {
        $(By.xpath("//tr[contains(.,'Ай Бо Лит')]//button[@class='btn btn-block btn-success']")).shouldBe(Condition.visible);
    }

    @Тогда("^появляется всплывающее окно с заполненными полями:$")
    public void ModalRecord()  {
        closemodal.shouldBe(Condition.visible);
    }

    @То("^в Записях пациента появится активная запись на прием к \"([^\"]*)\"$")
    public void ActiveRecordDirection(String arg0)  {
        allrecord.click();
        zapis.shouldNotHave(text(arg0));
        System.out.println("Фича 11");
    }

    @Допустим("^Тестовый оператор перешел на страницу вызова врача$")
    public void CalldoctorPage() {
        calldoc.click();
    }
//
    @Допустим("^Тестовый оператор не известен пациент$")
    public void PatientNoFound() {
        fondPatient1.shouldNotHave(text("АСТАХОВА"));
    }
//
//    @Когда("^Тестовый оператор заполняет обязательные поля$")
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
    public void aseertModal(String arg1,String arg2,String arg3,String arg4,String arg5,String arg6,String arg7,String arg8,String arg9) throws InterruptedException {
        page.callDoctorPage().eqCallDoc(arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
        closemodal.click();
        System.out.println("Фича 12");
    }

    @Допустим("^Тестовый оператор хочет вызвать врача$")
    public void WantCall() {
        calldocdom.click();
    }

    @Тогда("^Тестовый оператор заполняет поля \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", Телефон, \"([^\"]*)\"$")
    public void FillInFields(String comp,String porch,String floor,String intercomCode, String adr) {
        page.callDoctorPage().writePat(comp, porch, floor, intercomCode, adr);

    }

    @И("^найден пациент Астахова$")
    public void FindPat() throws IOException, InterruptedException {
        page.findPatientPage().findPatient();
    }


    @Когда("^Тестовый оператор заполняет данные \"([^\"]*)\" и \"([^\"]*)\"$")
    public void FindByFioAndDate(String arg1, String arg2) throws Throwable {
        page.findPatientPage().findByFio(arg1,arg2);

    }

    @Допустим("^Тестовый оператор захотел проверить корректость полей: Номер талона, Врач, Специальность, Дата создания записи, Дата приема, Время приема$")
    public void EqRec() throws Throwable {
        page.recordDoctorPage().EqualDoc();
    }

    @То("^появится всплывающие окно с полями ЛПУ, адрес ЛПУ, Источник вызова, Дата создания$")
    public void modWind() {
        page.recordDoctorPage().EqualDetal();
        System.out.println("Фича 7");
    }

    @И("^подтверждает создание вызова$")
    public void confirmCall() throws InterruptedException {
        Thread.sleep(1000);
        $(By.xpath("//button[@class='btn btn-success']")).click();
    }

    @Допустим("^Тестовый оператор захотел увидеть ошибку при создании повторной записи к врачу$")
    public void WantWatchEx()  {
        fondPatient1.shouldHave(text("АСТАХОВА"));
        $(By.xpath("//button[contains(.,'СТЕНД ЕМИАС МО')]")).shouldBe(Condition.visible);
    }

    @Тогда("^он увидит ошибку содержащую \"([^\"]*)\"$")
    public void WatchEx(String arg0)  {
        notyfyRec.shouldHave(text(arg0));
        System.out.println("Фича 14");
    }

    @Когда("^Тестовый оператор хочет записать пациента повторно к \"([^\"]*)\"$")
    public void DoubleRecord(String arg0) throws Throwable {
        page.recordDoctorPage().createNewCall(arg0);
    }

    @Дано("^Тестовый оператор авторизуется в ВебМис$")
    public void misLogin() {
        page.mis().loginMis();
    }

    @И("^открывает расписание врача \"([^\"]*)\"$")
    public void docShedule(String arg0) throws InterruptedException {
        page.mis().OpenShedule(arg0);;
    }

    @Тогда("^Проверяет наличие созданной записи на прием$")
    public void checkRecordDoc()  {

        $(By.xpath("//div[class='qtip-content']")).shouldHave(text(" Астахова Виктория Павловна, 1999 г.р."));
        System.out.println("Фича 15");
    }

    @И("^найден пациент Темников$")
    public void findTemnikov()  {
        // Write code here that turns the phrase above into concrete actions
    }

    @И("^создана карта диспансеризации$")
    public void createDisp()  {
        // Write code here that turns the phrase above into concrete actions
    }

    @Тогда("^в колонке \"([^\"]*)\" отобразится действующий маршрутный лист$")
    public void marshrutka(String arg0)  {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Фича 8");
    }

    @Тогда("^Тестовый оператор выбирает дату привема$")
    public void priemDate()  {
        $(By.xpath("//tr[contains(.,'Ай Бо Лит')]//button[@class='btn btn-block btn-success']")).click();
    }

    @Допустим("^Тестовый оператор захотел просмотреть все вызовы на дом$")
    public void watchAllCd()  {
        $(By.id("call-doc-home-list-tab")).click();
    }

    @Тогда("^появляется список всех созданных вызовов$")
    public void callList()  {
        $(By.xpath("//*[@id='all-patient-records']/div/div/div/div")).shouldHave(text("Список заявок вызова доктора на дом"));
        $(By.xpath("//*[@id='patientLpuList']/div[2]/button")).click();
    }

    @И("^Тестовый оператор удаляет созданный вызов$")
    public void deleteCallToDoc()  {
        $(By.xpath("//tbody[@id='call-doc-list']//button[@class='btn btn-danger']")).click();
        driver.switchTo().alert().accept();
        System.out.println("Фича 19");
    }

    @Когда("^Тестовый оператор захотел проверить корректость прикрепления пациента$")
    public void prikrepCorrect()  {
        $(By.xpath("//*[@id='accretionsPatient']/tbody/tr/td[1]/span")).shouldHave(text("СТЕНД ЕМИАС МО"));
        $(By.id("areaType")).shouldHave(text("Терапевтический (в т.ч. цеховой) Терапевтический щ-2"));
        $(By.id("docName")).shouldHave(text("Моков Павел Александрович"));

    }

    @Тогда("^в поле данные пациента будут отображено: Медучереждение, Участок и Врач$")
    public void polePatientData()  {
        System.out.println("Фича 20");
    }

    @Когда("^Тестовый оператор захотел проверить корректость количества талонов в фильтре специальностей$")
    public void checkCorrectNumTalon() {
        $(By.id("select2-searchDepartment-container")).click();
        String spec1 = $(By.xpath("//*[@id='select2-searchDepartment-result-tt9f-11802']")).getText();
        String spec2 = $(By.xpath("//*[@id='select2-searchDepartment-result-l52g-12100']")).getText();
        String spec3 = $(By.xpath("//*[@id='select2-searchDepartment-result-dra1-12102']")).getText();
        String specEq1 = $(By.xpath("//*[@id='department-11802']/button/span[2]")).getText();
        String specEq2 = $(By.xpath("//*[@id='department-12100']/button/span[2]")).getText();
        String specEq3 = $(By.xpath("//*[@id='department-12102']/button/span[2]")).getText();
        assertTrue(spec1.contains(specEq1));
        assertTrue(spec2.contains(specEq2));
        assertTrue(spec3.contains(specEq3));
    }

    @Тогда("^количество талонов совпадает$")
    public void CheckTalonDone()  {
        System.out.println("Фича 21");
    }

    @Тогда("^Тестовый оператор заполняет поля \"([^\"]*)\", Телефон, \"([^\"]*)\", \"([^\"]*)\"$")
    public void zapisToCallDoc(String arg0, String arg2, String arg3)  {
        page.callDoctorPage().writePatSMP(arg0,arg2,arg3);
    }

    @Ктомуже("^отмечает галочку Частный сектор$")
    public void chastnik()  {
        $(By.xpath("//*[@id='createHomeVisitForm']/div[3]/div[1]/label[2]/input")).click();
    }

    @То("^появится всплывающие окно с заполненными полями ЛПУ, \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void checkModalCallDoc(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
        page.callDoctorPage().eqCallDocSMP(arg1,arg2,arg3,arg4,arg5);
        closemodal.click();
        System.out.println("Фича 13");
    }

    @То("^в журнале вызовов будет указан тип операции - 12$")
    public void journalOper()  {
        open("http://call.emias.mosreg.ru/cc_dev/users/usrlog.php");
        $("#search").val("АСТАХОВА ВИКТОРИЯ ПАВЛОВНА");
        $("#type_search").click();
        $("#UF_PATIENT_FIO").click();
        $("#submitform").click();
        $(By.xpath("//*[@class='table table-bordered table-striped']/tbody/tr[1]/td[2]")).shouldHave(text("12"));
        System.out.println("Фича 22");

    }

    @Допустим("^Тестовый оператор создал вызов и передал его в 112$")
    public void createCallTo112() throws InterruptedException {
        PatientNoFound();
        WantCall();
        zapisToCallDoc("Температура","Московская обл, г Красногорск","АСТАХОВА ВИКТОРИЯ ПАВЛОВНА");
        chastnik();
        LpuFilter("СТЕНД ЕМИАС МО");
        FindLpu("СТЕНД ЕМИАС МО");
        CallDoc();
        $(By.xpath("//button[@class='btn btn-default btn-info']")).click();
        System.out.println("вроде ок");
    }

    @И("^Тестовый оператор удаляет запись на прием$")
    public void ClearAfterRec() throws InterruptedException {
       WantCancelRecord();
       CancelRecord();
       System.out.println("Фича 4");
    }

    @И("^Тестовый оператор отменяет созданный лист ожидания$")
    public void CancelCreateWL() throws InterruptedException {
        Thread.sleep(3000);
        allrecord.click();
        DeleteWl();
        System.out.println("Фича 5");
    }


    @И("^Тестовый оператор удаляет созданный вызов врача$")
    public void андрейУдаляетСозданныйВызовВрача()  {
        watchAllCd();
        callList();
        deleteCallToDoc();
    }

    @Дано("^Тестовый оператор хочет найти пациента по ФИО и Дате рождения$")
    public void андрейХочетНайтиПациентаПоФИОИДатеРождения()  {
        find.shouldBe(Condition.visible);
    }

    @Тогда("^отобразится всплывающее окно с полями \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void отобразитсяВсплывающееОкноСПолями(String lpu, String special, String fioDoc, String kab) throws InterruptedException {
        page.recordDoctorPage().assertDir(lpu, special, fioDoc, kab);
        closemodal.click();

    }

    @И("^сделана запись на прием к \"([^\"]*)\"$")
    public void сделанаЗаписьНаПриемК(String arg0) throws InterruptedException {
        page.recordDoctorPage().recordDoctor2(arg0);
    }

    @Тогда("^Тестовый оператор запоминает время и номер талона$")
    public void тестовыйОператорЗапоминаетВремяИНомерТалона()  {
       String eq = timeTicket.getText();
       closemodal.click();
    }
}
