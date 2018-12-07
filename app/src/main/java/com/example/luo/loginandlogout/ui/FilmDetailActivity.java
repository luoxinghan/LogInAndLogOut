package com.example.luo.loginandlogout.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.luo.loginandlogout.R;
import com.example.luo.loginandlogout.data.modules.Film;
import com.example.luo.loginandlogout.data.util.DateUtil;
import com.example.luo.loginandlogout.data.util.DrawableUtil;

public class FilmDetailActivity extends AppCompatActivity  implements View.OnClickListener {

    private ImageView mFilmDetailImage;
    private TextView mFilmDetailTitle;
    private TextView mFilmDetailDate;
    private TextView mFilmDetailDescribe;
    private Button mFilmDetailBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detail);
        Intent intent = getIntent();
        Film film= (Film) intent.getSerializableExtra("film");
        mFilmDetailImage = findViewById(R.id.film_detail_image_view);
        mFilmDetailTitle = findViewById(R.id.film_detail_title_text_view);
        mFilmDetailDate = findViewById(R.id.film_detail_date_text_view);
        mFilmDetailDescribe = findViewById(R.id.film_detail_des_text_view);
        mFilmDetailBack = findViewById(R.id.film_detail_back_button);

        mFilmDetailBack.setOnClickListener(this);

        mFilmDetailImage.setImageResource(DrawableUtil.getResourceByReflect(film.getFilmsPosterUrl()));
        mFilmDetailTitle.setText(film.getTitle());
        mFilmDetailDate.setText(DateUtil.dateFormat(film.getShowData()));
        mFilmDetailDescribe.setText(film.getDescribe());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.film_detail_back_button:
                /*Intent filmsIntent = new Intent(FilmDetailActivity.this, FilmsActivity.class);
                startActivity(filmsIntent);*/
                finish();
                break;
        }
    }
}
