package my.group.onlineshop.user.service;

import my.group.onlineshop.user.User;
import my.group.onlineshop.user.database.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImplementation implements UserService {

    private UserRepository repo;

    public UserServiceImplementation(UserRepository repo){
        this.repo = repo;
    }
    @Override
    public List<User> getAllUsers() {
        return repo.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return repo.getAllUsers().stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<User> getPremiumUser() {
        return repo.getAllUsers().stream().filter(x -> x.isPremium()).collect(Collectors.toList());
    }
}
