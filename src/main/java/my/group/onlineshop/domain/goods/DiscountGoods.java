package my.group.onlineshop.domain.goods;

import java.time.LocalDate;

public class DiscountGoods extends Goods {
    private double discountInPercents;
    private LocalDate dateUntilDiscountEnds;

    public DiscountGoods(String name, double price, int quantity, double discountInPercents, LocalDate dateUntilDiscountEnds){
        super(name, price, quantity);
        this.discountInPercents = discountInPercents;
        this.dateUntilDiscountEnds = dateUntilDiscountEnds;
    }

    public DiscountGoods(int id, String name, double price, int quantity, double discountInPercents, LocalDate dateUntilDiscountEnds){
        super(id, name, price, quantity);
        this.discountInPercents = discountInPercents;
        this.dateUntilDiscountEnds = dateUntilDiscountEnds;
    }

    @Override
    public Double getDiscountInPercents(){
        return discountInPercents;
    }

    @Override
    public LocalDate getDateUntilDiscountEnds(){
        return dateUntilDiscountEnds;
    }

    @Override
    public Double getRating(){return null;}
}
