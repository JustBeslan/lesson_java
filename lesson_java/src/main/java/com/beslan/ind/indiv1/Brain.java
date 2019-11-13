package com.beslan.ind.indiv1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Brain {
    private List<CreateData> projects = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper();
    private Gson gson = new Gson();

    public static void main(String[] args) throws IOException {
        Brain project1 = new Brain();
        project1.createProjectOnlineShop();
        String name = "Артем Грол";
        System.out.println("-------" + name + "-------");
        if (project1.outInfo(name, 0) == null) {
            System.out.println("Такого человека нет");
        }
//        StringWriter writer = new StringWriter();
//        String jsonString = "{ \"nameProject\"}";
//        StringReader reader = new StringReader(jsonString);
        for (CreateData data : project1.projects) {
//            project1.objectMapper.writeValue(writer,data);
//            System.out.println(writer.toString());
            String json = project1.gson.toJson(data);
            System.out.println(json);
            CreateData data1 = project1.gson.fromJson(json, CreateData.class);
            System.out.println(data1.getNameProject());
        }
    }

    private Human outInfo(@NotNull String name, int codeOp) {
        List<Human> managerProjects = new ArrayList<>();
        List<Human> teamLeadsProjectsAnalytic = new ArrayList<>();
        List<Human> teamLeadsProjectsDeveloper = new ArrayList<>();
        List<Human> teamLeadsProjectsTester = new ArrayList<>();
        List<Human> workersProjects = new ArrayList<>();
//        System.out.println(name + "\n");
        for (CreateData data : projects) {
            if (data.getProject().getProjectManagers().getNameSurname().equals(name)) {
                System.out.println("Должность : Менеджер проекта");
                System.out.println("Имя проекта : " + data.getNameProject());
                System.out.println("Обязанности : ");
                for (String resp : data.getProject().getProjectManagers().getResponsibility())
                    System.out.println("\t" + resp);
            }
            assert !data.getProject().getProjectManagers().getNameSurname().equals(name);
            for (Department department : data.getDepartments()) {
                switch (department.getCode()) {
                    case 1: {
                        for (Human human : data.getDepartmentAnalytics().getDepartmentLeadings()) {
                            if (human.getNameSurname().equals(name)) {
                                if (codeOp == 1) return human;
                                System.out.println("Должность : Ведущий аналитик");
                                System.out.println("Имя проекта : " + data.getNameProject());
                                System.out.println("Менеджер проекта : " + data.getProject().getProjectManagers().getNameSurname());
                                System.out.println("Обязанности : ");
                                for (String resp : human.getResponsibility())
                                    System.out.println("\t" + resp);
                                if (codeOp == 0) return human;
                            }
                            assert !human.getNameSurname().equals(name);
                            for (Human human1 : human.getWorkers()) {
                                if (human1.getNameSurname().equals(name)) {
                                    System.out.println("Должность : Аналитик");
                                    System.out.println("Имя проекта : " + data.getNameProject());
                                    System.out.println("Менеджер проекта : " + data.getProject().getProjectManagers().getNameSurname());
                                    System.out.println("Начальник отдела : " + human.getNameSurname());
                                    System.out.println("Обязанности : ");
                                    for (String resp : human1.getResponsibility())
                                        System.out.println("\t" + resp);
                                    if (codeOp == 0) return human1;
                                }
                            }
                        }
                    }
                    break;
                    case 2: {
                        for (Human human : data.getDepartmentsDevelopment().getDepartmentLeadings()) {
                            if (human.getNameSurname().equals(name)) {
                                if (codeOp == 1) return human;
                                System.out.println("Должность : Ведущий разработчик");
                                System.out.println("Имя проекта : " + data.getNameProject());
                                System.out.println("Менеджер проекта : " + data.getProject().getProjectManagers().getNameSurname());
                                System.out.println("Обязанности : ");
                                for (String resp : human.getResponsibility())
                                    System.out.println("\t" + resp);
                                if (codeOp == 0) return human;
                            }
                            assert !human.getNameSurname().equals(name);
                            for (Human human1 : human.getWorkers()) {
                                if (human1.getNameSurname().equals(name)) {
                                    System.out.println("Должность : Разработчик");
                                    System.out.println("Имя проекта : " + data.getNameProject());
                                    System.out.println("Менеджер проекта : " + data.getProject().getProjectManagers().getNameSurname());
                                    System.out.println("Начальник отдела : " + human.getNameSurname());
                                    System.out.println("Обязанности : ");
                                    for (String resp : human1.getResponsibility())
                                        System.out.println("\t" + resp);
                                    if (codeOp == 0) return human1;
                                }
                            }
                        }
                    }
                    break;
                    case 3: {
                        for (Human human : data.getDepartmentsTesting().getDepartmentLeadings()) {
                            if (human.getNameSurname().equals(name)) {
                                if (codeOp == 1) return human;
                                System.out.println("Должность : Ведущий тестировщик");
                                System.out.println("Имя проекта : " + data.getNameProject());
                                System.out.println("Менеджер проекта : " + data.getProject().getProjectManagers().getNameSurname());
                                System.out.println("Обязанности : ");
                                for (String resp : human.getResponsibility())
                                    System.out.println("\t" + resp);
                                if (codeOp == 0) return human;
                            }
                            assert !human.getNameSurname().equals(name);
                            for (Human human1 : human.getWorkers()) {
                                if (human1.getNameSurname().equals(name)) {
                                    System.out.println("Должность : Тестировщик");
                                    System.out.println("Имя проекта : " + data.getNameProject());
                                    System.out.println("Менеджер проекта : " + data.getProject().getProjectManagers().getNameSurname());
                                    System.out.println("Начальник отдела : " + human.getNameSurname());
                                    System.out.println("Обязанности : ");
                                    for (String resp : human1.getResponsibility())
                                        System.out.println("\t" + resp);
                                    if (codeOp == 0) return human1;
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }
        return null;
    }

    private void createProjectOnlineShop() throws IOException {
        //===============Основная информация о проекте==========================
        CreateData projectOnlineShop = new CreateData("Online Shop",
                "Николай Иванов", 46);
        //===============TeamLeads Отдела аналитики==========================
        projectOnlineShop.getDepartmentAnalytics().addLeadingDepartment("Владимир Иванов");
        projectOnlineShop.getDepartmentAnalytics().addLeadingDepartment("Григорий Семенович");
        //===============TeamLeads Отдела разработки==========================
        projectOnlineShop.getDepartmentsDevelopment().addLeadingDepartment("Семен Петрович");
        projectOnlineShop.getDepartmentsDevelopment().addLeadingDepartment("Григорий Иванович");
        //===============TeamLeads Отдела тестирования==========================
        projectOnlineShop.getDepartmentsTesting().addLeadingDepartment("Трофим Григорьевич");
        //===============Добавление этого проекта в список проектов==========================
        projects.add(projectOnlineShop);

        try {
            //===============Добавление аналитиков разным TeamLead-ам==========================
            projects.get(projects.size() - 1).getDepartmentAnalytics().addWorkerDepartment(
                    Objects.requireNonNull(outInfo("Владимир Иванов", 1)), "Анатолий Петров");
            projects.get(projects.size() - 1).getDepartmentAnalytics().addWorkerDepartment(
                    Objects.requireNonNull(outInfo("Владимир Иванов", 1)), "Сергей Иванов");
            projects.get(projects.size() - 1).getDepartmentAnalytics().addWorkerDepartment(
                    Objects.requireNonNull(outInfo("Григорий Семенович", 1)), "Сергей Иванов");
            //===============Добавление разработчиков разным TeamLead-ам==========================
            projects.get(projects.size() - 1).getDepartmentsDevelopment().addWorkerDepartment(
                    Objects.requireNonNull(outInfo("Семен Петрович", 1)), "Петра Ровано");
            projects.get(projects.size() - 1).getDepartmentsDevelopment().addWorkerDepartment(
                    Objects.requireNonNull(outInfo("Семен Петрович", 1)), "Адриано Челентано");
            projects.get(projects.size() - 1).getDepartmentsDevelopment().addWorkerDepartment(
                    Objects.requireNonNull(outInfo("Григорий Иванович", 1)), "Артем Грол");
            projects.get(projects.size() - 1).getDepartmentsDevelopment().addWorkerDepartment(
                    Objects.requireNonNull(outInfo("Григорий Иванович", 1)), "Артемий Ковров");
            //===============Добавление тестировщиков разным TeamLead-ам==========================
            projects.get(projects.size() - 1).getDepartmentsTesting().addWorkerDepartment(
                    Objects.requireNonNull(outInfo("Трофим Григорьевич", 1)), "Кирилл Романов");
            projects.get(projects.size() - 1).getDepartmentsTesting().addWorkerDepartment(
                    Objects.requireNonNull(outInfo("Трофим Григорьевич", 1)), "Роман Акрилов");
        } catch (NullPointerException e) {
            System.out.println("При создании структуры проекта произошла ошибка. Появился неизвестный проекту человек. Работа прервана");
            e.printStackTrace();
        }
    }
}
