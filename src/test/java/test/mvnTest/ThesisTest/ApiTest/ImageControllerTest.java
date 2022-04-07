package test.mvnTest.ThesisTest.ApiTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ua.hillel.ThesisObject.ApiObject.*;

import java.io.File;
import java.io.IOException;


public class ImageControllerTest {
    private User user;
    public String userToken;
    File file = new File("src/test/resources/2.jpg");

    @BeforeClass
    public void prepareUser() throws IOException {
        user = new User();
        user.setUsername("hoolo1");
        user.setPassword("12345678");

        AuthController authController = new AuthController();
        userToken = authController.login(user);
    }

    @Test
    public void getImageProfile() throws IOException {
        ImageController imageController = new ImageController();
        String image = imageController.getImageProfile(userToken).getImage();
        Assert.assertNotEquals("image", null);
    }

    @Test
    public void getImageProfileWithUserId() throws IOException {

        UserController userController = new UserController();
        String userId = userController.getUser(userToken).getId();

        ImageController imageController = new ImageController();
        String image = imageController.getImageWithUserId(userToken, userId).getImage();
        Assert.assertNotEquals("image", null);
    }

    @Test
    public void postImage() throws IOException {
        ImageController imageController = new ImageController();
        String image = imageController.postImageUplod(userToken, file).getMessage();
        Assert.assertEquals(image, "User image was uploaded", "not working");
    }
}
