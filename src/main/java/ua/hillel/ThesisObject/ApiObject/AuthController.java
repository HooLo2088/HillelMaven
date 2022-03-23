package ua.hillel.ThesisObject.ApiObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class AuthController {
    public void registerUser(User user) throws IOException {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("username", user.getUsername());
        jsonobject.put("password", user.getPassword());
        jsonobject.put("confirmPassword", user.getConfirmpassword());

        RequestBody requestBody = RequestBody.create(jsonobject.toString().getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/auth/signup")
                .post(requestBody)
                .header("Content-Type", "application/json")
                .build();

        Response response = new OkHttpClient().newCall(request).execute();
    }

    public String login(User user) throws IOException {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("username", user.getUsername());
        jsonobject.put("password", user.getPassword());



        RequestBody requestBody = RequestBody.create(jsonobject.toString().getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/auth/signin")
                .post(requestBody)
                .header("Content-Type", "application/json")
                .build();

        Response response = new OkHttpClient().newCall(request).execute();
        JSONObject responseJson = new JSONObject(response.body().string());
        return responseJson.get("token").toString();
    }
}
