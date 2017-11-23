package my.group.onlineshop.user.factory;

import my.group.onlineshop.user.entity.PremiumFacebookUser;
import my.group.onlineshop.user.entity.RegularFacebookUser;
import my.group.onlineshop.user.entity.User;

public class FacebookUserFactory implements UserFactory {
    @Override
    public User makePremiumUser(String email, String name, String address, int id) {
        System.out.println("Facebook Premium user is being made");
        return new PremiumFacebookUser(email, name, address, id);
    }

    @Override
    public User makeRegularUser(String email, String name, String address, int id) {
        System.out.println("Facebook Simple user is being made");
        return new RegularFacebookUser(email, name, address, id);
    }
}
