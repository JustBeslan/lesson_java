package com.beslan.ind.indiv1;

import com.google.gson.Gson;
import org.jetbrains.annotations.Contract;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ISR1 {
    private String name;
    private int numberDays;
    private Human projectManagers;
    private List<Department> departments;

    @Contract(pure = true)
    public ISR1(String name, int numberDays, List<Department> departments, Human projectManagers) {
        this.name = name;
        this.numberDays = numberDays;
        this.projectManagers = projectManagers;
        this.departments = departments;
    }

    public Human getProjectManagers() {
        return projectManagers;
    }

    public void setProjectManagers(Human projectManagers) {
        this.projectManagers = projectManagers;
    }

    public List<Human> findWorkersDepartment(Department department) {
        List<Human> workersDepartment = new ArrayList<>();
        for (Human human : department.getDepartmentLeadings()) {
            workersDepartment.add(human);
            workersDepartment.addAll(human.getWorkers());
        }
        return workersDepartment;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void inFromFile() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        try {
            // Запись в файл
            FileWriter writer = new FileWriter("src/main/resources/indJSON.txt", false);
            writer.write(json);
            writer.close();
            // Чтение из файла
            Stream<String> streamInfoFromFile = Files.lines(                                    // Получаем Stream из строк(читаем файл построчно в потоке).    lines(Path path , Charset charset(необязательно)).
                    Paths.get("src/main/resources/indJSON.txt"));                                // Для создания экземпляра класса Path, используем статический метод get класса Paths, позволяющего создать путь из строки или URI.
            String info = streamInfoFromFile.collect(Collectors.toCollection(ArrayList::new)).get(0);
            ISR1 data1 = gson.fromJson(info, ISR1.class);
            System.out.println("Project manager : " + data1.getProjectManagers().getNameSurname());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
