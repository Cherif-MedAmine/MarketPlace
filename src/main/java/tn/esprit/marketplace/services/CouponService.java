package tn.esprit.marketplace.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.marketplace.entities.*;
import tn.esprit.marketplace.enums.CouponType;
import tn.esprit.marketplace.repositories.CouponRepository;
import tn.esprit.marketplace.services.interfaces.ICouponService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class CouponService  implements ICouponService {
    CouponRepository couponRepository;

 @Override
public Coupon addCoupon(Coupon coupon){

    return couponRepository.save(coupon);
}

    @Override
    public Coupon updateCoupon(Coupon coupon){

        return couponRepository.save(coupon);
    }

    @Override
    public void deleteCouponById(Long idCoupon){
        couponRepository.deleteById(idCoupon);
    }

    @Override
    public List<Coupon> getAllCoupon(){

        return couponRepository.findAll();
    }
    @Override
    public Coupon getCouponByCo(String code){

        return couponRepository.getCouponByCode(code);
    }

     @Override
    public Coupon wheelChance() {

        List<Coupon> listCoupon = couponRepository.findAll();
         List<Coupon> gifts =new ArrayList<>();
         for(Coupon list:listCoupon){
             if(list.getCouponType().equals(CouponType.GIFT)){
                 gifts.add(list);
             }
         }
        int size = gifts.size();
        Coupon randomElement = null;
        if (size > 0) {
            int randomIndex = new Random().nextInt(size);
            randomElement = gifts.get(randomIndex);

        } else {
            System.out.println(listCoupon);
        }
        return randomElement;
    }
    @Override
    public List<Coupon> getCouponsGift(){

        List<Coupon> listCoupon = couponRepository.findAll();
        List<Coupon> gifts =new ArrayList<>();
        for(Coupon list:listCoupon){
            if(list.getCouponType().equals(CouponType.GIFT)){
                gifts.add(list);
            }
        }
        return gifts;
    }

    @Override
    public List<Coupon> getCouponsReturn(){

        List<Coupon> listCoupon = couponRepository.findAll();
        List<Coupon> returns =new ArrayList<>();
        for(Coupon list:listCoupon){
            if(list.getCouponType().equals(CouponType.RETURN)){
                returns.add(list);
            }
        }
        return returns;
    }

}
