package Bank_Application_Axis_Training;
import java.util.*;

class bank implements BankInterface{
    Scanner sc = new Scanner(System.in);
    final String name = "Axis";
    final String bankCode = "Axis0761";
    final String address = "Napier Town Road , Jabalpur , (M.P) ";
    HashMap <Long , Customer> map = new HashMap<Long, Customer>();
    
    @Override
    public void getAccount() {
        for (Customer value : map.values()) {
            System.out.println((Customer)value);
        }

    }
}

class Customer implements CustomerInterface{
    String custName ;
    int custid;
    String custemail;
    int custpassword;
    long custcardNo;
    long custPhoneNumber;
    String custAddress;
    public Account account;


    @Override
    public void addCustomer() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter CustomerID");
        custid = sc.nextInt();
        System.out.println("Customer Name ");
       custName = sc.next();
        System.out.println("Customer Email");
        custemail = sc.next();
        System.out.println("Customer CardNo");
        custcardNo = sc.nextLong();
        System.out.println("Customer Pin");
        custpassword = sc.nextInt();
        System.out.println("Customer Phone Number");
        custPhoneNumber = sc.nextLong();
        System.out.println("Customer Address");
        custAddress = sc.next();
        this.account = new Account().addAccount();

    }
}

class Account implements AccountInterface{
    ArrayList<Transactions> transac = new ArrayList<>();
    long accountNumber;
    long currentBankBalance;
    String accountType;
    Customer cust = new Customer();
    @Override
    public Account addAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Account No");
        accountNumber = sc.nextLong();
        System.out.println("Enter Account Balance");
        currentBankBalance = sc.nextLong();
        System.out.println("Enter Account type");
        accountType = sc.next();
        return this ;
    }


    public void transactionhist(){
        for (Transactions obj: transac) {
            System.out.println(obj.transactionDate);
            System.out.println(obj.transactionType);
            System.out.println(obj.transactionAmount);
            System.out.println(obj.currentBalance);
            System.out.println("--------------------");
        }
    }
}

class Transactions implements  TransactionInterface{
    int transactionID;
    Date transactionDate ;
    String transactionType;
    float transactionAmount;
    float currentBalance;


    @Override
    public void addTransaction( String transactionType, float transactionAmount, float currentBalance) {
        this.transactionDate = new Date();
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.currentBalance = currentBalance;
    }

}

class atm_class implements ATM{

    @Override
    public Customer deposite(Customer customer) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Amount you Want to Deposite:- ");
        int deposite1 = sc.nextInt();
        customer.account.currentBankBalance += deposite1;
        System.out.println(customer.account.currentBankBalance);
        Transactions tc = new Transactions();
        tc.addTransaction("Deposite" ,deposite1 ,customer.account.currentBankBalance );
        customer.account.transac.add(tc);
        return customer;
    }

    @Override
    public Customer withdraw(Customer customer) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Card Number:-");
        long cn = sc.nextLong();
        System.out.println("Enter Your Pin:-");
        int pw = sc.nextInt();

        if ( cn == customer.custcardNo && pw == customer.custpassword) {
            System.out.println("Enter the Amount you Want to Withdraw:- ");
            int withdraw1 = sc.nextInt();

            if (withdraw1 < customer.account.currentBankBalance && customer.account.currentBankBalance - withdraw1 > 10000) {
                System.out.println("Collect Your Amount");
                customer.account.currentBankBalance -= withdraw1;
                System.out.println(customer.account.currentBankBalance);
                Transactions tc = new Transactions();
                tc.addTransaction("Withdraw", withdraw1, customer.account.currentBankBalance);
                customer.account.transac.add(tc);
            }
            else {
                System.out.println("You Don't have enough balance to Withdraw");
            }
        }
        else {
            System.out.println("Wrong Credentials");
        }
        return customer;
    }

    @Override
    public Customer checkBalance(Customer customer) {
        System.out.println("Your Current Account Balance is:- " + customer.account.currentBankBalance);
        Transactions tc = new Transactions();
        tc.addTransaction("Check Balance", 0, customer.account.currentBankBalance);
        customer.account.transac.add(tc);
        return customer;
    }
}

public class Bank_App {
    bank bankobj = new bank();
    public static void main(String[] args) {
        Bank_App bankap = new Bank_App();
        boolean exit = true;
        Scanner sc = new Scanner(System.in);

        while(exit){
            System.out.println("Press 1 to Add Customer");
            System.out.println("Press 2 to Search the Account Information");
            System.out.println("Press 3 to Deposit");
            System.out.println("Press 4 to Withdraw");
            System.out.println("Press 5 to CheckBalance");
            System.out.println("Press 6 to Transaction History");
            System.out.println("Press 7 to Remove Customer");
            System.out.println("Press 8 to Exit");
            int input = sc.nextInt();

            switch (input){

                case 1:
                    Customer customer = new Customer();
                    customer.addCustomer();
                    bankap.bankobj.map.put(customer.account.accountNumber , customer);
                    break;

                case 2:
                    System.out.println("Enter the Account Number to view Information");
                    long n = sc.nextLong();
                    if (bankap.bankobj.map.containsKey(n)){
                        bankap.bankobj.map.get(n);
                        System.out.println(bankap.bankobj.map.get(n).custName);
                    }
                    else {
                        System.out.println("Account does not exist");
                    }

                    break;

                case 3:
                    System.out.println("Enter the your Account Number");
                    long dp1 = sc.nextLong();

                    if (bankap.bankobj.map.containsKey(dp1)){
                        ATM atm2 = new atm_class();
                        bankap.bankobj.map.put(dp1 ,atm2.deposite(bankap.bankobj.map.get(dp1)));
                    }
                    else {
                        System.out.println("Account Number not found!!");
                    }
                    break;

                case 4:
                    System.out.println("Enter the your Account Number");
                    long dp2 = sc.nextLong();

                    if (bankap.bankobj.map.containsKey(dp2)){
                        ATM atm2 = new atm_class();
                        bankap.bankobj.map.put(dp2 ,atm2.withdraw(bankap.bankobj.map.get(dp2)));
                    }
                    break;

                case 5:
                    System.out.println("Enter Account Number to Check Balance:-");
                    long t = sc.nextLong();
                    if (bankap.bankobj.map.containsKey(t)){
                        ATM atm3 = new atm_class();
                        bankap.bankobj.map.replace(t , atm3.checkBalance(bankap.bankobj.map.get(t)));
                    }
                    break;

                case 6:
                    System.out.println("Enter Account Number to Check Balance:-");
                    long p = sc.nextLong();
                    if (bankap.bankobj.map.containsKey(p)){
                        bankap.bankobj.map.get(p).account.transactionhist();
                    }
                    break;

                case 7:
                    System.out.println("Enter Acoount number");
                    long w = sc.nextLong();
                    if (bankap.bankobj.map.containsKey(w)) {
                        bankap.bankobj.map.remove(w);
                        System.out.println("Deleted");
                    }
                    else {
                        System.out.println("Not Available");
                    }
                    break;

                case 8:
                    exit = false;
                    break;


                default:
                    System.out.println("Wrong Choice");
            }
        }
    }
}
