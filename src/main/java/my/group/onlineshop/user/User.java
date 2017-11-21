package my.group.onlineshop.user;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Random;

public abstract class User {
    private String email;
    private String name;
    private String address;
    private int id;
    private static final Random rand = new Random();

    public User(String email, String name, String address){
        this.email = email;
        this.name = name;
        this.address = address;
        this.id = rand.nextInt(1000000000);
    }

    public String getEmail(){
        return email;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public abstract String getUserType();
    public abstract boolean isPremium();
}
