package tn.esprit.marketplace.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.marketplace.entities.Favorite;
import tn.esprit.marketplace.entities.Product;
import tn.esprit.marketplace.repositories.*;
import tn.esprit.marketplace.services.interfaces.IFavoriteService;

import java.util.List;


@Service
@AllArgsConstructor
public class FavoriteService implements IFavoriteService {

    UserRepository userRepository;
    BasketRepository basketRepository;
    ProductRepository productRepository;
    FavoriteReopository favoriteReopository;
@Override
    public String  recommandation(Long idUser){

        Favorite f=favoriteReopository.findById(idUser).get();
        List<Product> listProduct=f.getFproducts();
        int a=0;
        int b=0;
        String nameCat=null;
        for(Product list :listProduct){
            String category=list.getCategoryProduct().getNameCategoryP();
            for(Product list2:listProduct){
                if(category==list2.getCategoryProduct().getNameCategoryP()){
                    a=a+1;
                }


            }
            if(a>b){
                b=a;
                nameCat=list.getCategoryProduct().getNameCategoryP();
            }
        }


        return nameCat;
    }
}
