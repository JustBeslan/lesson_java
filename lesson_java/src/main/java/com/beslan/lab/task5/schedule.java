package com.beslan.lab.task5;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.time.DayOfWeek.*;

public class schedule{
    public static void main(String[] args) {
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);
        System.out.print("1 - Студент, 2 - Преподаватель : ");
        int choose = scannerInt.nextInt();
        if (choose == 1){
            System.out.print("Введите имя студента : ");
            String name = scannerString.nextLine();
        }
        if (choose == 2){
            System.out.print("Введите имя преподавателя : ");
            String name = scannerString.nextLine();
        }
        scannerInt.close();
        scannerString.close();
//
////        System.out.println(THURSDAY.getValue());
////        System.out.println(SATURDAY.getValue());
////        System.out.println(MONDAY.getValue());
//
//        String studentName = "Денис";
//        Group groupStudent = find(groups,studentName);
//        if(groupStudent != null){
//            System.out.println("Number Group : "+groupStudent.number_group);
//            ArrayList<Lesson> scheduleStudent = new ArrayList<>();
//            for (Lesson lesson : lessons) {
//                if (Arrays.stream(lesson.group).anyMatch(group1 -> group1 == groupStudent)){
//                    scheduleStudent.add(lesson);
//                    System.out.println(lesson.dayOfWeek+"----"+lesson.subject);
//                }
//            }
//        }
//        System.out.println("\n");
//        String educatorName = "Лебедев";
//        ArrayList<Lesson> scheduleEducator = new ArrayList<>();
//        for (Lesson lesson : lessons)
//            if (lesson.educator.name.equals(educatorName))
//                scheduleEducator.add(lesson);
//
//        System.out.println(educatorName);
//        for (Lesson lesson : scheduleEducator){
//            System.out.println(lesson.dayOfWeek);
//            System.out.println("Number Lesson: "+lesson.number);
//            System.out.println("Name Lesson : "+lesson.subject);
//            System.out.print("Number Group : ");
//            for (Group group : lesson.group) System.out.print(group.number_group + " ");
//            System.out.println("\n");
//        }
    }
    private static Group find(Group[] groups, String name){
        for (Group group : groups)
            for(Student student : group.students)
                if (student.name.equals(name)) return group;
        return null;
    }
}
