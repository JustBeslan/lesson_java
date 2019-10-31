package com.beslan.lab.task5;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Schedule extends WorkData {
    private static int choose;
    private static String name;
    private static ArrayList<Lesson> scheduleStudent = new ArrayList<>();
    private static ArrayList<Lesson> scheduleEducator = new ArrayList<>();
//    private static Lesson[] lessons = WorkData.getLessons();

    public ArrayList<Lesson> getScheduleStudent(){return scheduleStudent;}
    public ArrayList<Lesson> getScheduleEducator(){return scheduleEducator;}

    Schedule(int choose, String name){
        this.choose = choose;
        this.name = name;
    }
    void get(){
        WorkData.createLesson();

        WorkData.addStudent(42, new Student(createID(),"Иван","КИТ"));
        WorkData.addStudent(42, new Student(createID(),"Даниил","КИТ"));
        WorkData.addStudent(42, new Student(createID(),"Беслан","КИТ"));

        WorkData.addStudent(41,new Student(createID(),"Игорь","КПМ"));
        WorkData.addStudent(41,new Student(createID(),"Денис","КИТ"));
        WorkData.addStudent(41,new Student(createID(),"Александр","КИТ"));

//        workData.deleteStudent("Даниил");

//        String name = "";
//        Scanner scannerInt = new Scanner(System.in);
//        Scanner scannerString = new Scanner(System.in);
//        System.out.print("1 - Студент, 2 - Преподаватель : ");
//        int choose = scannerInt.nextInt();
        if (choose == 1){
//            System.out.print("Введите имя студента : ");
//            name = scannerString.nextLine();


            Group groupStudent = find(WorkData.getGroups(),name);
            DayOfWeek dayOfWeek = null;
            for (Lesson lesson : getLessons()) {
                if (dayOfWeek != lesson.dayOfWeek) System.out.println(lesson.dayOfWeek+"----");
                dayOfWeek = lesson.dayOfWeek;
                if (Arrays.stream(lesson.group).anyMatch(group1 -> group1 == groupStudent)){
                    LocalTime endLesson = lesson.localTime.plusHours(1).plusMinutes(30);
                    scheduleStudent.add(lesson);
                    System.out.println("\t" + lesson.number +" ) " + lesson.localTime + " - " + endLesson);
                    System.out.println("\t\t"+lesson.subject + "\n");
                }
            }
        }
        if (choose == 2){
//            System.out.print("Введите имя преподавателя : ");
//            name = scannerString.nextLine();

            for (Lesson lesson : WorkData.getLessons())
                if (lesson.educator.name.equals(name))
                    scheduleEducator.add(lesson);

            System.out.println("\nEducator : "+name);
            for (Lesson lesson : scheduleEducator){
                System.out.println(lesson.dayOfWeek);
                System.out.println("\tNumber Lesson : "+lesson.number);
                System.out.println("\tName Lesson : "+lesson.subject);
                System.out.print("\tNumber Group : ");
                for (Group group : lesson.group) System.out.print(group.number_group + " ");
                System.out.println("\n"); }
        }
//        scannerInt.close();
//        scannerString.close();

////        System.out.println(THURSDAY.getValue());
////        System.out.println(SATURDAY.getValue());
////        System.out.println(MONDAY.getValue());
    }
    private static Group find(Group[] groups, String name){
        for (Group group : groups)
            for(Student student : group.students)
                if (student.name.equals(name)) return group;
        return null;
    }
}
