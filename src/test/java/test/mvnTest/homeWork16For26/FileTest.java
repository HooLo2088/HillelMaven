package test.mvnTest.homeWork16For26;

import org.testng.annotations.Test;
import ua.hillel.File.FileObject;

public class FileTest {

    @Test
    public void fileTest() {

        FileObject file = new FileObject().absoluteAddress().inputText();
    }
}
