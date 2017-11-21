package my.group.onlineshop.user.factory;

import my.group.onlineshop.user.User;

public interface UserFactory {
    User makePremiumUser(String email, String name, String address);
    User makeRegularUser(String email, String name, String address);
}
