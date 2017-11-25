package my.group.onlineshop;

import my.group.onlineshop.domainservice.delivery.DeliveryDomainService;
import my.group.onlineshop.domainservice.delivery.DispatchService;
import my.group.onlineshop.domainservice.delivery.HomeDeliveryDomainServiceImplementation;
import my.group.onlineshop.domainservice.purchase.PurchaseDomainService;
import my.group.onlineshop.domainservice.purchase.PurchaseDomainServiceImplementation;
import my.group.onlineshop.domainservice.user.UserSearchService;
import my.group.onlineshop.domainservice.user.UserSearchServiceImplementation;
import my.group.onlineshop.facadeservice.delivery.DeliveryService;
import my.group.onlineshop.facadeservice.delivery.DeliveryServiceImplementation;
import my.group.onlineshop.facadeservice.goods.GoodsService;
import my.group.onlineshop.facadeservice.goods.GoodsServiceImplementation;
import my.group.onlineshop.facadeservice.purchase.PurchaseService;
import my.group.onlineshop.facadeservice.purchase.PurchaseServiceImplementation;
import my.group.onlineshop.facadeservice.user.UserService;
import my.group.onlineshop.facadeservice.user.UserServiceImplementation;
import my.group.onlineshop.integrationservice.BankService;
import my.group.onlineshop.integrationservice.DanskeBankService;
import my.group.onlineshop.integrationservice.SwedbankService;
import my.group.onlineshop.integrationservice.TruckDispatchService;
import my.group.onlineshop.repository.goodsrepository.GoodsRepository;
import my.group.onlineshop.repository.goodsrepository.GoodsRepositoryImplementation;
import my.group.onlineshop.repository.goodsrepository.GoodsFactory;
import my.group.onlineshop.repository.goodsrepository.GoodsFactoryImplementation;
import my.group.onlineshop.repository.purchaserepository.PurchaseRepository;
import my.group.onlineshop.repository.purchaserepository.PurchaseRepositoryImplementation;
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
    public DeliveryService deliveryService(@Qualifier ("danskeService") BankService bs, DeliveryDomainService dds, GoodsService gs, UserRepository ur){
        return new DeliveryServiceImplementation(ur, dds, gs, bs);
    }

    @Bean
    public  DeliveryDomainService deliveryDomainService(DispatchService ds){
        return new HomeDeliveryDomainServiceImplementation(ds);
    }

    @Bean
    public DispatchService dispatchService(){
        return new TruckDispatchService();
    }

    @Bean
    public UserService userService(UserSearchService uss, DeliveryService ds, UserRepository ur){
        return new UserServiceImplementation(ds, uss, ur);
    }

    @Bean
    public PurchaseService purchaseService(GoodsRepository gr, PurchaseRepository pr, PurchaseDomainService pds){
        return new PurchaseServiceImplementation(gr, pr, pds);
    }

    @Bean
    public PurchaseRepository purchaseRepository(){
        return new PurchaseRepositoryImplementation();
    }

    @Bean
    public  PurchaseDomainService purchaseDomainService(){
        return new PurchaseDomainServiceImplementation();
    }
}
