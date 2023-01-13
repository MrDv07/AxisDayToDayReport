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

}

class helperClass {
    Scanner sc = new Scanner(System.in);
    HashMap<Integer, Student1> map = new HashMap<>();
    Student1 stn = new Student1();

    public void addStudent(){
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
        while(map.containsKey(stn.rollno)){
            System.out.println("Roll is not Unique");
            System.out.println("Enter new rollno");
            stn.rollno = sc.nextInt();
        }
        map.put(stn.rollno , stn);
    }

    public void searchStudent(){

//        Student1 stn = new Student1();
        System.out.println("Enter the RollNo.");
        int n = sc.nextInt();
        if (map.containsKey(n)){
                System.out.println();
                System.out.println("Student Found");
                System.out.println("Student Name - " + stn.name);
                System.out.println("Student College Name - " + stn.college);
                System.out.println("Student Place Name - " + stn.place);
                System.out.println("Student Branch - " + stn.branch);
                System.out.println("Student Semester - " + stn.sem);
                System.out.println();
        }
        else {
            System.out.println("Student not found");
        }
//        boolean ds = false;
//        for (Map.Entry<Integer, Student1> i : map.entrySet()){
//            if ( n == i.getKey()){
//                ds = true;
//                System.out.println();
//                System.out.println("Student Found");
//                System.out.println("Student Name - " + i.getValue().name);
//                System.out.println("Student College Name - " + i.getValue().college);
//                System.out.println("Student Place Name - " + i.getValue().place);
//                System.out.println("Student Branch - " + i.getValue().branch);
//                System.out.println("Student Semester - " + i.getValue().sem);
//                System.out.println();
//            }
//            if (!ds){
//                System.out.println("Student Not Found");
//            }
//        }
    }

    public void updateStudent(){
        //Student1 stn3 = new Student1();
        System.out.println("Enter Student RollNo to Update");
        int w = sc.nextInt();
        if (map.containsKey(w)){
            map.replace(stn.rollno, stn);
        }
        else {
            System.out.println("RollNo not found");
        }
    }

    public void deleteStudent(){
        System.out.println("Enter The RollNo of the Student you want to delete");
        int o = sc.nextInt();
        map.remove(o);
        System.out.println("Deleted");
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
            System.out.println("Enter 4 to Update Student Details");
            System.out.println("Enter 5 to Exit");

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
                    dm.updateStudent();
                    break;

                case 5:
                    exit = false;
                    break;
            }
        }

    }
}
