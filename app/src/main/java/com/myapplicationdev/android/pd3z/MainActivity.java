package com.myapplicationdev.android.pd3z;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText idText,psText;
    Button loginBtn;
    DatabaseReference db;
    ArrayList<String> loginfo1 = new ArrayList<>();
    ArrayList<String> loginfo2 = new ArrayList<>();
    ArrayList<String> loginfo3 = new ArrayList<>();


    @Override
    protected void onStart() {
        super.onStart();

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataStore: dataSnapshot.getChildren()) {
                    loginfo1.add(dataStore.child("Email").getValue(String.class));
                    loginfo2.add(dataStore.child("Password").getValue(String.class));
                    loginfo3.add(dataStore.child("Username").getValue(String.class));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idText = findViewById(R.id.idText);
        psText = findViewById(R.id.psText);

        loginBtn = findViewById(R.id.loginBtn);


        db = FirebaseDatabase.getInstance().getReference("Account");
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //login process
                String aPass = idText.getText().toString();
                String bPass = psText.getText().toString();
                login(aPass, bPass);
            }
        });
    }

    public void login(String idText, String psText) {
        for (int i = 0; i < loginfo1.size(); i++) {
            if  (loginfo1.get(i).equals(idText) && loginfo2.get(i).equals(psText)) {
                Intent intent = new Intent(getBaseContext(), MainMenu.class);



                intent.putExtra("Username",  String.valueOf(loginfo3.get(i)));


                startActivity(intent);
            } else {

            }
        }
    }
}
