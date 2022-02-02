package test.mvnTest.homeWork18For29;

import org.testng.annotations.Test;
import ua.hillel.ApiOrder.Order;
import ua.hillel.ApiOrder.RestClient;

import java.io.IOException;

public class PostOrderTest2 {

    @Test
    public void postOrderTest2() throws IOException {
        Order order = new Order();
        order.setId(123);
        order.setPetId(456);
        order.setQuantity(789);
        order.setShipDate("02.02.2022");
        order.setStatus("placed");
        order.setComplete("true");

        new RestClient().createOrder(order);
    }
}
