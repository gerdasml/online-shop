package my.group.onlineshop.goods.entity;

import java.time.LocalDate;
import java.util.Random;

public abstract class Goods {
    private String name;
    private double price;
    private int quantity;
    private int id;
    private Random rand = new Random();

    public Goods (String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id = rand.nextInt(100000);
    }

    public Goods (int id, String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }

    public String getGoodsName(){
        return name;
    }

    public int getId(){return id;}

    public double getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public abstract Double getRating();
    public abstract Double getDiscountInPercents();
    public abstract LocalDate getDateUntilDiscountEnds();

}
