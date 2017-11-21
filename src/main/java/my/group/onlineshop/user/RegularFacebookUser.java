package my.group.onlineshop.user;


public class RegularFacebookUser extends FacebookUser{

    public RegularFacebookUser(String email, String name, String address){
        super(email, name, address);
    }

    @Override
    public boolean isPremium() {
        return false;
    }
}
