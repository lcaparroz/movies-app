package br.com.campuscode.moviesapp.api;

import java.util.List;

import br.com.campuscode.moviesapp.Config;
import br.com.campuscode.moviesapp.models.MovieApiResult;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by campuscode02 on 8/23/17.
 */

public interface MovieApi {
    @GET(Config.API_URL + "&api_key=" + Config.API_KEY)
    Call<MovieApiResult> getMovies();
}
