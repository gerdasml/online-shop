package my.group.onlineshop.user.service;

import my.group.onlineshop.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;

public class HomeDeliveryServiceImplementation implements DeliveryService {
    @Autowired
    private UserSearchService us;

    @Autowired
    private GoodsService gs;

    @Override
    public String deliver(int userId, int goodsId){
        return "Vartotojo: " + us.getUserById(userId).getName() + " uzsakyta preke: " + gs.getGoodById(goodsId).getGoodsName() + " yra ruosiama pritatymui adresu: " + us.getUserById(userId).getAddress() + ".";
    }

    @Override
    public Double getPurchaseCost(int goodsId) {
        return gs.getGoodById(goodsId).getPrice() + 4.5;
    }
}
