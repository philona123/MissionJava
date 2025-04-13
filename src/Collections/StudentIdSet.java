package Collections;

import java.util.HashSet;

public class StudentIdSet {
    public static void main(String[] args) {
        HashSet<Integer> studentIdSet = new HashSet<>();
        studentIdSet.add(100);
        studentIdSet.add(101);
        studentIdSet.add(102);
        studentIdSet.add(100); //Duplicate entry

        for(int id : studentIdSet) {
            System.out.println("Student ID " + id);
        }
    }
}
