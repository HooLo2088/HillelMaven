package test.mvnTest.BasicTest.homeWork18For29;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PostOrderTest {

    @Test
    public void postOrderTest() throws IOException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "100500");
        jsonObject.put("petId", "10500");
        jsonObject.put("quantity", "10050");
        jsonObject.put("shipDate", "2022-02-02T16:32:24.867Z");
        jsonObject.put("status", "placed");
        jsonObject.put("complete", "true");

        RequestBody body = RequestBody.create(jsonObject.toString().getBytes(StandardCharsets.UTF_8));

        Request request = new Request.Builder()
                .post(body)
                .url("https://petstore.swagger.io/v2/store/order")
                .addHeader("Content-type", "application/json")
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());
    }
}
