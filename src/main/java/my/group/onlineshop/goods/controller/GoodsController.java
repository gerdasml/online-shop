package my.group.onlineshop.goods.controller;

import my.group.onlineshop.goods.entity.Goods;
import my.group.onlineshop.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class GoodsController {

    @Autowired
    GoodsService gs;

    @RequestMapping("/goods")
    public String viewAllGoods(Model model){
        List<Goods> allGoods = gs.getAllGoods();
        model.addAttribute("goods", allGoods);
        return "goods";
    }

    @RequestMapping("/goods/{id}")
    public String viewSingleGood(@PathVariable("id") String id, Model model){
        int iid = Integer.parseInt(id);
        Goods good = gs.getGoodById(iid);
        model.addAttribute("good", good);
        return "good";
    }

    @RequestMapping("/goods/discounted")
    public String viewDiscountedGoods(Model model){
        List<Goods> discountedGoods = gs.getDiscountGoods();
        model.addAttribute("discounted", discountedGoods);
        return "discount";
    }

    @RequestMapping("/goods/{id}/buy")
    public String buyGoods(@PathVariable("id") String id, Model model){
        int iid = Integer.parseInt(id);
        Goods good = gs.getGoodById(iid);
        Boolean isSuccess = gs.buy(good);
        if(isSuccess) System.out.println("Purchase was successful");
        else System.out.println("Purchase wasn't successful.");
        return "buy";
    }}
