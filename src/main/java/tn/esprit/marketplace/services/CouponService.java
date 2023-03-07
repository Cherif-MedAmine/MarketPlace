package tn.esprit.marketplace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.marketplace.entities.Coupon;
import tn.esprit.marketplace.entities.User;
import tn.esprit.marketplace.exception.GenericException;
import tn.esprit.marketplace.repositories.CouponRepository;
import tn.esprit.marketplace.repositories.UserRepository;
import tn.esprit.marketplace.services.interfaces.ICouponService;
import tn.esprit.marketplace.utils.ConstUtils;

import java.util.List;
import java.util.Optional;

@Service
public class CouponService implements ICouponService {

    @Autowired
    CouponRepository couponRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Coupon addCoupon(Coupon coupon) {
        couponRepository.save(coupon);
        return coupon;
    }

    @Override
    public void addCouponAndAffectToUser(Coupon coupon, Long idUser) {
        User user = userRepository.findById(idUser).get();
        coupon.setUserCoupon(user);
        couponRepository.save(coupon);
    }

    @Override
    public Coupon findCouponById(Long idCoupon) {
        Coupon coupon = couponRepository.findById(idCoupon).get();
        if (coupon == null) throw new GenericException(ConstUtils.COUPON_NOT_EXIST);
        return coupon;
    }

    @Override
    public Coupon getCouponByCode(String code) {
        Coupon coupon = couponRepository.getCouponByCode(code);
        if (coupon == null) throw new GenericException(ConstUtils.COUPON_NOT_EXIST);
        return coupon;
    }

    @Override
    public List<Coupon> findAllCoupon() {
        List<Coupon> coupons = couponRepository.findAll();
        return coupons;
    }

    @Override
    public Coupon updateCoupon(Coupon coupon) {
        couponRepository.save(coupon);
        return coupon;
    }

    @Override
    public void deleteCoupon(Long id) {
        Optional<Coupon> optionalCoupon = couponRepository.findById(id);
        if (optionalCoupon.isPresent())
            couponRepository.deleteById(id);
    }
}
