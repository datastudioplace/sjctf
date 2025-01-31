package com.demos.lambdaAndstreams.streamMethods.limit20;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.youtube.com/c/learnbybhanu https://www.udemy.com/javabybhanu
 * https://www.facebook.com/learnbybhanupratap/
 *
 * @author Bhanu Pratap Singh
 */
public class Example1 {

  public static void main(String[] args) {

    List<Integer> list = Arrays.asList(2, 4, 6, 8, 10);

    list.stream().limit(3).forEach(x -> System.out.println(x));
  }
}
