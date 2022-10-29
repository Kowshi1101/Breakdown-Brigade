package com.example.medic;

import static com.example.medic.R.layout.activity_main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.medic.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    //
    ImageView image_flat,image_hook,image_lift;
//    Button search1;
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());

       setContentView(binding.getRoot());

       this.image_lift=(ImageView)findViewById(R.id.imageView2);
       this.image_flat=(ImageView)findViewById(R.id.imageView7);
       this.image_hook=(ImageView) findViewById(R.id.imageView8);
       //this.search1=(Button)findViewById(R.id.nav_search);
        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            switch ((item.getItemId())){
                case R.id.nav_home:
                    Intent intent = new Intent(MainActivity.this,MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    break;
                case R.id.nav_search:
                    Intent intents = new Intent(MainActivity.this,location.class);
                    intents.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intents);
                    break;
                case R.id.nav_profile:
                    Intent intentp = new Intent(MainActivity.this,user_profile.class);
                    intentp.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intentp);
                    break;
            }
            return  true;
        });

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