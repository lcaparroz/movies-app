package br.com.campuscode.moviesapp.controllers;

import java.util.List;
import java.util.Observable;

import br.com.campuscode.moviesapp.Config;
import br.com.campuscode.moviesapp.api.MovieApi;
import br.com.campuscode.moviesapp.models.Movie;
import br.com.campuscode.moviesapp.models.MovieApiResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by campuscode02 on 8/23/17.
 */

public class MovieApiController extends Observable implements Callback<MovieApiResult> {

    private MovieApi movieApi;
    private MovieApiResult result;

    @Override
    public void onResponse(Call<MovieApiResult> call, Response<MovieApiResult> response) {
        if (response.isSuccessful()) {
            result = response.body();
            setChanged();
            notifyObservers();
        }
    }

    @Override
    public void onFailure(Call<MovieApiResult> call, Throwable t) {
        t.printStackTrace();
    }

    public void start() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        movieApi = retrofit.create(MovieApi.class);
        Call<MovieApiResult> callResult   = movieApi.getMovies();
        callResult.enqueue(this);
    }

    public List<Movie> getMovieList() {
        return result.getResults();
    }
}
