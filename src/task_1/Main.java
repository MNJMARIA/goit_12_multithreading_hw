package task_1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    /*Завдання 1
    Напишіть програму, яка кожну секунду відображає на екрані
    дані про час, що минув від моменту запуску програми.
    Другий потік цієї ж програми кожні 5 секунд виводить
    повідомлення Минуло 5 секунд.*/
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private static long startTime = System.currentTimeMillis();
    public static void main(String[] args) {
        showHowMuchTimePassed();
        showMessageEveryFivePassedSeconds();

    }
    public static void showHowMuchTimePassed(){
        final Runnable printer = new Runnable(){
            public void run(){
                long currentTime = System.currentTimeMillis();

                System.out.println("Since the start of the program has passed: " + (currentTime - startTime)/1000 + " s");
            }
        };
        scheduler.scheduleAtFixedRate(printer, 0, 1, TimeUnit.SECONDS);
    }
    public static void showMessageEveryFivePassedSeconds(){
        final Runnable printer = new Runnable(){
            public void run(){
                System.out.println("Passed 5 seconds");
            }
        };
        scheduler.scheduleAtFixedRate(printer, 5, 5, TimeUnit.SECONDS);
    }
}
