package com.marvin.cararenaa;

import android.widget.TextView;

import com.marvin.cararenaa.ui.Findcars;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static junit.framework.TestCase.assertTrue;
@RunWith(RobolectricTestRunner.class)
public class FindcarsTest {
    private Findcars activity;
    @Before
    public void setup(){
        activity = Robolectric.setupActivity(Findcars.class);
    }
    @Test
    public void  ValidateTextViewContent(){
        TextView appNameTextView =  activity.findViewById(R.id.appNameTextView);
        assertTrue("E-Restaurants".equals(appNameTextView.getText().toString()));
    }
}
