package com.adam.presence;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adam.presence.Eleve;
import com.adam.presence.R;

public class EleveViewHolder extends RecyclerView.ViewHolder {
    private final TextView textView;

    public EleveViewHolder(View view) {
        super(view);
        // Define click listener for the ViewHolder's View

        textView = (TextView) view.findViewById(R.id.textView);
    }

    public TextView getTextView() {
        return textView;
    }

    public void updateWithEleve(Eleve eleve){
            String infos = eleve.getFirstname()+" "+eleve.getLastname();
            this.textView.setText(infos);
        }

}
