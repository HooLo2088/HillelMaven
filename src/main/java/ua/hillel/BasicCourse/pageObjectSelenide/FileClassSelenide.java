package ua.hillel.BasicCourse.pageObjectSelenide;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileClassSelenide {

    public FileClassSelenide inputTextFileClass(String filePath) {
        try {
            Files.writeString(Paths.get(filePath), "\nЛя-ля-ля\nля-ля-ля", StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }
}
