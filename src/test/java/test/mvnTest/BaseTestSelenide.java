package test.mvnTest;

import com.codeborne.selenide.Configuration;
import ua.hillel.BasicCourse.pageObjectSelenide.MainPageSelenide;
import static com.codeborne.selenide.Selenide.open;

public class BaseTestSelenide {

    public static MainPageSelenide openAppSelenide() {
        Configuration.downloadsFolder = "C:\\Users\\38097\\IdeaProjects\\HillelMaven\\target\\download";
        Configuration.timeout = 10000;

        open("https://the-internet.herokuapp.com");
        return new MainPageSelenide();
    }
}

