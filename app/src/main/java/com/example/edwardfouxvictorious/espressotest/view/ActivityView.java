package com.example.edwardfouxvictorious.espressotest.view;


import com.example.edwardfouxvictorious.espressotest.model.EarthquakeResponse;

/**
 * Interface to bridge UI (MainActivity) and the Presenter (MVP pattern)
 */
public interface ActivityView {
    /**
     * Called by presenter when the data is ready
     * @param response EarthquakeResponse payload
     */
    void onDataAvailable(EarthquakeResponse response);
}
