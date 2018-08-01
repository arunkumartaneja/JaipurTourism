package com.abnd.android.jaipurtourism.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.abnd.android.jaipurtourism.R;
import com.abnd.android.jaipurtourism.fragment.HomeFragment;
import com.abnd.android.jaipurtourism.fragment.PlaceFragment;
import com.abnd.android.jaipurtourism.model.Place;
import com.abnd.android.jaipurtourism.util.Constants;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, PlaceFragment.OnListFragmentInteractionListener {

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        if (savedInstanceState == null) {
            onNavigationItemSelected(navigationView.getMenu().findItem(R.id.nav_home));
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (mFragmentManager.getBackStackEntryCount() > 0) {
            mFragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        if (id == R.id.nav_home) {
            fragment = new HomeFragment();
            Bundle args = new Bundle();
            args.putString(Constants.TITLE_KEY, item.getTitle().toString());
            args.putInt(Constants.MENU_ID_KEY, id);
            fragment.setArguments(args);
        } else if (id == R.id.nav_fort || id == R.id.nav_cultural || id == R.id.nav_historical || id == R.id.nav_palaces || id == R.id.nav_museums
                || id == R.id.nav_temples) {
            fragment = new PlaceFragment();
            Bundle args = new Bundle();
            args.putString(Constants.CATEGORY_TITLE_KEY, item.getTitle().toString());
            args.putString(Constants.CATEGORY_KEY, item.getTitleCondensed().toString());
            args.putInt(Constants.MENU_ID_KEY, id);
            fragment.setArguments(args);
            ft.addToBackStack(Constants.FRAGMENT_BACK);
        }

        if (fragment != null) {
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPlaceListFragmentInteraction(Place place) {
        Intent intent = new Intent(MainActivity.this, PlaceDetailActivity.class);
        intent.putExtra(Constants.PLACE_KEY, place);
        this.startActivity(intent);
    }
}
