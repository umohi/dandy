package com.workhabit.drupal.publisher;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import org.workhabit.drupal.api.entity.DrupalNode;
import org.workhabit.drupal.api.site.DrupalFetchException;
import org.workhabit.drupal.api.site.DrupalSiteContext;

/**
 * Copyright 2009 - WorkHabit, Inc. - acs
 * Date: Sep 25, 2010, 7:39:37 PM
 */
public class DrupalNodeActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DrupalSiteContext drupalSiteContext = AnDrupalApplication.getDrupalSiteContext();
        int nid = getIntent().getExtras().getInt("nid");

        setContentView(R.layout.node);
        try {
            DrupalNode node = drupalSiteContext.getNode(nid);
            TextView titleView = (TextView) findViewById(R.id.nodeTitle);
            TextView bodyView = (TextView) findViewById(R.id.nodeBody);
            titleView.setText(node.getTitle());
            bodyView.setText(Html.fromHtml("<p>" + node.getBody().replaceAll("\r\n", "\n").replaceAll("\n\n", "</p><p>") + "</p>"));
        } catch (DrupalFetchException e) {
            DrupalDialogHandler.showMessageDialog(this, e.getMessage());
        }

    }
}