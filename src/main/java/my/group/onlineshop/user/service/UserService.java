package my.group.onlineshop.user.service;

import my.group.onlineshop.user.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(int id);
    List<User> getPremiumUser();

}
