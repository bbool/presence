package com.adam.presence;

import android.util.Log;

import java.util.Date;

public class Cours
{
    private String TAG = "Cours";
    private String id;
    private String professeur;
    private String matiere;
    private Date dateDebut;
    private float duree;

    public Cours() {}

    public Cours( String id, String professeur, String matiere, Date dateDebut, float duree) {
        this.id = id;
        this.professeur = professeur;
        this.matiere = matiere;
        this.dateDebut = dateDebut;
        this.duree = duree;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setProfesseur(String professeur)
    {
        this.professeur = professeur;
    }

    public void setMatiere(String matiere)
    {
        this.matiere = matiere;
    }

    public void setDuree(float duree)
    {
        this.duree = duree;
    }

    public String getId()
    {
        return id;
    }

    public String getProfesseur()
    {
        return professeur;
    }

    public String getMatiere()
    {
        return matiere;
    }

    public Date getDateDebut()
    {
        return dateDebut;
    }

    public float getDuree()
    {
        return duree;
    }

    public void affiche() {
        Date dateDebutTest = null; //null --> donner une date
        String message = "";
        Log.w(TAG, message);

    }
}
