package my.group.onlineshop.goods;

public abstract class Goods {
    private String name;
    private double price;
    private int quantity;

    public Goods (String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getGoodsName(){
        return name;
    };

    public double getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }




}
