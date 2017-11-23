package my.group.onlineshop;

import my.group.onlineshop.goods.database.GoodsRepository;
import my.group.onlineshop.goods.database.GoodsRepositoryImplementation;
import my.group.onlineshop.goods.factory.GoodsFactory;
import my.group.onlineshop.goods.factory.GoodsFactoryImplementation;
import my.group.onlineshop.paymentsAndDeliveries.service.delivery.DeliveryService;
import my.group.onlineshop.paymentsAndDeliveries.service.delivery.HomeDeliveryServiceImplementation;
import my.group.onlineshop.paymentsAndDeliveries.service.payment.BankService;
import my.group.onlineshop.paymentsAndDeliveries.service.payment.DanskeBankService;
import my.group.onlineshop.paymentsAndDeliveries.service.payment.SwedbankService;
import my.group.onlineshop.user.service.*;
import my.group.onlineshop.goods.service.GoodsService;
import my.group.onlineshop.goods.service.GoodsServiceImplementation;
import my.group.onlineshop.user.database.UserRepository;
import my.group.onlineshop.user.database.UserRepositoryImplementation;
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
    public UserSearchService userSearchService(UserRepository ur){
        return new UserSearchServiceImplementation(ur);
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
    public DeliveryService deliveryService(@Qualifier ("danskeService") BankService bs, UserSearchService us, GoodsService gs){
        return new HomeDeliveryServiceImplementation(us, gs, bs);
    }

    @Bean
    public UserService userService(UserSearchService uss, DeliveryService ds){
        return new UserServiceImplementation(ds, uss);
    }
}
