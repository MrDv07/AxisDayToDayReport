package Manipal_practise;

import java.util.Scanner;

class bank{

    private static bank bankobj = new bank();

    private bank() {
    }

    public static bank getBankobj() {
        return bankobj;
    }

    public void bankStatus(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Time");
        int input = sc.nextInt();
        if (input > 9 && input < 18){
            System.out.println("Bank is Open");
        }
        else {
            System.out.println("Bank Close");
        }
    }
}

class checkBank{
    public static void main(String[] args) {
        bank obj = bank.getBankobj();
        obj.bankStatus();
    }
}
