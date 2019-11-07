package com.beslan.lab.task5;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;

class WorkData {
    private Group[] groups = new Group[0];
    private int idCounter = 0;
    private Lesson[] lessons;

    public int getIdCounter() {
        return idCounter;
    }

    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
    }

    int createID() {
        return idCounter++;
    }

    Lesson[] getLessons() {
        return lessons;
    }

    Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    public Group createGroup(int numberGroup, Student... students) {
        Group group = new Group();
        group.number_group = numberGroup;
        group.students = students;

        Group[] groups1 = new Group[1];
        if (groups != null) groups1 = Arrays.copyOf(groups,groups.length+1);

        groups1[groups.length] = group;
        groups = groups1;
        return group;
    }

    public void deleteGroup(int numberGroup) {
        int i, j;
        for (i = j = 0; j < groups.length; ++j) if (groups[j].number_group != numberGroup) groups[i++] = groups[j];
        groups = Arrays.copyOf(groups, i);
    }

    public void addStudent(int numberGroup, Student student) {
        Student[] students;
        for (Group group : groups){
            if (group.number_group == numberGroup){
                students = Arrays.copyOf(group.students,group.students.length+1);
                students[group.students.length] = student;
                group.students = students;
            }
        }
    }

    public void deleteStudent(String name) {
        int i, j;
        for (Group group : groups) {
            for (i = j = 0; j < group.students.length; ++j) {
                if (group.students[j].getName().equals(name)) {
                    Student[] n = new Student[group.students.length - 1];
                    System.arraycopy(group.students, 0, n, 0, j );
                    System.arraycopy(group.students, j+1, n, j, group.students.length - j-1);
                    group.students = n;
                }
            }
        }
    }

    public void createLesson() {
        Group group42 = createGroup(42);
        Group group41 = createGroup(41);

        Educator kostenko = new Educator("Костенко");
        Educator sinitsa = new Educator("Синица");
        Educator golovin = new Educator("Головин");
        Educator lebedev = new Educator("Лебедев");
        Educator lebedeva = new Educator("Лебедева");
        Educator podkolzin = new Educator("Подколзин");
        Educator bessarabov = new Educator("Бессарабов");
        Educator osipyan = new Educator("Осипян");
        Educator zanin = new Educator("Занин");
        Educator garkusha = new Educator("Гаркуша");
        Educator kesiyan = new Educator("Кесиян");

        LocalTime firstLessonTime = LocalTime.of(8,0,0);
        LocalTime secondLessonTime = LocalTime.of(9,40,0);
        LocalTime thirdLessonTime = LocalTime.of(11,30,0);
        LocalTime fourthLessonTime = LocalTime.of(13,10,0);
        LocalTime fifthLessonTime = LocalTime.of(15,0,0);
        LocalTime sixthLessonTime = LocalTime.of(16,40,0);

        lessons = new Lesson[]{
                new Lesson(Lesson.Subject.calculusOfVariations, DayOfWeek.MONDAY, secondLessonTime, new Group[]{group42}, lebedev, 2),
                new Lesson(Lesson.Subject.calculusOfVariations, DayOfWeek.MONDAY, thirdLessonTime, new Group[]{group41, group42}, lebedev, 3),
                new Lesson(Lesson.Subject.Web, DayOfWeek.MONDAY, fourthLessonTime, new Group[]{group42}, sinitsa, 4),
                new Lesson(Lesson.Subject.Web, DayOfWeek.MONDAY, fifthLessonTime, new Group[]{group42}, sinitsa, 5),

                new Lesson(Lesson.Subject.Delphi, DayOfWeek.TUESDAY, firstLessonTime, new Group[]{group42}, podkolzin, 1),
                new Lesson(Lesson.Subject.Delphi, DayOfWeek.TUESDAY, secondLessonTime, new Group[]{group42}, podkolzin, 2),
                new Lesson(Lesson.Subject.Oracle, DayOfWeek.TUESDAY, thirdLessonTime, new Group[]{group41, group42}, bessarabov, 3),

                new Lesson(Lesson.Subject.KnowledgeBase, DayOfWeek.WEDNESDAY, secondLessonTime, new Group[]{group42}, lebedeva, 2),
                new Lesson(Lesson.Subject.MathematicalMethodsOfInformationSecurity, DayOfWeek.WEDNESDAY, thirdLessonTime, new Group[]{group42}, osipyan, 3),
                new Lesson(Lesson.Subject.MathematicalMethodsOfInformationSecurity, DayOfWeek.WEDNESDAY, fourthLessonTime, new Group[]{group42}, osipyan, 4),

                new Lesson(Lesson.Subject.ProgrammingOnJava, DayOfWeek.THURSDAY, firstLessonTime, new Group[]{group42}, golovin, 1),
                new Lesson(Lesson.Subject.Oracle, DayOfWeek.THURSDAY, secondLessonTime, new Group[]{group42}, zanin, 2),
                new Lesson(Lesson.Subject.ProgrammingOnJava, DayOfWeek.THURSDAY, thirdLessonTime, new Group[]{group41, group42}, garkusha, 3),
                new Lesson(Lesson.Subject.KnowledgeBase, DayOfWeek.THURSDAY, fourthLessonTime, new Group[]{group41, group42}, kostenko, 4),

                new Lesson(Lesson.Subject.FunctionProgramming, DayOfWeek.FRIDAY, thirdLessonTime, new Group[]{group42}, sinitsa, 3),
                new Lesson(Lesson.Subject.AccountingReportAutomation, DayOfWeek.FRIDAY, fourthLessonTime, new Group[]{group41, group42}, kesiyan, 4),
                new Lesson(Lesson.Subject.AccountingReportAutomation, DayOfWeek.FRIDAY, fifthLessonTime, new Group[]{group42}, kesiyan, 5),
                new Lesson(Lesson.Subject.FunctionProgramming, DayOfWeek.FRIDAY, sixthLessonTime, new Group[]{group42}, sinitsa, 6),
        };
    }
}
