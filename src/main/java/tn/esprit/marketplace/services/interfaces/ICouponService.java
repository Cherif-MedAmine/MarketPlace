package tn.esprit.marketplace.services.interfaces;

import tn.esprit.marketplace.entities.Coupon;

import java.util.List;

public interface ICouponService {
    Coupon addCoupon(Coupon coupon);

    Coupon updateCoupon(Coupon coupon);

    void deleteCouponById(Long idCoupon);

    List<Coupon> getAllCoupon();


    Coupon getCouponByCo(String code);

    Coupon wheelChance();

    List<Coupon> getCouponsGift();

    List<Coupon> getCouponsReturn();
}
