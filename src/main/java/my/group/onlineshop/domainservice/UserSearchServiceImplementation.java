package my.group.onlineshop.domainservice;

import my.group.onlineshop.domain.user.User;
import my.group.onlineshop.repository.userrepository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UserSearchServiceImplementation implements UserSearchService {

    private UserRepository repo;

    public UserSearchServiceImplementation(UserRepository repo){
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
