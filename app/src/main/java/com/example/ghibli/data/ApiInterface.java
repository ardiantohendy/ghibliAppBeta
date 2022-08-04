package com.example.ghibli.data;

import com.example.ghibli.model.GhibliMovies;
import com.example.ghibli.model.People;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/films")
    Call<List<GhibliMovies>> getMovies();
    @GET("/people")
    Call<List<People>> getCharacters();
}
