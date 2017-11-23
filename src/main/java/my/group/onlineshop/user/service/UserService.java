package my.group.onlineshop.user.service;

import my.group.onlineshop.goods.Goods;
import my.group.onlineshop.user.User;

import java.util.List;

public interface UserService {

    String deliver(int userId, int goodsId);
    Double getPurchaseCost(int goodsId);
    List<User> getAllUsers();
    User getUserById(int id);
    List<User> getPremiumUser();
}
