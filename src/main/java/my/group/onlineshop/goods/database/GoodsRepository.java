package my.group.onlineshop.goods.database;

import my.group.onlineshop.goods.entity.Goods;

import java.util.List;

public interface GoodsRepository {

    List<Goods> getAllGoods();
    void addGood(Goods good);
}
