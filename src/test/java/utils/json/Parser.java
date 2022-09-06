package utils.json;

import classes.TestInfo;
import com.google.gson.Gson;

public class Parser {
    private static Gson gson = new Gson();

    public static TestInfo[] parseJsonToTestsDataArray(String jsonString){
        return new Gson().fromJson(jsonString, TestInfo[].class);
    }
}
