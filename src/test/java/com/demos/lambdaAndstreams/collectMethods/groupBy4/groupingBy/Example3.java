package com.demos.lambdaAndstreams.collectMethods.groupBy4.groupingBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://www.youtube.com/c/learnbybhanu https://www.udemy.com/javabybhanu
 * https://www.facebook.com/learnbybhanupratap/
 *
 * @author Bhanu Pratap Singh
 */
public class Example3 {
  /**
   * Important Note: Please watch video in sequence otherwise you will not understand because each
   * video required previous concept
   */
  public static void main(String[] args) {

    Function<String, String> function = (a) -> a;

    List<String> list = new ArrayList<String>();
    list.add("Apple");
    list.add("Apple");
    list.add("Papaya");
    list.add("Banana");
    list.add("Orange");
    list.add("Orange");
    list.add("Orange");

    Map<String, Long> output =
        list.stream().collect(Collectors.groupingBy(function, Collectors.counting()));

    System.out.println(output);
  }
}
