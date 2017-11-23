package my.group.onlineshop.paymentsAndDeliveries.service.payment;

public class DanskeBankService implements BankService {
    @Override
    public Boolean buy(Double price) {
        System.out.println("The purchase was bought with Danske bank");
        return true;
    }
}
