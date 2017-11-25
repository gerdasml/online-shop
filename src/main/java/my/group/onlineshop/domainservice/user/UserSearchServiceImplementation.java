package my.group.onlineshop.domainservice.user;

import my.group.onlineshop.domain.user.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserSearchServiceImplementation implements UserSearchService {

    @Override
    public List<User> getPremiumUsers(List<User> list) {
        return list.stream().filter(x -> x.isPremium()).collect(Collectors.toList());
    }
}
