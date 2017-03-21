package com.example.edwardfouxvictorious.espressotest.adapter.viewholder;


import android.view.View;

import com.example.edwardfouxvictorious.espressotest.model.Earthquake;
import com.example.edwardfouxvictorious.espressotest.adapter.EarthquakeAdapter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ViewHolderTest {

    private EarthquakeAdapter earthquakeAdapter;
    @Mock
    View view;

    @Mock
    EarthquakeAdapter.ItemClickListener itemClickListener;

    private EarthquakeViewHolder earthquakeViewHolder;

    @Before
    public void setup() {
        Earthquake earthquake = new Earthquake("2007-09-12 09:10:26", 30, 8.4);
        Earthquake earthquake2 = new Earthquake("2007-09-12 09:10:26", 30, 5.4);
        List<Earthquake> list = new ArrayList<>();
        list.add(earthquake);
        list.add(earthquake2);

        earthquakeViewHolder = Mockito.mock(EarthquakeViewHolder.class);

        earthquakeAdapter = new EarthquakeAdapter(list, itemClickListener);
    }

    @Test
    public void testSelectedEarthQuake() {
        earthquakeAdapter.onBindViewHolder(earthquakeViewHolder, 0);

        Mockito.verify(earthquakeViewHolder, Mockito.times(1)).selectEQ();
    }

    @Test
    public void testUnSelectedEarthQuake() {
        earthquakeAdapter.onBindViewHolder(earthquakeViewHolder, 1);

        Mockito.verify(earthquakeViewHolder, Mockito.times(1)).unSelectEQ();
    }
}
