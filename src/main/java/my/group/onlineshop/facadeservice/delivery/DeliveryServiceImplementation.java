package my.group.onlineshop.facadeservice.delivery;

import my.group.onlineshop.domainservice.delivery.DeliveryDomainService;
import my.group.onlineshop.facadeservice.goods.GoodsService;
import my.group.onlineshop.integrationservice.bank.BankService;
import my.group.onlineshop.repository.userrepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DeliveryServiceImplementation implements DeliveryService {
    private UserRepository userRepository;
    private DeliveryDomainService deliveryDomainService;
    private GoodsService goodsService;
    private BankService bankService;

    @Autowired
    public DeliveryServiceImplementation(UserRepository ur, DeliveryDomainService dds, GoodsService gs, BankService bs){
        this.userRepository = ur;
        this.deliveryDomainService = dds;
        this.goodsService = gs;
        this.bankService = bs;
    }

    @Override
    public String deliver(int userId, int goodsId) {
        return deliveryDomainService.deliver(userRepository.getUserById(userId), goodsService.getGoodById(goodsId));
    }

    @Override
    public Double getPurchaseCost(int goodsId) {
        return deliveryDomainService.getPurchaseCost(goodsService.getGoodById(goodsId));
    }

    @Override
    public Boolean pay(int goodsId) {
        return bankService.buy(getPurchaseCost(goodsId));
    }
}
