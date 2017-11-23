package my.group.onlineshop.user.service;

import my.group.onlineshop.paymentsAndDeliveries.service.delivery.DeliveryService;
import my.group.onlineshop.user.entity.User;

import java.util.List;

public class UserServiceImplementation implements UserService {

    private DeliveryService delser;
    private UserSearchService usseas;

    public UserServiceImplementation(DeliveryService delser, UserSearchService usseas){
        this.delser = delser;
        this.usseas = usseas;
    }

    @Override
    public String deliver(int userId, int goodsId) {
        return delser.deliver(userId, goodsId);
    }

    @Override
    public Double getPurchaseCost(int goodsId) {
        return delser.getPurchaseCost(goodsId);
    }

    @Override
    public Boolean pay(int goodsId) {
        return delser.pay(goodsId);
    }

    @Override
    public List<User> getAllUsers() {
        return usseas.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return usseas.getUserById(id);
    }

    @Override
    public List<User> getPremiumUser() {
        return usseas.getPremiumUser();
    }
}
