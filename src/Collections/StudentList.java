package Collections;

import java.util.ArrayList;
import java.util.Scanner;

//Learning about ArrayList
public class StudentList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> students = new ArrayList<>();

        System.out.println("Enter the student names. Type 'done' to finish.");
        while(true) {
            String name = scanner.nextLine();
            if(name.equalsIgnoreCase("done")) break;;
            students.add(name);
        }

        System.out.println("------------------List of Students------------------");
        for(String s : students) {
            System.out.println(s);
        }
        scanner.close();
    }
}
