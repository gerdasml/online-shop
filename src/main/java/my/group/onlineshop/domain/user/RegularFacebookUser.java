package my.group.onlineshop.domain.user;


public class RegularFacebookUser extends FacebookUser{

    public RegularFacebookUser(String email, String name, String address, int id){
        super(email, name, address, id);
    }

    @Override
    public boolean isPremium() {
        return false;
    }
}
