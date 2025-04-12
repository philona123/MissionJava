import java.util.Scanner;

class StudentDetails {
    protected String name;
    protected int marks;

    public StudentDetails(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public void evaluate() {
        if(marks >= 50) {
            System.out.println("Result: Pass");
        } else {
            System.out.println("Result: Fail");
        }
    }

    public void displayDetails() {
        System.out.println("Student: "+name+ ", Marks: "+marks);
    }
}

class UnderGraduate extends StudentDetails {
    public UnderGraduate(String name, int marks) {
        super(name, marks);
    }

    @Override
    public void evaluate() {
        if(marks >=40) {
            System.out.println("Result: Pass");
        } else {
            System.out.println("Result: Fail");
        }
    }
}

class PostGraduate extends StudentDetails {
    public PostGraduate(String name, int marks) {
        super(name, marks);
    }

    @Override
    public void evaluate() {
        if(marks >= 60) {
            System.out.println("Result: Pass");
        } else {
            System.out.println("Result: Fail");
        }
    }
}

public class StudentInheritance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDetails[] student = new StudentDetails[2];

        System.out.print("Enter UG Student name: ");
        String ugName = scanner.nextLine();

        System.out.println("Enter UG marks: ");
        int ugMarks = Integer.parseInt(scanner.nextLine());

        student[0] = new UnderGraduate(ugName, ugMarks);

        System.out.print("Enter PG Student name: ");
        String pgName = scanner.nextLine();

        System.out.println("Enter PG marks: ");
        int pgMarks = Integer.parseInt(scanner.nextLine());

        student[1] = new PostGraduate(pgName, pgMarks);
        for(StudentDetails s:student) {
            s.displayDetails();
            s.evaluate();
            System.out.println();
        }

        scanner.close();
    }
}
