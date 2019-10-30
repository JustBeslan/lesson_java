package com.company.task3;

public class StudentClass implements Student {
    private String surName, name;
    private int course, id;

    public void outInfoStudent(){
        System.out.println("ИД : " + this.id);
        System.out.println("Курс : " + this.course);
        System.out.println("Фамилия : " + this.surName);
        System.out.println("Имя : " + this.name);
    }

    @Override
    public int getCourse() {
        return course;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurName() {
        return surName;
    }

    @Override
    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSurname(String surname) {
        this.surName = surname;
    }


}
