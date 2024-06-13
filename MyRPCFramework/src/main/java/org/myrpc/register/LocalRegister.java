package org.myrpc.register;

import java.util.HashMap;
import java.util.Map;

public class LocalRegister {
    /*
    * Local Register
    * */
    private static Map<String, Class> map = new HashMap<>();

    public static void regist(String interfaceName, Class serviceClass) {
        map.put(interfaceName, serviceClass);
    }

    public static Class get(String interfaceName) {
        return map.get(interfaceName);
    }
}
