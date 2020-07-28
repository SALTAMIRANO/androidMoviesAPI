package com.tareas.clase4moviesapi.data;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tareas.clase4moviesapi.models.ActorsModel;
import com.tareas.clase4moviesapi.models.MovieModel;
import com.tareas.clase4moviesapi.util.JSONUtil;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ActorsData {
    public static List<ActorsModel> getActors(InputStream is) {
        List<ActorsModel> result = new ArrayList<>();
        try {
            String data = JSONUtil.getAssetJsonData(is);
            Type type = new TypeToken<List<ActorsModel>>(){}.getType();
            result = new Gson().fromJson(data,type);
        } catch (Exception ex) {
            Log.e("error", ex.getMessage());
        }
        return result;
    }
}
