package pages.callCenter;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import pages.AbstractPage;
import pages.SElements;

import java.io.File;
import java.io.IOException;
import java.util.Map;



public class FindPatientPage extends AbstractPage implements SElements {

    public FindPatientPage() {
    }


    public void enterPol(String profile) throws IOException {
        File reader = new File("src\\main\\java\\pages\\callCenter\\profiles\\" + profile + ".json");
        Map<String, String> proData = new ObjectMapper().readValue(reader, Map.class);
        polis.val(proData.get("snpol"));
    }


    public void clickBtn() {
        find.click();
    }

    public void findByFio(String profile) throws Exception {
        File reader = new File("src\\main\\java\\pages\\callCenter\\profiles\\" + profile + ".json");
        Map<String, String> proData = new ObjectMapper().readValue(reader, Map.class);
        fio.val(proData.get("family"));
        birthday.val(proData.get("birthDay"));
    }
}
