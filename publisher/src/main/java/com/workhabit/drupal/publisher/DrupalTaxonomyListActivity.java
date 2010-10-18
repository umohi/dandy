package com.workhabit.drupal.publisher;

import android.app.ListActivity;
import android.os.Bundle;
import com.google.inject.Inject;
import com.workhabit.drupal.R;
import com.workhabit.drupal.entity.DrupalTaxonomyTerm;
import com.workhabit.drupal.site.DrupalFetchException;
import com.workhabit.drupal.site.DrupalSiteContext;

import java.util.ArrayList;

/**
 * Copyright 2009 - WorkHabit, Inc. - acs
 * Date: Oct 16, 2010, 3:55:47 PM
 */
public class DrupalTaxonomyListActivity extends ListActivity {
    @Inject
    private DrupalSiteContext drupalSiteContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            ArrayList<DrupalTaxonomyTerm> terms = (ArrayList<DrupalTaxonomyTerm>) drupalSiteContext.getTermView("andrupal_categories");
            this.setListAdapter(new DrupalTaxonomyAdapter(this, R.layout.row, terms));
            
        } catch (DrupalFetchException e) {
            DrupalDialogHandler.showMessageDialog(this, e.getMessage());
        }

    }
}