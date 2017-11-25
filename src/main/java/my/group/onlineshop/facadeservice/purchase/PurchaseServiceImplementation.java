package my.group.onlineshop.facadeservice.purchase;

import my.group.onlineshop.domain.goods.Goods;
import my.group.onlineshop.domain.purchase.Purchase;
import my.group.onlineshop.domainservice.purchase.PurchaseDomainService;
import my.group.onlineshop.repository.goodsrepository.GoodsRepository;
import my.group.onlineshop.repository.purchaserepository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PurchaseServiceImplementation implements PurchaseService {

    private GoodsRepository gr;
    private PurchaseRepository pr;
    private PurchaseDomainService pds;

    @Autowired
    public PurchaseServiceImplementation(GoodsRepository gr, PurchaseRepository pr, PurchaseDomainService pds){
        this.gr = gr;
        this.pr = pr;
        this.pds = pds;
    }

    @Override
    public Double getSpecificGoodsCost(int userId, int goodsId) {
        Purchase p = pr.getPurchase(userId, goodsId);
        List<Goods> g = gr.getAllGoods();
        return pds.getPurchaseCost(g, p);
    }

    @Override
    public Double getPurchaseCost(int userId) {
        List<Purchase> p = pr.getAllPurchases(userId);
        List<Goods> g = gr.getAllGoods();
        return pds.getAllPurchasesCost(g, p);
    }

    @Override
    public List<Purchase> getAllPurchases(int userId){
        return pr.getAllPurchases(userId);
    }
}
