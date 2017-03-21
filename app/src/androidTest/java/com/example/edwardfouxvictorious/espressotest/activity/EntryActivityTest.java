package com.example.edwardfouxvictorious.espressotest.activity;


import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.edwardfouxvictorious.espressotest.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class EntryActivityTest {

    @Rule
    public ActivityTestRule<EntryActivity> mActivityTestRule = new ActivityTestRule<>(EntryActivity.class);

    @Test
    public void editText1Test() {

        Espresso.onView(withId(R.id.edittext1))
        .perform(clearText(), typeText("-24.5"));

        Espresso.onView(withId(R.id.edittext1))
                .check(matches(withText("-24.5")));
    }

    @Test
    public void editText1Test2() {

        Espresso.onView(withId(R.id.edittext2))
                .perform(clearText(), typeText("-9.9"));

        Espresso.onView(withId(R.id.edittext2))
                .check(matches(withText("-9.9")));
    }

    @Test
    public void editText1Test3() {

        Espresso.onView(withId(R.id.edittext3))
                .perform(clearText(), typeText("24.5"));

        Espresso.onView(withId(R.id.edittext3))
                .check(matches(withText("24.5")));
    }

    @Test
    public void editText1Test4() {

        Espresso.onView(withId(R.id.edittext4))
                .perform(clearText(), typeText("-24.5"));

        Espresso.onView(withId(R.id.edittext4))
                .check(matches(withText("-24.5")));
    }

    @Test
    public void buttonClickTest() {

        Espresso.onView(withId(R.id.button))
                .perform(click());
    }
}
