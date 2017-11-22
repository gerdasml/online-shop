package my.group.onlineshop.goods.factory;

import my.group.onlineshop.goods.Goods;

import java.time.LocalDate;

public interface GoodsFactory {

    Goods makeDiscountGoods(String name, double discount, LocalDate dateUntilSaleEnds, double price, int quantity);
    Goods makeRegularGoods(String name, double rating, double price, int quantity);
}
