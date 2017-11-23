package my.group.onlineshop.domain.goods;

import java.time.LocalDate;

public class GoodsFactoryImplementation implements GoodsFactory {
    @Override
    public Goods makeDiscountGoods(String name, Double discount, LocalDate dateUntilSaleEnds, double price, int quantity) {
        System.out.println("Discount goods are being made");
        return new DiscountGoods(name, price, quantity, discount, dateUntilSaleEnds);
    }

    @Override
    public Goods makeRegularGoods(String name, Double rating, double price, int quantity) {
        System.out.println("Regular goods are being made");
        return new RegularGoods(name, price, quantity, rating);
    }
    @Override
    public Goods makeDiscountGoods(int id, String name, Double discount, LocalDate dateUntilSaleEnds, double price, int quantity) {
        System.out.println("Discount goods are being made");
        return new DiscountGoods(id, name, price, quantity, discount, dateUntilSaleEnds);
    }

    @Override
    public Goods makeRegularGoods(int id, String name, Double rating, double price, int quantity) {
        System.out.println("Regular goods are being made");
        return new RegularGoods(id, name, price, quantity, rating);
    }
}
