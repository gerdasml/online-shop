package my.group.onlineshop.facadeservice;

import my.group.onlineshop.goods.entity.Goods;

import java.util.List;
//this is domain service
public interface GoodsService {

    List<Goods> getAllGoods();
    List<Goods> getDiscountGoods();
    Goods getGoodById(int id);
    Boolean buy(Goods goods);
}