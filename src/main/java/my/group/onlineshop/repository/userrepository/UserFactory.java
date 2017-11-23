package my.group.onlineshop.user.factory;

import my.group.onlineshop.user.entity.User;

public interface UserFactory {
    User makePremiumUser(String email, String name, String address, int id);
    User makeRegularUser(String email, String name, String address, int id);
}
