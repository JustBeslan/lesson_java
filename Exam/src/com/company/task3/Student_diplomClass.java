package com.company.task3;

public class Student_diplomClass extends StudentClass implements Student_diplom{
    private String themeDiplom;

    public void outInfoStudentDiplom(){
        outInfoStudent();
        System.out.println("Тема диплома : " + this.themeDiplom);
    }

    @Override
    public void setThemeDiplom(String themeDiplom) {
        this.themeDiplom = themeDiplom;
    }

    @Override
    public String getThemeDiplom() {
        return themeDiplom;
    }
}
