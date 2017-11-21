package my.group.onlineshop.goods;

import java.util.Date;

public class DiscountGoods extends Goods {
    private double discountInPercents;
    private Date dateUntilDiscountEnds;

    public DiscountGoods(String name, double price, int quantity, double discountInPercents, Date dateUntilDiscountEnds){
        super(name, price, quantity);
        this.discountInPercents = discountInPercents;
        this.dateUntilDiscountEnds = dateUntilDiscountEnds;
    }

    public double getDiscountInPercents(){
        return discountInPercents;
    }

    public Date getDateUntilDiscountEnds(){
        return dateUntilDiscountEnds;
    }
}
