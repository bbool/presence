package com.adam.presence.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.adam.presence.Professeur;
import com.adam.presence.R;
import com.adam.presence.databinding.FragmentDashboardBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class DashboardFragment extends Fragment
{

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;


    private String TAG = "recup";
    private FirebaseAuth mAuth;
    public DatabaseReference myRef;
    public FirebaseDatabase mDatabase;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        this.mDatabase = FirebaseDatabase.getInstance();

        this.myRef = mDatabase.getReference("utilisateurs");

        mAuth = FirebaseAuth.getInstance();


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    Professeur p = ds.getValue(Professeur.class);
                    Log.d(TAG, "prof is" + p.toString());

                    String nom = p.getLastname();
                    String prenom = p.getFirstname();
                    String mail = p.getEmail();
                    setText(nom, prenom, mail);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    public void setText(String nom , String prenom, String mail) {
        TextView nomText = (TextView) getView().findViewById(R.id.idNom);
        nomText.setText(nom);

        TextView prenomText = (TextView) getView().findViewById(R.id.idPrenom);
        prenomText.setText(prenom);

        TextView mailText = (TextView) getView().findViewById(R.id.idEmail);
        mailText.setText(mail);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}