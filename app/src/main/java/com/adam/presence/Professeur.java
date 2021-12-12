package com.adam.presence;

import java.util.ArrayList;

public class Professeur {
    private String id;
    private String firstname;
    private String lastname;
    private ArrayList<Groupe> groups;
    //private ArrayList<String> subjects;

    public Professeur(String id)
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
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
