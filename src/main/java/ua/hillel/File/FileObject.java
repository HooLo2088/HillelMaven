package ua.hillel.File;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileObject {

    private String fileDirectory = "target/download/text.txt";


    public FileObject absoluteAddress() {
        new File(fileDirectory).getAbsoluteFile();
        return this;
    }

    public FileObject inputText() {
        try {
            Path path = Paths.get(fileDirectory);

            Files.writeString(path, "\nЛя-ля-ля\nля-ля-ля", StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }
}

