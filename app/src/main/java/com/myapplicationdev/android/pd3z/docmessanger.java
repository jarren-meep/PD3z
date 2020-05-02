package com.myapplicationdev.android.pd3z;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class docmessanger extends AppCompatActivity {

    ScrollView s1;
    TextView t1;
    EditText e1;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docmessanger);
        String username = "Juan";
        s1 = findViewById(R.id.s1);
        t1 = findViewById(R.id.t1);
        e1 = findViewById(R.id.e1);
        String user_name = "juan";
        //ref = FirebaseDatabase.getInstance().getReference().child();

    }
}
