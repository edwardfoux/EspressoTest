package com.example.edwardfouxvictorious.espressotest.net;

import com.example.edwardfouxvictorious.espressotest.model.EarthquakeResponse;

import retrofit.Call;
import retrofit.http.GET;

import static com.example.edwardfouxvictorious.espressotest.presenter.ListPresenter.URL_PATH;

public interface EarthquakeRequest {
    @GET(URL_PATH)
    Call<EarthquakeResponse> getEarthQuackesList(
            /*@Path("south") String south,
            @Path("east") String east,
            @Path("west") String west,
            @Path("north") String north*/
    );
}
