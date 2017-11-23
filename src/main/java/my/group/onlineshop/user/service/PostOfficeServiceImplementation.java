package my.group.onlineshop.user.service;

import my.group.onlineshop.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;

public class PostOfficeServiceImplementation implements DeliveryService {

    @Autowired
    private UserSearchService us;

    @Autowired
    private GoodsService gs;

    @Override
    public String deliver(int userId, int goodsId) {
        return "Vartotojo: " + us.getUserById(userId).getName() + " uzsakyta preke: " + gs.getGoodById(goodsId).getGoodsName() + " bus issiusta i artimiausia pasto punkta.";
    }

    @Override
    public Double getPurchaseCost(int goodsId) {
        return gs.getGoodById(goodsId).getPrice();
    }
}
