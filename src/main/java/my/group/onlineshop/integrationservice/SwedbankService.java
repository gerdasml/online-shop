package my.group.onlineshop.paymentsAndDeliveries.service.payment;

public class SwedbankService implements BankService {
    @Override
    public Boolean buy(Double price) {
        System.out.println("The purchase was bought with Swedbank");
        return true;
    }
}
