package pages.callCenter;

import pages.AbstractPage;
import pages.SElements;

import java.io.IOException;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;


public class FindPatientPage extends AbstractPage implements SElements {

    public FindPatientPage() {
    }


    public void enterPol(String name) throws IOException {
//        File reader = new File("src\\main\\java\\pages\\callCenter\\profiles\\" + profile + ".json");
//        Map<String, String> proData = new ObjectMapper().readValue(reader, Map.class);
        polis.val(name);
    }


    public void clickBtn() {
        find.click();
    }

    public void findByFio(String arg1, String arg2) throws Exception {
//        File reader = new File("src\\main\\java\\pages\\callCenter\\profiles\\" + profile + ".json");
//        Map<String, String> proData = new ObjectMapper().readValue(reader, Map.class);
//        fio.val(proData.get("family"));
//        birthday.val(proData.get("birthDay"));
        fio.val(arg1);
        birthday.val(arg2);
    }
    public void assertTable(String family, String born, String polisNumber) {
//        fondPatient.shouldHave(Condition.text("АСТАХОВА ВИКТОРИЯ ПАВЛОВНА"));
//        fondPatient.shouldHave(Condition.text("1999-10-25"));
//        oms.shouldHave(Condition.text("Тер. полис ОМС (до 01.05.11)"));
//        omsDate.shouldHave(Condition.text("04.08.2017 01.01.2222"));
        String eq1= fondPatient1.getText();
        String eq2= fondPatient2.getText();
        String eq3= fondPatient3.getText();
        System.out.println("Код гавно");

//        assertEquals("Проверка Фамилии",family, fondPatient1.getText());
//        assertEquals("Проверка Даты рождения",born, fondPatient2.getText());
//        assertEquals("Проверка Полиса",polisNumber, fondPatient3.getText());
        assertTrue(family.contains(eq1));
        assertTrue(born.contains(eq2));
        assertTrue(polisNumber.contains(eq3));
    }
}
