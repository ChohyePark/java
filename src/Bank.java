import java.util.Random;

public abstract class Bank {
    private String customer;
    private String account;
    private String phoneNumber;
    private String passWord;
    private int balance = 0;

    public Bank () {}
    public Bank (String customer, String passWord,String phoneNumber , String account) {
        this.customer = customer;
        this.phoneNumber = phoneNumber;
        this.account = account;
        this.passWord = passWord;
    }


    // 계좌 입금 함수
    public Boolean deposit (int money) {
        setBalance(this.balance+money);
        return true;
    }

    // 계좌 출금 함수
    public  boolean withdraw (int money) {
        if(money <= this.balance ) {
            this.balance = this.balance - money;
            return true;
        } else {
            return false;
        }
    }


    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
