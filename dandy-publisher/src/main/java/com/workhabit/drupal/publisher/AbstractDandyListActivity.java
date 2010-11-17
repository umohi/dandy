package com.workhabit.drupal.publisher;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.workhabit.drupal.publisher.support.BottomNavClickHandler;

/**
 * Copyright 2009 - WorkHabit, Inc. - acs
 * Date: 11/3/10, 8:32 PM
 */
public abstract class AbstractDandyListActivity extends ListActivity {
    public void bottomNavOnClick(View v) {
        BottomNavClickHandler.bottomNavOnClick(v, this);
    }
}
