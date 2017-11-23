package my.group.onlineshop;

import my.group.onlineshop.repository.userrepository.UserRepository;
import my.group.onlineshop.repository.userrepository.UserRepositoryImplementation;
import my.group.onlineshop.domain.user.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OnlineShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineShopApplication.class, args);
		UserRepository r = new UserRepositoryImplementation();
		List<User> l = r.getAllUsers();
		int x = 5;
	}
}
