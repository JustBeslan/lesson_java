package com.beslan.ind.indiv1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IndTest {
    private static List<Human> workers = new ArrayList<>();
    private static ISR1 project;

    @BeforeAll
    public static void createData() {

        Human project1Manager = new Human("Николай Иванов");
        project1Manager.setResponsibility(Arrays.asList(
                "Постановка задач перед участниками проекта",
                "Мониторинг работ"
        ));
//==============================================================
        Human worker1 = new Human("Анатолий Петров");
        workers.add(worker1);
        Human worker2 = new Human("Сергей Иванов");
        workers.add(worker2);
        Human worker3 = new Human("Сергей Иванов");
        workers.add(worker3);

        Human teamLead1 = new Human("Владимир Иванов");
        teamLead1.setWorkers(Arrays.asList(worker1, worker2));
        workers.add(teamLead1);
        Human teamLead2 = new Human("Григорий Семенович");
        teamLead2.setWorkers(Arrays.asList(worker3));
        workers.add(teamLead2);
//==============================================================
        Human worker4 = new Human("Петра Ровано");
        workers.add(worker4);
        Human worker5 = new Human("Адриано Челентано");
        workers.add(worker5);
        Human worker6 = new Human("Артем Грол");
        workers.add(worker6);
        Human worker7 = new Human("Артемий Ковров");
        workers.add(worker7);

        Human teamLead3 = new Human("Семен Петрович");
        teamLead3.setWorkers(Arrays.asList(worker4, worker5));
        workers.add(teamLead3);
        Human teamLead4 = new Human("Григорий Иванович");
        teamLead4.setWorkers(Arrays.asList(worker6, worker7));
        workers.add(teamLead4);
//================================================================
        Human worker8 = new Human("Кирилл Романов");
        workers.add(worker8);
        Human worker9 = new Human("Роман Акрилов");
        workers.add(worker9);

        Human teamLead5 = new Human("Трофим Григорьевич");
        teamLead5.setWorkers(Arrays.asList(worker8, worker9));
        workers.add(teamLead5);
//================================================================
        Department department1 = new Department(1, Arrays.asList(teamLead1, teamLead2));
        Department department2 = new Department(2, Arrays.asList(teamLead3, teamLead4));
        Department department3 = new Department(3, Arrays.asList(teamLead5));

        project = new ISR1("Online Shop", 364, Arrays.asList(department1, department2, department3), project1Manager);
    }

    @AfterAll
    public static void clearData() {
        workers = null;
        project = null;
    }

    @Test
    public void indTest() {
        Assertions.assertEquals(Arrays.asList(workers.get(0), workers.get(1)), workers.get(3).getWorkers());

        Assertions.assertEquals(Arrays.asList(
                workers.get(3),
                workers.get(0),
                workers.get(1),
                workers.get(4),
                workers.get(2)
                ),
                project.findWorkersDepartment(project.getDepartments().get(0)));
        project.inFromFile();
    }
}