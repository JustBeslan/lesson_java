package com.beslan.lab.task5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class scheduleTest {
    @Test
    void get() {
        Schedule schedule = new Schedule(1,"Беслан");
        schedule.get();
        Set<Lesson> set = new HashSet<>(schedule.getScheduleStudent());

        Set<DayOfWeek> dayOfWeeks = new HashSet<>();
        Set<Lesson.Subject> subjects = new HashSet<>();
        for (Lesson lesson : set){
            dayOfWeeks.add(lesson.dayOfWeek);
            subjects.add(lesson.subject);
        }

        Set<Lesson.Subject> subjects1 = new HashSet<>(Arrays.asList(Lesson.Subject.values()));
        Set<DayOfWeek> dayOfWeeks1 = new HashSet<>(Arrays.asList(DayOfWeek.values()).subList(0, DayOfWeek.values().length - 2));

        Assertions.assertEquals(set.size(),18);

        Assertions.assertEquals(dayOfWeeks.size(),5);
        Assertions.assertEquals(dayOfWeeks,dayOfWeeks1);

        Assertions.assertEquals(subjects.size(),9);
        Assertions.assertEquals(subjects,subjects1);
    }

    enum subject {}
}