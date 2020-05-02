package com.myapplicationdev.android.pd3z;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class MainMenu extends AppCompatActivity implements Dialog.DialogListener {

    Button updateBtn;
    DatabaseReference db;
    TextView name;
    ImageView doctorPress, newsPress, documentPress, infoPress;
    Intent intent = getIntent();
    String username = intent.getStringExtra("Username");

    @Override
    //Sets the name to username
    protected void onStart() {
        super.onStart();

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    db = FirebaseDatabase.getInstance().getReference("Account");
                    name = findViewById(R.id.name);
                    name.setText(dataSnapshot.child(username).child("Username").getValue().toString() + "?");

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        updateBtn = findViewById(R.id.updateBtn);
        doctorPress = findViewById(R.id.doctorPress);
        documentPress = findViewById(R.id.documentPress);

        db = FirebaseDatabase.getInstance().getReference("Account");

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUpdate();
            }
        });
        doctorPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), docmessanger.class);

                startActivity(intent);
            }
        });
        documentPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), document.class);
                startActivity(intent);
            }
        });



    }

    private void openUpdate() {
        Dialog dialog = new Dialog();
        dialog.show(getSupportFragmentManager(), "Dialog");
    }

    @Override
    public void update(String updateText) {
        db.child(username).child("Status").setValue(updateText);
    }
}
