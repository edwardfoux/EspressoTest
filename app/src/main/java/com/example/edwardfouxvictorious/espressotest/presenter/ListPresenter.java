package com.example.edwardfouxvictorious.espressotest.presenter;

import android.support.annotation.VisibleForTesting;

import com.example.edwardfouxvictorious.espressotest.model.EarthquakeResponse;
import com.example.edwardfouxvictorious.espressotest.net.ApiCallback;
import com.example.edwardfouxvictorious.espressotest.net.EarthquakeRequest;
import com.example.edwardfouxvictorious.espressotest.view.ActivityView;

import java.lang.ref.WeakReference;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Presenter class for the business logic of the MainActivity
 * Takes care of the networking data loading (Using Retrofit api)
 */
public class ListPresenter {

    public static final String URL = "http://api.geonames.org";
    public static final String URL_PATH = "/earthquakesJSON?formatted=true&north=44.1&south=-9.9&east=-22.4&west=55.2&username=mkoppelman ";
    //public static final String URL_PATH = "/earthquakesJSON?formatted=true&north={north}&south={south}&east={east}&west={west}&username=demo";

    @VisibleForTesting
    ActivityView view;

    @VisibleForTesting
    DataLoaderCallback dataLoaderCallback = new DataLoaderCallback(this);

    private String south;
    private String east;
    private String west;
    private String north;

    public void init(ActivityView view, String south,String east, String west, String north) {
        this.view = view;

        this.south = (south == null) ? "-9.9" : south ;
        this.east = (east == null) ? "-22.4" : east ;
        this.north = (north == null) ? "44.1" : north ;
        this.west = (west == null) ? "55.2" : south ;
    }

    /**
     * Called by the MainActivity to start loading the data
     */
    public void getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EarthquakeRequest earthquakeApi = retrofit.create(EarthquakeRequest.class);

        Call<EarthquakeResponse> call = earthquakeApi.getEarthQuackesList(/*south, east, west, north*/);

        call.enqueue(dataLoaderCallback);
    }

    /**
     * static class for the networking job
     * Keeps the weak reference to the presenter to avoid memory leaks
     */
    @VisibleForTesting
    class DataLoaderCallback extends ApiCallback<EarthquakeResponse> {
        WeakReference<ListPresenter> ref;

        private DataLoaderCallback(ListPresenter page) {
            this.ref = new WeakReference<>(page);
        }

        @Override
        public void onSuccess(EarthquakeResponse response) {
            ListPresenter listPresenter = ref.get();
            if (listPresenter == null) return;

            listPresenter.view.onDataAvailable(response);
        }
    }
}
