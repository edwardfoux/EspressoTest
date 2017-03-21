package com.example.edwardfouxvictorious.espressotest.net;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Abstract class for the network
 * @param <T>
 */
public abstract class ApiCallback<T> implements Callback<T>{
    public ApiCallback() {
        super();
    }

    public abstract void onSuccess(T response);

    @Override
    public void onResponse(Response<T> response, Retrofit retrofit) {
        onSuccess(response.body());
    }

    @Override
    public void onFailure(Throwable t) {}
}
