package utils;

import java.io.FileReader;
import au.com.bytecode.opencsv.CSVReader;

public class CSVReaderUtil {
    public static String readFile(String filename){
        try {
            CSVReader csvReader = new CSVReader(new FileReader(filename), ',', '"', 1);
            String[] nextLine;
            String csvResultAsString = "";
            while ((nextLine = csvReader.readNext()) != null) {
                csvResultAsString += String.join(" ", nextLine);
            }
            return csvResultAsString;
        } catch (Exception exception) {
            throw new RuntimeException("Reading CSV file Error");
        }
    }
}
