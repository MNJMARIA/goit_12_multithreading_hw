package task_2;

import java.util.concurrent.*;

public class FizzBuzzPrinter{
    private int n;
    private CopyOnWriteArrayList<String> list; // потокобезпечна черга
    ExecutorService executor;

    public FizzBuzzPrinter(int n) {
        this.n = n;
        this.list =  new CopyOnWriteArrayList<>();
        this.executor = Executors.newFixedThreadPool(4); // створили пул з 4 потоків
    }

    public void fizz(){
        for(int i = 1; i <= n; i++){
            if(i%3 == 0 && i%5 != 0){
                list.add("fizz");
            }
        }
    }
    public void buzz(){
        for(int i = 1; i <= n; i++){
            if(i%5 == 0 && i%3 != 0){
                list.add("buzz");
            }
        }
    }
    public void fizzbuzz(){
        for(int i = 1; i <= n; i++){
            if(i%15 == 0){
                list.add("fizzbuzz");
            }
        }
    }
    public void number(){
        for(int i = 1; i <= n; i++){
            if(i%5 != 0 && i%3 !=0){
                list.add(Integer.toString(i));
            }
        }
    }
    public void printQueue(){
        System.out.print(String.join(", ", list));
    }
}
