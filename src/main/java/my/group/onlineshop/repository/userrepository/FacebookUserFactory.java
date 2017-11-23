package my.group.onlineshop.repository.userrepository;

import my.group.onlineshop.domain.user.PremiumFacebookUser;
import my.group.onlineshop.domain.user.RegularFacebookUser;
import my.group.onlineshop.domain.user.User;

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
