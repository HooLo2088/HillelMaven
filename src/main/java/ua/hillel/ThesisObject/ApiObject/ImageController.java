package ua.hillel.ThesisObject.ApiObject;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import okhttp3.*;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ImageController {

    public Image getImageProfile(String token) throws IOException {

        Request request = new Request.Builder()
                .get()
                .url("https://freelance.lsrv.in.ua/api/image/profile")
                .header("Authorization", token)
                .build();
        Response response = new OkHttpClient().newCall(request).execute();
        Gson gson = new Gson();
        Image respImage = gson.fromJson(response.body().string(), Image.class);
        return respImage;
    }

    public Image getImageWithUserId(String token, String userId) throws IOException {

        Request request = new Request.Builder()
                .get()
                .url("https://freelance.lsrv.in.ua/api/image/" + userId)
                .header("Authorization", token)
                .build();
        Response response = new OkHttpClient().newCall(request).execute();
        Gson gson = new Gson();
        Image respImage = gson.fromJson(response.body().string(), Image.class);
        return respImage;

    }

    public Image postImageUplod(String token, File file) throws IOException {

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(),
                        RequestBody.create(MediaType.parse("image/jpg"), file))
                .build();

        Request request = new Request.Builder()
                .post(requestBody)
                .url("https://freelance.lsrv.in.ua/api/image/upload")
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .build();
        Response response = new OkHttpClient().newCall(request).execute();
        Gson gson = new Gson();
        Image respImage = gson.fromJson(response.body().string(), Image.class);
        return respImage;
    }
}
