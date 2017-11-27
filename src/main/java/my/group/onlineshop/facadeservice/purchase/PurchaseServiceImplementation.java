package my.group.onlineshop.facadeservice.purchase;

import my.group.onlineshop.domain.goods.Goods;
import my.group.onlineshop.domain.purchase.Purchase;
import my.group.onlineshop.domainservice.purchase.PurchaseDomainService;
import my.group.onlineshop.repository.goodsrepository.GoodsRepository;
import my.group.onlineshop.repository.purchaserepository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PurchaseServiceImplementation implements PurchaseService {

    private GoodsRepository goodsRepository;
    private PurchaseRepository purchaseRepository;
    private PurchaseDomainService purchaseDomainService;

    @Autowired
    public PurchaseServiceImplementation(GoodsRepository gr, PurchaseRepository pr, PurchaseDomainService pds){
        this.goodsRepository = gr;
        this.purchaseRepository = pr;
        this.purchaseDomainService = pds;
    }

    @Override
    public Double getSpecificGoodsCost(int userId, int goodsId) {
        Purchase p = purchaseRepository.getPurchase(userId, goodsId);
        List<Goods> g = goodsRepository.getAllGoods();
        return purchaseDomainService.getPurchaseCost(g, p);
    }

    @Override
    public Double getPurchaseCost(int userId) {
        List<Purchase> p = purchaseRepository.getAllPurchases(userId);
        List<Goods> g = goodsRepository.getAllGoods();
        return purchaseDomainService.getAllPurchasesCost(g, p);
    }

    @Override
    public List<Purchase> getAllPurchases(int userId){
        return purchaseRepository.getAllPurchases(userId);
    }
}
