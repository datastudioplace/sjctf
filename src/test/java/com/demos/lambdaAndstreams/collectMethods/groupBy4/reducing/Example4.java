package com.demos.lambdaAndstreams.collectMethods.groupBy4.reducing;

import java.util.stream.Stream;

public class Example4 {
  /**
   * Important Note: Please watch video in sequence otherwise you will not understand because each
   * video required previous concept
   */
  public static void main(String[] args) {

    Stream<Integer> s = Stream.of(5, 10, 20, 50);

    Integer i = s.reduce(1, (a, b) -> a * b);
    System.out.println(i);
  }
}
