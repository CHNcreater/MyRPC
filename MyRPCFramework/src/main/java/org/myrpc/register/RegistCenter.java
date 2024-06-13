package org.myrpc.register;

import org.myrpc.entity.Url;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistCenter {
    private static Map<String, List<Url>> map = new HashMap<>();

    public static void regist(String interfaceName, Url url) {
        List<Url> urls = map.get(interfaceName);
        if (urls == null) {
            urls = new ArrayList<Url>();
        }
        urls.add(url);
        map.put(interfaceName, urls);
        saveToFile();
    }

    public static List<Url> get(String interfaceName) {
        map = loadFromFile();
        return map.get(interfaceName);
    }

    private static void saveToFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(System.getProperty("user.dir") + "/temp.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(map);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Map<String, List<Url>> loadFromFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/temp.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Map<String, List<Url>>) objectInputStream.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
