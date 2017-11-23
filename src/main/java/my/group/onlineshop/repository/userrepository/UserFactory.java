package my.group.onlineshop.repository.userrepository;

import my.group.onlineshop.domain.user.User;

public interface UserFactory {
    User makePremiumUser(String email, String name, String address, int id);
    User makeRegularUser(String email, String name, String address, int id);
}
