package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface SElements {

//    String url = "http://local.call/cc_dev/to_work/";
    String url = "http://call.emias.mosreg.ru/call2_dev/to_work//";

//    String snpol = "5056900835000459";
//    String snpol = "45 558320";

//    String fam= "Карташев А Е";
//    String bd ="14.03.1990";
//    String fam= "Карташев А Е";
//    String bd ="14.03.1990";

//    SelenideElement lpu =$(By.xpath("//button[@title='ДЕМИХОВСКАЯ УЧАСТКОВАЯ БОЛЬНИЦА; Адрес: 142632, Московская область, Орехово-Зуевский район, д. Демихово, ул. Заводская']"));
//    SelenideElement lpu =$(By.xpath("//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']"));

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
    SelenideElement zapis = $(By.xpath("//*[@id='talon-list']"));
    SelenideElement oms = $(By.id("polisType"));
    SelenideElement omsDate = $(By.id("polisDate"));
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

//    SelenideElement mcod = $(By.xpath("//button[@data-lpucode='330501']"));
//    SelenideElement mcod = $(By.xpath("//button[@data-lpucode='330501']"));
    SelenideElement spec = $(By.xpath("//div[@id='department-12400']"));
    SelenideElement dayz = $(By.xpath("//*[contains(text(),'Ближайшая запись')]"));
    SelenideElement timerec = $(By.xpath("//button[@class='btn btn-success']")); //(text(),'17:30')
    SelenideElement recordbutton = $(By.xpath("//*[contains(text(),'Записать на прием')]"));
    SelenideElement closemodal = $(By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button"));

    SelenideElement waitspec = $(By.xpath("//div[@id='department-12202'"));
    SelenideElement waitbutton = $(By.xpath("//*[contains(text(),'Записать в лист ожидания')]"));
    SelenideElement complain = $(By.xpath("//*[@id='complain']"));
    SelenideElement oform = $(By.xpath("//*[contains(text(),'Оформить')]"));

//    SelenideElement apoinmentsList = $(By.xpath("//*[@id='direction-list-tab']"));
//    SelenideElement apoinment = $(By.xpath("//*[@id='direction-list']/div/div[2]/button"));
//    SelenideElement apoLpu = $(By.xpath("//*[@id='c3c977af-c3b4-4517-9d57-50a6844ec660B70332CC-940B-4284-BB44-48AA981F3AB9']/td[6]/button"));
//    SelenideElement apoLpu = $(By.xpath("//*[@id='a7f391d4-d5d8-44d5-a770-f7b527bb123326f407bc-01c7-4e64-ae16-80ae909b1574']/td[6]/button"));
    SelenideElement apolpu = $(By.xpath("//button[contains(text('СТЕНД ЕМИАС МО'))]"));

//    SelenideElement apoinment = $(By.xpath("//*[@id='direction-list']/div/div[2]/button"));
//    SelenideElement apoinment = $(By.xpath("//*[@id='direction-list']/div/div[2]/button"));

    SelenideElement calldoc = $(By.xpath("//div[@class='fast-buttons']//button[text()='Вызов врача']"));
    SelenideElement calldocdom = $(By.xpath("//a[contains(.,' Вызвать врача на дом')]"));


    SelenideElement notyfyRec = $(By.xpath("//div[@id='notifies']/div/p"));






}
