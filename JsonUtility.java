package com.example.myrecyclerviewapp;
import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonUtility {
    public static List<Movie> loadMovies(Context context, String fileName) {
        List<Movie> movies = new ArrayList<>();
        try {
            InputStream is = context.getAssets().open(fileName);
            Scanner scanner = new Scanner(is).useDelimiter("\\A");
            String jsonStr = scanner.hasNext() ? scanner.next() : "";

            JSONArray jsonArray = new JSONArray(jsonStr);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String title = obj.optString("title", "Unknown");
                int year = obj.optInt("year", 0);
                String genre = obj.optString("genre", "Unknown");
                String poster = obj.optString("poster", "default_poster");

                boolean add = movies.add(new Movie(title, year, genre, poster));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }
}
