package my.group.onlineshop.user.service;

import my.group.onlineshop.user.entity.User;

import java.util.List;

public interface UserSearchService {

    List<User> getAllUsers();
    User getUserById(int id);
    List<User> getPremiumUser();

}
