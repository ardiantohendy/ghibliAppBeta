package com.example.ghibli.data;

import com.example.ghibli.MoviesInfo;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientChar {
    private static final String BASE_URL = "https://ghibliapi.herokuapp.com/people/";
    private static Retrofit retrofit = null;


    public static ApiInterface getRetrofitClientChar() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(ApiInterface.class);
    }
}
