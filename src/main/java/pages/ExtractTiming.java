//package pages;
//
//import net.lightbody.bmp.core.har.Har;
//import org.json.JSONException;
//import org.json.JSONObject;
//import sun.nio.ch.IOUtil;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
//public class ExtractTiming {
//    Har har = proxy.getHar();
//}
//    private Har har;
////    JSONObject jsonOb;
////
////    public ParsingHar(Har har) throws JSONException {
////        this.har = har;
////        this.jsonOb = new JSONObject();
////        if (har.getName() != null && pacient.getName() != "")
////            jsonOb.put("name", pacient.getName());
////        if (har.getFamily() != null && pacient.getFamily() != "")
////            jsonOb.put("family", pacient.getFamily());
////        if (har.getOt() != null && pacient.getOt() != "")
////            jsonOb.put("ot", pacient.getOt());
////        if (har.getBirthdate() != null && pacient.getBirthdate("yyyy-MM-dd") != "")
////            jsonOb.put("birthdate", pacient.getBirthdate("yyyy-MM-dd"));
////        if (har.getSeriespol() != null && pacient.getSeriespol() != "")
////            jsonOb.put("seriespol", pacient.getSeriespol());
////    }
////
////    public Maping() throws IOException, JSONException {
////        JSONObject jsonOb;
////        String path = "target\\selenium_logs.har";
////        File reader2 = new File(path);
////        if (reader2.exists()) {
////            InputStream is = new FileInputStream(path);
////            String jsonTxt = IOUtil.toString(is, "UTF-8");
////            jsonOb = new JSONObject(jsonTxt);
////        } else {
////            throw new JSONException("Ошибка! Не найден файл.");
////        }
////        if (jsonOb.has("wait") && !jsonOb.get("wait").equals(""))
////            this.source = jsonOb.getInt("wait");
////    }
////}