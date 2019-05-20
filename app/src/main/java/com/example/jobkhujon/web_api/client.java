package com.example.jobkhujon.web_api;

import com.example.jobkhujon.model.Category;

import retrofit2.Call;
import retrofit2.http.GET;

public interface client {
    @GET("menu/allMenus")
    Call<Category> getSubmenu();
}
