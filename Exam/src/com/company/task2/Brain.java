package com.company.task2;

public class Brain {
    public static void main(String[] args) {
        Student student = new Student();
        student.setId(0);
        student.setSurName("Петров");
        student.setName("Анатолий");
        student.setCourse(3);
        student.outInfoStudent();
        System.out.println("\n");

        Student_diplom student_diplom = new Student_diplom();
        student_diplom.setId(3);
        student_diplom.setSurName("Серов");
        student_diplom.setName("Леонардо");
        student_diplom.setCourse(4);
        student_diplom.setThemeDiplom("Обработка чего-то да нужного");
        student_diplom.outInfoStudentDiplom();
        System.out.println("\n");

        student_diplom.setThemeDiplom(student_diplom.getThemeDiplom() + " и еще что-нибудь, что я забыл. ОЙ!");
        student_diplom.outInfoStudentDiplom();
        System.out.println("\n");
    }
}
