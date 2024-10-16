package com.app.aptech.repositories;
import android.util.Log;

import androidx.annotation.NonNull;

import com.app.aptech.models.Photo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PhotoRepository {
    private String urlPhotos = Repositories.BASE_URL+"/photos";
    //private Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();
    public void getAllPhotos(IResponse myResponse) {
        List<Photo> photos = new ArrayList<>();
        Request request = new Request.Builder()
                .url(urlPhotos)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String jsonString = response.body().string();
                JsonArray jsonArray = (JsonArray)JsonParser.parseString(jsonString);
                jsonArray.forEach((JsonElement jsonElement) -> {
                    JsonObject jsonObject = (JsonObject)jsonElement;
                    Photo photo = Photo.fromJson(jsonObject);
                    photos.add(photo);
                    Log.d("PhotoRepository", "haha");
                });
                myResponse.getResponse(photos, "");

            }

            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException exception) {
                Log.e("PhotoRepository", "Cannot get photos from Server: "+exception.toString());
                myResponse.getResponse(photos, exception.toString());
            }


        });
    }
}
