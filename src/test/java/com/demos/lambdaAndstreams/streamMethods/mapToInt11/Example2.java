package com.demos.lambdaAndstreams.streamMethods.mapToInt11;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import com.demos.lambdaAndstreams.streamMethods.Student;

/**
 * https://www.youtube.com/user/MrBhanupratap29/playlists? https://www.udemy.com/javabybhanu
 * https://www.facebook.com/learnbybhanupratap/
 *
 * @author Bhanu Pratap Singh
 */
public class Example2 {

  static ToIntFunction<Integer> toIntFunction = a -> a;

  public static void main(String[] args) {

    List<Student> list1 = Student.getListOfStudents();

    List<Student> list2 = Student.getListOfStudents();

    List<List<Student>> list = new ArrayList<List<Student>>();
    list.add(list1);
    list.add(list2);

    IntStream intData = list.stream().flatMapToInt(x -> x.stream().mapToInt(y -> y.getAge()));

    List<Integer> listData = intData.boxed().collect(Collectors.toList());

    System.out.println(listData);
  }
}
