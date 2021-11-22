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

public class SignInActivity extends AppCompatActivity {
    private String TAG = "Utilisateur";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();
        TextView btn = (TextView)findViewById(R.id.activity_main_link_connexion);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//Toast.makeText(MainActivity.this, "Coucou !", Toast.LENGTH_SHORT).show();

                Intent appel = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(appel);

            }
        });


        Button connexion = findViewById(R.id.buttonInscription);

        connexion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//Toast.makeText(MainActivity.this, "Coucou !", Toast.LENGTH_SHORT).show();

//Intent appel = new Intent(MainActivity.this, SignInActivity.class);
                inscription();

            }
        });

    }

    protected void inscription ()
    {
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

        //On vérifi que les deux mdp sont les meme
        if(password.equals(passwordverif)) {
            Log.d(TAG,"apres le if");
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
// Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "utilisateur créé avec succès");
                                FirebaseUser user = mAuth.getCurrentUser();
                                updateUI(user);

                                Intent appel = new Intent(SignInActivity.this, accueil.class);
                                startActivity(appel);

                            } else {
// If sign in fails, display a message to the user.
                                Log.w(TAG, "Echec d'ajout dans firebase", task.getException());
                                Log.w(TAG, email + " " + password);
                                Toast.makeText(SignInActivity.this, "creation failed.",
                                        Toast.LENGTH_SHORT).show();
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

}