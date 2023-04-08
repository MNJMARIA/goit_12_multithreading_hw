package task_2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzzPrinter {
    private int n;
    BlockingQueue<String> queue = new LinkedBlockingQueue<>(); // потокобезпечна черга

    public FizzBuzzPrinter(int n) {
        this.n = n;
    }

    public void fizz(){
        for(int i = 1; i < n; i++){
            if(i%3 == 0){
                try{
                    queue.put("fizz");
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        }
    }
    public void buzz(){
        for(int i = 1; i < n; i++){
            if(i%5 == 0){
                try{
                    queue.put("buzz");
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        }
    }
    public void fizzbuzz(){
        for(int i = 1; i < n; i++){
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
        for(int i = 1; i < n; i++){
            if(i%5 != 0 && i%3 !=0){
                System.out.println(i);
            }
        }
    }
}
