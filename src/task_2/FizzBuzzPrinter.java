package task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FizzBuzzPrinter{
    private int n;
    private BlockingQueue<String> queue = new LinkedBlockingQueue<>();// потокобезпечна черга


    public FizzBuzzPrinter(int n) {
        this.n = n;
    }

    public void fizz(){
        for(int i = 3; i <= n; i += 3){
            if(i%5 != 0){
                try{
                    queue.put("fizz");
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        }
    }
    public void buzz(){
        for(int i = 5; i <= n; i += 5){
            if(i%3 != 0){
                try{
                    queue.put("buzz");
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        }
    }
    public void fizzbuzz(){
        for (int i = 15; i <= n; i += 15){
            try{
                queue.put("fizzbuzz");
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
    public void number() {
        for (int i = 1; i <= n; i++) {
            String str;
            try {
                str = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
            if (i % 3 != 0 && i % 5 != 0) {
                str = Integer.toString(i);
            }
            System.out.print(str + " ");
        }
    }
    /*public void printResultOfFizzBuzz(){
        List<String> list = new ArrayList<>();
        queue.drainTo(list);
        System.out.print(String.join(", ", list));
    }*/

}
