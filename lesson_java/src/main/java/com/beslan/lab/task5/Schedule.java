package com.beslan.lab.task5;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

class Schedule extends WorkData {
    private int choose;
    private String name;
    private ArrayList<Lesson> scheduleStudent = new ArrayList<>();
    private ArrayList<Lesson> scheduleEducator = new ArrayList<>();

    public ArrayList<Lesson> getScheduleStudent(){return scheduleStudent;}
    public ArrayList<Lesson> getScheduleEducator(){return scheduleEducator;}

    public Schedule(int choose, String name) {
        this.choose = choose;
        this.name = name;
        getSchedule();
    }

    private void getSchedule() {
        WorkData workData = new WorkData();
        workData.createLesson();

        workData.addStudent(42, new Student(createID(), "Иван", "КИТ"));
        workData.addStudent(42, new Student(createID(), "Даниил", "КИТ"));
        workData.addStudent(42, new Student(createID(), "Беслан", "КИТ"));

        workData.addStudent(41, new Student(createID(), "Игорь", "КПМ"));
        workData.addStudent(41, new Student(createID(), "Денис", "КИТ"));
        workData.addStudent(41, new Student(createID(), "Александр", "КИТ"));

        if (choose == 1){
            Group groupStudent = find(workData.getGroups(), name);
            DayOfWeek dayOfWeek = null;
            for (Lesson lesson : workData.getLessons()) {
                if (dayOfWeek != lesson.getDayOfWeek()) System.out.println(lesson.getDayOfWeek() + "----");
                dayOfWeek = lesson.getDayOfWeek();
                if (Arrays.stream(lesson.getGroup()).anyMatch(group1 -> group1 == groupStudent)) {
                    LocalTime endLesson = lesson.getLocalTime().plusHours(1).plusMinutes(30);
                    scheduleStudent.add(lesson);
                    System.out.println("\t" + lesson.getNumber() + " ) " + lesson.getLocalTime() + " - " + endLesson);
                    System.out.println("\t\t" + lesson.getSubject() + "\n");
                }
            }
        }
        if (choose == 2){

            for (Lesson lesson : workData.getLessons())
                if (name.equals(lesson.getEducator().getName())) {
                    scheduleEducator.add(lesson);
                }
            System.out.println("\nEducator : "+name);
            for (Lesson lesson : scheduleEducator){
                System.out.println(lesson.getDayOfWeek());
                System.out.println("\tNumber Lesson : " + lesson.getNumber());
                System.out.println("\tName Lesson : " + lesson.getSubject());
                System.out.print("\tNumber Group : ");
                for (Group group : lesson.getGroup()) System.out.print(group.number_group + " ");
                System.out.println("\n"); }
        }
    }

    private Group find(Group[] groups, String name) {
        for (Group group : groups)
            for(Student student : group.students)
                if (student.getName().equals(name)) return group;
        return null;
    }
}
