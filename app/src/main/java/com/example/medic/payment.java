package com.example.medic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class payment extends AppCompatActivity implements PaymentResultListener {
    Button btPay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        btPay = findViewById(R.id.bt_pay);
        String sAmount="001";
        int amount= Math.round(Float.parseFloat(sAmount)*400);
        btPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Checkout checkout=new Checkout();
                checkout.setKeyID("rzp_test_PuWsKZ79BPFMdG");
                checkout.setImage(R.drawable.rzp_logo);
                JSONObject object=new JSONObject();
                try {
                    object.put("name","dheenu");
                    object.put("description","Test Payment");
                    object.put("theme.color","0093DD");
                    object.put("currency","INR");
                    object.put("amount",amount);
                    object.put("prefill.contact","9095353249");
                    object.put("prefill.email","dineshkanna.s00@gmail.com");
                    checkout.open(payment.this,object);
                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        });
    }

    @Override
    public void onPaymentSuccess(String s) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Payment ID");
        builder.setMessage(s);
        builder.show();

    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(getApplicationContext()
                ,s,Toast.LENGTH_SHORT).show();

    }
}