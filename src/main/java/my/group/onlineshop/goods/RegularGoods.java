package my.group.onlineshop.goods;

import java.time.LocalDate;

public class RegularGoods extends Goods{

    private double rating;

    public RegularGoods(String name, double price, int quantity, double rating) {
        super(name, price, quantity);
        this.rating = rating;
    }

    public RegularGoods(int id, String name, double price, int quantity, double rating) {
        super(id, name, price, quantity);
        this.rating = rating;
    }

    @Override
    public Double getRating(){
        return rating;
    }

    @Override
    public Double getDiscountInPercents() {
        return null;
    }

    @Override
    public LocalDate getDateUntilDiscountEnds() {
        return null;
    }
}
