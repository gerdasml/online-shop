package my.group.onlineshop.controller;

import javafx.util.Pair;
import my.group.onlineshop.domain.purchase.Purchase;
import my.group.onlineshop.facadeservice.goods.GoodsService;
import my.group.onlineshop.facadeservice.purchase.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PurchaseController {

    @Autowired
    PurchaseService ps;

    @Autowired
    GoodsService gs;

    @RequestMapping("/cart/{id}")
    public String viewCart(@PathVariable("id") String id, Model model){
        int iid = Integer.parseInt(id);
        List<Purchase> purchase = ps.getAllPurchases(iid);
        List<Pair<Pair<String, Integer>, Double>> list = purchase.stream()
                .map(x -> new Pair<>(new Pair<> (gs.getGoodById(x.getGoodsId()).getGoodsName(), x.getPurchaseQuantity()), ps.getSpecificGoodsCost(iid, x.getGoodsId()))).collect(Collectors.toList());
        model.addAttribute("rows", list);
        model.addAttribute("totalCost", (double)Math.round(ps.getPurchaseCost(iid) * 100) / 100);
        return "cart";
    }
}
