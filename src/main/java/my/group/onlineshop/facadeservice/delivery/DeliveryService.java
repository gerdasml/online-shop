package my.group.onlineshop.paymentsAndDeliveries.service.delivery;

public interface DeliveryService {

    String deliver(int userId, int goodsId);
    Double getPurchaseCost(int goodsId);
    Boolean pay(int goodsId);
}
