package com.adam.presence;

import android.util.Log;

import java.util.Date;

public class Cours
{
    private String TAG = "Cours";
    private String professeur;
    private String matiere;
    private Date dateDebut;
    private Date dateFin;
    private float tempsCours;

    public Cours()
    {

    }

    public Cours( String professeur, String matiere, Date dateDebut, Date dateFin, float tempsCours)
    {
        this.professeur = professeur;
        this.matiere = matiere;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.tempsCours = tempsCours;
    }

    public void setProfesseur(String professeur)
    {
        this.professeur = professeur;
    }

    public void setMatiere(String matiere)
    {
        this.matiere = matiere;
    }

    public void setDateDebut(Date dateDebut)
    {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin)
    {
        this.dateFin = dateFin;
    }

    public void setTempsCours(float tempsCours)
    {
        this.tempsCours = tempsCours;
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

    public Date getDateFin()
    {
        return dateFin;
    }

    public float getTempsCours()
    {
        return tempsCours;
    }


    public String tempsDeCours(Date laDateDebut, Date laDateFin)
    {
        float leTempsCours=0;
        String leTempsCoursString="";

        // calcul qui permet de récuperer uniquement l'heure et les minute de "laDateDebut" sous forme de float

        // calcul qui permet de récuperer uniquement l'heure et les minute de "laDateFin" sous forme de float

        // calcul qui permet de faire l'oppération de "laDateFin" - "laDateDebut" et metre cette valeur dans "leTempsCours"

        // transformer "leTempsCours"(float) vers "leTempsCoursString"(String)

        //retourner "leTempsCoursString"
        return leTempsCoursString;
    }

    public void affiche()
    {
        Date dateDebutTest = null; //null --> donner une date
        Date dateFinTest = null; //null --> donner une date
        String message = tempsDeCours(dateDebutTest, dateFinTest);
        Log.w(TAG, message);

    }
}
