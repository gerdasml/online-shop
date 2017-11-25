package my.group.onlineshop.domainservice.delivery;

import my.group.onlineshop.domain.goods.Goods;
import my.group.onlineshop.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;

public class PostOfficeDomainServiceImplementation implements DeliveryDomainService {

    @Autowired
    private DispatchService ds;

    public PostOfficeDomainServiceImplementation(DispatchService ds){
        this.ds = ds;
    }

    @Override
    public String deliver(User user, Goods goods){
        ds.dispatch(goods, "pastas");
        return "Vartotojo: " + user.getName() + " uzsakyta preke: " + goods.getGoodsName() + " bus issiusta i artimiausia pasto punkta.";
    }

    @Override
    public Double getPurchaseCost(Goods goods) {
        return goods.getPrice();
    }
}
