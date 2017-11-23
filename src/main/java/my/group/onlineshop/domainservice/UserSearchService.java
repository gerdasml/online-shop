package my.group.onlineshop.domainservice;

import my.group.onlineshop.domain.user.User;

import java.util.List;

public interface UserSearchService {

    User getUserById(int id, List<User> list);
    List<User> getPremiumUsers(List<User> list);

}
