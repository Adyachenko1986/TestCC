package callcenter.steps;

import callcenter.AbstractTest;
import com.codeborne.selenide.Condition;
import cucumber.api.PendingException;
import cucumber.api.java.ru.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs extends AbstractTest {

    @Если("^Андрей вошел в АРМ оператора под своей учетной записью$")
    public void АндрейВошелВАРМОператораПодСвоейУчетнойЗаписью() {
        page.loginPage().login();
//                open("http://ya.ru");
    }

    @Допустим("^Андрей хочет найти пациента по номеру полиса$")
    public void андрейХочетНайтиПациентаПоНомеруПолиса() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Когда("^Андрей заполняет данные полиса пациента$")
    public void андрейЗаполняетДанныеПолисаПациента() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @И("^нажимает кнопку “войти”$")
    public void нажимаетКнопкуВойти() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Тогда("^в колонке \"([^\"]*)\" появится строка содержащая следующие поля:$")
    public void вКолонкеПоявитсяСтрокаСодержащаяСледующиеПоля(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Допустим("^Андрей хочет найти пациента по ФИО и дате рождения$")
    public void андрейХочетНайтиПациентаПоФИОИДатеРождения() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Когда("^Андрей заполняет ФИО$")
    public void андрейЗаполняетФИО() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @И("^заполняет дату рождения$")
    public void заполняетДатуРождения() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Допустим("^Андрей хочет записать пациента к терапевту$")
    public void андрейХочетЗаписатьПациентаКТерапевту() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Тогда("^Андрей выбирает “СТЕНД ЕМИАС МО”$")
    public void андрейВыбираетСТЕНДЕМИАСМО() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @И("^затем выбирает специальность “Терапия”$")
    public void затемВыбираетСпециальностьТерапия() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @И("^затем выбирает “Записать на прием”$")
    public void затемВыбираетЗаписатьНаПрием() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @То("^появится всплывающее окно с заполненными полями:$")
    public void появитсяВсплывающееОкноСЗаполненнымиПолями() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Допустим("^Андрей хочет записать пациента в лист ожидания$")
    public void андрейХочетЗаписатьПациентаВЛистОжидания() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @И("^выбирает “Оформить лист ожидания” у специальности “Психиатрия”$")
    public void выбираетОформитьЛистОжиданияУСпециальностиПсихиатрия() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @И("^выбирает “Оформить”$")
    public void выбираетОформить() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @То("^Появится всплывающее окно с записью \"([^\"]*)\"$")
    public void появитсяВсплывающееОкноСЗаписью(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Допустим("^Андрей захотел просмотреть записи пациента$")
    public void андрейЗахотелПросмотретьЗаписиПациента() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Когда("^Андрей выбрал “Все записи пациента”$")
    public void андрейВыбралВсеЗаписиПациента() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Тогда("^открылась вкладка с записями \"([^\"]*)\" \"([^\"]*)\"$")
    public void открыласьВкладкаСЗаписями(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Допустим("^Андрей захотел просмотреть активный лист ожидания$")
    public void андрейЗахотелПросмотретьАктивныйЛистОжидания() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Когда("^Андрей нажимает “Подробная информация”$")
    public void андрейНажимаетПодробнаяИнформация() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @То("^появится всплывающие окно с полями:$")
    public void появитсяВсплывающиеОкноСПолями() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Тогда("^Андрей нажимает “История”$")
    public void андрейНажимаетИстория() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @И("^появится всплывающие окно с таблицей с полями:$")
    public void появитсяВсплывающиеОкноСТаблицейСПолями() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Допустим("^Андрей захотел отменить лист ожидания$")
    public void андрейЗахотелОтменитьЛистОжидания() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Когда("^Андрей нажимает “Удалить”$")
    public void андрейНажимаетУдалить() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Тогда("^у вызова проставляется статус “Отмена”$")
    public void уВызоваПроставляетсяСтатусОтмена() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Допустим("^Андрей захотел просмотреть все листы ожидания$")
    public void андрейЗахотелПросмотретьВсеЛистыОжидания() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Когда("^Андрей  ставит отметку “Показать все”$")
    public void андрейСтавитОтметкуПоказатьВсе() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Тогда("^появляется список всех созданных листов ожидания$")
    public void появляетсяСписокВсехСозданныхЛистовОжидания() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Допустим("^Андрей захотел перенести запись на прием$")
    public void андрейЗахотелПеренестиЗаписьНаПрием() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Когда("^Андрей нажимает “Перенести запись”$")
    public void андрейНажимаетПеренестиЗапись() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Тогда("^открывается окно “перенос записи талона” с расписанием врачей этой специальности$")
    public void открываетсяОкноПереносЗаписиТалонаСРасписаниемВрачейЭтойСпециальности() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @И("^нажимает “перенести запись”$")
    public void нажимаетПеренестиЗапись() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @То("^появляется всплывающее окно “Запись перенесена успешно”$")
    public void появляетсяВсплывающееОкноЗаписьПеренесенаУспешно() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Допустим("^Андрей захотел отменить запись на прием$")
    public void андрейЗахотелОтменитьЗаписьНаПрием() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Тогда("^вызов пропадает из поля “записи на прием”$")
    public void вызовПропадаетИзПоляЗаписиНаПрием() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Допустим("^Андрей захотел просмотреть направления пациента$")
    public void андрейЗахотелПросмотретьНаправленияПациента() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Когда("^Андрей выбрал “Записать по направлению”$")
    public void андрейВыбралЗаписатьПоНаправлению() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Когда("^Андрей нажал на выбранное направление$")
    public void андрейНажалНаВыбранноеНаправление() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @То("^появляется расписание врачей этой специальности$")
    public void появляетсяРасписаниеВрачейЭтойСпециальности() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Тогда("^Андрей выбирает дату$")
    public void андрейВыбираетДату() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @И("^нажимает “Записать на прием”$")
    public void нажимаетЗаписатьНаПрием() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Тогда("^появляется всплывающее окно с заполненными полями:$")
    public void появляетсяВсплывающееОкноСЗаполненнымиПолями() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @То("^в “Записях пациента” появится активная запись на прием$")
    public void вЗаписяхПациентаПоявитсяАктивнаяЗаписьНаПрием() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Допустим("^Андрей хочет перейти на страницу вызова врача на дом$")
    public void андрейХочетПерейтиНаСтраницуВызоваВрачаНаДом() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @И("^выбрал “Вызов врача”$")
    public void выбралВызовВрача() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Тогда("^открывается страница вызова врача на дом$")
    public void открываетсяСтраницаВызоваВрачаНаДом() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Допустим("^Андрей уже известен пациент$")
    public void андрейУжеИзвестенПациент() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Тогда("^Андрей заполняет поля:$")
    public void андрейЗаполняетПоля() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Допустим("^Андрей не известен пациент$")
    public void андрейНеИзвестенПациент() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Тогда("^Андрей заполняет обязательные поля$")
    public void андрейЗаполняетОбязательныеПоля() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();

    }

    @Допустим("^Андрей захотел посмотреть вызовы врача к пациенту$")
    public void андрейЗахотелПосмотретьВызовыВрачаКПациенту() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Когда("^Андрей нажимает “Список вызовов”$")
    public void андрейНажимаетСписокВызовов() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Тогда("^открывается вкладка со пустым списком заявок вызванных врачей$")
    public void открываетсяВкладкаСоПустымСпискомЗаявокВызванныхВрачей() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @То("^появится список вызовов врачей за последние (\\d+) дней с полями:$")
    public void появитсяСписокВызововВрачейЗаПоследниеДнейСПолями(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Тогда("^Андрей успешно входит в АРМ оператора$")
    public void андрейУспешноВходитВАРМОператора() throws Throwable {
        $(By.xpath("//*[conditions(text(),'Серия и номер полиса через пробел')]")).shouldBe(Condition.visible);
//                $(By.xpath("//*[conditions(text(),'Фамилия Имя Отчество (полностью)')]")).shouldBe(Condition.visible).equals(true));
//                $(By.xpath("//*[conditions(text(),'Дата рождения')]")).shouldBe(Condition.visible).equals(true));
    }

//        @Тогда("^открылась вкладка с активными направлениями, где указано куда направлен пациент, специализация, ФИО врача и период действия направления\.$")
//        public void открыласьВкладкаСАктивнымиНаправлениямиГдеУказаноКудаНаправленПациентСпециализацияФИОВрачаИПериодДействияНаправления() throws Throwable {
//                // Write code here that turns the phrase above into concrete actions
//                throw new PendingException();
//        }

//        @Допустим("^Андрей захотел записать пациента по направлению\.$")
//        public void андрейЗахотелЗаписатьПациентаПоНаправлению() throws Throwable {
//                // Write code here that turns the phrase above into concrete actions
//                throw new PendingException();
//        }

//        @И("^нажимает на ЛПУ$")
//        public void нажимаетНаЛПУ() throws Throwable {
//                // Write code here that turns the phrase above into concrete actions
//                throw new PendingException();
//        }

    @То("^появится всплывающие окно с заполненными полями:$")
    public void появитсяВсплывающиеОкноСЗаполненнымиПолями() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

//        @Допустим("^Андрей захотел посмотреть историю вызова врача на дом\.$")
//        public void андрейЗахотелПосмотретьИсториюВызоваВрачаНаДом() throws Throwable {
//                // Write code here that turns the phrase above into concrete actions
//                throw new PendingException();
//        }

    @Также("^заполняет поле жалобы$")
    public void заполняетПолеЖалобы() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Также("^выбирает время визита$")
    public void выбираетВремяВизита() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @И("^нажимает на  ЛПУ$")
    public void нажимаетНаЛПУ() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Также("^нажимает “Вызвать врача”$")
    public void нажимаетВызватьВрача() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Тогда("^вводит название ЛПУ в фильтре списка учреждений$")
    public void вводитНазваниеЛПУВФильтреСпискаУчреждений() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @И("^Андрей заполняет номер телефона$")
    public void андрейЗаполняетНомерТелефона() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @И("^Ввел в поиске \"([^\"]*)\"$")
    public void ввелВПоиске(String arg0) throws Throwable {
        $(By.id("text")).setValue(arg0);
        // Write code here that turns the phrase above into concrete actions
//                throw new PendingException();
    }

    @Тогда("^На странице поиска отобразится клип Бритни Спирс \"([^\"]*)\"$")
    public void наСтраницеПоискаОтобразитсяКлипБритниСпирс(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        $(By.xpath("//*[contains(text(),'" + arg0 + "')]")).shouldBe(Condition.visible);
//                throw new PendingException();
    }

    @Допустим("^что Андрей вошел в АРМ оператора под своей учетной записью$")
    public void чтоАндрейВошелВАРМОператораПодСвоейУчетнойЗаписью() throws Throwable {
        page.loginPage().login();
        throw new PendingException();
    }

//        @Допустим("^Андрей захотел посмотреть историю вызова врача на дом\.$")
//        public void андрейЗахотелПосмотретьИсториюВызоваВрачаНаДом() throws Throwable {
//                // Write code here that turns the phrase above into concrete actions
//                throw new PendingException();
//        }
}
