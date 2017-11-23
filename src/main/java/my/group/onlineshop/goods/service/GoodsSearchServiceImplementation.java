package my.group.onlineshop.goods.service;

import my.group.onlineshop.goods.Goods;
import my.group.onlineshop.goods.database.GoodsRepository;

import java.util.List;
import java.util.stream.Collectors;

public class GoodsSearchServiceImplementation implements GoodsSearchService {

    private GoodsRepository repo;

    public GoodsSearchServiceImplementation(GoodsRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Goods> getAllGoods() {
        return repo.getAllGoods();
    }

    @Override
    public List<Goods> getDiscountGoods() {
        return repo.getAllGoods().stream().filter(x -> x.getDiscountInPercents() != null).collect(Collectors.toList());
    }

    @Override
    public Goods getGoodById(int id) {
        return repo.getAllGoods().stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }
}
