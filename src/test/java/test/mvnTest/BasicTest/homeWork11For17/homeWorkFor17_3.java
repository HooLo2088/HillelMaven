package test.mvnTest.BasicTest.homeWork11For17;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test
public class homeWorkFor17_3 {

    @Parameters({"name", "age"})

        public void someTest2(String name, int age) {
        System.out.println(name + " " + age);

    }
}
