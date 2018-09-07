package pages.callCenter;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import pages.SElements;

import static com.codeborne.selenide.Selenide.$;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

public class WaitingListPage extends AbstractPage implements SElements {
//    @FindBy(xpath = "//button[@title='СТЕНД ЕМИАС МО; Адрес: Московская область, г. Неизвестный, ул. Светлая, д. 5']")
//    WebElement lpu;

    public WaitingListPage() {
    }

    public void assertWL(String arg0, String arg1, String arg2){
        System.out.println("Код гавно2");
        SelenideElement lpuName2 = $(By.xpath("//*[@id='waiting-list']/tr[2]/td[1]/div[1]/ul/li/div/h4"));
        SelenideElement adress = $(By.xpath("//*[@id='waiting-list']/tr[2]/td[1]/div[1]/ul/li/div/p[1]"));
        SelenideElement istok = $(By.xpath("//*[@id='waiting-list']/tr[2]/td[1]/div[1]/ul/li/div/p[3]"));
        SelenideElement createData = $(By.xpath("//*[@id='waiting-list']/tr[2]/td[1]/div[1]/ul/li/div/p[4]"));


        String eq1 = lpuName2.getText();
        String eq2 = adress.getText();
        String eq3 = istok.getText();
        String eq4 = createData.getText();

        assertTrue(eq1.contains(arg0));
        System.out.println(eq1+" есть");
        assertTrue(arg1.contains(eq2));
        System.out.println(eq2+" есть");
        assertTrue(eq3.contains(arg2));
        System.out.println(eq3+" есть");
        assertTrue(eq4 != null);
        System.out.println(eq4+" есть");

    }

    public void assertWLHis(){
        System.out.println("Код гавно2");

        SelenideElement autor = $(By.xpath("//*[@id='waiting-list-history']/table/tbody[2]/tr/td[2]"));
        SelenideElement changes = $(By.xpath("//*[@id='waiting-list-history']/table/tbody[2]/tr/td[3]"));
        SelenideElement stat = $(By.xpath("//*[@id='waiting-list-history']/table/tbody[2]/tr/td[4]"));

        String eq2 = autor.getText();
        String eq3 = changes.getText();
        String eq4 = stat.getText();

        System.out.println(eq2);
        System.out.println(eq3);
        System.out.println(eq4);

        assertTrue(eq2.contains("Колл-центр"));
        System.out.println(eq2+" есть");
        assertTrue(eq3.contains("Статус"));
        System.out.println(eq3+" есть");
        assertTrue(eq4.contains("Создана"));
        System.out.println(eq4+" есть");

    }

    public void waitingList() {
        $(By.xpath("//button[contains(.,'СТЕНД ЕМИАС МО')]")).click();
        waitspec.click();
        waitbutton.click();
        complain.sendKeys("тест ожидания");
        oform.click();
    }
}
