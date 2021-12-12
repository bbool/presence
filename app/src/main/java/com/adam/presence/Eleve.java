package com.adam.presence;

import android.provider.ContactsContract;

import java.util.ArrayList;

public class Eleve
{
    private String id;
    private String firstname;
    private String lastname;
    private String mail;
    private boolean isPresent = false;

    public Eleve() {}

    public Eleve( String id, String firstname, String lastname, String mail)
    {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMail()
    {
        return mail;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }

    public boolean getIsPresent()
    {
        return isPresent;
    }

    public void setIsPresent(boolean isPresent)
    {
        this.isPresent = isPresent;
    }

    public void isPresent()
    {
        this.isPresent = true;
    }

    public void isAbsent()
    {
        this.isPresent = false;
    }
}
