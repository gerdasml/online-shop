package my.group.onlineshop.repository.goodsrepository;

import my.group.onlineshop.domain.goods.GoodsFactory;
import my.group.onlineshop.domain.goods.Goods;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GoodsRepositoryImplementation implements GoodsRepository {

    private List<List<Object>> db = new ArrayList<>();
    private GoodsFactory faq;

    @Autowired
    public GoodsRepositoryImplementation(GoodsFactory faq){
        db.add(new ArrayList<>(Arrays.asList("Batai", 69.99, 43, null, 33.33, "2017-12-31", 0)));
        db.add(new ArrayList<>(Arrays.asList("Suknele", 14.99, 3, 4.6, null, null, 1)));
        db.add(new ArrayList<>(Arrays.asList("Striuke", 154.5, 8, 2.8, null, null, 2)));
        this.faq = faq;
    }

    @Override
    public List<Goods> getAllGoods() {
        return db.stream().map(x -> createGoods(x)).collect(Collectors.toList());
    }

    @Override
    public void addGood(Goods good) {
        db.add(new ArrayList<>(Arrays.asList(good.getGoodsName(), good.getPrice(), good.getQuantity(), good.getRating(), good.getDiscountInPercents(), good.getDateUntilDiscountEnds(), good.getId())));
    }

    private Goods createGoods(List<Object> list){
        String name = list.get(0).toString();
        double price = (double)list.get(1);
        int quantity = (int)list.get(2);
        Double rating = list.get(3) == null ? null : (Double)list.get(3);
        Double discount = list.get(4) == null ? null : (Double)list.get(4);
        LocalDate discountDate = list.get(5) == null ? null : LocalDate.parse(list.get(5).toString());
        int id = (int)list.get(6);
        if(list.get(3) == null) return faq.makeDiscountGoods(id, name, discount, discountDate, price, quantity);
        else return faq.makeRegularGoods(id, name, rating, price, quantity);
    }
}
