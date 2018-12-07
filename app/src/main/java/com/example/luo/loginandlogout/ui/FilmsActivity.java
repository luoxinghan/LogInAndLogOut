package com.example.luo.loginandlogout.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.luo.loginandlogout.R;
import com.example.luo.loginandlogout.data.modules.Film;
import com.example.luo.loginandlogout.data.inter.OnRecyclerViewClickListener;
import com.example.luo.loginandlogout.data.adapters.FilmsAdapters;
import com.example.luo.loginandlogout.data.helper.FilmsHelper;

import java.util.List;

public class FilmsActivity extends AppCompatActivity {

    public static final String FILM = "film";
    private List<Film> films;
    private RecyclerView mFilmRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private FilmsAdapters mFilmsAdapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films);

        films = FilmsHelper.createFilms();
        mFilmRecyclerView = findViewById(R.id.films_recycler_view);
        mFilmRecyclerView.setHasFixedSize(true);

        mFilmRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        mLayoutManager = new LinearLayoutManager(this);
        mFilmRecyclerView.setLayoutManager(mLayoutManager);

        mFilmsAdapters = new FilmsAdapters(films);
        mFilmRecyclerView.setAdapter(mFilmsAdapters);

        mFilmsAdapters.setItemClickListener(new OnRecyclerViewClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                /*Toast.makeText(getBaseContext(), "Des" + films.get(position).getDescribe(), Toast.LENGTH_LONG).show();*/
                Intent intent = new Intent(getBaseContext(), FilmDetailActivity.class);
                intent.putExtra(FILM, films.get(position));
                startActivity(intent);
            }
        });
    }
}
