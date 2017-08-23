package br.com.campuscode.moviesapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.campuscode.moviesapp.R;
import br.com.campuscode.moviesapp.models.Movie;

/**
 * Created by campuscode02 on 8/22/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    Context context;
    List<Movie> movieList;

    public MovieAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.movie_item, null);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.img_movie_poster.setImageResource(R.drawable.moonlight);
        holder.tv_movie_name.setText(movieList.get(position).getName());
        holder.tv_movie_release_date.setText(movieList.get(position).getReleaseDate());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        public ImageView img_movie_poster;
        public TextView  tv_movie_name;
        public TextView  tv_movie_release_date;

        public MovieViewHolder(View itemView) {
            super(itemView);

            img_movie_poster      = itemView.findViewById(R.id.img_movie_poster);
            tv_movie_name         = itemView.findViewById(R.id.tv_movie_name);
            tv_movie_release_date = itemView.findViewById(R.id.tv_movie_release_date);
        }
    }
}
