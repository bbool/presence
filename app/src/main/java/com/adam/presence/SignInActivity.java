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

public class SignInActivity extends AppCompatActivity {
    private String TAG = "Utilisateur";
    private FirebaseAuth mAuth;
    public DatabaseReference myRef;
    public FirebaseDatabase mDatabase;
    private Utilisateur utilisateur = new Utilisateur();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // mDatabase = FirebaseDatabase.getInstance();
        // Write a message to the database
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
        EditText lenom = findViewById(R.id. nomInscription);
        String nom = lenom.getText().toString();

        EditText leprenom = findViewById(R.id. prenomInscription);
        String prenom = leprenom.getText().toString();

        //récupération et transformation en String du mail
        EditText lemail = findViewById(R.id. mailInscription);
        String email = lemail.getText().toString();
        //récupération et transformation en String du mdp
        EditText lemdp = findViewById(R.id. mdpInscription);
        String password = lemdp.getText().toString();
        //récupération et transformation en String du deuxième mdp
        EditText lemdpverif = findViewById(R.id. mdpVerifInscription);
        String passwordverif = lemdpverif.getText().toString();
        Log.d(TAG,"premier mdp "+password);
        Log.d(TAG,"deuxieme mdp "+passwordverif);
        Log.d(TAG,"avant le if");


        this.myRef.setValue("Hello, World!");
//>>>>>>> 4481c36d864d438eab8686b4b06da225e49fe09b:app/src/main/java/com/adam/presence/RegisterActivity.java

        //On vérifi que les deux mdp sont les meme
        if(password.equals(passwordverif)) {
            Log.d(TAG,"apres le if");
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Log.d(TAG, "utilisateur créé avec succès");
                                FirebaseUser user = mAuth.getCurrentUser();
                                updateUI(user);
                                Log.d(TAG, "id user:"+user.getUid());

                                writeNewUser(user.getUid(),prenom,nom,email);

                                Intent appel = new Intent(SignInActivity.this, accueil.class);
                                startActivity(appel);
                            } else {
                                Log.w(TAG, "Echec d'ajout dans firebase", task.getException());
                                Log.w(TAG, email + " " + password);
                                Toast.makeText(SignInActivity.this, "creation failed.", Toast.LENGTH_SHORT).show();
                                updateUI(null);
                            }
                        }
                    });
        }
        else
        {
            Toast.makeText(SignInActivity.this, "les deux mot de passe ne sont pas identique.", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateUI(FirebaseUser user) {
    }

//<<<<<<< HEAD:app/src/main/java/com/adam/presence/SignInActivity.java
    public void writeNewUser(String userId, String name, String lastname, String mail) {
        Log.w(TAG, "dans la nouvelle fonction");
        Utilisateur user = new Utilisateur(name, lastname,mail);
        
        this.mDatabase = FirebaseDatabase.getInstance();
        myRef = mDatabase.getReference("utilisateurs");

        myRef.child(userId).setValue(user);
        /*
        , new
                DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference
                            databaseReference) {
                        Toast.makeText(SignInActivity.this, "User added.", Toast.LENGTH_SHORT).show();
                    }
                });

        /*mDatabase = FirebaseDatabase.getInstance().getReference("presence-3183d-default-rtdb");



=======
    public void writeNewUser(String userId, String name, String lastname) {
        Log.w(TAG, "dans la nouvelle fonction");

        utilisateur.setName(name);
        utilisateur.setLastName(lastname);

        this.mDatabase = FirebaseDatabase.getInstance();
        this.myRef = mDatabase.getReference("utilisateurs");
        myRef.child(userId).push().setValue(utilisateur, new
                DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference
                            databaseReference) {
                        Toast.makeText(SignInActivity.this, "User added.", Toast.LENGTH_SHORT).show();
                    }
                });

        mDatabase = FirebaseDatabase.getInstance().getReference("presence-3183d-default-rtdb");
>>>>>>> 4481c36d864d438eab8686b4b06da225e49fe09b:app/src/main/java/com/adam/presence/RegisterActivity.java

        mDatabase.child("utilisateurs").child(userId).setValue(utilisateur); //.child(userId).
        utilisateur.affiche();



<<<<<<< HEAD:app/src/main/java/com/adam/presence/SignInActivity.java
=======
        mDatabase.child("utilisateurs").child(userId).setValue(utilisateur); //.child(userId).
        utilisateur.affiche();



>>>>>>> 4481c36d864d438eab8686b4b06da225e49fe09b:app/src/main/java/com/adam/presence/RegisterActivity.java
*/

    }
}