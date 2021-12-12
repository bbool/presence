package com.adam.presence;

import java.util.ArrayList;

public class Groupe {
    private String id;
    private String name;
    private ArrayList<Eleve> eleves;

    public Groupe(String id) {
        // Get the right Group in Database
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Eleve> getEleves() {
        return eleves;
    }

    public void setEleves(ArrayList<Eleve> eleves) {
        this.eleves = eleves;
    }

    public void addEleves(Eleve eleves) {
        this.eleves.add(eleves);
    }
}
