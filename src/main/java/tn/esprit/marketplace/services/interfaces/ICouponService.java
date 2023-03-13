package tn.esprit.marketplace.services.interfaces;

import tn.esprit.marketplace.entities.Coupon;

import java.util.List;

public interface ICouponService {

    Coupon addCoupon(Coupon coupon);

    void addCouponAndAffectToUser(Coupon coupon, Long idUser);

    Coupon findCouponById(Long idCoupon);

    Coupon getCouponByCode(String code);

    List<Coupon> findAllCoupon();

    Coupon updateCoupon(Coupon coupon);

    void deleteCoupon(Long id);
}
