package com.adam.presence;
import android.provider.ContactsContract;

import java.util.ArrayList;
public class Eleve
{
    private String id;
    private String firstName;
    private String lastName;
    private String mail;
    private boolean isPresent = false;

    public Eleve() {}

    public Eleve( String id, String firstname, boolean t, String lastname, String mail) {
        this.id = id;
        this.firstName = firstname;
        this.lastName = lastname;
        this.mail = mail;
        isPresent = t;
    }

    public Eleve( String id, String firstName, String lastName, String mail) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
    }

    public Eleve(String firstName, String lastName, String mail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
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

    public String toString () {

        return "\nid: "+this.id+"\n prénom : "+this.firstName+"\n nom:"+this.lastName+"\n mail : "+this.mail+"\n"; }
}
