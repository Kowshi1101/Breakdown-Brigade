package com.example.medic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class location extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;
        LatLng singanallur = new LatLng(11.008983115172937, 77.02685009180507);
        map.addMarker(new MarkerOptions().position(singanallur).title("singanallur"));
        map.moveCamera(CameraUpdateFactory.newLatLng(singanallur));

        LatLng ukkadam = new LatLng(10.988946401231235, 76.96171641630066);
        map.addMarker(new MarkerOptions().position(ukkadam).title("ukkadam"));
        map.moveCamera(CameraUpdateFactory.newLatLng(ukkadam));

        LatLng gandipuram = new LatLng(11.016949898436833, 76.96810499421721);
        map.addMarker(new MarkerOptions().position(gandipuram).title("gandipuram"));
        map.moveCamera(CameraUpdateFactory.newLatLng(gandipuram));

        LatLng yourlocation = new LatLng(11.024600006402965, 77.00274947956885);
        MarkerOptions options = new MarkerOptions().position(yourlocation).title("I am there").icon(bitmapDescriptor(getApplicationContext()
        ,R.drawable.ic_baseline_accessibility_new_24));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(yourlocation,10));
        map.addMarker(options);

        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                LatLng markerlocation = marker.getPosition();

                Intent intent = new Intent(location.this, distance_pay.class);
                Bundle args = new Bundle();
                args.putParcelable("from_position", markerlocation);
                intent.putExtra("bundle", args);
//                intent.putExtra("key",markerlocation);
                startActivity(intent);

                return false;
            }
        });
    }
    private BitmapDescriptor bitmapDescriptor(Context context, int vectorResId){
        Drawable vectorDrawable= ContextCompat.getDrawable(context,vectorResId);
        vectorDrawable.setBounds(0,0,vectorDrawable.getIntrinsicWidth(),vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap=Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),vectorDrawable.getIntrinsicHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}