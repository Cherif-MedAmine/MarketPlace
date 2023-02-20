package tn.esprit.marketplace.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCoupon;
    private String code;
    private  float discount;
    private  float percentage;
    private Date startDate;
    private  Date endDate;
    private Integer usesTotal;
    @Enumerated(EnumType.STRING)
    private CouponType couponType;

    @ManyToMany(mappedBy = "coupons")
    private List<User> users;
}
