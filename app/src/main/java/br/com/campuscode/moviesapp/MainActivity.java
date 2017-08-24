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
    RecyclerView rcv_movie_list;
    MovieAdapter movieAdapter;
    List<Movie> movieList;
    MovieApiController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieList = new ArrayList<>();
        controller = new MovieApiController();

//        Movie movie1 = new Movie("Homem-Aranha", "01/08/2017");
//        Movie movie2 = new Movie("Alien", "01/08/1987");
//        Movie movie3 = new Movie("Clube da Luta", "01/08/1999");
//        Movie movie4 = new Movie("A Volta dos Que Nao Foram", "01/08/2020");
//
//        movieList.add(movie1);
//        movieList.add(movie2);
//        movieList.add(movie3);
//        movieList.add(movie4);

        controller.addObserver(this);
        controller.start();

        rcv_movie_list = (RecyclerView) findViewById(R.id.rcv_movie_list);
        rcv_movie_list.setLayoutManager(new GridLayoutManager(this, 2));

    }

    @Override
    public void update(Observable observable, Object o) {
        movieList = controller.getMovieList();
        setupAdapter();
    }

    private void setupAdapter() {
        movieAdapter = new MovieAdapter(this, movieList);
        rcv_movie_list.setAdapter(movieAdapter);
    }
}
