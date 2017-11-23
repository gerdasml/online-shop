package my.group.onlineshop.domain.user;

public class PremiumFacebookUser extends FacebookUser{

    public PremiumFacebookUser(String email, String name, String address, int id){
        super(email, name, address, id);
    }

    @Override
    public boolean isPremium() {
        return true;
    }
}
