package my.group.onlineshop.user.service;

import my.group.onlineshop.goods.Goods;
import java.util.List;

public interface DeliveryService {

    String deliver(int userId, int goodsId);
    Double getPurchaseCost(int goodsId);
}
