package com.example.edwardfouxvictorious.espressotest.activity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(ListActivity listActivity);
}
