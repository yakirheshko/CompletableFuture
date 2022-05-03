package combine;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class AnyAllOfExample {

    public static void main(String[] args) {
        //allOf
        /*CompletableFuture<Void> future = CompletableFuture.allOf(future1(),future2(),future3());
        future.join();*/

        //anyOf
        CompletableFuture<Object> future = CompletableFuture.anyOf(future1(),future2(),future3());
        System.out.println(future.join());
    }

    public static CompletableFuture<String> future1(){
        return CompletableFuture.supplyAsync(()->{
            System.out.println("future1 - " + Thread.currentThread().getName());
            delay(5);
            return "1";
        });
    }

    public static CompletableFuture<String> future2(){
        return CompletableFuture.supplyAsync(()->{
            System.out.println("future2 - " + Thread.currentThread().getName());
            delay(4);
            return "2";
        });
    }

    public static CompletableFuture<String> future3(){
        return CompletableFuture.supplyAsync(()->{
            System.out.println("future3 - " + Thread.currentThread().getName());
            delay(6);
            return "3";
        });
    }



    public static void delay(int seconds)  {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
