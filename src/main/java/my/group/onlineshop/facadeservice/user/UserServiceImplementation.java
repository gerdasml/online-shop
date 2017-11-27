package my.group.onlineshop.facadeservice.user;

import my.group.onlineshop.domain.user.User;
import my.group.onlineshop.domainservice.user.UserSearchService;
import my.group.onlineshop.facadeservice.delivery.DeliveryService;
import my.group.onlineshop.repository.userrepository.UserRepository;

import java.util.List;

public class UserServiceImplementation implements UserService {

    private DeliveryService deliveryService;
    private UserSearchService userSearchService;
    private UserRepository userRepository;

    public UserServiceImplementation(DeliveryService delser, UserSearchService usseas, UserRepository usrep){
        this.deliveryService = delser;
        this.userSearchService = usseas;
        this.userRepository = usrep;
    }

    @Override
    public String deliver(int userId, int goodsId) {
        return deliveryService.deliver(userId, goodsId);
    }

    @Override
    public Double getPurchaseCost(int goodsId) {
        return deliveryService.getPurchaseCost(goodsId);
    }

    @Override
    public Boolean pay(int goodsId) {
        return deliveryService.pay(goodsId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public List<User> getPremiumUser() {
        return userSearchService.getPremiumUsers(userRepository.getAllUsers());
    }
}
