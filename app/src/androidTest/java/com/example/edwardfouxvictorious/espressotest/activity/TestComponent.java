package com.example.edwardfouxvictorious.espressotest.activity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = TestModule.class)
public interface TestComponent extends NetComponent {
    void inject(ListActivityTest test);
}
