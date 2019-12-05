package com.beslan.ind.indiv1;

import java.util.ArrayList;
import java.util.List;

public class Role {
    private double code;
    private List<String> Responsibility = new ArrayList<>();
    private String role;
    private List<Human> hisWorkers;

    public Role(double code) {
        this.code = code;

        if (code == 0) {
            role = "Менеджер проекта";
            Responsibility.add("Постановка задач перед участниками проекта");
            Responsibility.add("Мониторинг работ");
        }

        if (code == 1.0) {
            role = "Ведущий аналитик";
            Responsibility.add("Распределение задач между аналитиками");
            Responsibility.add("Рецензирование проектной документации");
            Responsibility.add("Разработка проектной документации");
            hisWorkers = new ArrayList<>();
        }

        if (code == 1.1) {
            role = "Аналитик";
            Responsibility.add("Разработка проектной документации");
            Responsibility.add("Рецензирование тестовых спецификаций");
        }

        if (code == 2.0) {
            role = "Ведущий разработчик";
            Responsibility.add("Распределение задач между разработчиками");
            Responsibility.add("Рецензирование проектной документации");
            Responsibility.add("Разработка");
            hisWorkers = new ArrayList<>();
        }

        if (code == 2.1) {
            role = "Разработчик";
            Responsibility.add("Рецензирование проектной документации");
            Responsibility.add("Разработка");
            Responsibility.add("Исправление ошибок");
        }

        if (code == 3.0) {
            role = "Ведущий тестировщик";
            Responsibility.add("Распределение задач между тестировщиками");
            Responsibility.add("Рецензирование проектной документации");
            Responsibility.add("Тестирование");
            Responsibility.add("Разработка тестовых спецификаций");
            hisWorkers = new ArrayList<>();
        }

        if (code == 3.1) {
            role = "Тестировщик";
            Responsibility.add("Рецензирование проектной документации");
            Responsibility.add("Тестирование");
            Responsibility.add("Разработка тестовых спецификаций");
        }
    }

    public double getCode() {
        return code;
    }

    public List<Human> getWorkers() {
        return hisWorkers;
    }

    public void setWorkers(List<Human> workers) {
        this.hisWorkers = workers;
    }

    public String getRole() {
        return role;
    }
}
