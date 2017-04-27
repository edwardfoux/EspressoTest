package com.example.edwardfouxvictorious.espressotest.activity;


import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.example.edwardfouxvictorious.espressotest.EspressoApplication;
import com.example.edwardfouxvictorious.espressotest.R;
import com.example.edwardfouxvictorious.espressotest.presenter.ListPresenter;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import retrofit.Retrofit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.example.edwardfouxvictorious.espressotest.activity.EntryActivity.EAST;
import static com.example.edwardfouxvictorious.espressotest.activity.EntryActivity.NORTH;
import static com.example.edwardfouxvictorious.espressotest.activity.EntryActivity.SOUTH;
import static com.example.edwardfouxvictorious.espressotest.activity.EntryActivity.WEST;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class ListActivityTest {

    @Inject
    Retrofit retrofit;

    @Rule
    public ActivityTestRule<ListActivity> mActivityTestRule = new ActivityTestRule<>(ListActivity.class, true, false);

    @Before
    public void setup() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        EspressoApplication application
                = (EspressoApplication) instrumentation.getTargetContext().getApplicationContext();

        TestNetComponent component = DaggerTestNetComponent.builder().testNetModule(new TestNetModule(ListPresenter.URL)).build();
        application.setComponent(component);
        component.inject(this);
    }
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
        
        ViewInteraction textView = onView(
                allOf(withId(R.id.magnitude), withText("8.8"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                2),
                        isDisplayed()));
        textView.check(matches(withText("8.8")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
