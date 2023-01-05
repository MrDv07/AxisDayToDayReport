package Manipal_practise;

import java.util.Scanner;

class UserInfo {
    String name;
    private int userid;
    protected int age;
    String place;
    String companyname;
    private String position;

//    public UserInfo(String name, int userid, int age, String place, String companyname, String position) {  // Constructor
//        this.name = name;
//        this.userid = userid;
//        this.age = age;
//        this.place = place;
//        this.companyname = companyname;
//        this.position = position;
//    }


//    public void createUser(String name, int userid, int age, String place, String companyname, String position) {   //Parameterized Approach
//        this.name = name;
//        this.userid = userid;
//        this.age = age;
//        this.place = place;
//        this.companyname = companyname;
//        this.position = position;
//    }


    public void createUser(){       // Scanner Approach
        Scanner scan = new Scanner(System.in);


            System.out.println("Please Give your Details Below");
            System.out.println("Name");
            name = scan.nextLine();
            System.out.println("UserId");
            userid = scan.nextInt();
            System.out.println("Age");
            age = scan.nextInt();
            System.out.println("Company Name");
            companyname = scan.next();
            System.out.println("Postion Name");
            position = scan.next();
            System.out.println("Place");
            place = scan.next();

    }

    public void displayUser(){
        System.out.println("Name:-" + name);
        System.out.println("userID:-" + userid);
        System.out.println("Age:-" + age);
        System.out.println("Place:-" + place);
        System.out.println("Company:-" + companyname);
        System.out.println("Position:-" + position);

    }
}

public class Manipal_practise_playground{
    public static void main(String[] args) {

        var us =  new UserInfo();
        us.createUser();
        //System.out.println(us.age);
        us.displayUser();

    }
}