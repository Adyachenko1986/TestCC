package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface SElements {

//    String url = "http://local.call/cc_dev/to_work/";
    String url = "http://call.emias.mosreg.ru/call2_dev/to_work//";

    SelenideElement allrecord = $(By.xpath("//*[@id='all-patient-records-tab']"));
    SelenideElement reschedule = $(By.xpath("//button[@title='Перенести запись']"));
    SelenideElement recordDate = $(By.xpath("//tr[contains(.,'Ай Бо Лит')]//button[@class='btn btn-little btn-block btn-success']"));//*[@id='week-doc-schedule-table-body']/tr[2]/td[7]/button
    SelenideElement recordTime = $(By.xpath("//*[@id='day-doc-schedule']/div/div/div[2]/button[17]"));
    SelenideElement recordTimeRandom = $(By.xpath("//*[@id='day-doc-schedule']/div/div/div[2]/button[@class='btn btn-success']"));
    //*[@id="5b2ec87d-377e-4c93-b8e3-c2ddef9279cc"]
    SelenideElement rerecord = $(By.xpath("//*[@id='record-to-doc-form']/div/div[2]/button"));
    SelenideElement yes = $(By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button[2]"));
    SelenideElement delete = $(By.xpath("//button[@title='Удалить запись']"));
    SelenideElement talonNumber2 = $(By.xpath("//*[@id='talon-list']/tr/td[2]"));
    SelenideElement docName2 = $(By.xpath("//*[@id='talon-list']/tr/td[4]"));
    SelenideElement talonTime2 = $(By.xpath("//*[@id='talon-list']/tr/td[7]"));
    SelenideElement zapis = $(By.xpath("//*[@id='talon-list']"));
    SelenideElement fondPatient1 = $(By.xpath("//*[@id='fond-patients']/tr/td[2]"));
    SelenideElement fondPatient2 = $(By.xpath("//*[@id='fond-patients']/tr/td[3]"));
    SelenideElement fondPatient3 = $(By.xpath("//*[@id='fond-patients']/tr/td[4]"));

    SelenideElement lpuName = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[1]"));
    SelenideElement specName = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[2]"));
    SelenideElement doctor = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[3]"));
    SelenideElement kabName = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[4]"));
    SelenideElement dateTicket = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[5]"));
    SelenideElement timeTicket = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[6]"));
    SelenideElement numTicket = $(By.xpath("//*[@id='ccIngoModalCont']/dl/dd[7]"));

    SelenideElement log = $(By.id("USER_LOGIN"));
    SelenideElement pass = $(By.id("USER_PASSWORD"));
    SelenideElement loginButton = $(By.xpath("//button[@type='submit']"));

    SelenideElement polis = $(By.name("snPol"));
    SelenideElement find = $(By.xpath("//button[@id='search-patient']"));
    SelenideElement fio = $(By.name("surnameNamePatronymic"));
    SelenideElement birthday = $(By.name("birthday"));

    SelenideElement clear = $(By.xpath("//button[@title='Очистить форму']"));
    SelenideElement spec = $(By.xpath("//div[@id='department-12400']"));
    SelenideElement timerec = $(By.xpath("//button[@class='btn btn-success']")); //(text(),'17:30')
    SelenideElement recordbutton = $(By.xpath("//*[contains(text(),'Записать на прием')]"));
    SelenideElement closemodal = $(By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button"));
    SelenideElement nextday = $(By.xpath("//*[@id='day-doc-schedule']/div/div/div/button[2]"));

    SelenideElement waitspec = $(By.xpath("//div[@id='department-12102']/button[1]"));
    SelenideElement waitbutton = $(By.xpath("//*[contains(text(),'Записать в лист ожидания')]"));
    SelenideElement complain = $(By.xpath("//*[@id='complain']"));
    SelenideElement oform = $(By.xpath("//*[@id='createWaitingListRecordForm']/div[2]/div[2]/button"));
    SelenideElement apolpu = $(By.xpath("//button[contains(text('СТЕНД ЕМИАС МО'))]"));

    SelenideElement calldoc = $(By.xpath("//div[@class='fast-buttons']//button[text()='Вызов врача']"));
    SelenideElement calldocdom = $(By.xpath("//a[contains(.,' Вызвать врача на дом')]"));

    SelenideElement notyfyRec = $(By.xpath("//div[@id='notifies']/div/p"));
    SelenideElement directionList = $(By.xpath("//*[@id='direction-list-tab']"));

}
