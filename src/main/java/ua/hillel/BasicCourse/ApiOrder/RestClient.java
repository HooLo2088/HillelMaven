package ua.hillel.BasicCourse.ApiOrder;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class RestClient {

    public void createOrder(Order order) throws IOException {

        Gson gson = new Gson();

        RequestBody body = RequestBody.create(gson.toJson(order).getBytes(StandardCharsets.UTF_8));

        Request request = new Request.Builder()
                .post(body)
                .url("https://petstore.swagger.io/v2/store/order")
                .addHeader("Content-type", "application/json")
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());
    }

    public void getOrder() throws IOException {

        Request request = new Request.Builder()
                .url("https://petstore.swagger.io/v2/store/order/1")
                .get()
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());
    }

    public void deleteOrder() throws IOException {

        Request request = new Request.Builder()
                .url("https://petstore.swagger.io/v2/store/10500")
                .delete()
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());
    }

    public void getInventory() throws IOException {

        Request request = new Request.Builder()
                .url("https://petstore.swagger.io/v2/store/inventory")
                .get()
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());
    }
}
