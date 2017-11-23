package my.group.onlineshop.facadeservice.user;

import my.group.onlineshop.domain.user.User;
import my.group.onlineshop.domainservice.UserSearchService;
import my.group.onlineshop.facadeservice.delivery.DeliveryService;
import my.group.onlineshop.repository.userrepository.UserRepository;

import java.util.List;

public class UserServiceImplementation implements UserService {

    private DeliveryService delser;
    private UserSearchService usseas;
    private UserRepository usrep;

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
        return usrep.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return usseas.getUserById(id, usrep.getAllUsers());
    }

    @Override
    public List<User> getPremiumUser() {
        return usseas.getPremiumUsers(usrep.getAllUsers());
    }
}
