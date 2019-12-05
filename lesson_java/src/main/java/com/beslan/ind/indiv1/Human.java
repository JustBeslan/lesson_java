package com.beslan.ind.indiv1;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Human {
    private int years;
    private String name;
    private Map<Integer, Role> roleInProjects = new HashMap<>();

    public Human(String name, int years) {
        this.name = name;
        this.years = years;
    }

    public void outInfoHuman(@NotNull List<ISR1> projects) {
        System.out.println("ФИО : " + name + "\n");
        System.out.println("Возраст : " + years + "\n");
        System.out.println("Проекты, над которыми " + name + " работает : \n");
        for (ISR1 project : projects) {
            assert this.getRoleInProjects().containsKey(project.getId());
            System.out.println("\t Название проекта : " + project.getName() + "\n");
            System.out.println("\t Роль : " + roleInProjects.get(project.getId()).getRole() + "\n\n");
            for (Human human : project.getWorkers().values()) {
                Role role = human.getRoleInProjects().get(project.getId());
                if (role.getCode() == 0)
                    System.out.println("Менеджер проекта : " + human.getName());
            }
            for (Human human : project.getWorkers().values()) {
                Role role = human.getRoleInProjects().get(project.getId());
                if ((role.getWorkers() != null) && ((role.getWorkers().contains(this))))
                    System.out.println("Его TeamLead : " + human.getName());
            }
        }
    }

    public Map<Integer, Role> getRoleInProjects() {
        return roleInProjects;
    }

    public String getName() {
        return name;
    }

    public void addProject(@NotNull ISR1 project, double idDepartment) {
        Map<Integer, Human> workersProject = project.getWorkers();
        workersProject.put(project.getWorkers().size() + 1, this);
        project.setWorkers(workersProject);
        this.roleInProjects.put(project.getId(), new Role(idDepartment));
    }

    public Set<Human> findTeamLeadsProject(@NotNull List<ISR1> projects) {
        Set<Human> res = new HashSet<>();
        for (ISR1 project : projects) {
            assert this.getRoleInProjects().containsKey(project.getId());
            for (Human human1 : project.getWorkers().values()) {
                if ((human1.getRoleInProjects().get(project.getId()).getWorkers() != null) &&
                        (human1.getRoleInProjects().get(project.getId()).getWorkers().contains(this)))
                    res.add(human1);
            }
        }
        return res;
    }
}
