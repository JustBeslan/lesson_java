package com.beslan.ind.indiv1;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private String surname;
    private List<String> responsibility = new ArrayList<>();
    private List<Human> workers = new ArrayList<>();

    public Human(@NotNull String name, List<String> responsibility, List<Human> workers) {
        String[] fio = name.split(" ");
        this.name = fio[0];
        this.surname = fio[1];
        this.responsibility = responsibility;
        this.workers = workers;
    }

    public List<String> getResponsibility() {
        return responsibility;
    }

    public List<Human> getWorkers() {
        return workers;
    }

    public String getNameSurname() {
        return (name + " " + surname);
    }

    public void addResponsibility(String newResponsibility) {
        this.responsibility.add(newResponsibility);
    }
}
