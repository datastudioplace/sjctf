package com.demos.lambdaAndstreams.collectMethods.averagingDouble1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.youtube.com/c/learnbybhanu https://www.udemy.com/javabybhanu
 * https://www.facebook.com/learnbybhanupratap/
 *
 * @author Bhanu Pratap Singh
 */
public class Example1 {
  /**
   * Important Note: Please watch video in sequence otherwise you will not understand because each
   * video required previous concept
   */
  public static void main(String[] args) {

    List<Double> list = new ArrayList<Double>();
    for (int i = 0; i < 10; i++) {
      list.add(Double.valueOf(i));
    }

    Double output = list.stream().collect(Collectors.averagingDouble(x -> x));

    System.out.println(output);
  }
}
