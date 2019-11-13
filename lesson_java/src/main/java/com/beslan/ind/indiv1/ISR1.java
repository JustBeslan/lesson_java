package com.beslan.ind.indiv1;

import java.util.List;

public class ISR1 {
    private String name;
    private int numberDays;
    private Human projectManagers;

    public ISR1(String name, int numberDays, List<Department> departments, Human projectManagers) {
        this.name = name;
        this.numberDays = numberDays;
        this.projectManagers = projectManagers;
    }

    public Human getProjectManagers() {
        return projectManagers;
    }

    public void setProjectManagers(Human projectManagers) {
        this.projectManagers = projectManagers;
    }
}
