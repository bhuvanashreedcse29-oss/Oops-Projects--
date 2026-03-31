import java.io.*;
import java.util.*;
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Bank Name: ");
        String bankName = sc.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String accountName = sc.nextLine();
        System.out.print("Enter Account Balance: ");
        int balance = sc.nextInt();
        System.out.print("Enter Amount to Withdraw: ");
        int withdrawAmount = sc.nextInt();
        try {
            if (withdrawAmount <= 0) {
                throw new InsufficientBalanceException("Error: Invalid withdrawal amount.");
            }
            if (withdrawAmount > balance) {
                throw new InsufficientBalanceException("Error: Insufficient balance in account.");
            }
            if (withdrawAmount > 10000) {
                throw new InsufficientBalanceException("Error: Maximum withdrawal limit is 10000.");
            }
            balance = balance - withdrawAmount;
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + accountName);
            System.out.println("Amount withdrawn successfully.");
            System.out.println("Remaining Balance: " + balance);
        } 
        catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } 
        finally {
            System.out.println("Bank transaction completed.");
        }
    }
}