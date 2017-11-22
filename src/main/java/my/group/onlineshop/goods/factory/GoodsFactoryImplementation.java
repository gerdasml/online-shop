package my.group.onlineshop.goods.factory;

import my.group.onlineshop.goods.DiscountGoods;
import my.group.onlineshop.goods.Goods;
import my.group.onlineshop.goods.RegularGoods;

import java.time.LocalDate;

public class GoodsFactoryImplementation implements GoodsFactory {
    @Override
    public Goods makeDiscountGoods(String name, double discount, LocalDate dateUntilSaleEnds, double price, int quantity) {
        System.out.println("Discount goods are being made");
        return new DiscountGoods(name, price, quantity, discount, dateUntilSaleEnds);
    }

    @Override
    public Goods makeRegularGoods(String name, double rating, double price, int quantity) {
        System.out.println("Regular goods are being made");
        return new RegularGoods(name, price, quantity, rating);
    }
}
