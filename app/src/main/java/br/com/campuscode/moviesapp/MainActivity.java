package br.com.campuscode.moviesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import br.com.campuscode.moviesapp.adapters.MovieAdapter;
import br.com.campuscode.moviesapp.controllers.MovieApiController;
import br.com.campuscode.moviesapp.models.Movie;

public class MainActivity extends AppCompatActivity implements Observer {
    RecyclerView rcvMovieList;
    MovieAdapter movieAdapter;
    List<Movie> movieList;
    MovieApiController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieList = new ArrayList<>();
        controller = new MovieApiController();

        controller.addObserver(this);
        controller.start();

        rcvMovieList = (RecyclerView) findViewById(R.id.rcv_movie_list);
        rcvMovieList.setLayoutManager(new GridLayoutManager(this, 2));

    }

    @Override
    public void update(Observable observable, Object o) {
        movieList = controller.getMovieList();
        setupAdapter();
    }

    private void setupAdapter() {
        movieAdapter = new MovieAdapter(this, movieList);
        rcvMovieList.setAdapter(movieAdapter);
    }
}
