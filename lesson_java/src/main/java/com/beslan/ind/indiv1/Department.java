package com.beslan.ind.indiv1;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Department {
    private int numberHuman, code;
    private List<Human> departmentLeadings = new ArrayList<>();
    private List<String> programmingLanguages = new ArrayList<>();
    private List<String> Responsibility = new ArrayList<>();

    public Department(int code) {
        this.code = code;

        if (this.code == 1) {
            Responsibility.add("Распределение задач между аналитиками");
            Responsibility.add("Рецензирование проектной документации");
            Responsibility.add("Разработка проектной документации");
            Responsibility.add("Рецензирование тестовых спецификаций");
        }

        if (this.code == 2) {
            Responsibility.add("Распределение задач между разработчиками");
            Responsibility.add("Рецензирование проектной документации");
            Responsibility.add("Разработка");
            Responsibility.add("Исправление ошибок");
        }

        if (this.code == 3) {
            Responsibility.add("Распределение задач между тестировщиками");
            Responsibility.add("Рецензирование проектной документации");
            Responsibility.add("Тестирование");
            Responsibility.add("Разработка тестовых спецификаций");
        }
    }

    public int getCode() {
        return code;
    }

    public List<String> getResponsibility() {
        return Responsibility;
    }

    public List<Human> getDepartmentLeadings() {
        return departmentLeadings;
    }

    public void setProgrammingLanguages(String... strings) {
        this.programmingLanguages = Arrays.asList(strings);
    }

    public void addProgrammingLanguages(String language) {
        this.programmingLanguages.add(language);
    }

    public void addLeadingDepartment(String name) {
        Human leading = new Human(name, new ArrayList<>(), new ArrayList<>());

        if (this.code == 1) {
            leading.addResponsibility(Responsibility.get(0));
            leading.addResponsibility(Responsibility.get(1));
            leading.addResponsibility(Responsibility.get(2));
        }

        if (this.code == 2) {
            leading.addResponsibility(Responsibility.get(0));
            leading.addResponsibility(Responsibility.get(1));
            leading.addResponsibility(Responsibility.get(2));
        }

        if (this.code == 3) {
            leading.addResponsibility(Responsibility.get(0));
            leading.addResponsibility(Responsibility.get(1));
            leading.addResponsibility(Responsibility.get(2));
            leading.addResponsibility(Responsibility.get(3));
        }
        this.departmentLeadings.add(leading);
        this.numberHuman++;
    }

    public void addWorkerDepartment(@NotNull Human leading, String name) {
        Human worker = new Human(name, new ArrayList<>(), null);

        if (this.code == 1) {
            worker.addResponsibility(Responsibility.get(2));
            worker.addResponsibility(Responsibility.get(3));
        }

        if (this.code == 2) {
            worker.addResponsibility(Responsibility.get(1));
            worker.addResponsibility(Responsibility.get(2));
            worker.addResponsibility(Responsibility.get(3));
        }

        if (this.code == 3) {
            worker.addResponsibility(Responsibility.get(1));
            worker.addResponsibility(Responsibility.get(2));
            worker.addResponsibility(Responsibility.get(3));
        }
        leading.getWorkers().add(worker);
        this.numberHuman++;
    }
}
