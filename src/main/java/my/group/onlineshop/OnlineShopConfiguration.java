package my.group.onlineshop;

import my.group.onlineshop.goods.database.GoodsRepository;
import my.group.onlineshop.goods.database.GoodsRepositoryImplementation;
import my.group.onlineshop.goods.factory.GoodsFactory;
import my.group.onlineshop.goods.factory.GoodsFactoryImplementation;
import my.group.onlineshop.goods.service.DeliveryService;
import my.group.onlineshop.goods.service.GoodsSearchService;
import my.group.onlineshop.goods.service.GoodsSearchServiceImplementation;
import my.group.onlineshop.goods.service.HomeDeliveryServiceImplementation;
import my.group.onlineshop.user.database.UserRepository;
import my.group.onlineshop.user.database.UserRepositoryImplementation;
import my.group.onlineshop.user.service.BankService;
import my.group.onlineshop.user.service.SwedbankService;
import my.group.onlineshop.user.service.UserService;
import my.group.onlineshop.user.service.UserServiceImplementation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OnlineShopConfiguration {

    @Bean
    public GoodsSearchService goodsService(GoodsRepository gr){
        return new GoodsSearchServiceImplementation(gr);
    }

    @Bean
    public GoodsRepository goodsRepository(GoodsFactory gf){
        return new GoodsRepositoryImplementation(gf);
    }

    @Bean
    public GoodsFactory goodsFactory(){
        return new GoodsFactoryImplementation();
    }

    @Bean
    public UserService userService(UserRepository ur){
        return new UserServiceImplementation(ur);
    }

    @Bean
    public UserRepository userRepository(){
        return new UserRepositoryImplementation();
    }

    @Bean
    public BankService bankService(){
        return new SwedbankService();
    }

    @Bean
    public DeliveryService deliveryService(){
        return new HomeDeliveryServiceImplementation();
    }
}
