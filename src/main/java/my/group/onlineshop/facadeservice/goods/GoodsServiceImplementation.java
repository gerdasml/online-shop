package my.group.onlineshop.facadeservice.goods;

import my.group.onlineshop.domain.goods.Goods;
import my.group.onlineshop.repository.goodsrepository.GoodsRepository;
import my.group.onlineshop.integrationservice.bank.BankService;

import java.util.List;
import java.util.stream.Collectors;

public class GoodsServiceImplementation implements GoodsService {

    private GoodsRepository goodsRepository;
    private BankService bankService;

    public GoodsServiceImplementation(GoodsRepository repo, BankService bs) {
        this.goodsRepository = repo;
        this.bankService = bs;
    }

    @Override
    public List<Goods> getAllGoods() {
        return goodsRepository.getAllGoods();
    }

    @Override
    public List<Goods> getDiscountGoods() {
        return goodsRepository.getAllGoods().stream().filter(x -> x.getDiscountInPercents() != null).collect(Collectors.toList());
    }

    @Override
    public Goods getGoodById(int id) {
        return goodsRepository.getGoodsById(id);
    }

    @Override
    public Boolean buy(Goods goods) {
        return bankService.buy(goods.getPrice());
    }
}
