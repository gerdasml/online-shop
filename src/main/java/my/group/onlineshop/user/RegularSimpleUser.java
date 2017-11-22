package my.group.onlineshop.user;

public class RegularSimpleUser extends SimpleUser {

    public RegularSimpleUser(String email, String name, String address, int id){
        super(email, name, address, id);
    }

    @Override
    public boolean isPremium() {
        return false;
    }
}
