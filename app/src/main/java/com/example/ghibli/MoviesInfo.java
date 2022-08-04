package com.example.ghibli;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.example.ghibli.adapter.CharacterAdapter;
import com.example.ghibli.data.RecyclerViewCharInterface;
import com.example.ghibli.data.RetrofitClientChar;
import com.example.ghibli.model.GhibliMovies;
import com.example.ghibli.model.People;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesInfo extends AppCompatActivity implements RecyclerViewCharInterface {
    private ArrayList<People> peopleArrayList;
    private ArrayList<People> characterArraylist;
    private CardView charCard;
    private GhibliMovies movieInfo;
    private CharacterAdapter characterAdapter;
    private RecyclerView recyclerViewCharacter;



    @SuppressLint({"SetTextI18n", "SetJavaScriptEnabled"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_info);
        peopleArrayList = new ArrayList<>();
        characterArraylist = new ArrayList<>();

        TextView title = findViewById(R.id.commonTitle);
        TextView oriTitle = findViewById(R.id.oriTitle);
        TextView romajiTitle = findViewById(R.id.romajiTitle);
        TextView directorTxt = findViewById(R.id.director);
        TextView descriptionTxt = findViewById(R.id.descriptionMovie);
        TextView producerTxt = findViewById(R.id.producer);
        TextView releaseTxt = findViewById(R.id.yearRelease);
        TextView runningTimeTxt = findViewById(R.id.runningTime);
        ImageView imageView = findViewById(R.id.imageCard);
        charCard = findViewById(R.id.charCardInfo);
        YouTubePlayerView youTubePlayerView = findViewById(R.id.webViewVideo);
        getLifecycle().addObserver(youTubePlayerView);
        recyclerViewCharacter = findViewById(R.id.characterRecView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                super.onReady(youTubePlayer);
                String urlVideo = getIntent().getStringExtra("trailer");
                youTubePlayer.loadVideo(urlVideo, 0);
            }
        });


        //Intent from main activity
        movieInfo = (GhibliMovies) getIntent().getSerializableExtra("movies_object");
        ArrayList<Integer> imageCardArrayList = (ArrayList<Integer>) getIntent().getSerializableExtra("movies_images");


        //let's try it!

        fetcCharThrough();
        characterAdapter = new CharacterAdapter(characterArraylist, this, this);
        recyclerViewCharacter.setAdapter(characterAdapter);
        recyclerViewCharacter.setLayoutManager(new LinearLayoutManager(this));


        imageView.setImageResource(imageCardArrayList.get(movieInfo.getPosition()));
        title.setText(movieInfo.getTitle());
        oriTitle.setText(movieInfo.getOriginal_title());
        romajiTitle.setText(movieInfo.getOriginal_title_romanised());
        directorTxt.setText("Directed by: " + movieInfo.getDirector());
        descriptionTxt.setText(movieInfo.getDescription());
        producerTxt.setText("Producer: " + movieInfo.getProducer());
        releaseTxt.setText("Year of Production: " + movieInfo.getRelease_date());
        runningTimeTxt.setText("Running Time: " + movieInfo.getRunning_time() + " min");


    }

    private void fetcCharThrough() {
        RetrofitClientChar.getRetrofitClientChar().getCharacters().enqueue(new Callback<List<People>>(){
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<List<People>> call, Response<List<People>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    peopleArrayList.addAll(response.body());
                    boolean isExist = false;
                    for (int i = 0; i < peopleArrayList.size(); i++) {
                        if(movieInfo.getUrl().equals(peopleArrayList.get(i).getFilms().get(0))) {
                            characterArraylist.add(peopleArrayList.get(i));
                            isExist = true;
                        }
                    }
                    if(!isExist) {
                        charCard.setVisibility(View.GONE);
                    }
                    characterAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<People>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onItemCharClick(int position) {
        intentCharInfoIn(position);
    }

    private void intentCharInfoIn(int position) {
        Intent intent = new Intent(MoviesInfo.this, CharInfoActivity.class);
        intent.putExtra("character_object", characterArraylist.get(position));
        startActivity(intent);
    }
}