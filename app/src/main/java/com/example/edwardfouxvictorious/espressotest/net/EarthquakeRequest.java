package com.example.edwardfouxvictorious.espressotest.net;

import com.example.edwardfouxvictorious.espressotest.model.EarthquakeResponse;
import com.example.edwardfouxvictorious.espressotest.presenter.ListPresenter;

import retrofit.Call;
import retrofit.http.GET;

public interface EarthquakeRequest<T> {
    @GET(ListPresenter.URL_PATH)
    Call<EarthquakeResponse> getEarthQuackesList(
            /*@Path("south") String south,
            @Path("east") String east,
            @Path("west") String west,
            @Path("north") String north*/
    );
}
