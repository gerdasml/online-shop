package my.group.onlineshop.domainservice.user;

import my.group.onlineshop.domain.user.User;

import java.util.List;

public interface UserSearchService {

    List<User> getPremiumUsers(List<User> list);

}
