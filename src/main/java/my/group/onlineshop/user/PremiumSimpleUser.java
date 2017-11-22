package my.group.onlineshop.user;

public class PremiumSimpleUser extends SimpleUser {

    public PremiumSimpleUser(String email, String name, String address, int id){
        super(email, name, address, id);
    }

    @Override
    public boolean isPremium() {
        return true;
    }
}
