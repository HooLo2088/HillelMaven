package ua.hillel.ThesisObject.ApiObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UserController {

    public String getUser(String token) throws IOException {
        Request request = new Request.Builder()
                .get()
                .url("https://freelance.lsrv.in.ua/api/user/")
                .addHeader("Authorization", token)
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();

        JSONObject responseJson = new JSONObject(response.body().string());
        return responseJson.get("id").toString();
    }

    public String getUserWithId(String token, String userIdForUrl) throws IOException {
        Request request = new Request.Builder()
                .get()
                .url("https://freelance.lsrv.in.ua/api/user/" + userIdForUrl)
                .addHeader("Authorization", token)
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();

        JSONObject responseJson = new JSONObject(response.body().string());
        return responseJson.get("id").toString();
    }

    public void updateUser(String token, User user) throws IOException {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("userId", user.getUserId());
        jsonobject.put("username", user.getUsername());
        jsonobject.put("name", user.getName());
        jsonobject.put("lastname", user.getLastname());

        RequestBody requestBody = RequestBody.create(jsonobject.toString().getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/user/update")
                .post(requestBody)
                .header("Authorization", token)
                .build();

        Response response = new OkHttpClient().newCall(request).execute();
    }
}
