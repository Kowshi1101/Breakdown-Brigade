package com.example.medic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText n,e,m,p,cp;
    Button b;
    dbhelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
         this.mydb=new dbhelper(this);
        this.n =(EditText) findViewById(R.id.edtSignUpFullName);
        this.e =(EditText) findViewById(R.id.edtSignUpEmail);
        this.m =(EditText) findViewById(R.id.edtSignUpMobile);
        this.p =(EditText) findViewById(R.id.edtSignUpPassword);
        //this.cp =(EditText) findViewById(R.id.edtSignUpConfirmPassword);
        this.b =(Button) findViewById(R.id.btnSignUp);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sname = SignUpActivity.this.n.getText().toString();
                String semail = SignUpActivity.this.e.getText().toString();
                String smobno = SignUpActivity.this.m.getText().toString();
                String spass = SignUpActivity.this.p.getText().toString();
                if(TextUtils.isEmpty(sname)){
                    Toast.makeText(SignUpActivity.this.getApplicationContext(),"please enter name", Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(semail)){
                    Toast.makeText(SignUpActivity.this.getApplicationContext(),"please enter email", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(smobno)){
                    Toast.makeText(SignUpActivity.this.getApplicationContext(),"please enter mobno", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(spass)){
                    Toast.makeText(SignUpActivity.this.getApplicationContext(),"please enter pass", Toast.LENGTH_SHORT).show();
                }else{

                     if (SignUpActivity.this.mydb.insert(sname,semail,smobno,spass)) {
                        Toast.makeText(SignUpActivity.this.getApplicationContext(), "data inserted", Toast.LENGTH_SHORT).show();

                    }

                    else{
                        Toast.makeText(SignUpActivity.this.getApplicationContext(),"Not inserted", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}