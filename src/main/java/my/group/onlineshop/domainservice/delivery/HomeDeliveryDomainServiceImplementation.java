package my.group.onlineshop.domainservice.delivery;

import my.group.onlineshop.domain.goods.Goods;
import my.group.onlineshop.domain.user.User;
import my.group.onlineshop.domainservice.user.UserSearchService;
import my.group.onlineshop.facadeservice.goods.GoodsService;
import my.group.onlineshop.integrationservice.BankService;
import my.group.onlineshop.repository.userrepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class HomeDeliveryDomainServiceImplementation implements DeliveryDomainService {

    @Override
    public String deliver(User user, Goods goods){
        return "Vartotojo: " + user.getName() + " uzsakyta preke: " + goods.getGoodsName() + " yra ruosiama pritatymui adresu: " + user.getAddress() + ".";
    }

    @Override
    public Double getPurchaseCost(Goods goods) {
        return goods.getPrice() + 4.5;
    }
}
