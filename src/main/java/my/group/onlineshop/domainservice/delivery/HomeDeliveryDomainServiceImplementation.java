package my.group.onlineshop.domainservice.delivery;

import my.group.onlineshop.domain.goods.Goods;
import my.group.onlineshop.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;

public class HomeDeliveryDomainServiceImplementation implements DeliveryDomainService {

    @Autowired
    private DispatchService dispatchService;

    public HomeDeliveryDomainServiceImplementation(DispatchService ds){
        this.dispatchService = ds;
    }

    @Override
    public String deliver(User user, Goods goods){
        dispatchService.dispatch(goods, user.getAddress());
        return "Vartotojo: " + user.getName() + " uzsakyta preke: " + goods.getGoodsName() + " yra ruosiama pritatymui adresu: " + user.getAddress() + ".";
    }

    @Override
    public Double getPurchaseCost(Goods goods) {
        return goods.getPrice() + 4.5;
    }
}
