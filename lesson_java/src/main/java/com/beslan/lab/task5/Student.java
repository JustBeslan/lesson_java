package com.beslan.lab.task5;

class Student extends Human {
    private int id;
    private String department;

    Student(int id, String name, String department) {
        this.id = id;
        this.setName(name);
        this.department = department;
    }
}
