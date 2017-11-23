package my.group.onlineshop.user.entity;

public class PremiumFacebookUser extends FacebookUser{

    public PremiumFacebookUser(String email, String name, String address, int id){
        super(email, name, address, id);
    }

    @Override
    public boolean isPremium() {
        return true;
    }
}
