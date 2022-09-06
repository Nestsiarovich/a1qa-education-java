package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import static utils.CSVReaderUtil.*;
import static utils.SQLUtil.*;
import static utils.JsonReader.getConfig;


public class DBTests {
    @Test
    public void joinTestsTest(){
        Assert.assertEquals(callStoredProcedureAndPrint3ColumnResult(getConfig("storedProcedureName1")), readFile(getConfig("resultCSV1")), "Result joinTestsTest is wrong");
    }

    @Test
    public void joinProjectsTest(){
        Assert.assertEquals(callStoredProcedureAndPrint2ColumnResult(getConfig("storedProcedureName2")), readFile(getConfig("resultCSV2")), "Result joinProjectsTest is wrong");
    }

    @Test
    public void whereTestsTest(){
        Assert.assertEquals(callStoredProcedureAndPrint3ColumnResult(getConfig("storedProcedureName3")), readFile(getConfig("resultCSV3")), "Result whereTestsTest is wrong");
    }

    @Test
    public void unionTestsTest(){
        Assert.assertEquals(callStoredProcedureAndPrint1ColumnResult(getConfig("storedProcedureName4")), readFile(getConfig("resultCSV4")), "Result unionTestsTest is wrong");
    }
}
