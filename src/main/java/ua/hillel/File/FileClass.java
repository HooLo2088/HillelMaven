package ua.hillel.File;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileClass {

    public static void main(String[] args) {


        File file = new File("target/download/text.txt").getAbsoluteFile();
        try {
            Path path = Paths.get("target/download/text.txt");

            Files.writeString(path, "\nЛя-ля-ля\nля-ля-ля", StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
