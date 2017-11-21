package my.group.onlineshop;

import my.group.onlineshop.user.User;
import my.group.onlineshop.user.factory.UserFactory;
import my.group.onlineshop.user.factory.UserFactoryCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineShopApplication.class, args);
		UserFactory fac = UserFactoryCreator.makeFactory("Facebook");
		User user = fac.makePremiumUser("gerda@gmail.com", "gerda", "giedriai");
		System.out.println("id: " + user.getId());
		System.out.println("name: " + user.getName());
		System.out.println("address: " + user.getAddress());
		System.out.println("user type: " + user.getUserType());
		System.out.println("is premium: " + user.isPremium());
	}
}
