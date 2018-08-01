package com.abnd.android.jaipurtourism.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.abnd.android.jaipurtourism.R;
import com.abnd.android.jaipurtourism.model.Place;
import com.abnd.android.jaipurtourism.util.Constants;

public class PlaceDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        Toolbar toolbar = findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        if (intent != null) {
            Place place = (Place) intent.getSerializableExtra(Constants.PLACE_KEY);
            CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.toolbar_layout);
            collapsingToolbarLayout.setBackgroundResource(place.getImageResourceID());
            collapsingToolbarLayout.setTitle(place.getTitle());
            ((TextView) findViewById(R.id.place_desc)).setText(place.getDescription());
            ((TextView) findViewById(R.id.place_hours)).setText(place.getOpeningHours());
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
