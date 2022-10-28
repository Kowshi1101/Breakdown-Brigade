package com.example.medic;

import static com.example.medic.R.layout.activity_main;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    //
    ImageView image_flat,image_hook,image_lift;
//    Button search1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(activity_main);

       this.image_lift=(ImageView)findViewById(R.id.imageView2);
       this.image_flat=(ImageView)findViewById(R.id.imageView7);
       this.image_hook=(ImageView) findViewById(R.id.imageView8);
       //this.search1=(Button)findViewById(R.id.nav_search);


       image_lift.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(MainActivity.this,lift_vehicle_details.class);
               startActivity(intent);
               finish();

           }
       });

       image_flat.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(MainActivity.this, flat_vehicle_details.class);
               startActivity(intent);
               finish();

           }
       });
       image_hook.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent= new Intent(MainActivity.this, hook_vehicle_details.class);
               startActivity(intent);
               finish();
           }
       });

//      search1.setOnClickListener(new View.OnClickListener() {
//           @Override
//          public void onClick(View view) {
//               Intent intent = new Intent( MainActivity.this , gap.class);
//               startActivity(intent);
//               finish();
//           }
//       });





    }
}