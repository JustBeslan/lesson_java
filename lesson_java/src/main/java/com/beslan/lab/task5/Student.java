package com.beslan.lab.task5;

class Student extends Human {
    private int id;

    Student(int id, String name) {
        this.id = id;
        this.setName(name);
    }

    public int getId() {
        return id;
    }
}
