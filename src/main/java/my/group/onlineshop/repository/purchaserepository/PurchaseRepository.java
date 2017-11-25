package my.group.onlineshop.repository.purchaserepository;

import my.group.onlineshop.domain.purchase.Purchase;

import java.util.List;

public interface PurchaseRepository {

    List<Purchase> getAllPurchases(int userId);
    void addPurchase(Purchase purchase);
}
