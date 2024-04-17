package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Controller {
    List<String> fruits;
    HashMap<String , Integer> hashFruits;

    private boolean isLoad = false;

    public void LoadFile(String fileName) {
        try (FileReader file=new FileReader(fileName)){
            fruits = new ArrayList<>();
            BufferedReader reader = new BufferedReader(file);
            String line;
            while ((line = reader.readLine()) != null){
                fruits.addAll(Arrays.asList(line.split("\\s+")));
            }
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
        isLoad = true;
        setHashFruits();
        System.out.println("Файл " + fileName + " загружен успешно!");
    }

    public boolean fileIsLoad() {
        if (!isLoad) {
            System.out.println("Файл не загружен!");
        }
        return isLoad;
    }

    public void allFruitsAndVeget() {
        if (fileIsLoad()) {
            System.out.println("Всего фруктов и овощей: " + fruits.size());
        }
    }

    public void setHashFruits() {
        hashFruits = new HashMap<>();
        for (String fruit : fruits) {
            if (!hashFruits.containsKey(fruit)) {
                hashFruits.put(fruit,1);
            } else {
                hashFruits.put(fruit, hashFruits.get(fruit) + 1);
            }
        }
    }

    public void theLongName () {
        if (fileIsLoad()) {
            String name = "";
            for (String fruit : hashFruits.keySet()) {
                if (fruit.length() > name.length()) {
                    name = fruit;
                }
            }
            System.out.println("Самое длинное название: " + name);
        }
    }

    public void sortedFruits() {
        if (fileIsLoad()) {
            hashFruits.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(System.out::println);
        }
    }
}
