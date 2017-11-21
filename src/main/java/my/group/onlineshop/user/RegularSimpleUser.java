package my.group.onlineshop.user;

public class RegularSimpleUser extends SimpleUser {

    public RegularSimpleUser(String email, String name, String address){
        super(email, name, address);
    }

    @Override
    public boolean isPremium() {
        return false;
    }
}
