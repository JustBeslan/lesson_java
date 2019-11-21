package com.beslan.ind.indiv1;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private List<String> responsibility = new ArrayList<>();
    private List<Human> workers = new ArrayList<>();

    public Human(@NotNull String name) {
        this.name = name;
    }

    public void setResponsibility(List<String> responsibility) {
        this.responsibility = responsibility;
    }

    public void setWorkers(List<Human> workers) {
        this.workers = workers;
    }

    public List<String> getResponsibility() {
        return responsibility;
    }

    public List<Human> getWorkers() {
        return workers;
    }

    public String getNameSurname() {
        return name;
    }

    public void addResponsibility(String newResponsibility) {
        this.responsibility.add(newResponsibility);
    }
}
