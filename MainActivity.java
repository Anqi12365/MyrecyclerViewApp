package com.example.myrecyclerviewapp;

import android.os.Bundle;
import android.widget.Toast;
import androidx.App.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Movie> movies = JsonUtility.loadMovies(this, "movies.json");

        if (movies.isEmpty())
            Toast.makeText(this, "Failed to load movies", Toast.LENGTH_LONG).show();
        else {
            movieAdapter = new MovieAdapter(movies);
            recyclerView.setAdapter(movieAdapter);
        }
    }
}
