package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.*;
import java.util.List;

public class FileUtility {

    public static void saveObject(String filename, Object o, StandardOpenOption... option) {
        Path path = Paths.get(filename);
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path, option))) {
            out.writeObject(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object loadObject(String filename) {
        Path path = Paths.get(filename);
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))) {
            return in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void saveText(String filename, List<String> list, StandardOpenOption... option) {
        Path path = Paths.get(filename);
        try {
            Files.write(path, list, option);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> loadText(String filename) {
        Path path = Paths.get(filename);
        try {
            return Files.readAllLines(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}