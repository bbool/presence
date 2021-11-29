package com.adam.presence;

import android.util.Log;

public class Person
{
    private String TAG = "Person";
    private String name;
    private String lastName;
    private String id;

    public Person()
    {
    }

    public Person(String name, String lastName, String idUser)
    {
        this.name = name;
        this.lastName = lastName;
        this.id = idUser;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
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
        String message ="prenom : "+getName()+" \nnom: "+getLastName()+"\nid: "+ getId();
        Log.w(TAG, message);

    }
}
