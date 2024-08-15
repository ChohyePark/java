public class Kookmin extends Bank {

    public Kookmin(String customer, String password, String phoneNumber, String account) {
        super(customer, password, phoneNumber, account);
    }

    @Override // 출금
    public boolean withdraw(int money) {
        int fee = (int) (money * 0.50);
        if (getBalance() >= (money + fee)) {
            setBalance(getBalance()-(money+fee));
            return true;
        } return false;
    }
}
