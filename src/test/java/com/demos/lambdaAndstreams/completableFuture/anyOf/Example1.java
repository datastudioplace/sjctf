package com.demos.lambdaAndstreams.completableFuture.anyOf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example1 {

  public static void main(String[] args) throws InterruptedException, ExecutionException {

    ExecutorService executor = Executors.newFixedThreadPool(2);

    System.out.println("I am main thread");

    CompletableFuture<Integer> completableFuture =
        CompletableFuture.supplyAsync(
            () -> {
              sleep(1000);
              System.out.println("completableFuture Thread=" + Thread.currentThread().getName());
              return sum();
            },
            executor);

    CompletableFuture<Integer> completableFuture1 =
        CompletableFuture.supplyAsync(
            () -> {
              sleep(900);
              System.out.println("completableFuture Thread=" + Thread.currentThread().getName());
              return sum();
            },
            executor);

    CompletableFuture<Integer> completableFuture2 =
        CompletableFuture.supplyAsync(
            () -> {
              System.out.println("completableFuture Thread=" + Thread.currentThread().getName());
              return sum();
            },
            executor);

    @SuppressWarnings("unchecked")
    CompletableFuture<Integer>[] cfs =
        new CompletableFuture[] {
          completableFuture, completableFuture1, completableFuture1, completableFuture2
        };

    CompletableFuture<Object> anyCf = completableFuture2.anyOf(cfs);

    System.out.println("anyCf.get()=" + anyCf.get());

    System.out.println(anyCf.isDone());
  }

  public static int sum() {
    int sum = 0;
    for (int i = 0; i < 1000; i++) {
      sum = sum + i;
    }
    return sum;
  }

  static void sleep(long time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
