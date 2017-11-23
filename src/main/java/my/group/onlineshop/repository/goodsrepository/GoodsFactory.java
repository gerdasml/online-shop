package my.group.onlineshop.repository.goodsrepository;

import my.group.onlineshop.domain.goods.Goods;

import java.time.LocalDate;

public interface GoodsFactory {

    Goods makeDiscountGoods(String name, Double discount, LocalDate dateUntilSaleEnds, double price, int quantity);
    Goods makeRegularGoods(String name, Double rating, double price, int quantity);
    Goods makeDiscountGoods(int id, String name, Double discount, LocalDate dateUntilSaleEnds, double price, int quantity);
    Goods makeRegularGoods(int id, String name, Double rating, double price, int quantity);
}
