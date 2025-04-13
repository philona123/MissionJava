package MiniProject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> studentRoll = new HashSet<>();
        HashMap<Integer, Student> studentRecord = new HashMap<>();

        System.out.println("Welcome to the Student Management App");
//        scanner.nextLine();

        while(true) {
            System.out.println("Choose your option.\n1. Add a student\n2. View all Student details\n3. Search a student by roll\n4. Remove a Student\n5.Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Enter RollNumber: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine();
                    if(studentRoll.contains(rollNumber)) {
                        System.out.println("Roll number already exists");
                        break;
                    }
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();

                    Student s = new Student(name, rollNumber, marks);
                    studentRecord.put(rollNumber, s);
                    studentRoll.add(rollNumber);
                    System.out.println("Student added successfully");
                    break;

                case 2:
                    System.out.println("----------------------- Student Details --------------");
                    if(studentRecord.isEmpty()) {
                        System.out.println("No Students found");
                    } else {
                        for(Student student : studentRecord.values()) {
                            System.out.println(student.getFullDetails());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter the rollNumber: ");
                    int searchKey = scanner.nextInt();
                    Student student = studentRecord.get(searchKey);
                    if(student != null) {
                        System.out.println("Found: "+student.getFullDetails());
                    } else {
                        System.out.println("Student with rollnumber "+searchKey+ " not found");
                    }
                    break;

                case 4:
                    System.out.print("Enter the rollNumber of the student to be removed: ");
                    int roll = scanner.nextInt();
                    if(studentRoll.contains(roll)) {
                        studentRoll.remove(roll);
                        studentRecord.remove(roll);
                        System.out.println("Student removed successfully");
                    } else {
                        System.out.println("Student not found");
                    }
                    break;

                case 5:
                    System.out.println("Thank you!! Bye");
                    System.exit(0);
                    scanner.close();

                default:
                    System.out.println("Invalid choice. Try again");

            }
        }
    }
}
