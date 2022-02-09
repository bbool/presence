package com.adam.presence;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EleveAdapter extends RecyclerView.Adapter<EleveViewHolder>{

    // FOR DATA
    private List<Eleve> eleves;

    // CONSTRUCTOR
    public EleveAdapter(List<Eleve> eleves) {
        this.eleves = eleves;
    }

    @Override
    public EleveViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // CREATE VIEW HOLDER AND INFLATING ITS XML LAYOUT
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.appel_items, parent, false);

        return new EleveViewHolder(view);
    }

    // UPDATE VIEW HOLDER WITH A GITHUBUSER
    @Override
    public void onBindViewHolder(EleveViewHolder viewHolder, int position) {
        viewHolder.updateWithEleve(this.eleves.get(position));
    }

    // RETURN THE TOTAL COUNT OF ITEMS IN THE LIST
    @Override
    public int getItemCount() {
        return this.eleves.size();
    }
}
