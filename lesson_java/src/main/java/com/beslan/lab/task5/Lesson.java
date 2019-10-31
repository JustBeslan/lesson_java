package com.beslan.lab.task5;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

enum Subject{
    calculusOfVariations,
    Web,
    Delphi,
    Oracle,
    MathematicalMethodsOfInformationSecurity,
    ProgrammingOnJava,
    KnowledgeBase,
    FunctionProgramming,
    AccountingReportAutomation
};
class Human{
    String name;
}
class Educator extends Human{
    Educator(String name){
        this.name = name;
    }
}

class Student extends Human{
    private int id;
    private String department;
    Student(int id, String name, String department){
        this.id = id;
        this.name = name;
        this.department = department;
    }
}

class Group{
    Student[] students;
    int number_group;
}

class Lesson {
//    LocalDateTime localDateTime;
    LocalTime localTime;
    Group[] group;
    Subject subject;
    Educator educator;
    DayOfWeek dayOfWeek;
    int number;

//    Lesson(Subject subject, LocalDateTime localDateTime, Group[] group, Educator educator, int number) {
//        this.localDateTime = localDateTime;
//        this.group = group;
//        this.subject = subject;
//        this.educator = educator;
//        this.number = number;
//    }
    Lesson(Subject subject,DayOfWeek dayOfWeek, LocalTime localTime, Group[] group, Educator educator, int number) {
        this.localTime = localTime;
        this.dayOfWeek = dayOfWeek;
        this.group = group;
        this.subject = subject;
        this.educator = educator;
        this.number = number;
    }
}
