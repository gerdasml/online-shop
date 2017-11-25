package my.group.onlineshop.repository.purchaserepository;

import my.group.onlineshop.domain.purchase.Purchase;
import my.group.onlineshop.domain.purchase.PurchaseImplementation;
import my.group.onlineshop.domain.user.User;
import my.group.onlineshop.repository.userrepository.UserFactory;
import my.group.onlineshop.repository.userrepository.UserFactoryCreator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class PurchaseRepositoryImplementation implements PurchaseRepository {
    private List<List<Object>> db = new ArrayList<>();

    public PurchaseRepositoryImplementation() {
        db.add(new ArrayList<>(Arrays.asList(12345, 0, 1)));
        db.add(new ArrayList<>(Arrays.asList(67554, 1, 2)));
        db.add(new ArrayList<>(Arrays.asList(67984, 2, 1)));
        db.add(new ArrayList<>(Arrays.asList(12345, 1, 1)));
        db.add(new ArrayList<>(Arrays.asList(67554, 2, 1)));
        db.add(new ArrayList<>(Arrays.asList(67984, 2, 2)));
    }
    @Override
    public List<Purchase> getAllPurchases(int userId) {
        return db.stream().filter(x -> (int)x.get(0) == userId).map(x -> createPurchase(x)).collect(Collectors.toList());
    }

    @Override
    public void addPurchase(Purchase purchase) {
        db.add(new ArrayList<>(Arrays.asList(purchase.getUserId(), purchase.getGoodsId(), purchase.getPurchaseQuantity())));
    }

    private Purchase createPurchase(List<Object> list){
        Purchase purchase;
        purchase = new PurchaseImplementation((int)list.get(0), (int)list.get(1), (int)list.get(2));
        return purchase;
    }

    @Override
    public Purchase getPurchase(int userId, int goodsId){
        return getAllPurchases(userId).stream().filter(x -> x.getGoodsId() == goodsId).findFirst().orElse(null);
    }

}
