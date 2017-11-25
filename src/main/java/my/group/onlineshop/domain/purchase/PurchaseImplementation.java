package my.group.onlineshop.domain.purchase;

public class PurchaseImplementation implements Purchase {
    private int userId;
    private int goodsId;
    private int quantity;

    public PurchaseImplementation(int userId, int goodsId, int quantity){
        this.userId = userId;
        this.goodsId = goodsId;
        this.quantity = quantity;
    }

    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public int getGoodsId() {
        return goodsId;
    }

    @Override
    public int getPurchaseQuantity() {
        return quantity;
    }
}
