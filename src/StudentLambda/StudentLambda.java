package StudentLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentLambda {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Philona", 1, 95),
                new Student("Saangu", 2, 88),
                new Student("Riya", 4, 90),
                new Student("Antony", 3, 77)
        );

        Predicate<Student> isTopper = s -> s.getMarks() > 80;
        System.out.println("Students with marks > 80:");
        students.stream().filter(isTopper).forEach(s -> s.getInfo());

        Consumer<Student> printUpperCase = s -> System.out.println(s.getName().toUpperCase());
        System.out.println("Student names in upper case");
        students.forEach(printUpperCase);

        Function<Student, String> getSummary = s -> s.getName() + " Scored "+s.getMarks();
        List<String> studentSummaries = students.stream().map(getSummary).collect(Collectors.toList());
        studentSummaries.forEach(System.out::println);

        Comparator<Student> sortMarksByDesc = (s1,s2) -> Double.compare(s2.getMarks(), s1.getMarks());
        System.out.println("Students sorted by marks high to low");
        students.stream().sorted(sortMarksByDesc).forEach(s -> s.getInfo());
    }
}
