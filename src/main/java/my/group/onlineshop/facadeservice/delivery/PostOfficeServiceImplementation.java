package my.group.onlineshop.facadeservice.delivery;

import my.group.onlineshop.domainservice.user.UserSearchService;
import my.group.onlineshop.facadeservice.goods.GoodsService;
import my.group.onlineshop.integrationservice.BankService;
import my.group.onlineshop.repository.userrepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PostOfficeServiceImplementation implements DeliveryService {


    private UserSearchService us;
    private GoodsService gs;
    private BankService bs;
    private UserRepository ur;

    @Autowired
    public PostOfficeServiceImplementation(UserSearchService us, GoodsService gs, BankService bs, UserRepository ur){
        this.us = us;
        this.gs = gs;
        this.bs = bs;
        this.ur = ur;
    }

    @Override
    public String deliver(int userId, int goodsId) {
        return "Vartotojo: " + us.getUserById(userId, ur.getAllUsers()).getName() + " uzsakyta preke: " + gs.getGoodById(goodsId).getGoodsName() + " bus issiusta i artimiausia pasto punkta.";
    }

    @Override
    public Double getPurchaseCost(int goodsId) {
        return gs.getGoodById(goodsId).getPrice();
    }

    @Override
    public Boolean pay(int goodsId) {
        return bs.buy(gs.getGoodById(goodsId).getPrice());
    }
}
