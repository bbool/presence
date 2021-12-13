package com.adam.presence;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

@SuppressWarnings("ALL")
public class SignInActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    public DatabaseReference myRef;
    public FirebaseDatabase mDatabase;
    private Utilisateur utilisateur = new Utilisateur();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        this.mDatabase = FirebaseDatabase.getInstance();

        this.myRef = mDatabase.getReference("utilisateurs");

        mAuth = FirebaseAuth.getInstance();
        TextView btn = (TextView)findViewById(R.id.activity_main_link_connexion);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent appel = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(appel);
            }
        });

        Button connexion = findViewById(R.id.buttonInscription);
        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inscription();
            }
        });

    }

    protected void inscription ()
    {
        EditText nameView = findViewById(R.id. nomInscription);
        String nom = nameView.getText().toString();

        EditText firstnameView = findViewById(R.id. prenomInscription);
        String prenom = firstnameView.getText().toString();

        EditText emailView = findViewById(R.id. mailInscription);
        String email = emailView.getText().toString();

        EditText passwordView = findViewById(R.id. mdpInscription);
        String password = passwordView.getText().toString();

        EditText passwordVerifView = findViewById(R.id. mdpVerifInscription);
        String passwordVerif = passwordVerifView.getText().toString();

        if (password.equals(passwordVerif)) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                updateUI(user);

                                writeNewUser(user.getUid(), prenom, nom, email);

                                Intent appel = new Intent(SignInActivity.this, accueil.class);
                                startActivity(appel);
                            } else {
                                Toast.makeText(SignInActivity.this, "creation failed in firebase.", Toast.LENGTH_SHORT).show();
                                updateUI(null);
                            }
                        }
                    });
        } else {
            Toast.makeText(SignInActivity.this, "les deux mot de passe ne sont pas identique.", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateUI(FirebaseUser user) {
    }

    public void writeNewUser(String userId, String name, String lastname, String mail) {
        Utilisateur utilisateur = new Utilisateur(name, lastname, mail);

        this.mDatabase = FirebaseDatabase.getInstance();
        this.myRef = mDatabase.getReference("utilisateurs");
        myRef.child(userId).setValue(utilisateur, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                Toast.makeText(SignInActivity.this, "User added.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}