package app;

import java.util.HashMap;
import java.util.Map;

public class Users {
    public static Map<String, String> allUsers = new HashMap<>();

    static
    {
        allUsers.put("designer1", "pass1");
        allUsers.put("designer2", "pass2");
        allUsers.put("designer3", "pass3");
    }
}
