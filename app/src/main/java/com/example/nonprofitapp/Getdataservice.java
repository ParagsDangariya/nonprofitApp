package com.example.nonprofitapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Getdataservice {
/*

    @GET("search.json?order=revenue&sort_order=desc")
    Call<List<Pokemon>> getPokemons();
*/

    @GET("search.json?order=revenue&sort_order=desc")
    Call<Example> getExampleObj();
}
