package com.adam.presence;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Appel extends AppCompatActivity {
    private FirebaseAuth mAuth;
    public DatabaseReference myRef;
    public FirebaseDatabase mDatabase;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appel);

        this.mDatabase = FirebaseDatabase.getInstance();
        this.myRef = mDatabase.getReference("eleves");
        mAuth = FirebaseAuth.getInstance();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<String> eleves = new ArrayList<String>();
                ArrayAdapter<String> adapter;
                for (DataSnapshot ds : snapshot.getChildren()) {
                    Eleve e = ds.getValue(Eleve.class);
                    eleves.add(e.getFirstname() + " " + e.getLastname());
                }
                Log.d("oui", eleves.toString());
                adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, eleves);
                ListView list = findViewById(R.id.listViewAppel);
                list.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}