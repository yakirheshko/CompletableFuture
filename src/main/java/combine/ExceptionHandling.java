package combine;

import java.util.concurrent.CompletableFuture;

public class ExceptionHandling {

    public static void main(String[] args) {
        //handle
        boolean error = false;
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
            if(error) throw new RuntimeException("Error@Future");
            return "success";
        }).handle((s,e) -> {
            if(e!=null){
                System.out.println(e.getMessage());
            }
            return s;
        });

        System.out.println(future.join());


        //exceptionally
        boolean errorException = true;
        CompletableFuture<String> futureException = CompletableFuture.supplyAsync(()->{
            if(errorException) throw new RuntimeException("Error@Future");
            return "success";
        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            return null;
        });

        System.out.println(future.join());
    }



}
