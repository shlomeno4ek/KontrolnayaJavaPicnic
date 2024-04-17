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
                    controller.allFruitsAndVeget();
                    break;
                case 3 :
                    controller.theLongName();
                    break;
                case 4 :
                    controller.sortedFruits();
                    break;
                case 0 :
                    System.out.println("До свидания!");
                    break;
                default :
                    System.out.println("Такой команды не существует!");


            }
        }

    }

    public int menu() {
        System.out.println("""
                \nМеню:
                1. Загрузить из файла названия фруктов
                2. Подсчитать сколько фруктов и овощей всего:
                3. Найти самое длинное название
                4. Показать самые популярные фрукты и овощи:
                0. Выход""");
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВыберите действие: ");
        String choice = scanner.next();
        if (choice.matches("\\d+")) {
            return Integer.parseInt(choice);
        }
        return -1;
    }
}
