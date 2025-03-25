import java.util.*;
public class Bank {

    public static void main(String[] args) {
        // Initialize bank with given balance array
        Bank bank = new Bank(new long[]{10, 100, 20, 50, 30});

        // Perform transactions and print results
        System.out.println(bank.withdraw(3, 10));  // true
        System.out.println(bank.transfer(5, 1, 20)); // true
        System.out.println(bank.deposit(5, 20)); // true
        System.out.println(bank.transfer(3, 4, 15)); // false
        System.out.println(bank.withdraw(10, 50)); // false

        // Print final balances for verification
        System.out.println("Final Balances: " + Arrays.toString(bank.balance));
    }

    private long [] balance;
    int n;

    public Bank(long[] balance) {
        this.n=balance.length;
        this.balance=balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if((account1-1>=0 && account1-1<=n) && (account2-1>=0 && account2-1<=n)){
            System.out.println(balance[account1-1]);
            if(balance[account1-1]>=money) {

                balance[account2 - 1] += money;
                balance[account1 - 1] -= money;
                if (balance[account1 - 1] >= 0 && balance[account2 - 1] >= 0) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean deposit(int account, long money) {
        if(account-1>=0 && account-1<=n && money>=0){
            balance[account-1]+=money;
            return true;
        }
        return false;
    }

    public boolean withdraw(int account, long money) {
        if(account-1>=0 && account-1<=n){
            if(balance[account-1]>=money){
                balance[account-1]-=money;
                if(balance[account-1]>=0){
                    return true;
                }
            }
        }
        return false;
    }
}
