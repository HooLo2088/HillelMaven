package test.mvnTest.ThesisTest.ApiTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;
import ua.hillel.ThesisObject.ApiObject.AuthController;
import ua.hillel.ThesisObject.ApiObject.User;
import ua.hillel.ThesisObject.ApiObject.UserController;

import java.io.IOException;

public class UserControllerTest {
    private User user;
    public String userToken;
    public String userId;

    @BeforeClass
    public void prepareUser() {
        user = new User();
        user.setUsername("hoolo");
        user.setPassword("12345678");
        user.setName("Figli");
        user.setLastname("Migli");
    }

    @Test
    public void getUserId() throws IOException {
        AuthController authController = new AuthController();
        userToken = authController.login(user);

        UserController userController = new UserController();
        userId = userController.getUser(userToken);
        Assert.assertFalse(userId.isEmpty());
    }

    @Test(dependsOnMethods = "getUserId")
    public void getUserWithId() throws IOException {
        UserController userController = new UserController();
        String newInfo = userController.getUserWithId(userToken, userId);
        Assert.assertFalse(newInfo.isEmpty());
        System.out.println(newInfo);
    }

    @Test(dependsOnMethods = "getUserId")
    public void updateUserInfo() throws IOException {
        UserController userController = new UserController();
        userController.updateUser(userToken, user);
        Assert.assertFalse(userId.isEmpty());
    }
}
