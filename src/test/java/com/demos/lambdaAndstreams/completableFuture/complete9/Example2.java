package com.demos.lambdaAndstreams.completableFuture.complete9;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Example2 {

  static void testMethod() {

    StringBuilder result = new StringBuilder();

    List<String> messages = Arrays.asList("a", "b", "c");

    List<CompletableFuture<String>> futures =
        messages.stream()
            .map(msg -> CompletableFuture.completedFuture(msg).thenApplyAsync(String::toUpperCase))
            .collect(Collectors.toList());

    CompletableFuture<Void> allOf =
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
            .whenComplete(
                (v, th) -> {
                  futures.forEach(cf -> System.out.println(cf.getNow("valueIfAbsent")));
                  result.append("done");
                });

    allOf.join();
  }

  public static void main(String[] args) throws Exception {
    testMethod();
    System.out.println(Thread.currentThread());
  }
}
