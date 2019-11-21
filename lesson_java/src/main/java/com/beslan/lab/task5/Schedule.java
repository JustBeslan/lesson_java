package com.beslan.lab.task5;

import java.util.ArrayList;
import java.util.List;

class Schedule {
    private List<Lesson> lessons;

    public Schedule(List<Lesson> lessons) {
        this.lessons = new ArrayList<>(lessons);
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public List<Lesson> findLessons(Student student) {
        List<Lesson> lessons1 = new ArrayList<>();
        for (Lesson lesson : lessons) {
            for (Student student1 : lesson.getGroup().getStudents()) {
                if (student1.getName().equals(student.getName()))
                    lessons1.add(lesson);
            }
        }
        return lessons1;
    }
}
