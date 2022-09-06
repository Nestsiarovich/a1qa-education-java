package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public class JSONReader {
    public static final String pathToDataTestJSON = "src/test/resources/DataTest.json";
    public static final String pathToConfigTestJSON = "src/test/resources/ConfigTest.json";

    public static String readByKey(String path, String key){
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(path)){
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            return (String) jsonObject.get(key);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
