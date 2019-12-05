package com.beslan.lab.task5;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.List;
class Group {
    private int id;
    private List<Student> students;
    private String name_group;

    @Contract(pure = true)
    public Group(int id, List<Student> students, String name_group) {
        this.id = id;
        this.students = new ArrayList<>(students);
        this.name_group = name_group;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getId() {
        return id;
    }

    public String getName_group() {
        return name_group;
    }

    public void addStudent(Student student) {
        this.getStudents().add(student);
    }
}
