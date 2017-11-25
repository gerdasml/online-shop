package my.group.onlineshop.integrationservice;

import my.group.onlineshop.domain.goods.Goods;
import my.group.onlineshop.domainservice.delivery.DispatchService;

public class TruckDispatchService implements DispatchService {
    @Override
    public void dispatch(Goods goods, String address) {
        System.out.println("Sunkvezimis su jusu preke " + goods.getGoodsName() + " buvo issiustas i " + address);
    }
}
