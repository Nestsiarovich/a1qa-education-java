package utils;

import java.security.SecureRandom;

public class Randomizer {
    public static String getRandomString(int size) {
        SecureRandom random = new SecureRandom();
        String str = "";
        for (int i = 0; i < size; i++){
            char lowercase = (char) (random.nextInt(26) + 97);
            str += lowercase;
        }
        return str;
    }
}
