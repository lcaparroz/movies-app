package br.com.campuscode.moviesapp.models;

/**
 * Created by campuscode02 on 8/22/17.
 */

public class Movie {

    private String name;
    private String releaseDate;

    public Movie(String name, String releaseDate) {
        this.name = name;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
