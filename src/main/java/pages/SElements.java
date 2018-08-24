package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface SElements {
    SelenideElement lpu =$(By.xpath("//button[@title='ДЕМИХОВСКАЯ УЧАСТКОВАЯ БОЛЬНИЦА; Адрес: 142632, Московская область, Орехово-Зуевский район, д. Демихово, ул. Заводская']"));
    SelenideElement allrecord = $(By.xpath("//*[@id='all-patient-records-tab']"));
    SelenideElement reschedule = $(By.xpath("//button[@title='Перенести запись']"));
    SelenideElement recordDate = $(By.xpath("//*[@id='week-doc-schedule-table-body']/tr[2]/td[7]/button"));
    SelenideElement recordTime = $(By.xpath("//*[@id='day-doc-schedule']/div/div/div[2]/button[17]"));
    SelenideElement rerecord = $(By.xpath("//*[@id='record-to-doc-form']/div/div[2]/button"));
    SelenideElement yes = $(By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button[2]"));
    SelenideElement delete = $(By.xpath("//button[@title='Удалить запись']"));
    SelenideElement talonNumber2 = $(By.xpath("//*[@id='talon-list']/tr/td[2]"));
    SelenideElement docName2 = $(By.xpath("//*[@id='talon-list']/tr/td[4]"));
    SelenideElement talonTime2 = $(By.xpath("//*[@id='talon-list']/tr/td[7]"));
    SelenideElement oms = $(By.id("fond-patients"));

    SelenideElement log = $(By.id("USER_LOGIN"));
    SelenideElement pass = $(By.id("USER_PASSWORD"));
    SelenideElement loginButton = $(By.xpath("//button[@type='submit']"));

    SelenideElement polis = $(By.name("snPol"));
    SelenideElement find = $(By.xpath("//button[@id='search-patient']"));
    SelenideElement fio = $(By.name("surnameNamePatronymic"));
    SelenideElement birthday = $(By.name("birthday"));

    SelenideElement clear = $(By.xpath("//button[@title='Очистить форму']"));

    SelenideElement mcod = $(By.xpath("//button[@data-lpucode='330501']"));
    SelenideElement spec = $(By.xpath("//div[@id='department-12400']"));
    SelenideElement dayz = $(By.xpath("//*[contains(text(),'Ближайшая запись')]"));
    SelenideElement timerec = $(By.xpath("//*[contains(text(),'17:30')]"));
    SelenideElement recordbutton = $(By.xpath("//*[contains(text(),'Записать на прием')]"));
    SelenideElement closemodal = $(By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button"));

    SelenideElement waitspec = $(By.xpath("//div[@id='department-12202'"));
    SelenideElement waitbutton = $(By.xpath("//*[contains(text(),'Записать в лист ожидания')]"));
    SelenideElement complain = $(By.xpath("//*[@id='complain']"));
    SelenideElement oform = $(By.xpath("//*[contains(text(),'Оформить')]"));

//    SelenideElement recordbutton = $(By.xpath("//*[contains(text(),'Записать на прием')]"));
//    SelenideElement closemodal = (By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button"));


}
