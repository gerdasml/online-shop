package my.group.onlineshop;

import my.group.onlineshop.goods.database.GoodsRepository;
import my.group.onlineshop.goods.database.GoodsRepositoryImplementation;
import my.group.onlineshop.goods.factory.GoodsFactory;
import my.group.onlineshop.goods.factory.GoodsFactoryImplementation;
import my.group.onlineshop.user.service.*;
import my.group.onlineshop.goods.service.GoodsService;
import my.group.onlineshop.goods.service.GoodsServiceImplementation;
import my.group.onlineshop.user.database.UserRepository;
import my.group.onlineshop.user.database.UserRepositoryImplementation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OnlineShopConfiguration {

    @Bean
    public GoodsService goodsService(GoodsRepository gr){
        return new GoodsServiceImplementation(gr);
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
    public UserSearchService userSearchService(UserRepository ur){
        return new UserSearchServiceImplementation(ur);
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

    @Bean
    public UserService userService(UserSearchService uss, DeliveryService ds){
        return new UserServiceImplementation(ds, uss);
    }
}
