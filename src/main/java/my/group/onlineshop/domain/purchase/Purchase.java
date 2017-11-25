package my.group.onlineshop.domain.purchase;

import my.group.onlineshop.domain.goods.Goods;

import java.util.List;

public interface Purchase {
    int getUserId();
    int getGoodsId();
    int getPurchaseQuantity();
}
