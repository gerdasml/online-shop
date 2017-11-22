package my.group.onlineshop.user.controller;

import my.group.onlineshop.goods.Goods;
import my.group.onlineshop.user.User;
import my.group.onlineshop.user.service.UserService;
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

}
