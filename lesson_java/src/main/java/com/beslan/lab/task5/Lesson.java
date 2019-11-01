package com.beslan.lab.task5;

import java.time.DayOfWeek;
import java.time.LocalTime;

enum Subject {
    calculusOfVariations,
    Web,
    Delphi,
    Oracle,
    MathematicalMethodsOfInformationSecurity,
    ProgrammingOnJava,
    KnowledgeBase,
    FunctionProgramming,
    AccountingReportAutomation
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
