package tn.esprit.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.marketplace.entities.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

    Coupon getCouponByCode(String code);
}
