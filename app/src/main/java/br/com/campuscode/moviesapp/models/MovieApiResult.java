package br.com.campuscode.moviesapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by campuscode02 on 8/23/17.
 */

public class MovieApiResult {
    private int page;
    @SerializedName("total_results")
    private String totalResults;
    @SerializedName("total_pages")
    private String totalPage;
    private List<Movie> results;

    public int getPage() {
        return page;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public String getTotalPage() {
        return totalPage;
    }

    public List<Movie> getResults() {
        return results;
    }
}
