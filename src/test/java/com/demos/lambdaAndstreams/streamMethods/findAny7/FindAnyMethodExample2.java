package com.demos.lambdaAndstreams.streamMethods.findAny7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * https://www.youtube.com/c/learnbybhanu https://www.udemy.com/javabybhanu
 * https://www.facebook.com/learnbybhanupratap/
 *
 * @author Bhanu Pratap Singh
 */
public class FindAnyMethodExample2 {

  Predicate<String> predicate = e -> e.startsWith("A");
  Consumer<Integer> consumer = a -> System.out.println(a);

  List<String> list = new ArrayList<String>();

  public static void main(String[] args) {

    FindAnyMethodExample2 example2 = new FindAnyMethodExample2();

    example2.add();
    System.out.println(example2.list);
    example2.print();
    example2.add_1();
    System.out.println(example2.list);
    example2.print();
  }

  void print() {

    String output = list.stream().filter(predicate).findAny().orElse("null");

    System.out.println(output);

    List<Integer> numList = Arrays.asList(201, 202, 203, 204);

    numList.stream().filter(n -> n % 2 == 0).findAny().ifPresent(e -> System.out.println(e));

    // numList.com.demos.lambdaAndstreams.stream().filter(n -> n % 2 == 0).findAny().ifPresent(consumer);

    // boolean isPresent = numList.com.demos.lambdaAndstreams.stream().filter(n -> n % 2 ==
    // 0).findAny().isPresent();
  }

  void add() {
    list.add("AA");
    list.add("CC");
    list.add("ADDDA");
  }

  void add_1() {
    list.add(0, "ADADDA");
  }
}
