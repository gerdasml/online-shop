package my.group.onlineshop.domainservice.purchase;

import my.group.onlineshop.domain.goods.Goods;
import my.group.onlineshop.domain.purchase.Purchase;

import java.util.List;
import java.util.stream.Collector;

public class PurchaseDomainServiceImplementation implements PurchaseDomainService {

    @Override
    public Double getPurchaseCost(List<Goods> goods, Purchase purchase) {
        return goods.stream().filter(x -> x.getId() == purchase.getGoodsId()).map(x -> x.getPrice()).findFirst().orElse(0.0) * purchase.getPurchaseQuantity();
    }

    @Override
    public Double getAllPurchasesCost(List<Goods> goods, List<Purchase> purchase) {
        return goods.stream().filter(x -> purchase.stream().anyMatch(y -> y.getGoodsId() == x.getId()))
                    .map(x -> x.getPrice() * purchase.stream().filter(y -> y.getGoodsId() == x.getId())
                    .map(y -> y.getPurchaseQuantity()).findFirst().orElse(0)).mapToDouble(x -> x).sum();
    }
}
