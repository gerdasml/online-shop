package my.group.onlineshop.user.factory;

public class UserFactoryCreator {
    public static UserFactory makeFactory(String type){
        if(type.equals("Facebook")) {
            return new FacebookUserFactory();
        }
        else return new SimpleUserFactory();
    }
}
