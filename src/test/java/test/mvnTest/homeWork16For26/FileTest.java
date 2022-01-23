package test.mvnTest.homeWork16For26;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileTest {

    @Test
    public void fileTest() {

        File file = new File("target/download/text.txt").getAbsoluteFile();

        try {
            Path path = Paths.get("target/download/text.txt");

            Files.writeString(path, "\nЛя-ля-ля\nля-ля-ля", StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
