package test.mvnTest.homeWork18For29;

import org.testng.annotations.Test;
import ua.hillel.ApiOrder.RestClient;

import java.io.IOException;

public class GetOrderTest {

    @Test
    public void getOrderTest() throws IOException {

        new RestClient().getOrder();
    }
}
