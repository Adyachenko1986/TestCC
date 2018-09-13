package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.PressEnter;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import pages.SElements;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Mis extends AbstractPage implements SElements {
    SelenideElement createShedule = $(By.xpath("//button[@id='btn_create']/span[2]"));
    SelenideElement ddlbusytypeButton = $(By.xpath("//a[@id='ddlbusytype-button']/span[2]"));
    SelenideElement pickTime_nach = $(By.id("pickTime_nach"));
    SelenideElement schedule_add_button = $(By.id("schedule_add_button"));
    SelenideElement priemNaDomu = $(By.linkText("Прием на дому (вызов на дом)"));
    SelenideElement priemPoOcheredi = $(By.linkText("Прием по очереди"));
    SelenideElement btn_save_schedule = $(By.xpath("//button[@id='btn_save_schedule']/span"));
    SelenideElement pickTime_nachClose = $(By.xpath("(//button[@type='button'])[2]"));
    SelenideElement pickTime_okon = $(By.id("pickTime_okon"));
    SelenideElement pickTime_okonClose = $(By.xpath("(//button[@type='button'])[2]"));
    SelenideElement deleteShedule = $(By.xpath("//button[@id='btn_delete']/span[2]"));
    SelenideElement deleteSheduleBtnWindow = $(By.id("btn_delete_schedule"));
    SelenideElement deleteSheduleBtnOk = $(By.xpath("//button[contains(.,'Да']"));


    @Step("установить время календаря")
    public void setTimeCalendar(String a, String b) throws InterruptedException {
        pickTime_nach.sendKeys(a);          //нажимаем на поле начала интервала
        pickTime_nachClose.click();
        Thread.sleep(500);
        pickTime_okon.sendKeys(b);          //нажимаем на поле окончание интервала
        pickTime_okonClose.click();      //нажали закрыть календарь
    }

    @Step("установить тип приема")
    public void setTypeOfReception(WebElement typeOfReception) {
        ddlbusytypeButton.click();                  //нажимаем на выпадающий список тип приема
        typeOfReception.click();                     //выбор типа приема
        schedule_add_button.click();                 //нажали кнопу добавить
    }


    public void createShedule() throws InterruptedException {
        Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
        String c = "1500", d = "1530";
        createShedule.click();
        setTimeCalendar(c, d);
        setTypeOfReception(priemPoOcheredi);
        btn_save_schedule.click();                   //нажимаем кнопку сохранить
        keyboard.pressKey(Keys.ENTER);
    }

    public void loginMis() {
        open("http://emias.mosreg.ru/demonstration/");
        $(By.id("Login")).shouldBe(enabled).setValue("admin");
        $(By.id("Password")).shouldBe(enabled).setValue("RChS2014");
        $(By.id("loginBtn")).shouldBe(enabled).click();
    }
    public void OpenShedule (String arg0) throws InterruptedException {
        open("http://emias.mosreg.ru/demonstration/Schedule");
        $(By.id("sinpdocprvdgrid1")).shouldBe(enabled).val(arg0);
        $(By.id("btnfinddocprvdgrid1")).shouldBe(enabled).click();
        $(By.id("docprvdgrid1")).shouldBe(enabled).click();
        Thread.sleep(1000);

    }

    @Step("создать расписание Селевича")
    public void createSheduleDoc() throws InterruptedException {
        loginMis();
        open("http://emias.mosreg.ru/demonstration/ScheduleWriting");
        $(By.id("sinpschw_docprvdgrid1")).shouldBe(enabled).val("Селевич Николай Николаевич");
        $(By.id("btnfindschw_docprvdgrid1")).shouldBe(enabled).click();
        $(By.id("jqg_schw_docprvdgrid1_1290")).shouldBe(enabled).click();
        createShedule();
    }

    @Step("удалить расписание Селевича")
    public void deleteSheduleDoc() throws InterruptedException {//удалить расписание выбранного врача
        loginMis();
        open("http://emias.mosreg.ru/demonstration/ScheduleWriting");
        $(By.id("sinpschw_docprvdgrid1")).shouldBe(enabled).val("Селевич Николай Николаевич");
        $(By.id("btnfindschw_docprvdgrid1")).shouldBe(enabled).click();
        $(By.id("jqg_schw_docprvdgrid1_1290")).shouldBe(enabled).click();
        deleteShedule();
    }

    public void deleteShedule() throws InterruptedException {//удалить расписание выбранного врача
        deleteShedule.click();                     //кнопка удалить расписание
        deleteSheduleBtnWindow.click();            //подтверждение удаления
        Thread.sleep(1000);
//        deleteSheduleBtnOk.click();
//
        new PressEnter();
    }
}
