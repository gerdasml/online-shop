package my.group.onlineshop.domainservice.purchase;

import my.group.onlineshop.domain.goods.Goods;
import my.group.onlineshop.domain.purchase.Purchase;

import java.util.List;

public interface PurchaseDomainService {

    Double getPurchaseCost(List<Goods> goods, Purchase purchase);
    Double getAllPurchasesCost(List<Goods> goods, List<Purchase> purchase);
}
