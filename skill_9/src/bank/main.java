package bank;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    
    public synchronized void deposit(double amount) {
        System.out.println(Thread.currentThread().getName() + " is depositing " + amount);
        double newBalance = balance + amount;
        try {
            Thread.sleep(100); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance = newBalance;
        System.out.println(Thread.currentThread().getName() + " completed deposit. New balance: " + balance);
    }

    
    public synchronized void withdraw(double amount) {
        System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
        if (balance >= amount) {
            double newBalance = balance - amount;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance = newBalance;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal. New balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw, but insufficient balance.");
        }
    }

    
    public double getBalance() {
        return balance;
    }
}


class BankingTask implements Runnable {
    private BankAccount account;

    public BankingTask(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
       
        account.deposit(100);
        account.withdraw(50);
    }
}

public class main {
    public static void main (String[] args) {
        
        BankAccount account = new BankAccount(1000); 

       
        Thread t1 = new Thread(new BankingTask(account), "Thread 1");
        Thread t2 = new Thread(new BankingTask(account), "Thread 2");
        Thread t3 = new Thread(new BankingTask(account), "Thread 3");

        
        t1.start();
        t2.start();
        t3.start();

        
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       
        System.out.println("Final balance: " + account.getBalance());
    }
}
