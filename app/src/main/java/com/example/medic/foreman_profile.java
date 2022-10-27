package com.example.medic;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.core.AsyncEventListener;

public class foreman_profile extends AppCompatActivity {
TextView n,e,p;
FirebaseAuth fAuth;
FirebaseFirestore fstore;
String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreman_profile);
        n=findViewById(R.id.name);
        e=findViewById(R.id.email);
        p=findViewById(R.id.phone);
        fAuth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        userid=fAuth.getCurrentUser().getUid();
        DocumentReference documentReference=fstore.collection("foreman").document(userid);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                p.setText(value.getString("phone"));
                e.setText(value.getString("email"));
                n.setText(value.getString("name"));

            }
        });
    }
}