package callcenter.steps;

import callcenter.AbstractTest;
import com.codeborne.selenide.Condition;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Допустим;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs extends AbstractTest {

//    @When("^open website$")
//    public void openWebsite() {
//            open("http://ya.ru");
//    }
//
//    @And("^enter \"([^\"]*)\"$")
//    public void enter(String arg0) {
//            $(By.id("text")).setValue(arg0);
//    }
//
//    @Then("^verify \"([^\"]*)\"$")
//    public void verify(String arg0) {
//            $(By.xpath("//*[contains(text(),'" + arg0 + "')]")).shouldBe(Condition.visible);
//    }
//
//    @And("^press \"([^\"]*)\"$")
//    public void press(String arg0) {
//        $(By.xpath("//*[contains(text(),'" + arg0 + "')]")).click();
//    }

    @When("^что Андрей вошел в АРМ оператора под своей учетной записью$")
    public void чтоАндрейВошелВАРМОператораПодСвоейУчетнойЗаписью()  {
        open("http://local.call/cc_dev/to_work/?login=yes");
        $(By.id("USER_LOGIN")).val("ccg");
        $(By.id("USER_PASSWORD")).val("ccg123");
        $(By.xpath("//button[@type='submit']")).click();
    }

//    @Then("^Андрей успешно входит в АРМ оператора$")
//    public void андрейУспешноВходитВАРМОператора()  {
//        $(By.xpath("//button[@id='search-patient']")).shouldBe(Condition.visible);
//    }

    @Then("^Andre succesfull engate in ARM oper$")
    public void andreSuccesfullEngateInARMOper() {
        $(By.xpath("//button[@id='search-patient']")).shouldBe(Condition.visible);
    }
}
