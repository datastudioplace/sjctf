package com.demos.lambdaAndstreams.collectMethods.groupBy4.groupingBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.demos.lambdaAndstreams.streamMethods.Student;

/**
 * https://www.youtube.com/c/learnbybhanu https://www.udemy.com/javabybhanu
 * https://www.facebook.com/learnbybhanupratap/
 *
 * @author Bhanu Pratap Singh
 */
public class Example7 {
  /**
   * Important Note: Please watch video in sequence otherwise you will not understand because each
   * video required previous concept
   */
  public static void main(String[] args) {

    List<Student> items = getListOfStudents();

    Map<String, Long> counting =
        items.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));

    System.out.println(counting);

    System.out.println("--------");

    Map<String, Integer> sum =
        items.stream()
            .collect(
                Collectors.groupingBy(Student::getName, Collectors.summingInt(x -> x.getAge())));

    System.out.println(sum);
  }

  public static List<Student> getListOfStudents() {
    List<Student> list = new ArrayList<Student>();
    list.add(new Student("Test1", 40));
    list.add(new Student("Test5", 50));
    list.add(new Student("Test3", 30));
    list.add(new Student("Test2", 20));
    list.add(new Student("Test4", 10));
    list.add(new Student("Test4", 10));
    list.add(new Student("Test4", 10));
    return list;
  }
}
