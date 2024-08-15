public class Shinhan extends Bank {

    public Shinhan (String customer, String password, String phoneNumber,String account) {
        super(customer,password,phoneNumber,account);
    }

    @Override
    public Boolean deposit(int money) {
        int fee = (int) (money * 0.50);
        setBalance(getBalance()+(money-fee));
        return true;
    }
}
