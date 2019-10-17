package com.example.nonprofitapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {


    private static Retrofit retrofit;
    private static final String BASE_URL="hhttps://projects.propublica.org/nonprofits/api/v2/";

    public static Retrofit getRetrofitInstance(){

        if(retrofit== null){
            retrofit = new Retrofit
                    .Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;

    }
}
