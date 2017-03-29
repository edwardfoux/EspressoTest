package com.example.edwardfouxvictorious.espressotest;

import android.app.Application;

import com.example.edwardfouxvictorious.espressotest.activity.AppModule;
import com.example.edwardfouxvictorious.espressotest.activity.DaggerNetComponent;
import com.example.edwardfouxvictorious.espressotest.activity.NetComponent;
import com.example.edwardfouxvictorious.espressotest.activity.NetModule;
import com.example.edwardfouxvictorious.espressotest.presenter.ListPresenter;

public class EspressoApplication extends Application {
    private NetComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(ListPresenter.URL))
                .build();
    }

    public NetComponent getNetComponent() {
        return component;
    }

    public void setComponent(NetComponent component) {
        this.component = component;
    }
}
