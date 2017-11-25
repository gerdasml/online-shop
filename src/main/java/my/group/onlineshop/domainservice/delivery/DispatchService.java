package my.group.onlineshop.domainservice.delivery;

import my.group.onlineshop.domain.goods.Goods;

public interface DispatchService {

    void dispatch(Goods goods, String address);
}
