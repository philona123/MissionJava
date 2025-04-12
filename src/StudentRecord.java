import java.util.Scanner;

class Student {
    String name;
    int mark;

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    public void displayInfo() {
        System.out.println("Student Name: " + name + ", Marks: " + mark);
    }
}
public class StudentRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of Students: ");
        int n;
        try {
            n = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number. Exiting");
            return;
        }

        Student[] students = new Student[n];
        for(int i = 0; i<n;i++) {
            System.out.println("Enter Student "+(i+1)+ " Details");
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            int mark;
            while(true) {
                System.out.print("Enter Mark out of 100: ");
                try {
                    mark = Integer.parseInt(scanner.nextLine());
                    if(mark > 100) {
                        throw new IllegalArgumentException("Mark should be less than or equal to 100");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
                catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            students[i] = new Student(name, mark);
        }

        System.out.println("----------Student Record----------");
        for(Student s: students) {
            s.displayInfo();
        }
        scanner.close();
    }
}
