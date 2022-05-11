package com.example.myapplication.RetrofitAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    String BASE_URL ="https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<DataModel>> getHeros();
}
