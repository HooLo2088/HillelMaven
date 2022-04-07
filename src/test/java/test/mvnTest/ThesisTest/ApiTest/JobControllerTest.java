package test.mvnTest.ThesisTest.ApiTest;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ua.hillel.ThesisObject.ApiObject.AuthController;
import ua.hillel.ThesisObject.ApiObject.Job;
import ua.hillel.ThesisObject.ApiObject.JobController;
import ua.hillel.ThesisObject.ApiObject.User;

import java.io.IOException;
import java.util.List;

public class JobControllerTest {
    private User user;
    private Job job;
    public String userToken;

    @BeforeClass
    public void prepareUser() throws IOException {
        Faker faker = new Faker();

        user = new User();
        user.setUsername("hoolo1");
        user.setPassword("12345678");

        job = new Job();
        job.setTitle(faker.company().name());
        job.setDescription(faker.address().country());
        job.setPrice(100500.34);

        AuthController authController = new AuthController();
        userToken = authController.login(user);
    }

    @Test
    public void getUserJob() throws IOException {
        JobController jobController = new JobController();
        List job = jobController.getUserJob(userToken);
    }

    @Test
    public void getAllJob() throws IOException {
        JobController jobController = new JobController();
        List job = jobController.getAllJob(userToken);
    }

    @Test
    public void getUserJobWithId() throws IOException {
        JobController jobController = new JobController();
        Integer jobId = jobController.getUserJob(userToken).get(0).getId();
        Job job = jobController.getJobWithId(userToken, jobId);
    }

    @Test
    public void createUserJob() throws IOException {
        JobController jobController = new JobController();
        String newJobId = jobController.createJob(userToken, job).getId().toString();
        Assert.assertFalse(newJobId.isEmpty());
    }

    @Test(dependsOnMethods = "createUserJob")
    public void deleteUserJobWithId() throws IOException {
        JobController jobController = new JobController();
        Integer jobId = jobController.getUserJob(userToken).get(0).getId();
        String delMessa = jobController.deleteJobWithId(userToken, jobId);
        Assert.assertFalse(delMessa.isEmpty());
    }
}
