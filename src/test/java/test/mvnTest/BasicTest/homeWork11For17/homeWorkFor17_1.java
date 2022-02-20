package test.mvnTest.BasicTest.homeWork11For17;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class homeWorkFor17_1 {

    @Test(dataProvider = "logins", groups = {"userPassRole"})
    public void someTest(String user, String pass, String role) {
        System.out.printf("User: %s is %s have a pass %s%n ", user, role, pass);
    }



    @DataProvider(name = "logins")
    public Object[][] creatLogins() {
        String[][] users = {
                {"user1", "pass1", "role1"},
                {"user2", "pass2", "role2"},
                {"user3", "pass3", "role3"}
        };
        return users;
    }
}
