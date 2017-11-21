package my.group.onlineshop.user;

public abstract class SimpleUser extends User {
    private String userType;

    public SimpleUser(String email, String name, String address){
        super(email, name, address);
        userType = "Simple";
    }

    public String getUserType(){
        return userType;
    }
}
