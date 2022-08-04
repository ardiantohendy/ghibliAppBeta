package com.example.ghibli;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ghibli.adapter.CharacterAdapter;
import com.example.ghibli.adapter.MainMenuAdapter;
import com.example.ghibli.data.RecyclerViewCharInterface;
import com.example.ghibli.data.RecyclerviewInterface;
import com.example.ghibli.data.RetrofitClient;
import com.example.ghibli.data.RetrofitClientChar;
import com.example.ghibli.model.GhibliMovies;
import com.example.ghibli.model.People;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecyclerviewInterface, RecyclerViewCharInterface, View.OnClickListener {
    private ProgressBar progressBar;
    private TextView recInfo;
    private CardView loadScreen, cardCharChild;
    private ImageView characterBtn, moviesBtn, ratingBtn, arrowImage;
    private MainMenuAdapter adapter;
    private CharacterAdapter characterAdapter;
    private ArrayList<GhibliMovies> ghibliMoviesArrayListNative;
    private ArrayList<People> chartcersPeople;
    private ArrayList<Integer> images;
    private ArrayList<String> videosId;
    private RecyclerView recyclerView, recyclerViewChar;
    Intent intent;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.moviesBtn:
                recyclerView.setVisibility(View.VISIBLE);
                moviesBtn.setColorFilter(getResources().getColor(R.color.white));
                characterBtn.setColorFilter(getResources().getColor(R.color.warna_btn));
                recInfo.setText("MOVIES");
                recyclerViewChar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                ratingBtn.setColorFilter(getResources().getColor(R.color.warna_btn));

                break;
            case R.id.characterBtn:
                recyclerView.setVisibility(View.GONE);
                recyclerViewChar.setVisibility(View.VISIBLE);
                recInfo.setText("CHARACTERS");
                characterBtn.setColorFilter(getResources().getColor(R.color.white));
                moviesBtn.setColorFilter(getResources().getColor(R.color.warna_btn));
                ratingBtn.setColorFilter(getResources().getColor(R.color.warna_btn));
                break;
            case R.id.rattingBtn:
                recyclerView.setVisibility(View.GONE);
                recyclerViewChar.setVisibility(View.GONE);
                recInfo.setText("RATTING");
                ratingBtn.setColorFilter(getResources().getColor(R.color.white));
                moviesBtn.setColorFilter(getResources().getColor(R.color.warna_btn));
                characterBtn.setColorFilter(getResources().getColor(R.color.warna_btn));

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        characterBtn = findViewById(R.id.characterBtn);
        moviesBtn = findViewById(R.id.moviesBtn);
        ratingBtn = findViewById(R.id.rattingBtn);
        recyclerView = findViewById(R.id.recyclerViewMovies);
        recyclerViewChar = findViewById(R.id.recyclerViewChar);
        recInfo = findViewById(R.id.recInfo);
        cardCharChild = findViewById(R.id.cardCharChild);
        arrowImage = findViewById(R.id.arrowImage);

        moviesBtn.setOnClickListener(this);
        characterBtn.setOnClickListener(this);
        ratingBtn.setOnClickListener(this);

        ghibliMoviesArrayListNative = new ArrayList<>();
        chartcersPeople = new ArrayList<>();
        progressBar = findViewById(R.id.progressBar);
        loadScreen = findViewById(R.id.loadScreen);
        images = new ArrayList<>();
        videosId = new ArrayList<>();

        fetchMovies();
        fetchCharacter();
        imageLoader();
        youtubeVideoId();


        adapter = new MainMenuAdapter(ghibliMoviesArrayListNative, this, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        characterAdapter = new CharacterAdapter(chartcersPeople, this, this);
        recyclerViewChar.setAdapter(characterAdapter);
        recyclerViewChar.setLayoutManager(new LinearLayoutManager(this));


    }

    private void imageLoader() {
        images.add(R.drawable.castle);
        images.add(R.drawable.grave);
        images.add(R.drawable.totoroo);
        images.add(R.drawable.kiki);
        images.add(R.drawable.yesterday);
        images.add(R.drawable.porco2);
        images.add(R.drawable.pomm);
        images.add(R.drawable.whisperr);
        images.add(R.drawable.mononoke);
        images.add(R.drawable.yamadas);
        images.add(R.drawable.spirit);
        images.add(R.drawable.cat);
        images.add(R.drawable.howl);
        images.add(R.drawable.tales);
        images.add(R.drawable.ponyo);
        images.add(R.drawable.arietty);
        images.add(R.drawable.poppy);
        images.add(R.drawable.wind);
        images.add(R.drawable.kaguya);
        images.add(R.drawable.marnie);
        images.add(R.drawable.turtle);
        images.add(R.drawable.earwig);
    }

    private void youtubeVideoId() {
        videosId.add("8ykEy-yPBFc");
        videosId.add("4vPeTSRd580");
        videosId.add("92a7Hj0ijLs");
        videosId.add("4bG17OYs-GA");
        videosId.add("z1a9AV5ii_o");
        videosId.add("awEC-aLDzjs");
        videosId.add("_7cowIHjCD4");
        videosId.add("0pVkiod6V0U");
        videosId.add("4OiMOHRDs14");
        videosId.add("1C9ujuCPlnY");
        videosId.add("ByXuk9QqQkk");
        videosId.add("Gp-H_YOcYTM");
        videosId.add("iwROgK94zcM");
        videosId.add("8hxYx3Jq3kI");
        videosId.add("CsR3KVgBzSM");
        videosId.add("9CtIXPhPo0g");
        videosId.add("9nzpk_Br6yo");
        videosId.add("RzSpDgiF5y8");
        videosId.add("W71mtorCZDw");
        videosId.add("jjmrxqcQdYg");
        videosId.add("Sw7BggqBpTk");
        videosId.add("KRq3xlhZDPo");

    }

    private void fetchMovies() {
        loadScreen.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        RetrofitClient.getRetrofitClient().getMovies().enqueue(new Callback<List<GhibliMovies>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<List<GhibliMovies>> call, Response<List<GhibliMovies>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ghibliMoviesArrayListNative.addAll(response.body());
                    for (int i = 0; i < ghibliMoviesArrayListNative.size(); i++) {
                        ghibliMoviesArrayListNative.get(i).setImageCardInt(images.get(i));
                    }
                    adapter.notifyDataSetChanged();
                    loadScreen.setVisibility(View.GONE);
                    progressBar.setVisibility(View.GONE);
                } else {
                    Toast.makeText(MainActivity.this, "go to sleep", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<GhibliMovies>> call, Throwable t) {
                loadScreen.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Error " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fetchCharacter() {
        RetrofitClientChar.getRetrofitClientChar().getCharacters().enqueue(new Callback<List<People>>() {
            @Override
            public void onResponse(Call<List<People>> call, Response<List<People>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    chartcersPeople.addAll(response.body());
                    characterAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<People>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onItemClick(int position) {
        intentCharData(position);
    }

    @Override
    public void onItemCharClick(int position) {
        intent = new Intent(MainActivity.this,CharInfoActivity.class);
        intent.putExtra("person_object", chartcersPeople.get(position));
        startActivity(intent);
    }

    public void intentCharData(int position) {
        intent = new Intent(MainActivity.this, MoviesInfo.class);
        ghibliMoviesArrayListNative.get(position).setPosition(position);
        intent.putExtra("movies_images", images);
        intent.putExtra("trailer", videosId.get(position));
        intent.putExtra("people_object_people", chartcersPeople);
        intent.putExtra("movies_object", ghibliMoviesArrayListNative.get(position));
        startActivity(intent);
    }

}