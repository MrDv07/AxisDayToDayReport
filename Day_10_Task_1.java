package Manipal_practise;

import java.util.Scanner;

class bank{
    String name;
    int id;
    long phoneNumber;
    private final long totalFund = 1000000;
    private final float bankInterest = 5.5f;
    long approved_loan_amount = 0;
    String[] userData = new String[2] ;
    int i = 0;
    boolean exit = true;

    Scanner scan = new Scanner(System.in);


    public void checkLoan(){
        System.out.println("Enter the amount of Loan");
        long loan = scan.nextLong();
        if (loan <=totalFund){
            approved_loan_amount = loan;
            System.out.println("Loan is approved ");
            System.out.println(approved_loan_amount);

        }
        else {
            System.out.println("Not approved");
        }
    }

    public void totalInterest(){
        System.out.println("Enter the Branch Interest Rate");
        float branchBankInterest = scan.nextFloat();
        float total = bankInterest + branchBankInterest;
        System.out.println("Total Interest=" +" " + total+"%");
    }
}


class bankBranch extends bank{
    String branchname;
    int branchid;
    long phoneNumber;
    private long branchBankTotalFund;
    private  float branchBankInterest;




    public void loan(){
        System.out.println("Enter Your Name");
        name = scan.next();
        System.out.println("Enter Your Id");
        id = scan.nextInt();
        System.out.println("Enter your Phone Number");
        phoneNumber = scan.nextLong();
        System.out.println("Enter Your branch name");
        branchname = scan.next();
        System.out.println("Enter your Branch ID");
        branchid = scan.nextInt();
        checkLoan();

    }

}

class userInfo extends bankBranch{
        public void addUserInfo(){
            loan();
            if(approved_loan_amount != 0){
                userData[i]= "Name:-" + name + "\n" + "User_ID:-" + id + "\n" + "User_PhoneNumber:-" + phoneNumber + "\n" + "User_Branch_Name:-" + branchname + "\n" + "User's_Branch_ID:-" + branchid + "\n" + "Approved loan to User:-"+ approved_loan_amount;
                i++;
            }
            else {
                System.out.println(" ");
            }


        }
        public void displayUser(){
            System.out.println("Enter the User_ID to see the Information about the User:-");
            int e = scan.nextInt();
            System.out.println(userData[e]);
        }
}

public class Day_10_Task_1 {
    public static void main(String[] args) {
        userInfo us = new userInfo();
            while (us.exit) {
                try {
                System.out.println(" To add User Info Press - 1 \n To Display User Info Press - 2 \n To Exit Press - 3");
                int input = us.scan.nextInt();

                switch (input) {

                    case 1:
                        us.addUserInfo();
                        break;

                    case 2:
                        us.displayUser();
                        break;

                    case 3:
                        us.exit = false;
                        break;

                    default:
                        System.out.println("Invalid Command");
                }
        }catch (IndexOutOfBoundsException e){
            System.out.println("Exceeded User Limit Cannot add more users");
        }
            }
    }
}
