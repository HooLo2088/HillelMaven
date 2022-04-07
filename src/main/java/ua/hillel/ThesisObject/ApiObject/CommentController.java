package ua.hillel.ThesisObject.ApiObject;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CommentController {
    public Comment createComment(String token, Integer jobId, Comment comment) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", comment.getMessage());

        RequestBody requestBody = RequestBody.create(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .post(requestBody)
                .url("https://freelance.lsrv.in.ua/api/comment/" + jobId + "/create")
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .build();

        Response response = new OkHttpClient().newCall(request).execute();

        Gson gson = new Gson();
        Comment newComment = gson.fromJson(response.body().string(), Comment.class);
        return newComment;
    }

    public List<Comment> getAllComments(String token, Integer jobId) throws IOException {
        Request request = new Request.Builder()
                .get()
                .url("https://freelance.lsrv.in.ua/api/comment/" + jobId + "/all")
                .header("Authorization", token)
                .build();

        Response response = new OkHttpClient().newCall(request).execute();
        return new Gson().fromJson(response.body().string(), new TypeToken<List<Comment>>() {
        }.getType());
    }
}
