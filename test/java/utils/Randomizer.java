package utils;

import java.security.SecureRandom;

public class Randomizer {
    public static String generateRandomString(int size) {
        SecureRandom random = new SecureRandom();
        String string = "";
        for (int i = 0; i < size; i++){
            char lowercase = (char) (random.nextInt(26) + 97);
            string += lowercase;
        }
        return string;
    }
}
