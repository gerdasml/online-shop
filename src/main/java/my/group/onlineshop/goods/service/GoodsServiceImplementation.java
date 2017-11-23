package my.group.onlineshop.goods.service;

import my.group.onlineshop.goods.entity.Goods;
import my.group.onlineshop.goods.database.GoodsRepository;
import my.group.onlineshop.paymentsAndDeliveries.service.payment.BankService;

import java.util.List;
import java.util.stream.Collectors;

public class GoodsServiceImplementation implements GoodsService {

    private GoodsRepository repo;
    private BankService bs;

    public GoodsServiceImplementation(GoodsRepository repo, BankService bs) {
        this.repo = repo;
        this.bs = bs;
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

    @Override
    public Boolean buy(Goods goods) {
        return bs.buy(goods.getPrice());
    }
}
