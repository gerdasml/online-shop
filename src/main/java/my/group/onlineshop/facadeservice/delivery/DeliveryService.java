package my.group.onlineshop.facadeservice.delivery;

public interface DeliveryService {

    String deliver(int userId, int goodsId);
    Double getPurchaseCost(int goodsId);
    Boolean pay(int goodsId);
}
