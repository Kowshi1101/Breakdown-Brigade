package com.example.medic;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;

public class distance_pay extends AppCompatActivity {
TextView display,displaypay;
    private GoogleMap mMap;
    LatLng ylocation = new LatLng(11.024545, 77.003855);
    Double distance,distancepay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance_pay);
        display=findViewById(R.id.textView12);
        displaypay=findViewById(R.id.textView16);
        Bundle bundle = getIntent().getParcelableExtra("bundle");
        LatLng fromPosition = bundle.getParcelable("from_position");


        distance = SphericalUtil.computeDistanceBetween(fromPosition,ylocation);
        distance=distance/1000 + 1.5;
        display.setText(String.format("%.2f", distance)+"Km");

        distancepay=distance*100;
        displaypay.setText(String.format("%.2f", distancepay)+"Rs");


    }
}