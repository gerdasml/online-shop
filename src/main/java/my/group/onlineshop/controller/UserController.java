package my.group.onlineshop.controller;

import my.group.onlineshop.domain.user.User;
import my.group.onlineshop.facadeservice.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService us;

    @RequestMapping("/users")
    public String viewAllUsers(Model model){
        List<User> allUsers = us.getAllUsers();
        model.addAttribute("users", allUsers);
        return "users";
    }

    @RequestMapping("/users/premium")
    public String viewPremiumUsers(Model model){
        List<User> premiumUsers = us.getPremiumUser();
        model.addAttribute("premiumUsers", premiumUsers);
        return "premium";
    }

    @RequestMapping("/users/{id}")
    public String viewSingleUser(@PathVariable("id") String id, Model model){
        int iid = Integer.parseInt(id);
        User user = us.getUserById(iid);
        model.addAttribute("user", user);
        return "user";
    }

    @RequestMapping("/users/{userId}/delivery/{goodsId}")
    public String viewDeliveryInformation(@PathVariable("userId") String userId, @PathVariable("goodsId") String goodsId, Model model){
        int userIdy = Integer.parseInt(userId);
        int goodsIdy = Integer.parseInt(goodsId);
        String message = us.deliver(userIdy, goodsIdy);
        us.pay(goodsIdy);
        Double purchaseCost = us.getPurchaseCost(goodsIdy);
        model.addAttribute("message", message);
        model.addAttribute("purchaseCost", purchaseCost);
        return "delivery";
    }
}
