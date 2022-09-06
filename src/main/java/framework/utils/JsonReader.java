package framework.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public class JsonReader {
    public static final String PathToFrameworkJSON = "src/main/resources/FrameWorkConfig.json";
    public static final String PathToTestJSON = "src/test/resources/TestConfig.json";
    public static final String PathToDataTestsJSON = "src/test/resources/DataTests.json";

    public static String read(String key, String path){
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
