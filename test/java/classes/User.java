package classes;

import utils.JSONParser;

public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    public class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;
        public class Geo {
            private String lat;
            private String lng;
        }
    }
    private String phone;
    private String website;
    private Company company;
    public class Company {
        private String name;
        private String catchPhrase;
        private String bs;
    }

    public static boolean isStringParserableToUsersArray(String string){
        try {
            JSONParser.parseJSONToUsersArray(string);
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        return true;
    }

    public static int findIndexById(User[] users, int id){
        for (int i = 0; i < users.length; i++){
            if (users[i].id == id)
                return i;
        }
        return -1;
    }

    public static String lineAdjustment(String str){
        return JSONParser.getUserAsJSONString(JSONParser.parseJSONToUser(str));
    }
}
