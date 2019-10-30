package com.company.task3;

public class Brain {
    public static void main(String[] args) {
        StudentClass studentClass = new StudentClass();         // Можем обращаться к методам в классе и интерфейсе.
        Student student = new StudentClass();                   // Можем обращаться только к методам в интерфейсе

        Student_diplomClass student_diplomClass = new Student_diplomClass();         // Можем обращаться к методам в классе и интерфейсе.
        Student_diplom student_diplom = new Student_diplomClass();                   // Можем обращаться только к методам в интерфейсе

        student.setID(0);
        student.setSurname("Петров");
        student.setName("Анатолий");
        student.setCourse(3);

        studentClass.setID(student.getID());
        studentClass.setSurname(student.getSurName());
        studentClass.setName(student.getName());
        studentClass.setCourse(student.getCourse());
        studentClass.outInfoStudent();

        System.out.println("\n");

        student_diplom.setID(3);
        student_diplom.setSurname("Серов");
        student_diplom.setName("Леонардо");
        student_diplom.setCourse(4);
        student_diplom.setThemeDiplom("Обработка чего-то да нужного");
        System.out.println("\n");

        student_diplomClass.setID(student_diplom.getID());
        student_diplomClass.setSurname(student_diplom.getSurName());
        student_diplomClass.setName(student_diplom.getName());
        student_diplomClass.setCourse(student_diplom.getCourse());
        student_diplomClass.setThemeDiplom(student_diplom.getThemeDiplom());
        student_diplomClass.outInfoStudentDiplom();
    }
}
