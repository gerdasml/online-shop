package my.group.onlineshop;

import my.group.onlineshop.domainservice.*;
import my.group.onlineshop.facadeservice.delivery.DeliveryService;
import my.group.onlineshop.facadeservice.delivery.HomeDeliveryServiceImplementation;
import my.group.onlineshop.facadeservice.goods.GoodsService;
import my.group.onlineshop.facadeservice.goods.GoodsServiceImplementation;
import my.group.onlineshop.facadeservice.user.UserService;
import my.group.onlineshop.facadeservice.user.UserServiceImplementation;
import my.group.onlineshop.integrationservice.BankService;
import my.group.onlineshop.integrationservice.DanskeBankService;
import my.group.onlineshop.integrationservice.SwedbankService;
import my.group.onlineshop.repository.goodsrepository.GoodsRepository;
import my.group.onlineshop.repository.goodsrepository.GoodsRepositoryImplementation;
import my.group.onlineshop.repository.goodsrepository.GoodsFactory;
import my.group.onlineshop.repository.goodsrepository.GoodsFactoryImplementation;
import my.group.onlineshop.repository.userrepository.UserRepository;
import my.group.onlineshop.repository.userrepository.UserRepositoryImplementation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OnlineShopConfiguration {

    @Bean
    public GoodsService goodsService(GoodsRepository gr, @Qualifier("swedbankService") BankService bs){
        return new GoodsServiceImplementation(gr, bs);
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
    public UserSearchService userSearchService(){
        return new UserSearchServiceImplementation();
    }

    @Bean
    public UserRepository userRepository(){
        return new UserRepositoryImplementation();
    }

    @Bean(name = "swedbankService")
    public BankService swedbankService(){
        return new SwedbankService();
    }

    @Bean(name = "danskeService")
    public BankService danskeService(){
        return new DanskeBankService();
    }

    @Bean
    public DeliveryService deliveryService(@Qualifier ("danskeService") BankService bs, UserSearchService us, GoodsService gs, UserRepository ur){
        return new HomeDeliveryServiceImplementation(us, gs, bs, ur);
    }

    @Bean
    public UserService userService(UserSearchService uss, DeliveryService ds, UserRepository ur){
        return new UserServiceImplementation(ds, uss, ur);
    }
}
