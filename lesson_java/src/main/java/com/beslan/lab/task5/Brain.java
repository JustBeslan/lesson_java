package com.beslan.lab.task5;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Brain {
    List<Student> students = new ArrayList<>();
    List<Group> groups = new ArrayList<>();
    List<Educator> educators = new ArrayList<>();
    Schedule schedule = new Schedule(new ArrayList<>());

    public static void main(String[] args) throws IOException {
        Brain mainMenu = new Brain();
        mainMenu.menu();
    }

    public void menu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Menu :");
        System.out.println("\tCreateStudent");
        System.out.println("\tDeleteStudent");
        System.out.println("\tCreateGroup");
        System.out.println("\tDeleteGroup");
        System.out.println("\tAddGroupStudent");
        System.out.println("\tAddEducator");
        System.out.println("\tDeleteEducator");
        System.out.println("\tAddLesson");
        System.out.println("\tShowGroup");
        System.out.println("\tShowLessons");
        System.out.println("\tLoadFromFile");
        System.out.println("\tWriteInFile");
        System.out.println("\tExit");
        System.out.println("Your choise : ");

        String action = scanner.nextLine();
        switch (action) {
            case "CreateStudent": {
                System.out.println("\tName : ");
                String name = scanner.nextLine();
                students.add(new Student(students.size() + 1, name));
                menu();
            }
            break;
            case "DeleteStudent": {
                System.out.println("\tName Student : ");
                String name = scanner.nextLine();
                groups.forEach(group -> {
                    group.deleteStudent(name);
                });
                students.forEach(student -> {
                    if (student.getName().equals(name))
                        students.remove(student);
                });
                menu();
            }
            break;
            case "CreateGroup": {
                System.out.println("\tName Group : ");
                String name = scanner.nextLine();
                groups.add(new Group(groups.size() + 1, new ArrayList<>(), name));
                menu();
            }
            break;
            case "DeleteGroup": {
                System.out.println("\tName Group : ");
                String name = scanner.nextLine();
                groups.forEach(group -> {
                    if (group.getName_group().equals(name)) {
                        groups.remove(group);
                        schedule.getLessons().forEach(lesson -> {
                            if (lesson.getGroup().getName_group().equals(name))
                                schedule.getLessons().remove(lesson);
                        });
                    }
                });
                menu();
            }
            break;
            case "AddGroupStudent": {
                System.out.println("\tInput name student which add : ");
                String name = scanner.nextLine();

                System.out.println("\tInput name group : ");
                String nameGroup = scanner.nextLine();

                groups.forEach(group -> {
                    if (group.getName_group().equals(nameGroup))
                        students.forEach(student -> {
                            if (student.getName().equals(name))
                                group.addStudent(student);
                        });
                });
                menu();
            }
            break;
            case "AddEducator": {
                System.out.println("\tInput name educator : ");
                String name = scanner.nextLine();
                educators.add(new Educator(educators.size() + 1, name));
                menu();
            }
            break;
            case "DeleteEducator": {
                System.out.println("\tInput name educator : ");
                String name = scanner.nextLine();
                educators.forEach(educator -> {
                    if (educator.getName().equals(name)) {
                        educators.remove(educator);
                        schedule.getLessons().forEach(lesson -> {
                            if (lesson.getEducator().getName().equals(name))
                                schedule.getLessons().remove(lesson);
                        });
                    }
                });
                menu();
            }
            break;
            case "AddLesson": {
                Lesson.Subject subject = null;
                DayOfWeek dayOfWeek = null;
                LocalTime localTime;
                Group group = null;
                Educator educator = null;

                System.out.println("\tnameLesson : ");
                String nameLesson = scanner.nextLine();
                for (Lesson.Subject subject1 : Lesson.Subject.values())
                    if (subject1.toString().equals(nameLesson)) subject = subject1;

                System.out.println("\tdayOfWeek : ");
                String day = scanner.nextLine();
                for (DayOfWeek dayOfWeek1 : DayOfWeek.values())
                    if (dayOfWeek1.toString().equals(day.toUpperCase())) dayOfWeek = dayOfWeek1;

                System.out.println("\tlocalTime (HH,MM,SS): ");
                String localTime1 = scanner.nextLine();
                String[] time = localTime1.split(",");
                localTime = LocalTime.of(Integer.parseInt(time[0]), Integer.parseInt(time[1]), Integer.parseInt(time[2]));

                System.out.println("\tnameGroup : ");
                String nameGroup = scanner.nextLine();
                for (Group group1 : groups)
                    if (group1.getName_group().equals(nameGroup)) group = group1;

                System.out.println("\tnameEducator : ");
                String nameEducator = scanner.nextLine();
                for (Educator educator1 : educators)
                    if (educator1.getName().equals(nameEducator)) educator = educator1;

                System.out.println("\tnumberLesson : ");
                int numberLesson = Integer.parseInt(scanner.nextLine());

                schedule.addLesson(new Lesson(subject, dayOfWeek, localTime, group, educator, numberLesson));
                menu();
            }
            break;
            case "ShowGroup": {
                System.out.println("\tInput name group : ");
                String nameGroup = scanner.nextLine();
                groups.forEach(group -> {
                    if (group.getName_group().equals(nameGroup)) {
                        System.out.println("ID group : " + group.getId());
                        System.out.println("Name group : " + group.getName_group());
                        group.getStudents().forEach(student -> System.out.println("Student : " + student.getName()));
                    }
                });
                menu();
            }
            break;
            case "ShowLessons": {
                schedule.getLessons().forEach(lesson -> {
                    System.out.println("Name : " + lesson.getSubject().toString());
                    System.out.println("Day : " + lesson.getDayOfWeek().toString());
                    System.out.println("Time : " + lesson.getLocalTime().toString());
                    System.out.println("Educator : " + lesson.getEducator().getName());
                    System.out.println("Group : " + lesson.getGroup().getName_group());
                    System.out.println("Number : " + lesson.getNumber());
                });
                menu();
            }
            break;
            case "LoadFromFile": {
                Schedule newSchedule = null;
                Gson gson = new Gson();
                try {
                    // Чтение из файла
                    Stream<String> streamInfoFromFile = Files.lines(                                    // Получаем Stream из строк(читаем файл построчно в потоке).    lines(Path path , Charset charset(необязательно)).
                            Paths.get("src/main/resources/ScheduleJSON.txt"));                                // Для создания экземпляра класса Path, используем статический метод get класса Paths, позволяющего создать путь из строки или URI.
                    String info = streamInfoFromFile.collect(Collectors.toCollection(ArrayList::new)).get(0);
                    newSchedule = gson.fromJson(info, Schedule.class);
                    schedule = newSchedule;
                    schedule.getLessons().forEach(lesson -> {
                        educators.add(lesson.getEducator());
                        groups.add(lesson.getGroup());
                        students.addAll(lesson.getGroup().getStudents());
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
                menu();
            }
            break;
            case "WriteInFile": {
                Gson gson = new Gson();
                String json = gson.toJson(schedule);
                try {
                    // Запись в файл
                    FileWriter writer = new FileWriter("src/main/resources/ScheduleJSON.txt", false);
                    writer.write(json);
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                menu();
            }
            break;
            case "Exit":
                System.exit(0);
            default: {
                System.out.println("Such command is not exist. Try again");
                menu();
            }
            break;
        }
    }
}
