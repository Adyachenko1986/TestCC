package pages.callCenter;

import org.openqa.selenium.By;
import pages.AbstractPage;
import pages.SElements;

import static com.codeborne.selenide.Selenide.$;
import static pages.SElements.find;


public class FindPatientPage extends AbstractPage implements SElements {

    public FindPatientPage() {
    }


    public void EnterPol() {
        polis.val(snpol);
    }
    public void Clicable() {
        find.click();
    }

    public void FindByFio() {
        fio.val(fam);
        birthday.val(bd);
    }
}
