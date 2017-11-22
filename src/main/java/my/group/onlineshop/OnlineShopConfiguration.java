package my.group.onlineshop;

import my.group.onlineshop.goods.database.GoodsRepository;
import my.group.onlineshop.goods.database.GoodsRepositoryImplementation;
import my.group.onlineshop.goods.factory.GoodsFactory;
import my.group.onlineshop.goods.factory.GoodsFactoryImplementation;
import my.group.onlineshop.goods.service.GoodsService;
import my.group.onlineshop.goods.service.GoodsServiceImplementation;
import org.springframework.beans.factory.annotation.Configurable;
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
}
