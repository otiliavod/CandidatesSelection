package com.facultate.proiectasd.model;

import java.util.Comparator;
import java.util.List;

public class Candidate implements Comparable<Candidate> {

    private String name;
    private String email;
    private List<String> criterias;

    public Candidate() {
    }

    public Candidate(String name, String email, List<String> criterias) {
        this.name = name;
        this.email = email;
        this.criterias = criterias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getCriterias() {
        return criterias;
    }

    public void setCriterias(List<String> criterias) {
        this.criterias = criterias;
    }

    @Override
    public String toString() {
        return "Candidate: " +
                "Candidate Name " + name +
                "Email " + email;
    }


    @Override
    public int compareTo(Candidate o) {
        return this.getCriterias().size() < o.getCriterias().size() ? 1 :
                this.getCriterias().size() > o.getCriterias().size() ? -1 : 0;
    }
}
