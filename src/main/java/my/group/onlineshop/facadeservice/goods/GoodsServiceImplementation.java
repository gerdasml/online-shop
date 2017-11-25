package my.group.onlineshop.facadeservice.goods;

import my.group.onlineshop.domain.goods.Goods;
import my.group.onlineshop.repository.goodsrepository.GoodsRepository;
import my.group.onlineshop.integrationservice.BankService;

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
        return repo.getGoodsById(id);
    }

    @Override
    public Boolean buy(Goods goods) {
        return bs.buy(goods.getPrice());
    }
}
