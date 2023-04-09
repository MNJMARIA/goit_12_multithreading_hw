package task_2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzzPrinter extends Thread{
    private int n;
    private BlockingQueue<String> queue; // потокобезпечна черга
    ExecutorService executor;

    public FizzBuzzPrinter(int n) {
        this.n = n;
        this.queue =  new LinkedBlockingQueue<>();
        this.executor = Executors.newFixedThreadPool(4); // створили пул з 4 потоків
    }

    public void fizz(){
        for(int i = 1; i <= n; i++){
            if(i%3 == 0 && i%5 != 0){
                try{
                    queue.put("fizz");
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        }
    }
    public void buzz(){
        for(int i = 1; i <= n; i++){
            if(i%5 == 0 && i%3 != 0){
                try{
                    queue.put("buzz");
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        }
    }
    public void fizzbuzz(){
        for(int i = 1; i <= n; i++){
            if(i%15 == 0){
                try{
                    queue.put("fizzbuzz");
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        }
    }
    public void number(){
        for(int i = 1; i <= n; i++){
            if(i%5 != 0 && i%3 !=0){
                try{
                    String num = String.valueOf(i);
                    queue.put(num);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
            executor.shutdown(); // Виконання потоків завершено
        }
    }
    public void printQueue(){
        while (!queue.isEmpty()) {
            try {
                System.out.print(queue.take() + " ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
