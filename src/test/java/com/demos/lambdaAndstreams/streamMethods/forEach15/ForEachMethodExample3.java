package com.demos.lambdaAndstreams.streamMethods.forEach15;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import com.demos.lambdaAndstreams.streamMethods.Student;

/**
 * https://www.youtube.com/c/learnbybhanu https://www.udemy.com/javabybhanu
 * https://www.facebook.com/learnbybhanupratap/
 *
 * @author Bhanu Pratap Singh
 */
public class ForEachMethodExample3 {

  static Consumer<Student> consumer =
      s -> {
        if (s.getAge() == 10) {
          System.out.print(s.getName() + " ");
        }
      };

  public static void main(String[] args) {

    Student student = new Student();

    List<Student> list = new ArrayList<>();
    list.add(new Student("Test1", 10));
    list.add(new Student("Test2", 20));
    list.add(new Student("Test3", 30));

    list.forEach(consumer);

    System.out.println("-------");

    list.forEach(Student::getName);

    System.out.println("-------");

    list.forEach(student::printDeatils);

    System.out.println("-------");

    list.forEach(Student::printDeatils);
  }
}
