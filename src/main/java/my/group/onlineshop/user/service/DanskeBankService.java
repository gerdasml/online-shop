package my.group.onlineshop.user.service;

import my.group.onlineshop.goods.Goods;

public class DanskeBankService implements BankService {
    @Override
    public Boolean buy(Goods goods) {
        System.out.println("The purchase was bought with Danske bank");
        return true;
    }
}
