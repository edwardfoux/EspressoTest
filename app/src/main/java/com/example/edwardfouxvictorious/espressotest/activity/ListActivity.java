package com.example.edwardfouxvictorious.espressotest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.edwardfouxvictorious.espressotest.EspressoApplication;
import com.example.edwardfouxvictorious.espressotest.R;
import com.example.edwardfouxvictorious.espressotest.adapter.EarthquakeAdapter;
import com.example.edwardfouxvictorious.espressotest.model.Earthquake;
import com.example.edwardfouxvictorious.espressotest.model.EarthquakeResponse;
import com.example.edwardfouxvictorious.espressotest.presenter.ListPresenter;
import com.example.edwardfouxvictorious.espressotest.view.ActivityView;

import javax.inject.Inject;

import retrofit.Retrofit;

public class ListActivity extends AppCompatActivity implements ActivityView {

    private RecyclerView recyclerView;
    private EarthquakeAdapter.ItemClickListener itemClickListener;
    public static final String EARTHQUAKE = "earthquake";

    @Inject
    Retrofit retrofit;

    ListPresenter listPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((EspressoApplication) getApplication()).getNetComponent().inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String south = extras.getString(EntryActivity.SOUTH, "-9.9");
            String east = extras.getString(EntryActivity.EAST, "-22.4");
            String west = extras.getString(EntryActivity.WEST, "55.2");
            String north = extras.getString(EntryActivity.NORTH, "44.1");

            listPresenter = new ListPresenter(retrofit);
            listPresenter.init(this, south, east, west, north);
            listPresenter.getData();
        }
    }

    @Override
    public void onDataAvailable(EarthquakeResponse response) {
        findViewById(R.id.progress).setVisibility(View.GONE);
        itemClickListener = new EarthquakeAdapter.ItemClickListener() {
            @Override
            public void onItemCLicked(Earthquake earthquake) {
                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                intent.putExtra(EARTHQUAKE, earthquake);
                startActivity(intent);
            }
        };

        EarthquakeAdapter earthquakeAdapter = new EarthquakeAdapter(response.getEarthquakes(), itemClickListener);
        recyclerView.setAdapter(earthquakeAdapter);

        earthquakeAdapter.notifyDataSetChanged();
    }
}
