package news.roadster.com.newsapp.activity;

import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import news.roadster.com.newsapp.util.NewsUtil;

@RunWith(android.support.test.runner.AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class, true, true);

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void checkInternetWorkingOrNot() {
        MainActivity activity = activityActivityTestRule.getActivity();
        Assert.assertFalse("Connected with internet",NewsUtil.isOnline(activity));
    }
}