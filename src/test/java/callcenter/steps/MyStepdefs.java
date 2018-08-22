package callcenter.steps;

import callcenter.AbstractTest;
import com.codeborne.selenide.Condition;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Допустим;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs extends AbstractTest {

    @When("^open website$")
    public void openWebsite() throws Throwable {
            open("http://ya.ru");
    }

    @And("^enter \"([^\"]*)\"$")
    public void enter(String arg0) throws Throwable {
            $(By.id("text")).setValue(arg0);
    }

    @Then("^verify \"([^\"]*)\"$")
    public void verify(String arg0) throws Throwable {
            $(By.xpath("//*[contains(text(),'" + arg0 + "')]")).shouldBe(Condition.visible);
    }

    @And("^press \"([^\"]*)\"$")
    public void press(String arg0) throws Throwable {
        $(By.xpath("//*[contains(text(),'" + arg0 + "')]")).click();
    }

    @Допустим("^что Андрей вошел в АРМ оператора под своей учетной записью$")
    public void чтоАндрейВошелВАРМОператораПодСвоейУчетнойЗаписью() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Тогда("^Андрей успешно входит в АРМ оператора$")
    public void андрейУспешноВходитВАРМОператора() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
