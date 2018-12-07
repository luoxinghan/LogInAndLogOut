package com.example.luo.loginandlogout.data.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.luo.loginandlogout.R;
import com.example.luo.loginandlogout.data.modules.Film;
import com.example.luo.loginandlogout.data.inter.OnRecyclerViewClickListener;
import com.example.luo.loginandlogout.data.util.DateUtil;
import com.example.luo.loginandlogout.data.util.DrawableUtil;

import java.util.List;

public class FilmsAdapters extends RecyclerView.Adapter<FilmsAdapters.FilmViewHolder> {

    private final String TAG = "FilmsAdaptersLogs";
    private List<Film> films;

    public FilmsAdapters(List<Film> films) {
        this.films = films;
    }

    private OnRecyclerViewClickListener listener;
    public void setItemClickListener(OnRecyclerViewClickListener itemClickListener) {
        listener = itemClickListener;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_film, viewGroup,false);
        final FilmViewHolder filmViewHolder = new FilmViewHolder(view);
        if(listener != null){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClickListener(v, (int)v.getTag());
                }
            });
        }
        return filmViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder filmViewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: " + i);
        Film film = films.get(i);

        filmViewHolder.mFilmPoster.setImageResource(DrawableUtil.getResourceByReflect(film.getFilmsPosterUrl()));
        filmViewHolder.itemView.setTag(i);
        filmViewHolder.mFilmTitle.setText(film.getTitle());
        filmViewHolder.mPublishDate.setText(DateUtil.dateFormat(film.getShowData()));
    }


    @Override
    public int getItemCount() {
        return films.size();
    }

    public class FilmViewHolder extends RecyclerView.ViewHolder {
        private ImageView mFilmPoster;
        private TextView mFilmTitle;
        private TextView mPublishDate;

        public FilmViewHolder(@NonNull View itemView) {
            super(itemView);
            mFilmPoster = itemView.findViewById(R.id.film_image_view);
            mFilmTitle = itemView.findViewById(R.id.film_title_text_view);
            mPublishDate = itemView.findViewById(R.id.film_date_text_view);
        }
    }
}
