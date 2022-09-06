package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public class JsonReader {
    public static String getConfig(String key){
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("src/test/resources/Config.json")){
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            return (String) jsonObject.get(key);
        } catch (Exception exception){
            throw new RuntimeException("Error reading config file");
        }
    }
}
