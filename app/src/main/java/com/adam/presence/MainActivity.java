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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private String TAG = "Utilisateur"; //canal utiliser pour le terminal
    private String TAG2 = "Eleves"; //canal utiliser pour le terminal
    private FirebaseAuth mAuth; //création de l'objet d'autantification



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        FirebaseDatabase.getInstance().getReference("utilisateurs").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()){
                    Professeur e = ds.getValue(Professeur.class);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        TextView btn = (TextView)findViewById(R.id.inscription_link_inscrir);

        //TextView btnForget = (TextView)findViewById(R.id.inscription_link_forgetPassword);

        btn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Intent appel = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(appel);
            }
        });

        /*btnForget.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Intent appel = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(appel);
            }
        });*/

        Button connexion = findViewById(R.id.buttonConnexion);

        connexion.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                connexion();
            }
        });
    }

    protected void connexion ()
    {
        EditText lemail = findViewById(R.id.SaisieEmailConnexion);
        String email = lemail.getText().toString();
        EditText lemdp = findViewById(R.id.SaisiePasswordConnexion);
        String password = lemdp.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);

                            Intent appel = new Intent(MainActivity.this, accueil.class);
                            startActivity(appel);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Log.w(TAG, email + " "+ password);
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);

                        }
                    }
                });
    }
    private void updateUI(FirebaseUser user) {}

}