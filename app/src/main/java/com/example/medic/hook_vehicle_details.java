package com.example.medic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class hook_vehicle_details extends AppCompatActivity {
Button button4,button7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hook_vehicle_details);
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hook_vehicle_details.this,location.class);
                startActivity(intent);
            }
        });
//        button7 = findViewById(R.id.button7);
//        button7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(hook_vehicle_details.this,payment.class);
//                startActivity(intent);
//              finish();
//            }
//        });
    }
}