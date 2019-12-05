package com.beslan.ind.indiv1;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class IndTest {
    private List<Human> workers = new ArrayList<>();
    private List<ISR1> projects = new ArrayList<>();

    @BeforeEach
    public void createData() {
//====================Attempt Number2=============================
        Human project1Manager1 = new Human("Роман Акрилов", 31);
        Human project1Manager2 = new Human("Николай Иванов", 43);
        ISR1 project1 = new ISR1(1, "Online Shop", 364);
        project1Manager1.addProject(project1, 0);
        workers.add(project1Manager1);
        project1Manager2.addProject(project1, 0);
        workers.add(project1Manager2);

        //------------------------
        Human worker1_1_1 = new Human("Трофим Григорьевич", 31);
        worker1_1_1.addProject(project1, 1.0);
        workers.add(worker1_1_1);
        Human worker1_1_2 = new Human("Серена Петровна", 32);
        worker1_1_2.addProject(project1, 1.0);
        workers.add(worker1_1_2);
        Human worker1_1_3 = new Human("Артемий Ковров", 23);
        worker1_1_3.addProject(project1, 1.1);
        workers.add(worker1_1_3);
        Human worker1_1_4 = new Human("Артем Грол", 22);
        worker1_1_4.addProject(project1, 1.1);
        workers.add(worker1_1_4);
        Human worker1_1_5 = new Human("Адриано Челентано", 22);
        worker1_1_5.addProject(project1, 1.1);
        workers.add(worker1_1_5);
        worker1_1_1.getRoleInProjects().get(project1.getId()).setWorkers(Arrays.asList(worker1_1_3, worker1_1_4));
        worker1_1_2.getRoleInProjects().get(project1.getId()).setWorkers(Arrays.asList(worker1_1_5));
        //------------------------
        Human worker1_2_1 = new Human("Кирилл Романов", 27);
        worker1_2_1.addProject(project1, 2.0);
        workers.add(worker1_2_1);
        Human worker1_2_2 = new Human("Петра Ровано", 27);
        worker1_2_2.addProject(project1, 2.0);
        workers.add(worker1_2_2);
        Human worker1_2_3 = new Human("Григорий Семенович", 28);
        worker1_2_3.addProject(project1, 2.1);
        workers.add(worker1_2_3);
        Human worker1_2_4 = new Human("Владимир Иванов", 22);
        worker1_2_4.addProject(project1, 2.1);
        workers.add(worker1_2_4);
        Human worker1_2_5 = new Human("Евгения Иванова", 32);
        worker1_2_5.addProject(project1, 2.1);
        workers.add(worker1_2_5);
        worker1_2_1.getRoleInProjects().get(project1.getId()).setWorkers(Arrays.asList(worker1_2_4));
        worker1_2_2.getRoleInProjects().get(project1.getId()).setWorkers(Arrays.asList(worker1_2_3, worker1_2_5));
        //------------------------
        Human worker1_3_1 = new Human("Григорий Иванович", 28);
        worker1_3_1.addProject(project1, 3.0);
        workers.add(worker1_3_1);
        Human worker1_3_2 = new Human("Сергей Иванов", 28);
        worker1_3_2.addProject(project1, 3.1);
        workers.add(worker1_3_2);
        Human worker1_3_3 = new Human("Анатолий Петров", 30);
        worker1_3_3.addProject(project1, 3.1);
        workers.add(worker1_3_3);
        worker1_3_1.getRoleInProjects().get(project1.getId()).setWorkers(Arrays.asList(worker1_3_2, worker1_3_3));

        projects.add(project1);
//====================Attempt Number2=============================
        ISR1 project2 = new ISR1(2, "Snowing", 36);
        project1Manager1.addProject(project2, 0);
        //------------------------
        worker1_1_1.addProject(project2, 1.0);
        worker1_1_3.addProject(project2, 1.1);
        worker1_1_4.addProject(project2, 1.1);
        worker1_1_5.addProject(project2, 1.1);
        worker1_1_1.getRoleInProjects().get(project2.getId()).setWorkers(Arrays.asList(worker1_1_3, worker1_1_4, worker1_1_5));
        //------------------------
        worker1_2_3.addProject(project2, 2.0);
        worker1_2_4.addProject(project2, 2.1);
        worker1_2_5.addProject(project2, 2.1);
        worker1_2_3.getRoleInProjects().get(project2.getId()).setWorkers(Arrays.asList(worker1_2_4, worker1_2_5));
        //------------------------
        worker1_3_2.addProject(project2, 3.0);
        worker1_3_3.addProject(project2, 3.1);
        worker1_3_2.getRoleInProjects().get(project2.getId()).setWorkers(Arrays.asList(worker1_3_3));

        projects.add(project2);
    }

    @Test
    public void indTest() {
        Assertions.assertTrue(projects.get(0).getWorkers().containsValue(workers.get(3)));
        Assertions.assertFalse(projects.get(1).getWorkers().containsValue(workers.get(3)));

        Assertions.assertEquals(Arrays.asList(workers.get(0), workers.get(1)),
                findManagersProject(projects.get(0)));

        projects.get(0).workJSON();

        Human newWorker = new Human("Марк Де Блор", 28);
        newWorker.addProject(projects.get(0), 0);
        workers.add(newWorker);

        Assertions.assertNotEquals(Arrays.asList(workers.get(0), workers.get(1)),
                findManagersProject(projects.get(0)));
        Assertions.assertEquals(Arrays.asList(workers.get(0), workers.get(1), workers.get(15)),
                findManagersProject(projects.get(0)));

        Assertions.assertEquals(Stream.of(workers.get(2)).collect(Collectors.toSet()), workers.get(5).findTeamLeadsProject(projects));
//        workers.get(10).outInfoHuman(projects);
    }

    public List<Human> findManagersProject(@NotNull ISR1 project) {
        List<Human> res = new ArrayList<>();
        for (Human human : project.getWorkers().values()) {
            Role role = human.getRoleInProjects().get(project.getId());
            if (role.getCode() == 0) res.add(human);
        }
        return res;
    }
}