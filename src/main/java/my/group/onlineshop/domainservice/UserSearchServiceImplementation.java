package my.group.onlineshop.domainservice;

import my.group.onlineshop.domain.user.User;
import my.group.onlineshop.repository.userrepository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UserSearchServiceImplementation implements UserSearchService {


    @Override
    public User getUserById(int id, List<User> list) {
        return list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<User> getPremiumUsers(List<User> list) {
        return list.stream().filter(x -> x.isPremium()).collect(Collectors.toList());
    }
}
