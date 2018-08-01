package com.abnd.android.jaipurtourism.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abnd.android.jaipurtourism.R;
import com.abnd.android.jaipurtourism.util.Constants;

public class HomeFragment extends Fragment {

    private String mTitle;
    private int menuId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mTitle = getArguments().getString(Constants.TITLE_KEY);
            menuId = getArguments().getInt(Constants.MENU_ID_KEY);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setTitle(mTitle);
            }
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        // Set title
        FragmentActivity activity = getActivity();
        if (activity != null) {
            NavigationView navigationView = activity.findViewById(R.id.nav_view);
            navigationView.setCheckedItem(menuId);
            activity.setTitle(mTitle);
        }
    }

}
