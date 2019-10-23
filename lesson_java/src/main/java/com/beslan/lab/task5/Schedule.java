package com.beslan.lab.task5;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

import static java.time.DayOfWeek.*;

public class Schedule {
    public static void main(String[] args) {
        Group group42 = new Group();
        group42.number_group = 42;
        group42.students = new Student[]{
                new Student("Иван","КИТ"),
                new Student("Даниил","КИТ"),
                new Student("Беслан","КИТ")
        };

        Group group41 = new Group();
        group41.number_group = 41;
        group41.students = new Student[]{
                new Student("Игорь","КПМ"),
                new Student("Денис","КИТ"),
                new Student("Александр","КИТ")
        };

        Educator kostenko = new Educator("Костенко");
        Educator sinitsa = new Educator("Синица");
        Educator golovin = new Educator("Головин");
        Educator lebedev = new Educator("Лебедев");
        Educator lebedeva = new Educator("Лебедева");
        Educator podkolzin = new Educator("Подколзин");
        Educator bessarabov = new Educator("Бессарабов");
        Educator osipyan = new Educator("Осипян");
        Educator zanin = new Educator("Занин");
        Educator garkusha = new Educator("Гаркуша");
        Educator kesiyan = new Educator("Кесиян");

//        LocalDateTime calculusOfVariationsTime = LocalDateTime.of(2019, Month.OCTOBER,28,8,00,00);
//        LocalDateTime programmingJavaTime = LocalDateTime.of(2019, Month.OCTOBER,24,8,00,00);
//        LocalDateTime knoledgeBaseLectionTime = LocalDateTime.of(2019, Month.OCTOBER,24,13,10,00);
//        LocalDateTime functionProgrammingTime = LocalDateTime.of(2019, Month.OCTOBER,25,11,30,00);
//        Lesson[] lessons = new Lesson[]{
//                new Lesson(Subject.ProgrammingOnJava,programmingJavaTime,new Group[]{group42},golovin,1),
//                new Lesson(Subject.KnoledgeBase,knoledgeBaseLectionTime,new Group[]{group42},kostenko,4),
//                new Lesson(Subject.Web,functionProgrammingTime,new Group[]{group42},sinitsa,3),
//        };
        LocalTime firstLessonTime = LocalTime.of(8,0,0);
        LocalTime secondLessonTime = LocalTime.of(9,40,0);
        LocalTime thirdLessonTime = LocalTime.of(11,30,0);
        LocalTime fourthLessonTime = LocalTime.of(13,10,0);
        LocalTime fifthLessonTime = LocalTime.of(15,0,0);
        LocalTime sixthLessonTime = LocalTime.of(16,40,0);

        Lesson[] lessons = new Lesson[]{
                new Lesson(Subject.calculusOfVariations,MONDAY,secondLessonTime,new Group[]{group42},lebedev,2),
                new Lesson(Subject.calculusOfVariations,MONDAY,thirdLessonTime,new Group[]{group41,group42},lebedev,3),
                new Lesson(Subject.Web,MONDAY,fourthLessonTime,new Group[]{group42},sinitsa,4),
                new Lesson(Subject.Web,MONDAY,fifthLessonTime,new Group[]{group42},sinitsa,5),

                new Lesson(Subject.Delphi,TUESDAY,firstLessonTime,new Group[]{group42},podkolzin,1),
                new Lesson(Subject.Delphi,TUESDAY,secondLessonTime,new Group[]{group42},podkolzin,2),
                new Lesson(Subject.Oracle,TUESDAY,thirdLessonTime,new Group[]{group41,group42},bessarabov,3),

                new Lesson(Subject.KnowledgeBase,WEDNESDAY,secondLessonTime,new Group[]{group42},lebedeva,2),
                new Lesson(Subject.MathematicalMethodsOfInformationSecurity,WEDNESDAY,thirdLessonTime,new Group[]{group42},osipyan,3),
                new Lesson(Subject.MathematicalMethodsOfInformationSecurity,WEDNESDAY,fourthLessonTime,new Group[]{group42},osipyan,4),

                new Lesson(Subject.ProgrammingOnJava,THURSDAY,firstLessonTime,new Group[]{group42},golovin,1),
                new Lesson(Subject.Oracle,THURSDAY,secondLessonTime,new Group[]{group42},zanin,2),
                new Lesson(Subject.ProgrammingOnJava,THURSDAY,thirdLessonTime,new Group[]{group41,group42},garkusha,3),
                new Lesson(Subject.KnowledgeBase,THURSDAY,fourthLessonTime,new Group[]{group41,group42},kostenko,4),

                new Lesson(Subject.FunctionProgramming,FRIDAY,thirdLessonTime,new Group[]{group42},sinitsa,3),
                new Lesson(Subject.AccountingReportAutomation,FRIDAY,fourthLessonTime,new Group[]{group41,group42},kesiyan,4),
                new Lesson(Subject.AccountingReportAutomation,FRIDAY,fifthLessonTime,new Group[]{group42},kesiyan,5),
                new Lesson(Subject.FunctionProgramming,FRIDAY,sixthLessonTime,new Group[]{group42},sinitsa,6),
        };

//        System.out.println(THURSDAY.getValue());
//        System.out.println(SATURDAY.getValue());
//        System.out.println(MONDAY.getValue());

        String studentName = "Денис";
        Group groupStudent = find(new Group[]{group41,group42},studentName);
        if(groupStudent != null){
            System.out.println("Number Group : "+groupStudent.number_group);
            ArrayList<Lesson> scheduleStudent = new ArrayList<>();
            for (Lesson lesson : lessons) {
                if (Arrays.stream(lesson.group).anyMatch(group1 -> group1 == groupStudent)){
                    scheduleStudent.add(lesson);
                    System.out.println(lesson.dayOfWeek+"----"+lesson.subject);
                }
            }
        }
        System.out.println("\n");
        String educatorName = "Лебедев";
        ArrayList<Lesson> scheduleEducator = new ArrayList<>();
        for (Lesson lesson : lessons)
            if (lesson.educator.name.equals(educatorName))
                scheduleEducator.add(lesson);

        System.out.println(educatorName);
        for (Lesson lesson : scheduleEducator){
            System.out.println(lesson.dayOfWeek);
            System.out.println("Number Lesson: "+lesson.number);
            System.out.println("Name Lesson : "+lesson.subject);
            System.out.print("Number Group : ");
            for (Group group : lesson.group) System.out.print(group.number_group + " ");
            System.out.println("\n");
        }
    //        System.out.println(lessons1.get(0).subject);
    }
    private static Group find(Group[] groups, String name){
        for (Group group : groups)
            for(Student student : group.students)
                if (student.name.equals(name)) return group;
        return null;
    }
}
