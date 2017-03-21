package com.example.edwardfouxvictorious.espressotest.activity;

import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.edwardfouxvictorious.espressotest.R;
import com.example.edwardfouxvictorious.espressotest.model.Earthquake;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class DetailActivityTest {
    @Rule
    public ActivityTestRule<DetailActivity> mActivityTestRule = new ActivityTestRule<>(DetailActivity.class, false, false);

    @Test
    public void detailActivityTest() {

        Intent intent = new Intent();
        Earthquake earthquake = new Earthquake("24-03-2010", 10, 6.0);
        intent.putExtra(ListActivity.EARTHQUAKE, earthquake);
        mActivityTestRule.launchActivity(intent);

        Espresso.onView(withId(R.id.date))
                .check(matches(withText("24-03-2010")));
    }
}
