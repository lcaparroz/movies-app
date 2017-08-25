package br.com.campuscode.moviesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.campuscode.moviesapp.models.Movie;

public class MovieDescriptionActivity extends AppCompatActivity {

    ImageView imgMovieBackdrop;
    TextView tvMovieTitle;
    TextView tvMovieReleasDate;
    TextView tvMovieVoteCount;
    TextView tvMovieVoteAverage;
    TextView tvMovieOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_description);

        Object movieBundle = getIntent().getSerializableExtra("movie");
        Movie movie = null;

        if (movieBundle instanceof Movie) {
            movie = (Movie) movieBundle;
        }

        imgMovieBackdrop = (ImageView) findViewById(R.id.img_descr_movie_backdrop);
        tvMovieTitle = (TextView) findViewById(R.id.tv_descr_movie_title);
        tvMovieReleasDate = (TextView) findViewById(R.id.tv_descr_movie_release_date);
        tvMovieVoteAverage = (TextView) findViewById(R.id.tv_descr_movie_vote_avg);
        tvMovieVoteCount= (TextView) findViewById(R.id.tv_descr_movie_vote_count);
        tvMovieOverview = (TextView) findViewById(R.id.tv_descr_movie_overview);

        String movieReleaseDateText = "Release Date: " + movie.getReleaseDate();
        String movieVotesAverageText = "Vote Average: " + String.valueOf(movie.getVoteAverage());
        String movieVotesCountText = "Votes: " + String.valueOf(movie.getVoteCount());

        tvMovieTitle.setText(movie.getTitle());
        tvMovieReleasDate.setText(movieReleaseDateText);
        tvMovieVoteAverage.setText(movieVotesAverageText);
        tvMovieVoteCount.setText(movieVotesCountText);
        tvMovieOverview.setText(movie.getOverview());
        Picasso.with(this).load(movie.getBackdropPath()).into(imgMovieBackdrop);
    }
}
