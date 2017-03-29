package com.example.edwardfouxvictorious.espressotest.activity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = TestNetModule.class)
public interface TestNetComponent extends NetComponent {
    void inject(ListActivityTest test);
}
