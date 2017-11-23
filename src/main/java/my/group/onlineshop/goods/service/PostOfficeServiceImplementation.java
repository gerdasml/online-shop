package my.group.onlineshop.goods.service;

import my.group.onlineshop.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class PostOfficeServiceImplementation implements DeliveryService {

    @Autowired
    private UserService us;

    @Autowired
    private GoodsSearchService gs;

    @Override
    public String deliver(int userId, int goodsId) {
        return "Vartotojo: " + us.getUserById(userId).getName() + " uzsakyta preke: " + gs.getGoodById(goodsId).getGoodsName() + " bus issiusta i artimiausia pasto punkta.";
    }

    @Override
    public Double getPurchaseCost(int goodsId) {
        return gs.getGoodById(goodsId).getPrice();
    }
}
