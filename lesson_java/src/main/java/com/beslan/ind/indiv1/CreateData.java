package com.beslan.ind.indiv1;

import java.util.ArrayList;
import java.util.List;

class CreateData {
    private String nameProject, fioProjectManager;
    private int numberDays;
    private Department departmentAnalytics = new Department(1);
    private Department departmentsDevelopment = new Department(2);
    private Department departmentsTesting = new Department(3);
    private ISR1 project;
    private List<Department> departments = new ArrayList<>();

    public CreateData(String nameProject, String fioProjectManager, int numberDays) {
        this.nameProject = nameProject;
        this.fioProjectManager = fioProjectManager;
        this.numberDays = numberDays;
        createStructureProject();
    }

    public ISR1 getProject() {
        return project;
    }

    public String getNameProject() {
        return nameProject;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public Department getDepartmentAnalytics() {
        return departmentAnalytics;
    }

    public Department getDepartmentsDevelopment() {
        return departmentsDevelopment;
    }

    public Department getDepartmentsTesting() {
        return departmentsTesting;
    }

    public void createStructureProject() {

        departmentAnalytics.setProgrammingLanguages("Python", "JavaScript", "HTML", "PHP", "CSS", "Go");
        departmentsDevelopment.setProgrammingLanguages("Python", "Java", "SQL", "Scala", "Perl");
        departmentsTesting.setProgrammingLanguages("Rational Suite TestStudio", "Rational Test RealTime", "Rational TestManager");

        departments.add(departmentAnalytics);
        departments.add(departmentsDevelopment);
        departments.add(departmentsTesting);

        project = new ISR1(nameProject, numberDays, departments,
                new Human(fioProjectManager, new ArrayList<String>(), null));
        project.getProjectManagers().addResponsibility("Постановка задач перед участниками проекта");
        project.getProjectManagers().addResponsibility("Мониторинг работ");

    }
}
