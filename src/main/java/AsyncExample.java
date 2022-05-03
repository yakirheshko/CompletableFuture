import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class AsyncExample {

    public static void main(String[] args) {
        Runnable runnable = () -> {
          delay(1);
            System.out.println("I am in Runnable - " + Thread.currentThread().getName());

        };

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(runnable);

        System.out.println("I am in main - " + Thread.currentThread().getName());

        completableFuture.join();
    }

    public static void delay(int seconds)  {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
