package my.group.onlineshop.repository.userrepository;

import my.group.onlineshop.domain.user.User;

import java.util.List;

public interface UserRepository {

    List<User> getAllUsers();
    void addUser(User user);
    User getUserById(int id);
}
