package my.group.onlineshop.user.database;

import my.group.onlineshop.user.User;
import my.group.onlineshop.user.factory.UserFactory;
import my.group.onlineshop.user.factory.UserFactoryCreator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepositoryImplementation implements UserRepository {
    private List<List<Object>> db = new ArrayList<>();

    public UserRepositoryImplementation() {
        db.add(new ArrayList<>(Arrays.asList("gerda@gerda", "gerda", "gerdausku kaimas", 12345, "Facebook", true)));
        db.add(new ArrayList<>(Arrays.asList("test@test.com", "test", "test city", 67554, "Facebook", false)));
        db.add(new ArrayList<>(Arrays.asList("anotherOne@gmail.com", "anotherOne", "vlk", 67984, "Simple", true)));
    }

    @Override
    public List<User> getAllUsers() {
        return db.stream().map(x -> createUser(x)).collect(Collectors.toList());
    }

    @Override
    public void addUser(User user) {
        db.add(new ArrayList<>(Arrays.asList(user.getEmail(), user.getName(), user.getAddress(), user.getId(), user.getUserType(), user.isPremium())));
    }

    private User createUser(List<Object> list){
        UserFactory faq;
        if (list.get(4).toString().equals("Facebook")) faq = UserFactoryCreator.makeFactory("Facebook");
        else faq = UserFactoryCreator.makeFactory("Simple");
        User user;
        if((boolean)list.get(5)) user = faq.makePremiumUser(list.get(0).toString(), list.get(1).toString(), list.get(2).toString());
        else user = faq.makeRegularUser(list.get(0).toString(), list.get(1).toString(), list.get(2).toString());
        return user;
    }
}
