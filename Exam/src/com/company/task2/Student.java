package com.company.task2;

public class Student {
    private String surName, name;
    private int course, id;

    public int getCourse() {
        return course;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void outInfoStudent(){
        System.out.println("ИД : " + this.id);
        System.out.println("Курс : " + this.course);
        System.out.println("Фамилия : " + this.surName);
        System.out.println("Имя : " + this.name);
    }
}
