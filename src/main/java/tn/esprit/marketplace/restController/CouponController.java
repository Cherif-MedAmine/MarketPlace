package tn.esprit.marketplace.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.marketplace.entities.Coupon;
import tn.esprit.marketplace.services.interfaces.ICouponService;

import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    ICouponService iCouponService;

    @PostMapping("/addCoupon")
    public Coupon addCoupon(@RequestBody Coupon coupon) {
        return iCouponService.addCoupon(coupon);
    }

    @PostMapping("/addCouponAndAffectToUser/{idUser}")
    public void addCouponAndAffectToUser(@RequestBody Coupon coupon, @PathVariable("idUser") Long idUser) {
        iCouponService.addCouponAndAffectToUser(coupon, idUser);
    }

    @GetMapping("/findCouponById/{idCoupon}")
    public Coupon findCouponById(@PathVariable("idCoupon") Long idCoupon) {
        return iCouponService.findCouponById(idCoupon);
    }

    @GetMapping("/getCoupon/{couponCode}")
    public Coupon getCouponByCode(@PathVariable("couponCode") String code) {
        return iCouponService.getCouponByCode(code);
    }

    @GetMapping("/findAllCoupon")
    public List<Coupon> findAllCoupon() {
        return iCouponService.findAllCoupon();
    }

    @PutMapping("/updateCoupon")
    public Coupon updateCoupon(@RequestBody Coupon coupon) {
        return iCouponService.updateCoupon(coupon);
    }

    @DeleteMapping("/deleteCoupon/{couponId}")
    public void deleteStore(@PathVariable("couponId") Long id) {
        iCouponService.deleteCoupon(id);
    }
}
