package utils;

import aquality.selenium.elements.interfaces.ILabel;
import classes.TestInfo;
import io.restassured.response.Response;
import java.util.*;
import static utils.json.Parser.parseJsonToTestsDataArray;

public class Utils {
    public static boolean isTableSorted(String columnName, List<ILabel> table) {
        for (int i = 1; i < table.size(); i++) {
            if ((table.get(i-1).getText().compareTo(table.get(i).getText()) <= 0) & (table.size() > 2))
                return false;
        }
        return true;
    }

    public static boolean isTestInTableByName(String TestName, List<ILabel> table) {
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i).getText().equals(TestName)){
                return true;
            }
        }
        return false;
    }

    public static boolean isTestsInResponseByName(Response response, List<ILabel> table) {
        TestInfo[] testsData = parseJsonToTestsDataArray(response.body().asString());
        List<String> responseTestsNames = new ArrayList<>();
        for (int i = 0; i < testsData.length; i++){
            responseTestsNames.add(testsData[i].getName());
        }
        for (int i = 0; i < table.size(); i++){
            if (!responseTestsNames.contains(table.get(i).getText())){
                return false;
            }
        }
        return true;
    }
}
