package pages.callCenter;

import org.openqa.selenium.By;
import pages.AbstractPage;
import pages.SElements;

import static com.codeborne.selenide.Selenide.$;
import static pages.SElements.find;


public class FindPatientPage extends AbstractPage implements SElements {

    public FindPatientPage() {
    }

//    String snpol = "45 558320";
    String snpol = "5056900835000459";

    public void EnterPol() {
        polis.val(snpol);
    }
    public void Clicable() {
        find.click();
    }

    public void FindByFio() {
        fio.val("Карташев А Е");
        birthday.val("14.03.1990");
    }
}
