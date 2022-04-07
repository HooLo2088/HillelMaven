package test.mvnTest.ThesisTest.ApiTest;

import com.github.javafaker.Faker;
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
        Faker faker = new Faker();
        user = new User();
        user.setUsername("hoolo1");
        user.setPassword("12345678");
        user.setName(faker.name().name());
        user.setLastname(faker.name().lastName());
    }

    @Test
    public void getUserId() throws IOException {
        AuthController authController = new AuthController();
        userToken = authController.login(user);

        UserController userController = new UserController();
        userId = userController.getUser(userToken).getId();
        Assert.assertFalse(userId.isEmpty());
    }

    @Test(dependsOnMethods = "getUserId")
    public void getUserWithId() throws IOException {
        UserController userController = new UserController();
        String newId = userController.getUserWithId(userToken, userId);
        Assert.assertEquals(newId, userId, "not work");
    }

    @Test(dependsOnMethods = "getUserId")
    public void updateUserInfo() throws IOException {
        UserController userController = new UserController();
        String oldName = userController.getUser(userToken).getName();
        String newName = userController.updateUser(userToken, user).getName();
        Assert.assertNotEquals(newName, oldName, "ne rabotaet");
    }
}
