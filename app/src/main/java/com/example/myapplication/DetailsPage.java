package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class DetailsPage extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View detailsView = inflater.inflate(R.layout.details_page, container, false);

        String propertyName = getArguments().getString(MapWithLocations.DETAILS_PROPERTY_NAME);
        String description = getArguments().getString(MapWithLocations.DETAILS_PROPERTY_DESC);
        String imageURL = getArguments().getString(MapWithLocations.DETAILS_PROPERTY_PIC);

        TextView propertyNameTextView = detailsView.findViewById(R.id.textView2);
        propertyNameTextView.setText(propertyName);

        TextView propertyDescriptionTextView = detailsView.findViewById(R.id.textView3);
        propertyDescriptionTextView.setText(description);

        ImageView imageviewTest = detailsView.findViewById(R.id.imageView2);
        Picasso.get().load(imageURL).into(imageviewTest);

        return detailsView;
    }

}
