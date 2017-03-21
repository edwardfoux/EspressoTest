package com.example.edwardfouxvictorious.espressotest.activity;


import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.edwardfouxvictorious.espressotest.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static com.example.edwardfouxvictorious.espressotest.activity.EntryActivity.EAST;
import static com.example.edwardfouxvictorious.espressotest.activity.EntryActivity.NORTH;
import static com.example.edwardfouxvictorious.espressotest.activity.EntryActivity.SOUTH;
import static com.example.edwardfouxvictorious.espressotest.activity.EntryActivity.WEST;

@RunWith(AndroidJUnit4.class)
public class ListActivityTest {

    @Rule
    public ActivityTestRule<ListActivity> mActivityTestRule = new ActivityTestRule<>(ListActivity.class, false, false);

    @Test
    public void listActivityTest() {

        Intent intent = new Intent();
        intent.putExtra(SOUTH, "-9.9");
        intent.putExtra(EAST, "24.2");
        intent.putExtra(WEST, "66.4");
        intent.putExtra(NORTH, "-1");

        mActivityTestRule.launchActivity(intent);

        Espresso.onView(ViewMatchers.withId(R.id.recycler_view)).perform(swipeUp());
        Espresso.onView(ViewMatchers.withId(R.id.recycler_view)).perform(swipeDown());

    }
}
