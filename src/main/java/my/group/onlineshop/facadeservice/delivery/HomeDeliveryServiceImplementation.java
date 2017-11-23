package my.group.onlineshop.facadeservice.delivery;

import my.group.onlineshop.domainservice.UserSearchService;
import my.group.onlineshop.facadeservice.goods.GoodsService;
import my.group.onlineshop.integrationservice.BankService;
import org.springframework.beans.factory.annotation.Autowired;

public class HomeDeliveryServiceImplementation implements DeliveryService {

    private UserSearchService us;
    private GoodsService gs;
    private BankService bs;

    @Autowired
    public HomeDeliveryServiceImplementation(UserSearchService us, GoodsService gs, BankService bs){
        this.us = us;
        this.gs = gs;
        this.bs = bs;
    }

    @Override
    public String deliver(int userId, int goodsId){
        return "Vartotojo: " + us.getUserById(userId).getName() + " uzsakyta preke: " + gs.getGoodById(goodsId).getGoodsName() + " yra ruosiama pritatymui adresu: " + us.getUserById(userId).getAddress() + ".";
    }

    @Override
    public Double getPurchaseCost(int goodsId) {
        return gs.getGoodById(goodsId).getPrice() + 4.5;
    }

    @Override
    public Boolean pay(int goodsId) {
        return bs.buy(gs.getGoodById(goodsId).getPrice());
    }
}
