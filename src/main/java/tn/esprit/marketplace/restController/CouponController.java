package tn.esprit.marketplace.restController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.marketplace.entities.Coupon;
import tn.esprit.marketplace.entities.Product;
import tn.esprit.marketplace.services.interfaces.ICouponService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/coupon")
public class CouponController {
    ICouponService couponService;


    @PostMapping("/add")
    Coupon addCoupon(@RequestBody Coupon coupon) {

        return couponService.addCoupon(coupon);
    }
    @PutMapping("/update")
    public Coupon updateCoupon(@RequestBody Coupon coupon) {
        return couponService.updateCoupon(coupon);
    }
    @DeleteMapping("deleteCouponById")
    public void deleteCouponById(@RequestParam Long idCouponuct) {
        couponService.deleteCouponById(idCouponuct);
    }
    @GetMapping("get_all")
    public List<Coupon> getAllCoupon(){

        return couponService.getAllCoupon();
    }
    @GetMapping("get_coupon_code")
    public Coupon getCouponByCode(@RequestParam String code){

        return couponService.getCouponByCo(code);
    }
    @GetMapping("wheel_chance")
    public Coupon wheelChance(){

        return couponService.wheelChance();
    }
    @GetMapping("coupons_gift")
    public List<Coupon> getCouponsGift(){

        return couponService.getCouponsGift();
    }

    @GetMapping("coupons_return")
    public List<Coupon> getCouponsReturn(){

        return couponService.getCouponsReturn();
    }
}
