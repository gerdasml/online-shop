package my.group.onlineshop.repository.userrepository;

public class UserFactoryCreator {
    public static UserFactory makeFactory(String type){
        if(type.equals("Facebook")) {
            return new FacebookUserFactory();
        }
        else return new SimpleUserFactory();
    }
}
