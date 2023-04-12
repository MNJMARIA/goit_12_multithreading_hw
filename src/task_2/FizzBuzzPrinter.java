package task_2;

import java.util.concurrent.*;

public class FizzBuzzPrinter{
    private int n;
    private BlockingQueue<String> queueA = new LinkedBlockingQueue<>();
    private BlockingQueue<String> queueB = new LinkedBlockingQueue<>();
    private BlockingQueue<String> queueC = new LinkedBlockingQueue<>();
    private BlockingQueue<String> queueD = new LinkedBlockingQueue<>();

    public FizzBuzzPrinter() {}
    public FizzBuzzPrinter(int n) {
        this.n = n;
    }

    public void fizz(){
        for(int i = 3; i <= n; i += 3){
            if(i%5 != 0){
                try{
                    queueA.put("fizz");
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        }
    }
    public void buzz() {
        for(int i = 5; i <= n; i += 5){
            if(i%3 != 0){
                try {
                    queueB.put("buzz");
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        }
    }
    public void fizzbuzz()  {
        for (int i = 15; i <= n; i += 15){
            try {
                queueC.put("fizzbuzz");
            }catch(InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void number()  {
        try {
            int i = 1;
            while (i <= n) {
                String result = null;
                if (i % 3 == 0 && i % 5 == 0) {
                    result = "fizzbuzz";
                } else if (i % 3 == 0) {
                    result = "fizz";
                } else if (i % 5 == 0) {
                    result = "buzz";
                } else {
                    result = Integer.toString(i);
                }
                if (!queueA.isEmpty() && result.equals(queueA.peek())) {
                    System.out.print(queueA.take() + " ");
                } else if (!queueB.isEmpty() && result.equals(queueB.peek())) {
                    System.out.print(queueB.take() + " ");
                } else if (!queueC.isEmpty() && result.equals(queueC.peek())) {
                    System.out.print(queueC.take() + " ");
                } else {
                    System.out.print(result + " ");
                }
                i++;
            }
        }catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
