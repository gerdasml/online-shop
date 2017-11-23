package my.group.onlineshop.user.database;

import my.group.onlineshop.user.entity.User;

import java.util.List;

public interface UserRepository {

    List<User> getAllUsers();
    void addUser(User user);
}
