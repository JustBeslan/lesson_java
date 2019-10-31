package com.beslan.lab.task6;

import com.beslan.lab.task2.WordCounter;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FilesWordsCounter {
    private String pathDir;
    private Map<String,Integer> wordsStatistic;

    Map<String,Integer> getWordsStatistic(){return this.wordsStatistic;}

    FilesWordsCounter(String pathDir) throws IOException {
        this.pathDir = pathDir;
        this.wordsStatistic = Solution();
    }
    @NotNull
    private Map<String,Integer> Solution() throws IOException {
        Map<String,Integer> info = new HashMap<>();
        File folder = new File(pathDir);
        File[] listOfFiles = folder.listFiles();
        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());

                Stream<String> streamInfoFromFile = Files.lines(                                    // Получаем Stream из строк(читаем файл построчно в потоке).    lines(Path path , Charset charset(необязательно)).
                        Paths.get(pathDir+file.getName()));                                // Для создания экземпляра класса Path, используем статический метод get класса Paths, позволяющего создать путь из строки или URI.

//                streamInfoFromFile.forEach(System.out::println);                                    // Здесь используем метод forEach(делать для каждого) для полученного Stream<String>(потока строк из файла)

                ArrayList<String> infoFromFile = streamInfoFromFile.collect(Collectors.toCollection(ArrayList::new));
                for (String s : infoFromFile){
                    WordCounter wordCounter = new WordCounter(s);
                    info = joinLists(info,wordCounter.getWords_col());
                }
            }
        }
        return info;
    }
    private Map<String,Integer> joinLists(Map<String,Integer> map1,Map<String,Integer> map2){
        Map<String,Integer> mapResult = new HashMap<>();
        if (map1 == null || map2 == null){throw new NullPointerException("One of maps is null");}
        if (map1.isEmpty()) return map2;
        if (map2.isEmpty()) return map1;

        mapResult = map1;
        for(String s: map2.keySet()){
            int count = mapResult.getOrDefault(s, 0);
            mapResult.put(s,count+map2.get(s));
        }
        return mapResult;
    }
}
