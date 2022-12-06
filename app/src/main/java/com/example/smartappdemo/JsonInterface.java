package com.example.smartappdemo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonInterface {

    @GET("/.json")
    Call<DataModel> getData();

}
