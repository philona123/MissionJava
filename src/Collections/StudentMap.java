package Collections;

import java.util.HashMap;
import java.util.HashSet;

public class StudentMap {
    public static void main(String[] args) {
        HashMap<Integer, String> studentIdNameMap = new HashMap<>();
        studentIdNameMap.put(101, "Philona");
        studentIdNameMap.put(102, "Saangu");
        studentIdNameMap.put(103, "Riya");
        studentIdNameMap.put(104, "Antony");

        System.out.println("-----------------Student List-------------------");
        for (int roll : studentIdNameMap.keySet()) {
            System.out.println("Roll number: "+roll+" ,Name: "+studentIdNameMap.get(roll));
        }
    }
}
