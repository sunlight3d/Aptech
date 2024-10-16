package com.aptech.androidclient.services;

import com.aptech.androidclient.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductApiService {
    @GET("api/Products")
    Call<List<Product>> getProducts();
}