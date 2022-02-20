package test.mvnTest.BasicTest.homeWork16For26;

import org.testng.annotations.Test;
import ua.hillel.BasicCourse.File.FileObject;

public class FileTest {

    @Test
    public void fileTest() {

        FileObject file = new FileObject()
                .absoluteAddress()
                .inputText();
    }
}
