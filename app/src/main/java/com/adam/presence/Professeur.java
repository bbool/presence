package com.adam.presence;

import java.util.ArrayList;

public class Professeur {
    private String id;
    private String firstname;
    private String lastName;
    private String email;
    private ArrayList<Groupe> groups;
    //private ArrayList<String> subjects;

    public Professeur()
    {
        // Get the right Group in Database
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
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Groupe> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Groupe> groups) {
        this.groups = groups;
    }

    public void addGroup(Groupe group) {
        this.groups.add(group);
    }


    public String toString () {

        return "\nid: "+this.id+"\n prénom : "+this.firstname+"\n nom:"+this.lastName+"\n mail : "+this.email+"\n";
    }

    /*public ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(String subject) {
        this.subjects.add(subject);
    }
    */
}
