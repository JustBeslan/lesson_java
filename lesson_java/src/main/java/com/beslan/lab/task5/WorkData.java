package com.beslan.lab.task5;

import java.time.LocalTime;
import java.util.Arrays;
import static java.time.DayOfWeek.*;

class WorkData {
    private static Group[] groups = new Group[0];
    private static int idCounter = 0;
    private static Lesson[] lessons;

    static int createID(){return idCounter++;}
    static Lesson[] getLessons() {return lessons; }
    static Group[] getGroups() {return groups;}

    private static Group createGroup(int numberGroup, Student... students){
        Group group = new Group();
        group.number_group = numberGroup;
        group.students = students;

        Group[] groups1 = new Group[1];
        if (groups != null) groups1 = Arrays.copyOf(groups,groups.length+1);

        groups1[groups.length] = group;
        groups = groups1;
        return group;
    }

    public static void deleteGroup(int numberGroup){
        int i, j;
        for (i = j = 0; j < groups.length; ++j) if (groups[j].number_group != numberGroup) groups[i++] = groups[j];
        groups = Arrays.copyOf(groups, i);
    }

    static void addStudent(int numberGroup, Student student){
        Student[] students;
        for (Group group : groups){
            if (group.number_group == numberGroup){
                students = Arrays.copyOf(group.students,group.students.length+1);
                students[group.students.length] = student;
                group.students = students;
            }
        }
    }
    static void deleteStudent(String name){
        int i, j;
        for (Group group : groups) {
            for (i = j = 0; j < group.students.length; ++j) {
                if (group.students[j].name.equals(name)) {
                    Student[] n = new Student[group.students.length - 1];
                    System.arraycopy(group.students, 0, n, 0, j );
                    System.arraycopy(group.students, j+1, n, j, group.students.length - j-1);
                    group.students = n;
                }
            }
        }
    }
    static void createLesson(){
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
                new Lesson(Subject.calculusOfVariations,MONDAY,secondLessonTime,new Group[]{group42},lebedev,2),
                new Lesson(Subject.calculusOfVariations,MONDAY,thirdLessonTime,new Group[]{group41,group42},lebedev,3),
                new Lesson(Subject.Web,MONDAY,fourthLessonTime,new Group[]{group42},sinitsa,4),
                new Lesson(Subject.Web,MONDAY,fifthLessonTime,new Group[]{group42},sinitsa,5),

                new Lesson(Subject.Delphi,TUESDAY,firstLessonTime,new Group[]{group42},podkolzin,1),
                new Lesson(Subject.Delphi,TUESDAY,secondLessonTime,new Group[]{group42},podkolzin,2),
                new Lesson(Subject.Oracle,TUESDAY,thirdLessonTime,new Group[]{group41,group42},bessarabov,3),

                new Lesson(Subject.KnowledgeBase,WEDNESDAY,secondLessonTime,new Group[]{group42},lebedeva,2),
                new Lesson(Subject.MathematicalMethodsOfInformationSecurity,WEDNESDAY,thirdLessonTime,new Group[]{group42},osipyan,3),
                new Lesson(Subject.MathematicalMethodsOfInformationSecurity,WEDNESDAY,fourthLessonTime,new Group[]{group42},osipyan,4),

                new Lesson(Subject.ProgrammingOnJava,THURSDAY,firstLessonTime,new Group[]{group42},golovin,1),
                new Lesson(Subject.Oracle,THURSDAY,secondLessonTime,new Group[]{group42},zanin,2),
                new Lesson(Subject.ProgrammingOnJava,THURSDAY,thirdLessonTime,new Group[]{group41,group42},garkusha,3),
                new Lesson(Subject.KnowledgeBase,THURSDAY,fourthLessonTime,new Group[]{group41,group42},kostenko,4),

                new Lesson(Subject.FunctionProgramming,FRIDAY,thirdLessonTime,new Group[]{group42},sinitsa,3),
                new Lesson(Subject.AccountingReportAutomation,FRIDAY,fourthLessonTime,new Group[]{group41,group42},kesiyan,4),
                new Lesson(Subject.AccountingReportAutomation,FRIDAY,fifthLessonTime,new Group[]{group42},kesiyan,5),
                new Lesson(Subject.FunctionProgramming,FRIDAY,sixthLessonTime,new Group[]{group42},sinitsa,6),
        };
    }
}
