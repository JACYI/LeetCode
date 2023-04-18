package others;

class Bank{
    private long[] balance;
    private int n;
    public Bank(long[] balance) {
        this.balance = balance;
        this.n = balance.length;
    }
    //account序号是下标
    public boolean transfer(int account1, int account2, long money) {
        // 用户错误
        if(account1 < 0 || account1 > n)
            return false;
        if(account2 < 0 || account2 > n)
            return false;
        // 余额不足
        if(balance[account1-1] < money)
            return false;
        balance[account1-1] -= money;
        balance[account2-1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        // 用户错误
        if(account < 0 || account > n)
            return false;
        balance[account-1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        // 用户错误
        if(account < 0 || account > n)
            return false;
        // 余额不足
        if(balance[account-1] < money)
            return false;
        balance[account-1] -= money;
        return true;
    }
}

public class code2043 {
    public static void main(String[] args){

    }
}
