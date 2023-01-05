package Manipal_practise;

import java.util.Scanner;

class bank{
    String name;
    int id;
    long phoneNumber;
    private final int totalFund = 1000000;
    private final float bankInterest = 5.5f;

Scanner scan = new Scanner(System.in);

//    public bank(String name, int id, long phoneNumber) {
//        this.name = name;
//        this.id = id;
//        this.phoneNumber = phoneNumber;
//    }

    public void checkLoan(){
        System.out.println("Enter the amount of Loan");
        int loan = scan.nextInt();
        if (loan <=totalFund){
            System.out.println("Loan is approved ");
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
        totalInterest();
        checkLoan();
    }

}

public class Day_7_task_1 {
    public static void main(String[] args) {

        var check = new bankBranch();
        check.loan();

    }
}
