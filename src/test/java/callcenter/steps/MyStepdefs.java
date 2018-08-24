package callcenter.steps;

import callcenter.AbstractTest;
import com.codeborne.selenide.Selectors;
import cucumber.api.PendingException;
import cucumber.api.java.ru.*;
import pages.SElements;
import com.codeborne.selenide.Condition;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs extends AbstractTest implements SElements {

    @Допустим("^что Андрей вошел в АРМ оператора под своей учетной записью$")
    public void LoginCC() {
        page.loginPage().login();
    }

    @Тогда("^Андрей успешно входит в АРМ оператора$")
    public void SucsessLog() {
        find.shouldBe(Condition.visible);
    }

    @Дано("^Андрей хочет найти пациента по номеру полиса$")
    public void FindPol() {
        find.shouldBe(Condition.visible);
    }

    @Когда("^Андрей заполняет данные полиса пациента$")
    public void EnerPolis() {
        page.findPatientPage().EnterPol();
    }

    @И("^нажимает кнопку “войти”$")
    public void EnterArm() {
        page.findPatientPage().Clicable();
    }

    @Тогда("^в колонке  появится строка содержащая следующие поля:$")
    public void Patient() {
        oms.shouldHave(Condition.text("Единый полис ОМС"));
    }

    @Когда("^Андрей заполняет данные ФИО и телефон пациента$")
    public void EnterFio() {
        page.findPatientPage().FindByFio();
    }

    @Дано("^очистка поиска$")
    public void ClearSearch() {
        clear.click();
    }

    @Дано("^Андрей хочет записать пациента к терапевту$")
    public void RecordToDocor() {
        mcod.shouldBe(Condition.visible);
    }

    @Когда("^Андрей выбирает “СТЕНД ЕМИАС МО”$")
    public void FiendLpu() {
        lpu.click();
    }

    @И("^затем выбирает специальность “Терапия”$")
    public void FiendSrec() {
        spec.click();
    }

    @И("^выбирает ближайшую запись у Ай Бо Лит$")
    public void FiendDay() {
        dayz.click();
    }

    @И("^выбирает время приема$")
    public void FiendTime() {
        timerec.click();
    }

    @И("^затем выбирает “Записать на прием”$")
    public void RecToDoc() {
        recordbutton.click();
    }

    @Тогда("^появится всплывающее окно$")
    public void WinModal() {
        closemodal.click();
    }

    @Когда("^Андрей хочет записать пациента в лист ожидания$")
    public void RecordWait() {
        waitbutton.shouldBe(Condition.visible);
    }

    @И("^выбирает “Оформить лист ожидания” у специальности “Психиатрия”$")
    public void RecWait() {
        waitbutton.click();
    }

    @И("^заполняет поле жалобы$")
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


    @И("^найден пациент$")
    public void Scenar() {
        page.findPatientPage().EnterPol();
        page.findPatientPage().Clicable();
    }

    @Допустим("^Андрей захотел просмотреть записи пациента$")
    public void андрейЗахотелПросмотретьЗаписиПациента() {
        allrecord.shouldBe(Condition.visible);
    }

    @Когда("^Андрей выбрал “Все записи пациента”$")
    public void андрейВыбралВсеЗаписиПациента() {
        allrecord.click();
    }

    @Тогда("^открылась вкладка с записями \"([^\"]*)\" \"([^\"]*)\"$")
    public void открыласьВкладкаСЗаписями(String arg0, String arg1) {
        $(By.xpath("//div[contains(text()]")).shouldHave(Condition.text(arg0));
        $(By.xpath("//div[contains(text()]")).shouldHave(Condition.text(arg1));
    }

    @Допустим("^Андрей захотел просмотреть активный лист ожидания$")
    public void андрейЗахотелПросмотретьАктивныйЛистОжидания() {
        $(By.xpath("//*[@class='waiting-list-item']")).shouldHave(Condition.text("Создана"));
    }

    @Когда("^Андрей нажимает “Подробная информация”$")
    public void андрейНажимаетПодробнаяИнформация() {
        $(By.xpath("//*[@class='waiting-list-item']/div/button")).click();
    }

    @То("^появится всплывающие окно с полями:$")
    public void появитсяВсплывающиеОкноСПолями() {
        $(By.xpath("//*[@class='waiting-list-item']/div")).getText();
    }

    @Тогда("^Андрей нажимает “История”$")
    public void андрейНажимаетИстория() {
        $(By.xpath("//*[@class='waiting-list-item']/div[2]/button")).click();
    }

    @И("^появится всплывающие окно с таблицей с полями:$")
    public void появитсяВсплывающиеОкноСТаблицейСПолями() {
        $(By.xpath("//*[@id='waiting-list-history']/table/tbody[2]")).getText();
    }

    @Допустим("^Андрей захотел просмотреть все листы ожидания$")
    public void андрейЗахотелПросмотретьВсеЛистыОжидания() {
        $(By.xpath("//input[@id='show-all-waiting-list']")).shouldBe(Condition.visible);
    }

    @Когда("^Андрей  ставит отметку “Показать все”$")
    public void андрейСтавитОтметкуПоказатьВсе() {
        $(By.xpath("//input[@id='show-all-waiting-list']")).click();
    }

    @Тогда("^появляется список всех созданных листов ожидания$")
    public void появляетсяСписокВсехСозданныхЛистовОжидания() {
        $(By.xpath("//*[@class='waiting-list-item']")).shouldHave(Condition.text("Отменена"));
    }

    @Допустим("^Андрей захотел перенести запись на прием$")
    public void андрейЗахотелПеренестиЗаписьНаПрием() {
        reschedule.shouldBe(Condition.visible);
    }

    @Когда("^Андрей нажимает “Перенести запись”$")
    public void андрейНажимаетПеренестиЗапись() {
        reschedule.click();
    }

    @Тогда("^открывается окно “перенос записи талона” с расписанием врачей этой специальности$")
    public void открываетсяОкноПереносЗаписиТалонаСРасписаниемВрачейЭтойСпециальности() {
        $(By.xpath("//div[@class='modal-header']")).shouldHave(Condition.text("Перенос записи талона"));
    }

    @И("^Андрей выбирает дату$")
    public void андрейВыбираетДату() {
        recordDate.click();
    }

    @И("^нажимает “перенести запись”$")
    public void нажимаетПеренестиЗапись() {
        rerecord.click();
    }

    @То("^появляется всплывающее окно “Запись перенесена успешно”$")
    public void появляетсяВсплывающееОкноЗаписьПеренесенаУспешно() {
        yes.click();
    }

    @Допустим("^Андрей захотел отменить лист ожидания$")
    public void андрейЗахотелОтменитьЛистОжидания() {
        $(By.xpath("//*[@class='waiting-list-item']/td[7]/button")).shouldBe(Condition.visible);
    }

    @Когда("^Андрей нажимает “Удалить”$")
    public void андрейНажимаетУдалить() {
        $(By.xpath("//*[@class='waiting-list-item']/td[7]/button")).click();
    }

    @Тогда("^у вызова проставляется статус “Отменена”$")
    public void уВызоваПроставляетсяСтатусОтменена() {
        $(By.xpath("//*[@class='waiting-list-item']")).shouldHave(Condition.text("Отменена"));
    }

    @Допустим("^Андрей захотел отменить запись на прием$")
    public void андрейЗахотелОтменитьЗаписьНаПрием() {
        delete.shouldBe(Condition.visible);
    }

    @Когда("^Андрей нажимает “Удалить запись”$")
    public void андрейНажимаетУдалитьЗапись() {
        delete.click();
    }

    @Тогда("^запись пропадает из поля “записи на прием”$")
    public void записьПропадаетИзПоляЗаписиНаПрием() {
    }
}
