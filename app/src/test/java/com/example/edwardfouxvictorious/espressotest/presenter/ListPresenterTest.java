package com.example.edwardfouxvictorious.espressotest.presenter;


import com.example.edwardfouxvictorious.espressotest.model.EarthquakeResponse;
import com.example.edwardfouxvictorious.espressotest.view.ActivityView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import retrofit.Retrofit;

public class ListPresenterTest {

    private ListPresenter listPresenter;
    private ActivityView activityView;

    @Mock
    EarthquakeResponse earthquakeResponseBody;

    @Mock
    Retrofit retrofit;

    @Before
    public void setup() {
        listPresenter = new ListPresenter(retrofit);

        listPresenter.init(activityView, "20", "10", "20", "30");

        activityView = Mockito.mock(ActivityView.class);
        listPresenter.view = activityView;
    }

    @Test
    public void onDataAvailableTest() {
        listPresenter.dataLoaderCallback.onSuccess(earthquakeResponseBody);

        Mockito.verify(activityView, Mockito.times(1)).onDataAvailable(earthquakeResponseBody);
    }
}
