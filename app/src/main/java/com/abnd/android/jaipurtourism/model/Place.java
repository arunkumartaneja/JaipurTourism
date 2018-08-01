package com.abnd.android.jaipurtourism.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Place implements Serializable {

    private String title;
    private int imageResourceID;
    private List<String> categories;
    private String description;
    private String openingHours;

    public Place(String title, int imageResourceID, String description, String openingHours, String... categories) {
        this.title = title;
        this.categories = Arrays.asList(categories);
        this.imageResourceID = imageResourceID;
        this.description = description;
        this.openingHours = openingHours;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }
}
