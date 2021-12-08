package com.adam.presence;

import android.util.Log;

public class Utilisateur
{
    private String TAG = "Utilisateur";
    private String name;
    private String lastName;
    private String email;

    public Utilisateur()
    {
    }

    public Utilisateur(String name, String lastName, String mail)
    {
        this.name     = name;
        this.lastName = lastName;
        this.email    = mail;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setMail(String mail)
    {
        this.email = mail;
    }

    public String getEmail()
    {
        return email;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getName()
    {
        return name;
    }

    public void affiche(){
        String message ="prenom : "+getName()+" \nnom: "+getLastName()+"\nmail: "+ getEmail();
        Log.w(TAG, message);

    }
}
