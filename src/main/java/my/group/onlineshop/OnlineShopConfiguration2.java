package my.group.onlineshop;

import my.group.onlineshop.domainservice.delivery.DeliveryDomainService;
import my.group.onlineshop.domainservice.delivery.DispatchService;
import my.group.onlineshop.domainservice.delivery.HomeDeliveryDomainServiceImplementation;
import my.group.onlineshop.domainservice.delivery.PostOfficeDomainServiceImplementation;
import my.group.onlineshop.domainservice.purchase.PurchaseDomainService;
import my.group.onlineshop.domainservice.purchase.PurchaseDomainServiceImplementation;
import my.group.onlineshop.domainservice.user.UserSearchService;
import my.group.onlineshop.domainservice.user.UserSearchServiceImplementation;
import my.group.onlineshop.facadeservice.delivery.DeliveryService;
import my.group.onlineshop.facadeservice.delivery.InternationalDeliveryServiceImplementation;
import my.group.onlineshop.facadeservice.delivery.LocalDeliveryServiceImplementation;
import my.group.onlineshop.facadeservice.goods.GoodsService;
import my.group.onlineshop.facadeservice.goods.GoodsServiceImplementation;
import my.group.onlineshop.facadeservice.purchase.PurchaseService;
import my.group.onlineshop.facadeservice.purchase.PurchaseServiceImplementation;
import my.group.onlineshop.facadeservice.user.UserService;
import my.group.onlineshop.facadeservice.user.UserServiceImplementation;
import my.group.onlineshop.integrationservice.bank.BankService;
import my.group.onlineshop.integrationservice.bank.DanskeBankService;
import my.group.onlineshop.integrationservice.bank.SwedbankService;
import my.group.onlineshop.integrationservice.dispatch.TruckDispatchService;
import my.group.onlineshop.repository.goodsrepository.GoodsFactory;
import my.group.onlineshop.repository.goodsrepository.GoodsFactoryImplementation;
import my.group.onlineshop.repository.goodsrepository.GoodsRepository;
import my.group.onlineshop.repository.goodsrepository.GoodsRepositoryImplementation;
import my.group.onlineshop.repository.purchaserepository.PurchaseRepository;
import my.group.onlineshop.repository.purchaserepository.PurchaseRepositoryImplementation;
import my.group.onlineshop.repository.userrepository.UserRepository;
import my.group.onlineshop.repository.userrepository.UserRepositoryImplementation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class OnlineShopConfiguration2 {

    @Bean
    public GoodsService goodsService(GoodsRepository goodsRepository, @Qualifier("swedbankService") BankService bankService){
        return new GoodsServiceImplementation(goodsRepository, bankService);
    }

    @Bean
    public GoodsRepository goodsRepository(GoodsFactory goodsFactory){
        return new GoodsRepositoryImplementation(goodsFactory);
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

    @Bean(name="delivery1")
    public DeliveryService deliveryService1(@Qualifier ("danskeService") BankService bankService, DeliveryDomainService deliveryDomainService, GoodsService goodsService, UserRepository userRepository){
        return new LocalDeliveryServiceImplementation(userRepository, deliveryDomainService, goodsService, bankService);
    }
    @Bean(name="delivery2")
    public DeliveryService deliveryService2(@Qualifier ("swedbankService") BankService bankService, DeliveryDomainService deliveryDomainService, GoodsService goodsService, UserRepository userRepository){
        return new InternationalDeliveryServiceImplementation(userRepository, deliveryDomainService, goodsService, bankService);
    }

    @Bean
    public  DeliveryDomainService deliveryDomainService(DispatchService dispatchService){
        return new PostOfficeDomainServiceImplementation(dispatchService);
    }

    @Bean
    public DispatchService dispatchService(){
        return new TruckDispatchService();
    }

    @Bean
    public UserService userService(UserSearchService userSearchService, @Qualifier("delivery2") DeliveryService deliveryService, UserRepository userRepository){
        return new UserServiceImplementation(deliveryService, userSearchService, userRepository);
    }

    @Bean
    public PurchaseService purchaseService(GoodsRepository goodsRepository, PurchaseRepository purchaseRepository, PurchaseDomainService purchaseDomainService){
        return new PurchaseServiceImplementation(goodsRepository, purchaseRepository, purchaseDomainService);
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
