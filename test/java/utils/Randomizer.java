package utils;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Randomizer {
    private static final ISettingsFile testsData = new JsonSettingsFile("TestsData.json");
    private static final ISettingsFile testsConfig = new JsonSettingsFile("TestsConfig.json");
    private static SecureRandom random = new SecureRandom();

    private static String generateRandomString(int size) {
        String str = "";
        for (int i = 0; i < size; i++){
            char lowercase = (char) (random.nextInt(26) + 97);
            str += lowercase;
        }
        return str;
    }

    private static String shuffleString(String input) {
        List<String> result = Arrays.asList(input.split(""));
        Collections.shuffle(result);
        return result.stream().collect(Collectors.joining());
    }

    public static String passwordGeneration(){
        String password = "";
        for (int i = 0; i < Integer.parseInt(testsConfig.getValue("/numberEachCharacterInPassword").toString()); i++)
        {
            char lowercase = (char) (random.nextInt(26) + 97);
            char uppercase = (char) (random.nextInt(26) + 65);
            char digit = (char) (random.nextInt(10) + 48);
            password = password + lowercase + uppercase + digit;
        }
        return shuffleString(password);
    }

    public static String emailGeneration(){
        return generateRandomString(Integer.parseInt(testsConfig.getValue("/emailLowercaseLatinCharNumber").toString()));
    }

    public static String domainGeneration(){
        return generateRandomString(Integer.parseInt(testsConfig.getValue("/domainLowercaseLatinCharNumber").toString()));
    }

    public static int generateRandomIndexForComboBox(int maximum) {
        return (int) (Math.random()*maximum);
    }
}
