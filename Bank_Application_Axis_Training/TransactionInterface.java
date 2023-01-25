package Bank_Application_Axis_Training;

import java.util.Date;

public interface TransactionInterface {
    void addTransaction( String transactionType, float transactionAmount, float currentBalance);
}
