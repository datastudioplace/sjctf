package com.demos.lambdaAndstreams.streamMethods.distinct5;

import com.demos.lambdaAndstreams.streamMethods.Student;

/**
 * https://www.youtube.com/c/learnbybhanu https://www.udemy.com/javabybhanu
 * https://www.facebook.com/learnbybhanupratap/
 *
 * @author Bhanu Pratap Singh
 */
public class Example2 {

  public static void main(String[] args) {

    Student.getListOfStudents()
        .forEach(
            x -> {
              System.out.println(x.getName() + " " + x.getAge());
            });

    System.out.println("----");
    Student.getListOfStudents().stream()
        .distinct()
        .forEach(
            x -> {
              System.out.println(x.getName() + " " + x.getAge());
            });
  }
}
