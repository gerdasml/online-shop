package my.group.onlineshop.integrationservice;

public class SwedbankService implements BankService {
    @Override
    public Boolean buy(Double price) {
        System.out.println("The purchase was bought with Swedbank");
        return true;
    }
}
