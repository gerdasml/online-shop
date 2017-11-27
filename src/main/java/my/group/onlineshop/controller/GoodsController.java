package my.group.onlineshop.controller;

import my.group.onlineshop.domain.goods.Goods;
import my.group.onlineshop.facadeservice.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/goods")
    public String viewAllGoods(Model model){
        List<Goods> allGoods = goodsService.getAllGoods();
        model.addAttribute("goods", allGoods);
        return "goods";
    }

    @RequestMapping("/goods/{id}")
    public String viewSingleGood(@PathVariable("id") String id, Model model){
        int iid = Integer.parseInt(id);
        Goods good = goodsService.getGoodById(iid);
        model.addAttribute("good", good);
        return "good";
    }

    @RequestMapping("/goods/discounted")
    public String viewDiscountedGoods(Model model){
        List<Goods> discountedGoods = goodsService.getDiscountGoods();
        model.addAttribute("discounted", discountedGoods);
        return "discount";
    }

    @RequestMapping("/goods/{id}/buy")
    public String buyGoods(@PathVariable("id") String id, Model model){
        int iid = Integer.parseInt(id);
        Goods good = goodsService.getGoodById(iid);
        Boolean isSuccess = goodsService.buy(good);
        if(isSuccess) System.out.println("Purchase was successful");
        else System.out.println("Purchase wasn't successful.");
        return "buy";
    }}
