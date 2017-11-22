package my.group.onlineshop.goods.service;

import my.group.onlineshop.goods.Goods;

import java.util.List;
//this is domain service
public interface GoodsService {

    List<Goods> getAllGoods();
    List<Goods> getDiscountGoods();
    Goods getGoodById(int id);
}
