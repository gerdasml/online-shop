package my.group.onlineshop.user.service;

import my.group.onlineshop.goods.Goods;

public class SwedbankService implements BankService {
    @Override
    public Boolean buy(Goods goods) {
        System.out.println("The purchase was bought with Swedbank");
        return true;
    }
}
