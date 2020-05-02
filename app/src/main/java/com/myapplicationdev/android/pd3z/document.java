package com.myapplicationdev.android.pd3z;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class document extends AppCompatActivity {

    TextView documentinfo, documentation;
    DatabaseReference db, db2;
    String username = "";

    @Override
    //Sets the name to username
    protected void onStart() {
        super.onStart();

        db2 = FirebaseDatabase.getInstance().getReference("Account");
        db2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        username = "Juan";
documentinfo = findViewById(R.id.documentinfo);
documentation = findViewById(R.id.documentation);



                        String condition = dataSnapshot.child(username).child("Document").child("condition").getValue(String.class);
                        String hospital = dataSnapshot.child(username).child("Document").child("hospital").getValue(String.class);
                        String illness = dataSnapshot.child(username).child("Document").child("illness").getValue(String.class);
                        String lastSur = dataSnapshot.child(username).child("Document").child("lastSurgery").getValue(String.class);

                        documentinfo.setText("Date of Documentation: \n" + dataSnapshot.child("Juan").child("Document").child("DoD").getValue() + "\nHospital: \n" + hospital);
                        documentation.setText("Condition: " + condition + "\nillness: " + illness + "\nLast Sugery: " + lastSur);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);
    }
}
