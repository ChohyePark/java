import java.util.Random;

public class KaKao extends Bank {

    public KaKao (String customer,String password,String phoneNumber,String account) {
        super(customer,phoneNumber,password,account);
    }

    @Override
    public int getBalance() {
        return (super.getBalance()/2);
    }
}
