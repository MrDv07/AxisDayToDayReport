package Manipal_practise;
import java.util.Scanner;


class student{
    String name;
    int age;
    String place;
    String college;
    String[] list = new String[10];
    int i = 0;
    boolean exit = true;
    Scanner sc = new Scanner(System.in);

    public void addStudent() {
        if (i < list.length) {

            System.out.println("Enter the Name:-");
            name = sc.next();
            System.out.println("Enter the Age:-");
            age = sc.nextInt();
            System.out.println("Enter the Place:-");
            place = sc.next();
            System.out.println("Enter the College Name:-");
            college = sc.next();

            list[i] = "Name:-" + name.toUpperCase() + " " + "Age:-" + age + " " + "Place:-" + place.toUpperCase() + " " + "College:-" + college.toUpperCase();
            i++;

        }
        else {
            System.out.println("No more seats Available");
        }
    }

    public void displayStudent(){
        System.out.println("Enter the Number of Index( 0-10 )to see the information you want :-");
        int e = sc.nextInt();
        System.out.println(list[e]);
    }

    public void Final(){
        while(exit) {
        System.out.println("What do you want to do:- To Add Student details press 0 , To Display the details of Students press 1 , To Exit press 2");
        int Input = sc.nextInt();

            switch (Input) {
                case 0:
                    addStudent();
                    break;
                case 1:
                    displayStudent();
                    break;
                case 2:
                    exit = false;
                    break;
            }
        }
    }
}

public class Day_9_Task_1 {
    public static void main(String[] args) {
        var std = new student();
        std.Final();
    }
}
