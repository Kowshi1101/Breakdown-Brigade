package com.example.medic;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class payment extends AppCompatActivity {

    Button btPay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btPay = findViewById(R.id.bt_pay);

        string sAmount="100";
        int amount = Math.round(Float.parseFloat(sAmount) * 100);

        btPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox checkBox = new CheckBox();

            }
        });
    }
}