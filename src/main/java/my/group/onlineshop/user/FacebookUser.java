package my.group.onlineshop.user;

public abstract class FacebookUser extends User {
    private String userType;

    public FacebookUser(String email, String name, String address){
        super(email, name, address);
        userType = "Facebook";
    }

    public String getUserType(){
        return userType;
    }
}
