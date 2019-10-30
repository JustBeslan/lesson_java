package com.beslan.lab.task5;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.time.DayOfWeek.*;

class schedule extends workData{
    public static void main(String[] args) {
        workData.createLesson();

        workData.addStudent(42, new Student(createID(),"Иван","КИТ"));
        workData.addStudent(42, new Student(createID(),"Даниил","КИТ"));
        workData.addStudent(42, new Student(createID(),"Беслан","КИТ"));

        workData.addStudent(41,new Student(createID(),"Игорь","КПМ"));
        workData.addStudent(41,new Student(createID(),"Денис","КИТ"));
        workData.addStudent(41,new Student(createID(),"Александр","КИТ"));

//        workData.deleteStudent("Даниил");

        String name = "";
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);
        System.out.print("1 - Студент, 2 - Преподаватель : ");
        int choose = scannerInt.nextInt();
        if (choose == 1){
            System.out.print("Введите имя студента : ");
            name = scannerString.nextLine();

            Group groupStudent = find(workData.getGroups(),name);
            ArrayList<Lesson> scheduleStudent = new ArrayList<>();
            DayOfWeek dayOfWeek = null;
            for (Lesson lesson : getLessons()) {
                if (dayOfWeek != lesson.dayOfWeek) System.out.println(lesson.dayOfWeek+"----");
                dayOfWeek = lesson.dayOfWeek;
                if (Arrays.stream(lesson.group).anyMatch(group1 -> group1 == groupStudent)){
                    scheduleStudent.add(lesson);
                    System.out.println("\t"+lesson.number +" ) "+lesson.subject);
                }
            }
        }
        if (choose == 2){
            System.out.print("Введите имя преподавателя : ");
            name = scannerString.nextLine();

            ArrayList<Lesson> scheduleEducator = new ArrayList<>();
            for (Lesson lesson : workData.getLessons())
                if (lesson.educator.name.equals(name))
                    scheduleEducator.add(lesson);

            System.out.println("\nEducator : "+name);
            for (Lesson lesson : scheduleEducator){
                System.out.println(lesson.dayOfWeek);
                System.out.println("\tNumber Lesson: "+lesson.number);
                System.out.println("\tName Lesson : "+lesson.subject);
                System.out.print("\tNumber Group : ");
                for (Group group : lesson.group) System.out.print(group.number_group + " ");
                System.out.println("\n"); }
        }
        scannerInt.close();
        scannerString.close();

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
