package combine;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CombineExample {

    public static void main(String[] args) {
        CompletableFuture<String> future = getUserEmail().thenCombine(getWeather(), (e,w) -> {
            System.out.println(" Sending email to: " + e + "with report - " + w);
            delay(1);
            return e + w;
        });
        System.out.println("Do Something!");
        delay(3);
        System.out.println(future.join());
    }

    public static CompletableFuture<String> getUserEmail(){
        return CompletableFuture.supplyAsync(()->{
            System.out.println(" getUserEmail() - " + Thread.currentThread().getName());
            delay(3);
            return "tech.recipe@yt.com";
        });
    }

    public static CompletableFuture<String> getWeather(){
        return CompletableFuture.supplyAsync(()->{
            System.out.println(" getWeather() - " + Thread.currentThread().getName());
            delay(3);
            return "Weater Report od city is - Rainy";
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
