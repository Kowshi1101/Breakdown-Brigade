package com.example.medic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class LoginActivity extends AppCompatActivity {

    TextView txtSignUp;
    Button btnlogin;
    EditText etuser,etpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar();

        txtSignUp = findViewById(R.id.txtSignUp);

        this.btnlogin=(Button)findViewById(R.id.btnSignIn);
        this.etuser = (EditText)findViewById(R.id.edtSignInEmail);
        this.etpass = (EditText)findViewById(R.id.edtSignInPassword);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               LoginActivity lg = LoginActivity.this;
               lg.validate(lg.etuser.getText().toString(),LoginActivity.this.etpass.getText().toString());
            }
        });


        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    public void validate(String username, String password){
        boolean equals = username.equals("hank");
        //String str = BuildConfig.BUILD_TYPE;
        if (equals &&  password.equals("hank")){
            this.etuser.setText("");
            this.etpass.setText("");
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            return;
        }
        Toast.makeText(getApplicationContext(),"Login Failed", Toast.LENGTH_LONG).show();
        this.etuser.setText("");
        this.etpass.setText("");


    }
}