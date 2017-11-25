package my.group.onlineshop.facadeservice.purchase;

import my.group.onlineshop.domain.purchase.Purchase;

import java.util.List;

public interface PurchaseService {

    Double getSpecificGoodsCost(int userId, int goodsId);
    Double getPurchaseCost(int userId);
    List<Purchase> getAllPurchases(int userId);
}
