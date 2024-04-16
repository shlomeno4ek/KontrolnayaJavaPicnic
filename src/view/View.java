package view;

import controller.Controller;

import java.util.List;
import java.util.Scanner;

public class View {
    String file = "input.txt";
    List<String> fruits;
    Controller controller;
    public void run(){

        controller = new Controller();
        int command = 1;

        System.out.println("Вас приветствует вируальный пикник!");

        while (command != 0){
            command = menu();
            switch (command) {
                case 1 :
                    controller.LoadFile(file);
                    break;
                case 2 :
                    if (controller.isLoad()) {
                        controller.allFruitsAndVeget();
                    } else {
                        System.out.println("Файл не загружен!");
                    }
                    break;
                case 3 :
                    controller.theLongName();
                    break;


            }
        }

    }

    public int menu() {
        System.out.println("""
                Выберите действие:
                1. Загрузить из файла названия фруктов
                2. Подсчитать сколько фруктов и овощей всего:
                3. Найти самое длинное название
                4. Показать самые популярные фрукты и овощи:
                0. Выход""");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if (choice.matches("\\d+")) {
            return Integer.parseInt(choice);
        }
        return -1;
    }
}
