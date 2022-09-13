package com.example.medic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homepage extends AppCompatActivity {

    Button btn_user,btn_foreman, btn_admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        this.btn_user=(Button)findViewById(R.id.button3);
        this.btn_foreman=(Button)findViewById(R.id.button2);


        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homepage.this, user_login.class);
                startActivity(intent);
                finish();
            }
        });
        btn_foreman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homepage.this, foreman_login.class);
                startActivity(intent);
                finish();
            }
        });
//        btn_admin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(homepage.this, admin_login.class);
//                startActivity(intent);
//                finish();
//            }
//        });
    }
}