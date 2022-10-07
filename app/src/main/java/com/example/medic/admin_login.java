package com.example.medic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class admin_login extends AppCompatActivity {
    TextView txtSignUp;
    Button btnlogin;
    EditText etuser,etpass;
    ProgressDialog progressDialog ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        txtSignUp = findViewById(R.id.txtSignUp);

        this.btnlogin=(Button)findViewById(R.id.btnSignIn);
        this.etuser = (EditText)findViewById(R.id.edtSignInEmail);
        this.etpass = (EditText)findViewById(R.id.edtSignInPassword);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etuser.getText().toString();
                String password = etpass.getText().toString();
                if(!email.equals("admin")) {
                    etuser.setError("Enter Correct username");
                }else if (password.isEmpty() || password.length() < 5) {
                    etpass.setError("Enter Proper Password ");
                }else if(!password.equals("12345")){
                    etpass.setError("Enter Correct Password ");
                }else{
                    progressDialog.setMessage(" Please Wait While Login ... ");
                    progressDialog.setTitle(" Logging in ");
                    Intent intent = new Intent(admin_login.this,adminhomepage.class);
                    startActivity(intent);
                }
            }
        });





    }
}