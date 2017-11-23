package my.group.onlineshop.domainservice;

import my.group.onlineshop.domain.user.User;

import java.util.List;

public interface UserSearchService {

    List<User> getAllUsers();
    User getUserById(int id);
    List<User> getPremiumUser();

}
