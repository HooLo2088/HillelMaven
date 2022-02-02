package test.mvnTest.homeWork18For29;

import org.testng.annotations.Test;
import ua.hillel.ApiOrder.RestClient;

import java.io.IOException;

public class GetInventory {

    @Test
    public void getInventory() throws IOException {
        new RestClient().getInventory();
    }
}
