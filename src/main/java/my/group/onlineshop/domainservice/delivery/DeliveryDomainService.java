package my.group.onlineshop.domainservice.delivery;

import my.group.onlineshop.domain.goods.Goods;
import my.group.onlineshop.domain.user.User;

public interface DeliveryDomainService {

    String deliver(User user, Goods goods);
    Double getPurchaseCost(Goods goods);
}
