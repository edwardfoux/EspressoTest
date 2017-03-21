package com.example.edwardfouxvictorious.espressotest.adapter;

import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.edwardfouxvictorious.espressotest.model.Earthquake;
import com.example.edwardfouxvictorious.espressotest.R;
import com.example.edwardfouxvictorious.espressotest.adapter.viewholder.EarthquakeViewHolder;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeAdapter extends RecyclerView.Adapter<EarthquakeViewHolder> {

    private List<Earthquake> list = new ArrayList<>();
    private static final double MIN_MAGNITUDE = 8.0;
    ItemClickListener itemClickListener;

    public EarthquakeAdapter(List<Earthquake> list, ItemClickListener itemClickListener) {
        this.list = list;
        this.itemClickListener = itemClickListener;
    }

    @Override
    public EarthquakeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.earhquake_item, null);
        return new EarthquakeViewHolder(view);
    }

    @Override
    @VisibleForTesting
    public void onBindViewHolder(EarthquakeViewHolder holder, int position) {
        Earthquake earthquake = list.get(position);
        holder.setup(earthquake, itemClickListener);
        if (Double.compare(earthquake.getMagnitude(), MIN_MAGNITUDE) > 0) {
            holder.selectEQ();
        } else {
            holder.unSelectEQ();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface ItemClickListener {
        void onItemCLicked(Earthquake earthquake);
    }
}
