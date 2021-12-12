package com.adam.presence;

import java.util.ArrayList;

public class Groupe {
    private String id;
    private String name;
    private ArrayList<String> members;

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

    public ArrayList<String> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<String> members) {
        this.members = members;
    }

    public void addMember(String member) {
        this.members.add(member);
    }
}
