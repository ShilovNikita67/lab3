package ru.university.lab3;

import ru.university.lab3.collections.Task01CollectionsMethods;
import ru.university.lab3.maps.Task05SwapMap;
import ru.university.lab3.primes.PrimesGeneratorTest;
import ru.university.lab3.sets.Task03Sets;
import ru.university.lab3.words.Task04WordFrequency;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().runMenu();
    }

    private void runMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            printMenu();
            choice = readChoice(scanner);
            runTask(choice);
        } while (choice != 0);
    }

    private void printMenu() {
        System.out.println("""

                Лабораторная работа 3. Коллекции и компараторы
                1 - Методы Collections
                2 - Генератор простых чисел (Iterator)
                3 - Множества и сравнение объектов (Human)
                4 - Частота слов (HashMap)
                5 - Обмен ключей и значений (Map)
                6 - Выполнить все задания
                0 - Выход
                Ваш выбор:""");
    }


    private int readChoice(Scanner scanner) {
        if (!scanner.hasNext()) {
            return 0;
        }
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        scanner.next();
        return -1;
    }

    private void runTask(int choice) {
        switch (choice) {
            case 1 -> new Task01CollectionsMethods().run();
            case 2 -> new PrimesGeneratorTest().run();
            case 3 -> new Task03Sets().run();
            case 4 -> new Task04WordFrequency().run();
            case 5 -> new Task05SwapMap().run();
            case 6 -> runAll();
            case 0 -> System.out.println("Выход.");
            default -> System.out.println("Нет такого пункта меню.");
        }
    }

    private void runAll() {
        for (int task = 1; task <= 5; task++) {
            System.out.println("\nЗадание " + task );
            runTask(task);
        }
    }
}
