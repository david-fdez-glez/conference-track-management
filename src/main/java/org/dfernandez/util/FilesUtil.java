package org.dfernandez.util;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesUtil {

    public static List<String> readAllLines(String path) {
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(Paths.get(path));
        } catch (IOException exception) {
            // TODO Catch Error
        }
        return lines;
    }

}
