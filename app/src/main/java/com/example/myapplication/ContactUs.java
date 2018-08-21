package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContactUs extends Fragment {

    private TextView linkedIn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        container.clearDisappearingChildren();
        getActivity().setTitle(R.string.contact_us);

        return inflater.inflate(R.layout.contact_us_page, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        linkedIn = getActivity().findViewById(R.id.linkedIn);
        linkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent linkedIntent = new Intent(Intent.ACTION_VIEW);
                linkedIntent.setData(Uri.parse(linkedIn.getText().toString()));
                getActivity().startActivity(linkedIntent);
            }
        });
    }

}
