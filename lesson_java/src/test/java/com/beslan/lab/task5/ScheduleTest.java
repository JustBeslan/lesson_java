package com.beslan.lab.task5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ScheduleTest {
    private List<Student> students1 = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();
    private Schedule schedule;

    @BeforeEach
    public void createData() {
        Student studentAnna = new Student(1, "Анна");
        students1.add(studentAnna);
        Student studentIvan = new Student(1, "Иван");
        students1.add(studentIvan);

        Group groupOp1 = new Group(1, Collections.singletonList(studentAnna), "Оп1");
        groups.add(groupOp1);
        Group groupOp2 = new Group(2, Collections.singletonList(studentIvan), "Оп2");
        groups.add(groupOp2);

        Educator kostenko = new Educator(1, "Костенко");
        Educator sinitsa = new Educator(2, "Синица");
        Educator golovin = new Educator(3, "Головин");
        Educator lebedev = new Educator(4, "Лебедев");
        Educator lebedeva = new Educator(5, "Лебедева");
        Educator podkolzin = new Educator(6, "Подколзин");
        Educator bessarabov = new Educator(7, "Бессарабов");
        Educator osipyan = new Educator(8, "Осипян");
        Educator zanin = new Educator(9, "Занин");
        Educator garkusha = new Educator(10, "Гаркуша");
        Educator kesiyan = new Educator(11, "Кесиян");

        LocalTime firstLessonTime = LocalTime.of(8, 0, 0);
        LocalTime secondLessonTime = LocalTime.of(9, 40, 0);
        LocalTime thirdLessonTime = LocalTime.of(11, 30, 0);
        LocalTime forthLessonTime = LocalTime.of(13, 10, 0);
        LocalTime fifthLessonTime = LocalTime.of(15, 0, 0);

        schedule = new Schedule(Arrays.asList(
                new Lesson(Lesson.Subject.calculusOfVariations, DayOfWeek.MONDAY, secondLessonTime, groupOp1, lebedev, 2),
                new Lesson(Lesson.Subject.calculusOfVariations, DayOfWeek.MONDAY, thirdLessonTime, groupOp1, lebedev, 3),
                new Lesson(Lesson.Subject.Web, DayOfWeek.MONDAY, forthLessonTime, groupOp2, sinitsa, 4),
                new Lesson(Lesson.Subject.Web, DayOfWeek.MONDAY, fifthLessonTime, groupOp1, sinitsa, 5),

                new Lesson(Lesson.Subject.ProgrammingOnJava, DayOfWeek.THURSDAY, firstLessonTime, groupOp1, golovin, 1),
                new Lesson(Lesson.Subject.Oracle, DayOfWeek.THURSDAY, secondLessonTime, groupOp1, zanin, 2),
                new Lesson(Lesson.Subject.ProgrammingOnJava, DayOfWeek.THURSDAY, thirdLessonTime, groupOp2, garkusha, 3),
                new Lesson(Lesson.Subject.KnowledgeBase, DayOfWeek.THURSDAY, forthLessonTime, groupOp2, kostenko, 4)
        ));
    }

    @Test
    public void test() {
        Assertions.assertEquals(Arrays.asList(
                schedule.getLessons().get(0),
                schedule.getLessons().get(1),
                schedule.getLessons().get(3),
                schedule.getLessons().get(4),
                schedule.getLessons().get(5)
                ),
                schedule.findLessons(students1.get(0)));

        Assertions.assertEquals(Arrays.asList(
                schedule.getLessons().get(2),
                schedule.getLessons().get(6),
                schedule.getLessons().get(7)
                ),
                schedule.findLessons(students1.get(1)));

        Student studentKirill = new Student(2, "Кирилл");
        students1.add(studentKirill);
        Assertions.assertEquals(new ArrayList<>(), schedule.findLessons(studentKirill));

        groups.get(0).addStudent(studentKirill);
        Assertions.assertEquals(Arrays.asList(
                schedule.getLessons().get(0),
                schedule.getLessons().get(1),
                schedule.getLessons().get(3),
                schedule.getLessons().get(4),
                schedule.getLessons().get(5)
                ),
                schedule.findLessons(students1.get(2)));
    }
}
