package my.group.onlineshop.facadeservice.delivery;

import my.group.onlineshop.domainservice.delivery.DeliveryDomainService;
import my.group.onlineshop.domainservice.user.UserSearchService;
import my.group.onlineshop.facadeservice.goods.GoodsService;
import my.group.onlineshop.integrationservice.BankService;
import my.group.onlineshop.repository.goodsrepository.GoodsRepository;
import my.group.onlineshop.repository.userrepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DeliveryServiceImplementation implements DeliveryService {
    private UserRepository ur;
    private DeliveryDomainService dds;
    private GoodsService gs;
    private BankService bs;

    @Autowired
    public DeliveryServiceImplementation(UserRepository ur, DeliveryDomainService dds, GoodsService gs, BankService bs){
        this.ur = ur;
        this.dds = dds;
        this.gs = gs;
        this.bs = bs;
    }

    @Override
    public String deliver(int userId, int goodsId) {
        return dds.deliver(ur.getUserById(userId), gs.getGoodById(goodsId));
    }

    @Override
    public Double getPurchaseCost(int goodsId) {
        return dds.getPurchaseCost(gs.getGoodById(goodsId));
    }

    @Override
    public Boolean pay(int goodsId) {
        return bs.buy(getPurchaseCost(goodsId));
    }
}
