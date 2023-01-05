package Manipal_practise;


import java.util.Scanner;

class college{
    String collegeName;
    int collegeId;
    String collegePlace;

    public college(String collegeName, int collegeId, String collegePlace) {
        this.collegeName = collegeName;
        this.collegeId = collegeId;
        this.collegePlace = collegePlace;
    }
}

class branch extends college{
    String branchName;
    int branchId;
    int branchTotalStaff;

    public branch(String collegeName, int collegeId, String collegePlace, String branchName, int branchId, int branchTotalStaff) {
        super(collegeName, collegeId, collegePlace);
        this.branchName = branchName;
        this.branchId = branchId;
        this.branchTotalStaff = branchTotalStaff;
    }
}

class student extends branch{
    String studentName;
    String studentPlace;
    int studentID;

Scanner scan = new Scanner(System.in);

    public student(String collegeName, int collegeId, String collegePlace, String branchName, int branchId, int branchTotalStaff, String studentName, String studentPlace, int studentID) {
        super(collegeName, collegeId, collegePlace, branchName, branchId, branchTotalStaff);
        this.studentName = studentName;
        this.studentPlace = studentPlace;
        this.studentID = studentID;
    }


    public void showStudentDetails(){
        //show all details (studentdetails + collegename + branchname)
       System.out.println("Student Name:-"+ " "+ studentName);
//        studentName = scan.next();
       System.out.println("Student Place:-" + " " + studentPlace );
//        studentPlace = scan.next();
        System.out.println("Student ID:-" + " "+ studentID);
//        studentID = scan.nextInt();
        System.out.println("College Name:-"+ " "+ collegeName);



    }
    public void showCollege(){
        // college details
        System.out.println("College Name:-"+ " "+ collegeName);
        System.out.println("College ID:-"+ " "+ collegeId);
        System.out.println("College Place:-"+ " "+ collegePlace);
    }
    public void showBranchDetails(){
        // branch details
        System.out.println("Branch Name:-"+ " "+ branchName);
        System.out.println("Branch ID:-"+ " "+ branchId);
        System.out.println("Branch Total Staff:-"+ " "+ branchTotalStaff);

    }
}
public class Day_7_task_2 {
    public static void main(String[] args) {
        var show = new student("Manipal", 1234, "Bangalore", "Civil", 151, 10 , "Dv", "Jbp", 9999);
        show.showStudentDetails();
        show.showCollege();
        show.showBranchDetails();
    }
}
