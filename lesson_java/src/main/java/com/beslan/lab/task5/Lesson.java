package com.beslan.lab.task5;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Lesson {
    private LocalTime localTime;
    private Group[] group;
    private Subject subject;
    private Educator educator;
    private DayOfWeek dayOfWeek;
    private int number;

    public Lesson(Subject subject, DayOfWeek dayOfWeek, LocalTime localTime, Group[] group, Educator educator, int number) {
        this.localTime = localTime;
        this.dayOfWeek = dayOfWeek;
        this.group = group;
        this.subject = subject;
        this.educator = educator;
        this.number = number;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Group[] getGroup() {
        return group;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public int getNumber() {
        return number;
    }

    public Subject getSubject() {
        return subject;
    }

    public Educator getEducator() {
        return educator;
    }

    public enum Subject {
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

}
