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
            Thread threadA = new Thread(()->{
                fizzBuzzPrinter.fizz();
            });
            Thread threadB = new Thread(()->{
                fizzBuzzPrinter.buzz();
            });
            Thread threadC = new Thread(()->{
                fizzBuzzPrinter.fizzbuzz();
            });
            Thread threadD = new Thread(()->{
                fizzBuzzPrinter.number();
            });

            threadA.start();
            threadB.start();
            threadC.start();
            threadD.start();
            threadA.join();
            threadB.join();
            threadC.join();
            threadD.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //АБО
    /*
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number: ");
            int number = scanner.nextInt();

        FizzBuzzPrinter fizzBuzzPrinter = new FizzBuzzPrinter(number);
            Thread threadD = new Thread(()->{
                fizzBuzzPrinter.number();
            });
            threadD.start();
            threadD.interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}*/
}
