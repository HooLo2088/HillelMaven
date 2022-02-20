package test.mvnTest.BasicTest.homeWork11For17;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class homeWorkFor17_2 {

    @Test(dataProvider = "logins", dependsOnGroups = {"userPassRole"})
    public void someTest1(String user, String pass, String role) {
        if (pass.equals("")) {
            throw new RuntimeException("user2 don't have a pass )))");
        }
        System.out.printf("User: %s is %s have a pass %s%n ", user, role, pass);
    }

    @DataProvider(name = "logins")
    public Object[][] creatLogins() {
        String[][] users = {
                {"user1", "pass1", "role1"},
                {"user2", "", "role2"},
                {"user3", "pass3", "role3"}
        };
        return users;
    }
}
