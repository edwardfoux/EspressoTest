package com.example.edwardfouxvictorious.espressotest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.edwardfouxvictorious.espressotest.R;
import com.example.edwardfouxvictorious.espressotest.model.Earthquake;

public class DetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earhquake_item);

        TextView textView = (TextView) findViewById(R.id.date);
        TextView depth = (TextView) findViewById(R.id.depth);
        TextView magnitude = (TextView) findViewById(R.id.magnitude);

        if (getIntent().getExtras() != null) {
            Earthquake earthquake = (Earthquake) getIntent().getExtras().getSerializable(ListActivity.EARTHQUAKE);
            textView.setText(earthquake.getDatetime());
            depth.setText(earthquake.getDepth() + "");
            magnitude.setText(earthquake.getMagnitude()+ "");
        }
    }
}
