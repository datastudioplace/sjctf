package com.demos.lambdaAndstreams.collectMethods.averagingDouble1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.demos.lambdaAndstreams.streamMethods.Student;

/**
 * https://www.youtube.com/c/learnbybhanu https://www.udemy.com/javabybhanu
 * https://www.facebook.com/learnbybhanupratap/
 *
 * @author Bhanu Pratap Singh
 */
public class Examplae2 {

  /**
   * Important Note: Please watch video in sequence otherwise you will not understand because each
   * video required previous concept
   */
  public static void main(String[] args) {

    Double output =
        getListOfStudents().stream().collect(Collectors.averagingDouble(x -> x.getAge()));
    System.out.println(output);
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
