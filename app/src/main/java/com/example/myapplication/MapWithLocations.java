package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;

public class MapWithLocations extends Fragment {

    MapView map = null;

    public ArrayList<MapItem> mapItems = new ArrayList<MapItem>();


    public static final String DETAILS_PROPERTY_NAME = "com.example.myapplication.MapWithLocations_DETAILS_PROPERTY_NAME";
    public static final String DETAILS_PROPERTY_DESC = "com.example.myapplication.MapWithLocations_DETAILS_PROPERTY_DESC";
    public static final String DETAILS_PROPERTY_PIC = "com.example.myapplication.MapWithLocations_DETAILS_PROPERTY_PIC";

/*
    public static MapWithLocations newInstance() {
        return new MapWithLocations();
    }*/
/*

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
*/


    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        View mapView = inflater.inflate(R.layout.map_with_locations, container, false);

        map = (MapView) mapView.findViewById(R.id.map);


        Context ctx = getContext();
        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));

        //map = new MapView(ctx);
        map.setTileSource(TileSourceFactory.MAPNIK);

        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);

        IMapController mapController = map.getController();
        mapController.setZoom(10.0);
        GeoPoint startPoint = new GeoPoint(52.3702, 4.8952);
        mapController.setCenter(startPoint);

        genLocationsForMap(mapItems);

        ArrayList<OverlayItem> items = new ArrayList<OverlayItem>();
        for(MapItem item: mapItems) {
            items.add(new OverlayItem(item.getmTitle(), item.getmDescription(),item.getmLocation() ));
        }

        ItemizedOverlayWithFocus<OverlayItem> mOverlay = new ItemizedOverlayWithFocus<OverlayItem>(getActivity(),items,
                new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
                    @Override
                    public boolean onItemSingleTapUp(final int index, final OverlayItem item) {
                        return false;
                    }
                    @Override
                    public boolean onItemLongPress(final int index, final OverlayItem item) {
                        System.out.println("TWICE");
                        Intent intent = new Intent(getActivity(), DetailsPage.class);
                        intent.putExtra(DETAILS_PROPERTY_NAME, item.getTitle());
                        intent.putExtra(DETAILS_PROPERTY_DESC, item.getSnippet());
                        intent.putExtra(DETAILS_PROPERTY_PIC, mapItems.get(index).getmPicture());
                        System.out.println("HOI + "+ mapItems.get(index).getmPicture());
                        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        return false;
                    }
                });
        mOverlay.setFocusItemsOnTap(true);

        map.getOverlays().add(mOverlay);


        return mapView;


    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout mapView = (LinearLayout) inflater.inflate(R.layout.map_with_locations, container, false);

        map = (MapView) mapView.findViewById(R.id.map);

        Context ctx = getContext();
        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));

        map.setTileSource(TileSourceFactory.MAPNIK);

        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);

        IMapController mapController = map.getController();
        mapController.setZoom(10.0);
        GeoPoint startPoint = new GeoPoint(52.3702, 4.8952);
        mapController.setCenter(startPoint);

        genLocationsForMap(mapItems);

        ArrayList<OverlayItem> items = new ArrayList<OverlayItem>();
        for(MapItem item: mapItems) {
            items.add(new OverlayItem(item.getmTitle(), item.getmDescription(),item.getmLocation() ));
        }

        ItemizedOverlayWithFocus<OverlayItem> mOverlay = new ItemizedOverlayWithFocus<OverlayItem>(getActivity(),items,
                new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
                    @Override
                    public boolean onItemSingleTapUp(final int index, final OverlayItem item) {
                        return false;
                    }
                    @Override
                    public boolean onItemLongPress(final int index, final OverlayItem item) {
                        DetailsPage detailsFrag = new DetailsPage();
                        Bundle arguments = new Bundle();
                        arguments.putString(DETAILS_PROPERTY_NAME, item.getTitle());
                        arguments.putString(DETAILS_PROPERTY_DESC, item.getSnippet());
                        arguments.putString(DETAILS_PROPERTY_PIC, mapItems.get(index).getmPicture());
                        detailsFrag.setArguments(arguments);

                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.fContent, detailsFrag).commit();
                        getActivity().setTitle(item.getTitle());
                        return false;
                    }
                });

        mOverlay.setFocusItemsOnTap(true);
        map.getOverlays().add(mOverlay);

        return mapView;
    }

    public void onResume() {
        super.onResume();
        map.onResume();
    }

    public void onPause(){
        super.onPause();
        map.onPause();
    }

    //popuplate the list of mapitems, simulating a database.
    public void genLocationsForMap(ArrayList mapItems) {
        mapItems.add(new MapItem("SpecialChoc", "Voor de kenners","https://www.culy.nl/wp-content/uploads/2013/10/8344580158_a39f617225_b-694x400.jpg",new GeoPoint(52.260817, 5.044965)));
        mapItems.add(new MapItem("Chocs R us", "Steeds verassend","https://c1.staticflickr.com/6/5058/5537492450_5c1e01a8d6_b.jpg",new GeoPoint(52.276158, 5.160706)));
        mapItems.add(new MapItem("Warme drank", "Erg lekkere chocolade","https://bakingmischief.com/wp-content/uploads/2017/04/chocolate-milk-for-one-photo.jpg",new GeoPoint(52.156535, 5.386441)));
        mapItems.add(new MapItem("Hema", "Goedkoop en redelijk","https://gratis247.nl/wp-content/uploads/2017/11/sint-4.jpg",new GeoPoint(52.374782, 4.893992)));
    }
}