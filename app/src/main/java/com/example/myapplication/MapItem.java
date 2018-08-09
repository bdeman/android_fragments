package com.example.myapplication;

import org.osmdroid.api.IGeoPoint;

public class MapItem {

    private String mTitle;
    private String mDescription;
    private String mPicture;
    private IGeoPoint mLocation;

    public MapItem(String title, String desc, String pic, IGeoPoint loc) {
        this.mTitle = title;
        this.mDescription = desc;
        this.mPicture = pic;
        this.mLocation = loc;
    }


    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmPicture() {
        return mPicture;
    }

    public void setmPicture(String mPicture) {
        this.mPicture = mPicture;
    }


    public IGeoPoint getmLocation() {
        return mLocation;
    }

    public void setmLocation(IGeoPoint mLocation) {
        this.mLocation = mLocation;
    }
}
