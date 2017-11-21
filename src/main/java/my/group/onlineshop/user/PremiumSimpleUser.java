package my.group.onlineshop.user;

public class PremiumSimpleUser extends SimpleUser {

    public PremiumSimpleUser(String email, String name, String address){
        super(email, name, address);
    }

    @Override
    public boolean isPremium() {
        return true;
    }
}
