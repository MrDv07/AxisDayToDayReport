package Bank_Application_Axis_Training;

public interface ATM {
    Customer deposite(Customer customer);
    Customer withdraw(Customer customer);
    Customer checkBalance(Customer customer);
}
