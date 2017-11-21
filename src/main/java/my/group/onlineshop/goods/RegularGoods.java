package my.group.onlineshop.goods;

public class RegularGoods extends Goods{

    private double rating;

    public RegularGoods(String name, double price, int quantity, double rating) {
        super(name, price, quantity);
        this.rating = rating;
    }

    public double getRating(){
        return rating;
    }
}
