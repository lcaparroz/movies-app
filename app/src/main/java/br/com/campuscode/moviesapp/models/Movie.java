package br.com.campuscode.moviesapp.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import br.com.campuscode.moviesapp.Config;

/**
 * Created by campuscode02 on 8/22/17.
 */

public class Movie implements Serializable {

    private String title;
    @SerializedName("release_date")
    private String releaseDate;
    private String overview;
    @SerializedName("vote_count")
    private int voteCount;
    @SerializedName("vote_average")
    private Float  voteAverage;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("backdrop_path")
    private String backdropPath;

    public Movie(String title, String releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public Float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getPosterPath() {
        return Config.POSTER_BASE_URL + posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return Config.BACKDROP_BASE_URL + backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }
}
