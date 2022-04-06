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

public class JobController {

    public Job createJob(String token, Job job) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", job.getTitle());
        jsonObject.put("description", job.getDescription());
        jsonObject.put("price", job.getPrice());

        RequestBody requestBody = RequestBody.create(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/job/create")
                .post(requestBody)
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .build();

        Response response = new OkHttpClient().newCall(request).execute();

        Gson gson = new Gson();
        Job newJob = gson.fromJson(response.body().string(), Job.class);
        return newJob;
    }

    public String deleteJobWithId(String token, Integer jobId) throws IOException {
        JSONObject jsonObject = new JSONObject();
        RequestBody requestBody = RequestBody.create(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .post(requestBody)
                .url("https://freelance.lsrv.in.ua/api/job/delete/" + jobId)
                .addHeader("Authorization", token)
                .header("Content-Type", "application/json")
                .build();

        Response response = new OkHttpClient().newCall(request).execute();
        JSONObject respMessa = new JSONObject(response.body().string());
        return respMessa.get("message").toString();
    }

    public Job getJobWithId(String token, Integer jobId) throws IOException {
        Request request = new Request.Builder()
                .get()
                .url("https://freelance.lsrv.in.ua/api/job/" + jobId)
                .addHeader("Authorization", token)
                .build();

        Response response = new OkHttpClient().newCall(request).execute();
        Gson gson = new Gson();
        Job respJob = gson.fromJson(response.body().string(), Job.class);
        return respJob;
    }

    public List<Job> getUserJob(String token) throws IOException {

        Request request = new Request.Builder()
                .get()
                .url("https://freelance.lsrv.in.ua/api/job/user/jobs")
                .addHeader("Authorization", token)
                .build();
        Response response = new OkHttpClient().newCall(request).execute();

        return new Gson().fromJson(response.body().string(), new TypeToken<List<Job>>() {
        }.getType());
    }

    public List<Job> getAllJob(String token) throws IOException {

        Request request = new Request.Builder()
                .get()
                .url("https://freelance.lsrv.in.ua/api/job/all")
                .addHeader("Authorization", token)
                .build();
        Response response = new OkHttpClient().newCall(request).execute();

        return new Gson().fromJson(response.body().string(), new TypeToken<List<Job>>() {
        }.getType());
    }
}
