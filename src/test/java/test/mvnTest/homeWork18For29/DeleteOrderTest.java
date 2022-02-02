package test.mvnTest.homeWork18For29;

import org.testng.annotations.Test;
import ua.hillel.ApiOrder.RestClient;

import java.io.IOException;

public class DeleteOrderTest {
    @Test
    public void deleteOrderTest() throws IOException {
        new RestClient().deleteOrder();
    }
}
