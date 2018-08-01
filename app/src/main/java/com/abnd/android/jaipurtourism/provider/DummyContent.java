package com.abnd.android.jaipurtourism.provider;

import android.content.Context;

import com.abnd.android.jaipurtourism.R;
import com.abnd.android.jaipurtourism.model.Place;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created
 */
public class DummyContent {

    public static Map<String, List<Place>> getItemMap(Context context) {
        context.getResources().getString(R.string.app_name);
        List<Place> places = new ArrayList<>();
        places.add(new Place(context.getString(R.string.birla_mandir), R.drawable.birla_mandir, context.getString(R.string.birla_mandir_description), context.getString(R.string.birla_mandir_hours), context.getString(R.string.cultural), context.getString(R.string.historical), context.getString(R.string.tamples)));
        places.add(new Place(context.getString(R.string.nahargarh_fort), R.drawable.nahargarh_fort, context.getString(R.string.nahargarh_fort_description), context.getString(R.string.nahargarh_fort_hours), context.getString(R.string.cultural), context.getString(R.string.historical), context.getString(R.string.forts)));
        places.add(new Place(context.getString(R.string.jaigarh_fort), R.drawable.jaigarh_fort, context.getString(R.string.jaigarh_fort_description), context.getString(R.string.jaigarh_fort_hours), context.getString(R.string.cultural), context.getString(R.string.historical), context.getString(R.string.forts)));
        places.add(new Place(context.getString(R.string.amber_fort), R.drawable.amer_fort, context.getString(R.string.amber_fort_description), context.getString(R.string.amber_fort_hours), context.getString(R.string.cultural), context.getString(R.string.historical), context.getString(R.string.forts)));
        places.add(new Place(context.getString(R.string.city_palace), R.drawable.city_palace, context.getString(R.string.city_palace_description), context.getString(R.string.city_palace_hours), context.getString(R.string.cultural), context.getString(R.string.historical), context.getString(R.string.palace)));
        places.add(new Place(context.getString(R.string.jantar_mantar), R.drawable.jantar_mantar, context.getString(R.string.jantar_mantar_description), context.getString(R.string.jantar_mantar_hours), context.getString(R.string.cultural), context.getString(R.string.historical)));
        places.add(new Place(context.getString(R.string.hawa_mahal), R.drawable.hawa_mahal, context.getString(R.string.hawa_mahal_description), context.getString(R.string.hawa_mahal_hours), context.getString(R.string.cultural), context.getString(R.string.historical), context.getString(R.string.palace)));
        places.add(new Place(context.getString(R.string.jal_mahal), R.drawable.jal_mahal, context.getString(R.string.jal_mahal_description), context.getString(R.string.jal_mahal_hours), context.getString(R.string.cultural), context.getString(R.string.historical), context.getString(R.string.palace)));
        places.add(new Place(context.getString(R.string.albert_hall), R.drawable.albert_hall, context.getString(R.string.albert_hall_description), context.getString(R.string.albert_hall_hours), context.getString(R.string.cultural), context.getString(R.string.historical), context.getString(R.string.museums)));
        places.add(new Place(context.getString(R.string.rambagh_place), R.drawable.rambagh_palace, context.getString(R.string.rambhag_description), context.getString(R.string.rambagh_hours), context.getString(R.string.historical), context.getString(R.string.palace)));
        return getItemMap(places);
    }

    private static Map<String, List<Place>> getItemMap(List<Place> places) {
        Map<String, List<Place>> placeByCategory = new HashMap<>();
        List<Place> tempPlaces;
        for (Place place : places) {
            for (String category : place.getCategories()) {
                if (placeByCategory.containsKey(category)) {
                    placeByCategory.get(category).add(place);
                } else {
                    tempPlaces = new ArrayList<>();
                    tempPlaces.add(place);
                    placeByCategory.put(category, tempPlaces);
                }
            }
        }

        return placeByCategory;
    }

}
