package test.mvnTest.ThesisTest.ApiTest;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ua.hillel.ThesisObject.ApiObject.AuthController;
import ua.hillel.ThesisObject.ApiObject.User;

import java.io.IOException;

public class AuthControllerTest {
    private User user;

    @BeforeClass
    public void prepareUser(){
        Faker faker = new Faker();
        user = new User();
        user.setUsername(faker.name().username());
        user.setPassword("12345678");
        user.setConfirmpassword("12345678");
    }

    @Test
    public void testRegistration() throws IOException {
        AuthController controller = new AuthController();
        controller.registerUser(user);
    }

    @Test(dependsOnMethods = "testRegistration")
    public void testLogin() throws IOException {
    AuthController authController = new AuthController();
    String token = authController.login(user);
        Assert.assertFalse(token.isEmpty());
     }
}
