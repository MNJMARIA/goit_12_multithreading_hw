package task_2;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    /*Завдання 2
    Напишіть програму, що виводить в консоль рядок, що складається
    з чисел від 1 до n, але з заміною деяких значень:
    - якщо число ділиться на 3 - вивести fizz
    - якщо число ділиться на 5 - вивести buzz
    - якщо число ділиться на 3 і на 5 одночасно - вивести fizzbuzz
    Наприклад, для n = 15, очікується такий результат:
    1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz.

    Програма повинна бути багатопотоковою, і працювати з 4 потоками:
    Потік A викликає fizz(), щоб перевірити, чи ділиться число на 3,
    і якщо так - додати в чергу на виведення для потоку D рядок fizz.

    Потік B викликає buzz(), щоб перевірити, чи ділиться число на 5,
    і якщо так - додати в чергу на виведення для потоку D рядок buzz.

    Потік C викликає fizzbuzz(), щоб перевірити,
    чи ділиться число на 3 та 5 одночасно,
    і якщо так - додати в чергу на виведення для потоку D рядок fizzbuzz.

    Потік D викликає метод number(), щоб вивести наступне число з черги,
    якщо є таке число для виведення.*/
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number: ");
            int number = scanner.nextInt();

        FizzBuzzPrinter fizzBuzzPrinter = new FizzBuzzPrinter(number);
        ExecutorService executor = Executors.newFixedThreadPool(4);
        //Метод submit() додає задачу до черги пулу потоків і повертає майбутнє значення,
        // яке можна використовувати для отримання результату виконання задачі в майбутньому.
        // Додаємо задачі до черги пулу потоків

        executor.submit(() -> fizzBuzzPrinter.fizz());
        executor.submit(() -> fizzBuzzPrinter.buzz());
        executor.submit(() -> fizzBuzzPrinter.fizzbuzz());
        executor.submit(() -> fizzBuzzPrinter.number());


        // Викликаємо метод shutdown(), щоб зупинити пул потоків після того, як він виконає всі задачі
        executor.shutdown();
        //fizzBuzzPrinter.printResultOfFizzBuzz();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
