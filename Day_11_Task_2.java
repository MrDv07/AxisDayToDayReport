package Manipal_practise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student1{
    String name;
    int rollno;
    String college;
    String place;
    String branch;
    int sem;
    String n;

}

class helperClass {
    Scanner sc = new Scanner(System.in);
    HashMap<Integer, Student1> map = new HashMap<>();

    public void addStudent(){
        Student1 stn = new Student1();
        System.out.println("Enter Student Name");
        stn.name = sc.next();
        System.out.println("Enter RollNo.");
        stn.rollno = sc.nextInt();
        System.out.println("Enter College Name");
        stn.college = sc.next();
        System.out.println("Enter Place Name");
        stn.place = sc.next();
        System.out.println("Enter Branch Name");
        stn.branch = sc.next();
        System.out.println("Enter Semester");
        stn.sem = sc.nextInt();

        map.put(stn.rollno , stn);
    }

    public void searchStudent(){

        System.out.println("Enter the RollNo.");
        int n = sc.nextInt();
        boolean ds = false;
        for (Map.Entry<Integer, Student1> i : map.entrySet()){
            if ( n == i.getKey()){
                ds = true;
                System.out.println();
                System.out.println("Student Found");
                System.out.println("Student Name - " + i.getValue().name);
                System.out.println("Student College Name - " + i.getValue().college);
                System.out.println("Student Place Name - " + i.getValue().place);
                System.out.println("Student Branch - " + i.getValue().branch);
                System.out.println("Student Semester - " + i.getValue().sem);
                System.out.println();
            }
            if (!ds){
                System.out.println("Student Not Found");
            }
        }
    }

    public void deleteStudent(){
        System.out.println("Enter The Rollno of the Student you want to delete");
        int o = sc.nextInt();
        map.remove(o);
    }
}

public class Day_11_Task_2 {
    public static void main(String[] args) {
        var dm = new helperClass();
        boolean exit = true;
        while(exit){
            System.out.println("Enter 1 to Add Student");
            System.out.println("Enter 2 to Search Student");
            System.out.println("Enter 3 to delete Student");
            System.out.println("Enter 4 to Exit");

            int t = dm.sc.nextInt();

            switch (t){

                case 1:
                    dm.addStudent();
                    break;

                case 2:
                    dm.searchStudent();
                    break;

                case 3:
                    dm.deleteStudent();
                    break;

                case 4:
                    exit = false;
                    break;
            }
        }

    }
}
