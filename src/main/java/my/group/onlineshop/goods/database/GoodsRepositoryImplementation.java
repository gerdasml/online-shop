package my.group.onlineshop.goods.database;

import my.group.onlineshop.goods.factory.GoodsFactory;
import my.group.onlineshop.goods.Goods;
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
        db.add(new ArrayList<>(Arrays.asList("Batai", 69.99, 43, null, 33.33, "2017-12-31")));
        db.add(new ArrayList<>(Arrays.asList("Suknele", 14.99, 3, 4.6, null, null)));
        db.add(new ArrayList<>(Arrays.asList("Striuke", 154.5, 8, 2.8, null, null)));
        this.faq = faq;
    }

    @Override
    public List<Goods> getAllGoods() {
        return db.stream().map(x -> createGoods(x)).collect(Collectors.toList());
    }

    @Override
    public void addGood(Goods good) {
        db.add(new ArrayList<>(Arrays.asList(good.getGoodsName(), good.getPrice(), good.getQuantity(), good.getRating(), good.getDiscountInPercents(), good.getDateUntilDiscountEnds())));
    }

    private Goods createGoods(List<Object> list){
        if(list.get(2) == null) return faq.makeDiscountGoods(list.get(0).toString(), (double)list.get(4), LocalDate.parse(list.get(5).toString()), (double)list.get(1), (int)list.get(2));
        else return faq.makeRegularGoods(list.get(0).toString(), (double)list.get(3), (double)list.get(1), (int)list.get(2));
    }
}
