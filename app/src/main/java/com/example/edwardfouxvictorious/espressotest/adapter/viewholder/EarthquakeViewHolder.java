package com.example.edwardfouxvictorious.espressotest.adapter.viewholder;


import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.edwardfouxvictorious.espressotest.adapter.EarthquakeAdapter;
import com.example.edwardfouxvictorious.espressotest.model.Earthquake;
import com.example.edwardfouxvictorious.espressotest.R;


public class EarthquakeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView textView;
    private TextView magnitude;
    private TextView depth;
    private Earthquake earthquake;
    private View view;
    private EarthquakeAdapter.ItemClickListener itemClickListener;

    public EarthquakeViewHolder(View itemView) {
        super(itemView);
        view = itemView;
        textView = (TextView) itemView.findViewById(R.id.date);
        depth = (TextView) itemView.findViewById(R.id.depth);
        magnitude = (TextView) itemView.findViewById(R.id.magnitude);
    }

    public void setup(Earthquake earthquake, EarthquakeAdapter.ItemClickListener itemClickListener) {
        this.earthquake = earthquake;
        textView.setText(earthquake.getDatetime());
        depth.setText(String.valueOf(earthquake.getDepth()));
        magnitude.setText(String.valueOf(earthquake.getMagnitude()));
        this.itemClickListener = itemClickListener;
        view.setOnClickListener(this);
    }

    public void selectEQ() {
        magnitude.setTextColor(Color.RED);
    }

    public void unSelectEQ() {
        magnitude.setTextColor(Color.BLACK);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onItemCLicked(earthquake);
    }
}
