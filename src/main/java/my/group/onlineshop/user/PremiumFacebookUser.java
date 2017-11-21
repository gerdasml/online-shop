package my.group.onlineshop.user;

public class PremiumFacebookUser extends FacebookUser{

    public PremiumFacebookUser(String email, String name, String address){
        super(email, name, address);
    }

    @Override
    public boolean isPremium() {
        return true;
    }
}
