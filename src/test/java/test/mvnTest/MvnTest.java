package test.mvnTest;

import org.testng.annotations.Test;

@Test
public class MvnTest {
    public void mvnTest(){
        System.out.println("First Test");
        System.out.println("Open URL: "+ System.getProperty("siteUrl"));
    }
}
