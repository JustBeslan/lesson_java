package com.beslan.ind.indiv1;

import com.google.gson.Gson;
import org.jetbrains.annotations.Contract;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ISR1 {
    private int id;
    private String name;
    private int numberDays;
    private Map<Integer, Human> workers = new HashMap<>();

    @Contract(pure = true)
    public ISR1(int id, String name, int numberDays) {
        this.id = id;
        this.name = name;
        this.numberDays = numberDays;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Human> getWorkers() {
        return workers;
    }

    public void setWorkers(Map<Integer, Human> workers) {
        this.workers = workers;
    }

    public void workJSON() {
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
            data1.getWorkers().values().forEach(n -> System.out.println(n.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
