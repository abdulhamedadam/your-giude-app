package com.example.cityguide.HelperClasses.HomeAdapter;

import android.graphics.drawable.Drawable;

public class CategoriesHelperclass {

    int image,background;
    String title;



    public CategoriesHelperclass(int image, String title, int background) {
        this.image = image;
        this.title = title;
        this.background = background;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }
}