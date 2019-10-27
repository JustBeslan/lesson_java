package com.company.task2;

public class Student_diplom extends Student {
    String themeDiplom;

    public String getThemeDiplom() {
        return themeDiplom;
    }

    public void setThemeDiplom(String themeDiplom) {
        this.themeDiplom = themeDiplom;
    }
    public void outInfoStudentDiplom(){
        outInfoStudent();
        System.out.println("Тема диплома : " + this.themeDiplom);
    }
}
