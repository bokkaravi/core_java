package streamsPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintOddNumbers {
    public static void main(String[] args) {
        // printing odd numbers from the list
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//        numbers.stream().filter(num -> num % 2 == 1).forEach(System.out::println);

        List<String> courses = Arrays.asList("spring","spring boot","API","microservices","aws","azure","docker","kubernet");

        //print all the courses individually
//        courses.stream().forEach(System.out::println);
//
//        //print the cource whose contain spring
//        courses.stream().filter(course -> course.contains("spring")).forEach(System.out :: println);
//        // print the courses who's length is > 4
//        courses.stream().filter(cource -> cource.length() > 4).forEach(System.out::println);
//
//        // print the cube of odd numbers in given list of numbers
//        numbers.stream().filter(num -> num %2 == 1).map(num -> num * num * num).forEach(System.out::println);

        //print the number of characters in each word
        courses.stream().map(course -> course.length()).forEach(System.out :: println);


    }
}