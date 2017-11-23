package my.group.onlineshop.repository.goodsrepository;

import my.group.onlineshop.domain.goods.Goods;

import java.util.List;

public interface GoodsRepository {

    List<Goods> getAllGoods();
    void addGood(Goods good);
}
