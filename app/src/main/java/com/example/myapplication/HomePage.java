package com.example.myapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomePage extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        container.clearDisappearingChildren();
        getActivity().setTitle(R.string.home_page);
        return inflater.inflate(R.layout.home_page, container, false);
    }
}
