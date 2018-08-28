package callcenter.steps;

import callcenter.Hook;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.*;
import callcenter.RunCallCenterTests;
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
        driver.quit();
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
    public void EnerPolis(String polisNumber) throws Throwable {
        page.findPatientPage().enterPol(polisNumber);
    }

    @И("^нажимает кнопку “найти”$")
    public void EnterArm() {
        page.findPatientPage().clickBtn();
    }

    @Тогда("^в колонке появится строка содержащая следующие поля: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void Patient(String family, String born, String polisNumber) {
        page.findPatientPage().assertTable(family, born, polisNumber);

    }

    @Дано("^Андрей хочет найти пациента по ФИО и Дате рождения$")
    public void андрейХочетНайтиПациентаПоФИОИДатеРождения() throws Throwable {
        find.shouldBe(Condition.visible);
        // TODO: 28.08.2018 доделать тут, а то тест падает
        throw new PendingException();
    }

    @Когда("^Андрей заполняет данные \"([^\"]*)\" и \"([^\"]*)\"$")
    public void андрейЗаполняетДанныеФИОИДатаРождения(String arg1, String arg2) throws Throwable {
        page.findPatientPage().findByFio(arg1, arg2);

    }

}
