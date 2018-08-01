package com.abnd.android.jaipurtourism.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abnd.android.jaipurtourism.R;
import com.abnd.android.jaipurtourism.adapter.MyPlaceRecyclerViewAdapter;
import com.abnd.android.jaipurtourism.model.Place;
import com.abnd.android.jaipurtourism.provider.DummyContent;
import com.abnd.android.jaipurtourism.util.Constants;


public class PlaceFragment extends Fragment {

    private OnListFragmentInteractionListener mListener;
    private String mCategoryKey;
    private String mCategoryTitle;
    private int menuId;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PlaceFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mCategoryTitle = getArguments().getString(Constants.CATEGORY_TITLE_KEY);
            mCategoryKey = getArguments().getString(Constants.CATEGORY_KEY);
            menuId = getArguments().getInt(Constants.MENU_ID_KEY);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setTitle(mCategoryTitle);
            }
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_place_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
            recyclerView.setAdapter(new MyPlaceRecyclerViewAdapter(DummyContent.getItemMap(getContext()).get(mCategoryKey), mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Set title
        FragmentActivity activity = getActivity();
        if (activity != null) {
            NavigationView navigationView = activity.findViewById(R.id.nav_view);
            navigationView.setCheckedItem(menuId);
            activity.setTitle(mCategoryTitle);
        }
    }


    public interface OnListFragmentInteractionListener {
        void onPlaceListFragmentInteraction(Place item);
    }
}
