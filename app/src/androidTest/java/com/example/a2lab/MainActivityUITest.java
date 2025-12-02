package com.example.a2lab;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testUIElementsExist() {
        // Tikrina ar visi elementai atsiranda
        onView(withId(R.id.edUserInput)).check(matches(isDisplayed()));
        onView(withId(R.id.spSelectionOptions)).check(matches(isDisplayed()));
        onView(withId(R.id.btnCount)).check(matches(isDisplayed()));
        onView(withId(R.id.tvCountResult)).check(matches(isDisplayed()));
    }

    @Test
    public void testCountWords() {
        // Iveda zodzius
        onView(withId(R.id.edUserInput)).perform(typeText("Hello World"));

        // Spausk mygtuka
        onView(withId(R.id.btnCount)).perform(click());

        // Tikrina rezultata
        onView(withId(R.id.tvCountResult)).check(matches(isDisplayed()));
    }

    @Test
    public void testEmptyInput() {
        // Neivedus teksto spaudzia mygtuka
        onView(withId(R.id.btnCount)).perform(click());

        // Tikrina ar programa necrashino
        onView(withId(R.id.edUserInput)).check(matches(isDisplayed()));
    }

    @Test
    public void testSimpleSentence() {
        // Iveda sakini
        onView(withId(R.id.edUserInput)).perform(typeText("Labas."));

        // Spaudzia mygtuka
        onView(withId(R.id.btnCount)).perform(click());

        // Tikrinu ar rezultatas nera tuscias
        onView(withId(R.id.tvCountResult)).check(matches(isDisplayed()));
    }

    @Test
    public void testMultipleWords() {
        // Iveda keleta zodziu
        onView(withId(R.id.edUserInput)).perform(typeText("Vienas du trys keturi"));

        // Spaudzia mygtuka
        onView(withId(R.id.btnCount)).perform(click());

        // Tikrina ar rezultatas nera tuscias
        onView(withId(R.id.tvCountResult)).check(matches(isDisplayed()));
    }
}