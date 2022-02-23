package test.mvnTest.ThesisTest;

import com.codeborne.selenide.Configuration;
import ua.hillel.ThesisObject.StartThesisPage;

import static com.codeborne.selenide.Selenide.open;

public class BaseThesisTest {

    public static StartThesisPage opennApp() {
        Configuration.downloadsFolder = "C:\\Users\\38097\\IdeaProjects\\HillelMaven\\target\\download";
        Configuration.timeout = 10000;

        open("https://freelance.lsrv.in.ua/");
        return new StartThesisPage();
    }
}