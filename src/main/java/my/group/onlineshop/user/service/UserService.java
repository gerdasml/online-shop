package my.group.onlineshop.user.service;

import my.group.onlineshop.user.entity.User;

import java.util.List;

public interface UserService {

    String deliver(int userId, int goodsId);
    Double getPurchaseCost(int goodsId);
    Boolean pay(int goodsId);
    List<User> getAllUsers();
    User getUserById(int id);
    List<User> getPremiumUser();
}
